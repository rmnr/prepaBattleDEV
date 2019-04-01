package fr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExosTest {
	PrintStream old = System.out;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	
	@Before
	void redirigerSortieStandard() {
		baos = new ByteArrayOutputStream();
	}
	
	@After
	void remettreSortie(String fichierSortie) {
		System.out.flush();
		System.setOut(old);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void testExo1(int numFichierTest) throws FileNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		/**
		 * GIVEN
		 */
		String input = "input"+numFichierTest+".txt";
		String output = "output"+numFichierTest+".txt";
		
		// Tell Java to use your special stream
		System.setOut(ps);
		
		/**
		 * WHEN
		 */
		Exo1.main(input);
		
		/**
		 * THEN
		 */
		comparerResultatEtFichierDeReponses(output);
	}

	
	private void comparerResultatEtFichierDeReponses(String nomFichierSortie) throws FileNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource(nomFichierSortie).getFile());
	    Scanner sc = new Scanner(file); 
	    
	    String line;
	    String[] reponses = baos.toString().split("\r\n");
	    int i=0;
	    while (sc.hasNextLine()) {
	    	line = sc.nextLine();
	    	
	    	assertEquals(line, reponses[i]);
	    	i++;
	    }
	}
	
}
