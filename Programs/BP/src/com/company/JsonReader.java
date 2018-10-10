package com.company;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class JsonReader {

	static List<Word> Read(String JSONstring) {
		JSONParser parser = new JSONParser();
		List<Word> Words = new ArrayList<Word>();

		try {
			JSONArray jsonArray = (JSONArray) parser.parse(JSONstring);

			for (int i = 0; i < jsonArray.size(); i++) {
				Gson gson = new Gson();
				Words.add(gson.fromJson(jsonArray.get(i).toString(), Word.class));

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Words;
	}
}
