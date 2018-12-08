package com.epam.kira_demidova.java.lesson3.task1.utils;

import java.util.Comparator;

public class ArrayComparator implements Comparator<String[]>{
		public int compare(String o1[], String o2[]){	
			return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0]));
		}
}
