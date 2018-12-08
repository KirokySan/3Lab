package com.epam.kira_demidova.java.lesson3.task1.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.kira_demidova.java.lesson3.task1.ResourseBundle;

import java.util.ResourceBundle;
public class ProgramUtils {
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * Check input integer
	 * 
	 * @return
	 */
	public int getNumber(){
		int number = 0;
		boolean scanInt = true;
		while(scanInt) {				
			if (scan.hasNextInt()) {
				number = scan.nextInt();
				scanInt = false;
			}
			else {
				System.out.println("Нет номера");
				System.out.println("Введите число: ");
				scan.next();
			}			
		}
		return number;
	}
	public void closeScan(){
		scan.close();
	}
	
	public Matcher setPattern(String str, String regex){
		ResourseBundle prop = new ResourseBundle();
		String reg = prop.getValue(regex);
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);	
		return matcher;
		
	}
}
