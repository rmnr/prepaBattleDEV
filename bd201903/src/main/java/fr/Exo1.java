package fr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exo1 {

	public static void main(String fichier) throws FileNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource(fichier).getFile());
	    Scanner sc = new Scanner(file); 
	    
	    /**
	     * - si vous terminez dans le top 100, vous gagnez 1 000 euros ;
			- si vous terminez le marathon, vous gagnez 100 euros ;
			- si vous ne terminez pas le marathon, vous aurez juste perdu votre crédibilité.
	     */
	    
	    String line;
	    int i=0;
	    int position = 0;
	    while (sc.hasNextLine()) {
	    	line = sc.nextLine();
	    	if(i==0) {
	    		position = Integer.parseInt(line);
	    	}else {
	    		position += Integer.parseInt(line.split(" ")[0]) - Integer.parseInt(line.split(" ")[1]);
	    	}
	    	
	    	i++;
	    }
	    
	    if(position<=100) {
	    	System.out.println("1000");
	    }else if(position<=10000) {
	    	System.out.println("100");
	    }else {
	    	System.out.println("KO");
	    }
	}

}
