package com.bhaavanmerchant;

import java.io.FileWriter;
import java.io.IOException;

import com.bhaavanmerchant.models.Location;
import com.bhaavanmerchant.models.Position;

public class CsvWriter implements Writer {
	String fileName;

	@Override
	public void saveFile(Position[] positions) {
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.append("_id");
			writer.append(',');
			writer.append("name");
			writer.append(',');
			writer.append("type");
			writer.append(',');
			writer.append("latitude");
			writer.append(',');
			writer.append("longitude");
			writer.append('\n');
			for (int i = 0; i < positions.length; i++) {
				try {
					Location location = positions[i].getGeo_position();
					writer.append(positions[i].get_id());
					writer.append(',');
					writer.append(positions[i].getName());
					writer.append(',');
					writer.append(positions[i].getType());
					writer.append(',');
					writer.append(location.getLatitude());
					writer.append(',');
					writer.append(location.getLongitude());
					writer.append('\n');
				} catch (Exception e) {
					System.out.println("Unexpected values encountered");
				}
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Error occured while writing to CSV");
		}
	}

	public CsvWriter(String fileName) {
		this.fileName = fileName;
	}
}
