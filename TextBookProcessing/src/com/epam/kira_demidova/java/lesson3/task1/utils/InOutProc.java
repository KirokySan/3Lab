package com.epam.kira_demidova.java.lesson3.task1.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.lang.NullPointerExeption;


public class InOutProc {
	String inFileName;
	private String outFileName;
	
	public InOutProc(String inFile, String outFile){
		inFileName = inFile;
		outFileName = outFile;
	}
	
	/**
	 * Create a backup of txt file
	 * 
	 * @param inFileName name of input txt file
	 * @param outFileName name of output txt file
	 */
	
	public void backUpTxtFile(){
		byte[] buffer = readInFile();
		writeOutFile(buffer);
	}

	/**
	 * 
	 * 
	 * @param outFileName
	 * @param buffer
	 */
	private void writeOutFile(byte[] buffer){
		FileOutputStream outFile = null;
		try{
			outFile = new FileOutputStream(new File(outFileName));
			System.out.println("Файл открыт для записи");
			outFile.write(buffer);
			outFile.close();
			System.out.println("Файл был закрыт после записи");
		} catch (FileNotFoundException e) {
			System.out.println("Не было записи в файл: "+ outFileName);
		} catch (IOException e) {
			System.out.println("Исключение ввода/вывода: " + e.toString());
		} 
	}
	
	public void appendInFile(byte[] buffer){
		FileOutputStream inFile = null;
		try{
			inFile = new FileOutputStream(inFileName, true);
			System.out.println("Файл открыт");
			inFile.write(buffer);
			inFile.close();
			System.out.println("Файл был закрыт после чтения");
		} catch (FileNotFoundException e) {
			System.out.println("Не было записи в файл: "+ inFileName);
		} catch (IOException e) {
			System.out.println("Исключения ввода/вывода:" + e.toString());
		} 
	}
	
	public byte[] readInFile(){
		FileInputStream inFile = null;
		byte[] buffer = null;
		try{
			inFile = new FileInputStream(inFileName);
			System.out.println("Файл открыт для чтения");
			int bytesAvailable = inFile.available();
			System.out.println("Размер входного файла " + bytesAvailable + "байт");
			buffer = new byte[inFile.available()];
			inFile.read(buffer, 0, bytesAvailable);
			inFile.close();	
			System.out.println("Файл был закрыт после чтения");
		} catch (FileNotFoundException e) {
			System.out.println("Не был прочитан входной файл: "+ inFileName);
			//LOG.error("Файл "+inFileName+"не найден",e);
		} catch (IOException e) {
			System.out.println("Исключения ввода/вывода: " + e.toString());
		} //catch (NullPointerExeption e) {
			//System.out.println("Не был найден файл: "+ inFileName);
		//}
		return buffer;
	}
}
