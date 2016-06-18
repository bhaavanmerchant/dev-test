package com.bhaavanmerchant;

import com.bhaavanmerchant.models.Position;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GoEuroTest {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().create();
		if (args.length < 1 || args[0].isEmpty()) {
			System.out.println("Please provide a valid input city.");
		} else {
			try {
				Position[] positions = gson.fromJson(Api.suggestPosition(args[0]), Position[].class);
				Writer writer = new CsvWriter(Constants.OUTPUT_FILE);
				writer.saveFile(positions);
			} catch (Exception e) {
				System.out.println("Something unexpected happened.");
			}
		}
	}
}
