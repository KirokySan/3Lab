package com.epam.kira_demidova.java.lesson3.task1;

import java.io.IOException;

import com.epam.kira_demidova.java.lesson3.task1.utils.InOutProc;
import com.epam.kira_demidova.java.lesson3.task1.utils.ParseBook;
import com.epam.kira_demidova.java.lesson3.task1.utils.ProgramUtils;
import com.epam.kira_demidova.java.lesson3.task1.utils.VowelsChar;
import com.epam.kira_demidova.java.lesson3.task1.utils.WordProcessing;

public class MainClass {

	public static void main(String[] args) throws IOException {
		boolean menuRun = true;
		ProgramUtils number = new ProgramUtils();
		String inFileName = "resource/original/book.txt";
		String outFileName = "resource/backup/book.bak";
		InOutProc inOut = new InOutProc(inFileName, outFileName);
		while (menuRun){
			System.out.println("Выберите действие: ");
			System.out.println("1. Сделать копию");
			System.out.println("2. Считать из файла");
			System.out.println("3. Получить файл в консоли");
			System.out.println("4. Удалить дополнительные места");
			System.out.println("5. Макс. длина воодимых символов");
			System.out.println("6. Слова с самой встречающейся гласной");
			int menuChoise = number.getNumber();
			switch(menuChoise){
			case 1:
				//1. backup txt file
				inOut.backUpTxtFile();
				break;
			case 2:
				//2. read from file
				byte[] text = inOut.readInFile();
				String str = new String(text);
				System.out.println(str);
				break;
			case 3:
				System.out.print(inOut.readInFile());
				break;
			case 4:
				ParseBook parse = new ParseBook();
				parse.regexParse(inOut);
				break;
			case 5:
				System.out.print("Ввести максимальную длину: ");
				int maxLength = number.getNumber();
				WordProcessing x = new WordProcessing();
				x.getWordsByAsc(inOut, maxLength);	
				break;
			case 6:
				byte[] book = inOut.readInFile();
				VowelsChar vowels = new VowelsChar();
				vowels.getMostReapitingChar(book, inOut);
				break;
			case 0:
				menuRun = false;
				number.closeScan();
				break;
			}
		
		}
		
		
	}

}
