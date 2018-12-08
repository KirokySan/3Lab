package com.epam.kira_demidova.java.lesson3.task1;

import java.util.regex.Matcher;

import com.epam.kira_demidova.java.lesson3.task1.utils.ProgramUtils;

public class Sentence {
	ProgramUtils util = new ProgramUtils();
	private String sentence;
	public String getSentence(){
		return sentence;
	}
	public void setSentence(String sentence){
		this.sentence = sentence;
	}
	public int getWordsCount(){
		Word word = new Word();
		int wordCount = 0;		
		Matcher matcher = util.setPattern(getSentence(), "word");
		while (matcher.find()){
			wordCount++;
			word.setWord(matcher.group());
		}
		return wordCount;	
	}
	public String wordsLessLength(int length){
		String line = "";
		Matcher matcher = util.setPattern(getSentence(), "word");
		while (matcher.find()){
			if(matcher.group().length() < length)
				line += matcher.group() + " ";
		}
		return line;
	}
}
