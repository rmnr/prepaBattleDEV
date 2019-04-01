package fr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) throws FileNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource(args[0]).getFile());
	    Scanner sc = new Scanner(file); 
	    
	    String line;
	    int i=0;
	    while (sc.hasNextLine()) {
	    	line = sc.nextLine();
	    	
	    	
	    	i++;
	    }
		System.out.println("OK");
	}

}
