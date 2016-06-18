package com.bhaavanmerchant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Api {
	public static String suggestPosition(String city) {
		StringBuilder res = new StringBuilder();
		try {
			URL url = new URL(Constants.POSTION_API_URL + city);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty(Constants.ACCEPT, Constants.APPLICATION_JSON);

			if (conn.getResponseCode() != 200) {
				System.out.println("Did not get the correct response status from the API.");
				throw new RuntimeException(Constants.FAILED_MSG + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;

			while ((output = br.readLine()) != null) {
				res.append(output);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			System.out.println("API URL may be wrong.");
		} catch (IOException e) {
			System.out.println("Could not interact with the API.");
		}
		return res.toString();
	};
}
