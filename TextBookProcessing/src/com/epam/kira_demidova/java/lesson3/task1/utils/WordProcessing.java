package com.epam.kira_demidova.java.lesson3.task1.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import com.epam.kira_demidova.java.lesson3.task1.Char;
import com.epam.kira_demidova.java.lesson3.task1.Word;
import com.epam.kira_demidova.java.lesson3.task1.Sentence;
import com.epam.kira_demidova.java.lesson3.task1.utils.InOutProc;

public class WordProcessing {
	public void getWordsByAsc(InOutProc inOut, int length) throws IOException {
		int lineCounter = 0;
		String[][] wordsArray = new String[0][2];
		Sentence line = new Sentence();
		ProgramUtils util = new ProgramUtils();
		String sent = new String(inOut.readInFile());
		Matcher matcher = util.setPattern(sent, "sentence");
		while (matcher.find()){
			line.setSentence(matcher.group(1));								
			wordsArray = arrayResizing(wordsArray);
			wordsArray[lineCounter][0] = String.valueOf(line.getWordsCount());
			wordsArray[lineCounter][1] = line.wordsLessLength(length);							
			lineCounter++;
		}
		 Arrays.sort(wordsArray, new ArrayComparator());
		 gridPrint(wordsArray, inOut);
	}
	
	/**
	 * print grid in original file
	 * 
	 * @param array
	 * @param inOut
	 */
	private void gridPrint(String[][] array, InOutProc inOut){
		String line;
		line = "\n|=====================================================|";
		line += "\n|  №  |          Sentence              | Word's Count |";
		line += "\n|=====+================================+==============|";
		for(int i = 0; i < array.length; i++){
			line += String.format("%n|%-5d|%-32s|%14s|", i, array[i][1], array[i][0]);	
			line += "\n|-----+--------------------------------+--------------|";
		}
		inOut.appendInFile(line.getBytes());
	// обрезать длину строки
	
	}
	
	private String[][] arrayResizing(String[][] array){	
		int a = array.length;
		String[][] newArray = new String[array.length + 1][2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		return newArray;
	}
	
	/**
	 * USE FOR PRINT GRID IN CONSOLE
	 */
	private void topGrid(){
		System.out.println("|=====================================================|");
		System.out.println("|  №  |          Sentence              | Word's Count |");
		System.out.println("|=====+================================+==============|");
	}
	
	/**
	 * USE FOR PRINT GRID IN CONSOLE
	 */
	private void grid(int lineCounter, int size, String line){
		System.out.format("|%-5d|%-32s|%14d|%n", lineCounter, line, size);		
		System.out.println("|-----+--------------------------------+--------------|");
	}
}
