package com.company;

import java.util.ArrayList;
import java.util.List;

//Class with text preprocessing usage
public class TextPreprocessor {

	private TokenServiceCommunicator tokenServiceCommunicator = new TokenServiceCommunicator();
	private JsonReader jsonReader = new JsonReader();
	private List<Word> Words = new ArrayList<>();

	void Process(String Input) {
		try {
			String json = tokenServiceCommunicator.sendPost(Input);
			Words = jsonReader.Read(json);
			parseOutUnnessesary();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void Print() {
		for (Word word : Words) {
			System.out.println(word.word + " - " + word.meta);
		}
	}

	private void parseOutUnnessesary() {
		for(int i=0; i < Words.size(); i++){
			Word word = Words.get(i);
			if(word.word.matches(".*[.,!?]+.*")){
				Words.remove(i);
				if(word.meta != null && word.meta.length() == 4){
					i--;
					Word prevWord = Words.get(i);
					prevWord.meta = "{/S}";
					Words.set(i,prevWord);
				}
			}
		}
	}
}
