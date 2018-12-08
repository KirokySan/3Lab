package com.epam.kira_demidova.java.lesson3.task1.utils;

import java.util.regex.Matcher;

import com.epam.kira_demidova.java.lesson3.task1.utils.InOutProc;

public class ParseBook { 	
	
	public void regexParse(InOutProc inOut){
		ProgramUtils util = new ProgramUtils();
		Matcher matcher = util.setPattern(inOut.readInFile().toString(), "regex");
		String str2 = matcher.replaceAll(" ");
		System.out.print(str2);
	}
}
