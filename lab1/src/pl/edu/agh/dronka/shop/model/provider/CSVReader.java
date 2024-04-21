package pl.edu.agh.dronka.shop.model.provider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CSVReader {

	private Map<String, Integer> header = new LinkedHashMap<>();

	private List<String[]> data = new LinkedList<>();

	private String filename;

	public CSVReader(String filename) {
		this.filename = filename;
	}

	public List<String[]> getData() {
		return data;
	}

	public String getValue(String[] line, String name) {
		if (header.containsKey(name)) {
			return line[header.get(name)];
		}
		return null;
	}

	public List<String> getHeaders() {
		return header.keySet().stream().toList();
	}

	public List<String> getHeaders(int start) {
		return header.keySet().stream().toList().subList(start, header.size());
	}

	public List<String> getHeaders(int start, int end) {
		return header.keySet().stream().toList().subList(start, end);
	}


	public void parse() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), "UTF8"))) {

			String line;
			while ((line = br.readLine()) != null) {
				data.add(line.split(","));
			}

		}
		
		

		String[] headerLine = data.remove(0);

		for (int i = 0; i < headerLine.length; i++) {
			header.put(headerLine[i], i);
		}

	}

}
