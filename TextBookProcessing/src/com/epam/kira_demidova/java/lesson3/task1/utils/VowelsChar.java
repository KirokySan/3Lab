package com.epam.kira_demidova.java.lesson3.task1.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VowelsChar {
	public void getMostReapitingChar(byte[] book, InOutProc inOut){
		ProgramUtils util = new ProgramUtils();
		Matcher matcher = util.setPattern(inOut.readInFile().toString(), "vowels");
		printWord(matcher);
		}
	
	private String vowelsCount(Matcher matcher){
		int a = 0, e = 0, i = 0, o = 0, u = 0, y = 0, j=0;
		while(matcher.find()){
			String symb = matcher.group();
			switch(symb.toLowerCase()){
			case "a": 
				a++;
				break;
			case "e": 
				e++;
				break;
			case "i": 
				i++;
				break;
			case "o": 
				o++;
				break;
			case "u": 
				u++;
				break;
			case "y": 
				y++;
				break;
			case "j": 
				j++;
				break;	
			}		
		}
		String symb;
		if(a > e && a > i && a > o && a > u && a > y) symb = "a";
		else if(e > a && e > i && e > o && e > u && e > y) symb = "e";
		else if(i > a && i > e && i > o && i > u && i > y) symb = "i";
		else if(j > a && j > e && j > o && j > u && j > y) symb = "j";
		else if(o > a && o > e && o > i && o > u && o > y) symb = "o";
		else if(u > a && u > e && u > i && u > o && a > y) symb = "u";
		else symb = "y";
		return symb;
	}
	
	private Matcher setPattern(byte[] book, String regex){
		Pattern pattern = Pattern.compile(regex);
		String text = new String(book);
		Matcher matcher = pattern.matcher(text);
		return matcher;
	}
	
	private void printWord(Matcher matcher){
		while(matcher.find()){
			
		}
	}
}
