package fr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exos {

	public static void exo1(String fichier) throws FileNotFoundException {
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

	public static void exo2(String fichier) throws FileNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource(fichier).getFile());
	    Scanner sc = new Scanner(file); 
	    String line;
	    
	
	    
	   
	    int i=0;
	    int nbAllers = 0;
	    int poids = 0;
	    while (sc.hasNextLine()) {
	    	line = sc.nextLine();
	    	if(i==0) {
	    		
	    	}else {
	    		if(poids + Integer.parseInt(line) >100) {
	    			nbAllers++;
	    			poids=0;
	    			poids += Integer.parseInt(line);
	    		}else {
	    			poids += Integer.parseInt(line);
	    		}
	    	}
	    	
	    	i++;
	    }
	    
	    
	    System.out.println(nbAllers+1);

	}
	
	public static void exo3(String fichier) throws FileNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource(fichier).getFile());
	    Scanner sc = new Scanner(file); 
	    String line;
	    
	    //22:22
	    
	   
	    int i=0;
	    String parcours = "";
	    List<String> map = new ArrayList<String>();
	    while (sc.hasNextLine()) {
	    	line = sc.nextLine();
	    	System.err.println(line);
	    	if(i==0) {
	    		
	    	}else {
	    		map.add(line);
	    	}
	    	
	    	i++;
	    }
	    
	    int k=0;
	    for(String ligne : map) {
	    	int j= 0;
	    	for(char c : ligne.toCharArray()) {
	    		if(c=='o') {
	    			parcours+='x';
	    		}
	    		
	    		if(j==ligne.toCharArray().length-1) {
	    			for(char allerAGauche : ligne.toCharArray()) {
	    				if(j==0) {
	    					if(k==map.size()-1) {
	    						int l = 0;
	    						for(char remonter : ligne.toCharArray()) {
	    							if(l<ligne.toCharArray().length-1) {
	    								parcours+='^';
	    							}
	    							l++;
	    						}
	    					}else {
	    						parcours+='v';
	    					}
	    				}else {
	    					parcours+='<';
	    				}
	    				j--;
	    			}
	    		}else {
	    			parcours+='>';
	    		}
	    		j++;
	    	}
	    	k++;
	    }
	    
	    k=0;
	    for(String ligne : map) {
	    	int j= 0;
	    	for(char c : ligne.toCharArray()) {
	    		if(c=='*') {
	    			parcours+='x';
	    		}
	    		
	    		if(j==ligne.toCharArray().length-1) {
	    			for(char allerAGauche : ligne.toCharArray()) {
	    				if(j==0) {
	    					if(k!=map.size()-1) {
	    						parcours+='v';
	    					}
	    				}else {
	    					parcours+='<';
	    				}
	    				j--;
	    			}
	    		}else {
	    			parcours+='>';
	    		}
	    		j++;
	    	}
	    	k++;
	    }
	    
	    System.err.println(parcours);
	    System.out.println(parcours);
	}
	
	public static void exo4(String fichier) throws FileNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource(fichier).getFile());
	    Scanner sc = new Scanner(file); 
	    String line;
	    
	    //22:39
	    /**
	     * L'objectif de ce challenge est donc de trouver une suite de lettres qui se retrouvent,
	     *  dans le même ordre, dans tous mots de la liste en entrée.
	     *   On voudrait que cette suite soit la plus longue possible
	     */
	    
	    int i=0;
	    List<String> mots = new ArrayList<String>();
	    String plusLongueSerie = "";
	    while (sc.hasNextLine()) {
	    	line = sc.nextLine();
	    	if(i==0) {
	    		
	    	}else {
	    		mots.add(line);
	    	}
	    	
	    	i++;
	    }
	    
	    Set<String> seriesMax = new HashSet<String>();
	    seriesMax.add(mots.get(0));
	    for(String motActuel : mots) {
	    	seriesMax = serieRec(motActuel, seriesMax);
	    }
	    
	    int tailleMax=0;
	    for (Iterator iterator = seriesMax.iterator(); iterator.hasNext();) {
			String serie = (String) iterator.next();
			if(tailleMax<serie.length()) {
				tailleMax = serie.length();
			}
		}
	    for (Iterator iterator = seriesMax.iterator(); iterator.hasNext();) {
			String serie = (String) iterator.next();
			if(tailleMax>serie.length()) {
				iterator.remove();
			}
		}
	    
	    if(seriesMax.size()==0 || (seriesMax.size()==1 && "".equals(seriesMax.toArray()[0])) ) {
	    	System.out.println("KO");
	    }else {
	    	System.out.println(seriesMax.toArray()[0]);
	    }
	    

	}
	
	private static Set<String> serieRec(String mot1, Set<String> series) {
		Set<String> seriesEnPlus = new HashSet<String>();
		
		for (Iterator iterator = series.iterator(); iterator.hasNext();) {
			String serie = (String) iterator.next();
			
			if(!contientToutesLesLettresDansLOrdre(mot1,serie)) {
				iterator.remove();
				for(int i =0;i<serie.length();i++) {
					Set<String> seriesActuelles = new HashSet<String>();
					StringBuilder sb = new StringBuilder(serie).deleteCharAt(i);
					seriesActuelles.add(sb.toString());
					Set<String> seriesRetour = serieRec(mot1,seriesActuelles);
					
					for(String s : seriesRetour) {
						seriesEnPlus.add(s);
					}
					
				}
			}
		}
		series.addAll(seriesEnPlus);
		return series;
	}
	
	private static boolean contientToutesLesLettresDansLOrdre(String mot1, String serie) {
		String mot1Decoupe = mot1;
		for(char c : serie.toCharArray()) {
			int posTrouvee = mot1Decoupe.indexOf(c);
			if(posTrouvee==-1) {
				return false;
			}
			mot1Decoupe = mot1Decoupe.substring(posTrouvee+1);
		}
		return true;
	}
}
