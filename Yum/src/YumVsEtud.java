package src;

import java.util.Random;
import java.util.Scanner;


/*

 ** Programme principal qui démarre le jeu de YUM pour un seul joueur. 
 *  
 * Une série de 5 dés est généré aléatoirement et le joueur a droit 
 * a changer les dés qu'il désire à deux reprises à moins qu'il les 
 * garde tous. 
 *  
 * Par la suite, le programme offre toutes les possibilités de points  
 * pouvant être joués et le joueur décide quel est son choix parmi  
 * ces possibilités. 
 *  
 * Dans le cadre du cours inf111 (voir énnoncé fourni). 
 *  
 * Auteur : Mettez le nom de chaque membre du groupe qui a suffisamment  
 *          contribué en écriture de code et de commentaires. 
 *           
 *          
 * Auteur : Youcef mekki daouadji
 * Auteur : Rada Leng
 * Auteur :
 * Auteur :
 * Auteur :
 * 
 * 
 * Auteur : Pierre Bélisle 
 *          
 * Version : Copyright A2021
 */

public class YumVsEtud {

	
	// Les constantes sont défines dans le module Constantes.java
	// Si vous en ajoutez, faites-le ici.
	
	 public static int[] Grillepossibilite = new int[12];
	 public static int  CompteurTour = 1;
	 
	 
	// Permet la saisie de donné au clavier en mode console.
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args){
		
		   int[] ArrayDice = new int[5]; //creation des 5 des.
		   int[] ArrayPoint = new int[19];
		   int[] tabOccurrence = new int[7];//Tableau pour accumuler les occurences des dÃ©s 
		  
		  

		   
		   ModAffichage.afficherGrille(ArrayPoint);
		   
		  
		    
		   InitialShuflle(ArrayDice); //génération des chiffre aléatoirement entre 1 et 6; 
		   
		   ModAffichage.afficherDes(ArrayDice);//affichage des dés 
		   Additiondelespoints(ArrayDice);
		   ModAffichage.afficherGrillePossibilite(Grillepossibilite);
		   
		   
		   
		   int [] test = {1,1,1,1,1}; 
		    
		   RemplirTabOccurrence(test,tabOccurrence); 
		    
		   if(mainPleine(tabOccurrence)) { 
			   System.out.print("Main pleine(25 points)  \n" ); 
		   } 
		    
		   if(courteSequence(tabOccurrence)) { 
			   System.out.print("Courte SÃ©quence(15 points)  \n" ); 
		   } 
		    
		   if(longueSequence(tabOccurrence)) { 
			   System.out.print("Longue SÃ©quence(20 points)  \n" ); 
		   } 
		   
		
		   while(CompteurTour< Constantes.NB_ESSAIS) 
		  		 {
		  			 String Input = InputDesARouler();
		  			 
		  			 int intdice = Integer.parseInt(Input);  //Convertion du string en integer
		  			 
		  			 if(intdice<=0) 
		  			 {
		  				 System.out.print("Le joueur ne veux pas relancer.  \n" );//Affichage message pour ne relancer 
		  				 ModAffichage.afficherDes(ArrayDice);
		  				 CompteurTour=Constantes.NB_ESSAIS;
		  				 System.out.print("COMPTEUR EST A  : " + CompteurTour + "\n" );
		  			 }
		  			 
		  			 
		  			  else if(intdice>0)
		  			  {
		  				   System.out.print("Nouvelle main de dés :  \n" );
		  				   ReshuffleDice(ArrayDice,Input);
		  				   ModAffichage.afficherDes(ArrayDice);
		  				   CompteurTour++;
		  				   System.out.print("COMPTEUR EST A  : " + CompteurTour + "\n" );
		  				   
		  			  }
		  			 
		  		 }
		   
		   
		   
		  Additiondelespoints(ArrayDice);
		  ModAffichage.afficherGrillePossibilite(Grillepossibilite);
		   
		 
	    /* Traduisez ici l'algorithme du programme principal
	    
	     */
		   
	    System.out.print(" \nMerci d'avoir joue au YUM avec nous");

	}
	
	
	/*
	 écrivez TOUS vos sous-programmes ici.  Il y en a entre 15 et 20.
	 */
	
	/*
	fonction imcomplet pour rajouter les points dans la grille principale
	*/

	
	public static int[] AjoutPointGrille(int[] array) {
		
		
		System.out.println("(1 a 6) ou 10 = Brelan, 11 = Carre, 12 = Main pleine, 13 = Petite, 14 = Grosse, 15 = Surplus, 16 = Yum");
		int choix = clavier.nextInt();

		
		if (choix == 1) {
			array[1] = 25;
		}
		else if (choix == 2) {
			array[2] = 12;
		}
		else if (choix == 3) {
			array[3] = 17;
		}
		else if (choix == 4) {
			array[4] = 9;
		}
		else if (choix == 5) {
			array[5] = 22;
		}
		else if (choix == 6) {
			array[6] = 19;
		}
		else if (choix == 10) {
			array[Constantes.BRELAN] = 25;
		}
		else if (choix == 11) {
			array[Constantes.CARRE] = 44;
		}
		else if (choix == 12) {
			array[Constantes.MAIN_PLEINE] = 24;
		}
		else if (choix == 13) {
			array[Constantes.PETITE_SUITE] = 77;
		}
		else if (choix == 14) {
			array[Constantes.GROSSE_SUITE] = 100;
		}
		else if (choix == 15) {
			array[Constantes.SURPLUS] = 98;
		}
		else if (choix == 16) {
			array[Constantes.YUM] = 250;
		}

		
		return array;
	}
	
	
	public static int[] InitialShuflle(int[] array) //fonction qui permet de donner 5 des different
	{   
	    Random random = new Random();
	    
	    for (int i = 0; i < array.length; i++) 
	    {
	        array[i] = random.nextInt(Constantes.DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN;
	        
	    }
	 
	    return array;
	}
			
	
	
	public static int[] ReshuffleDice(int[] arrayParam, String Index) // fonction qui shuffle les des selectionner.
	{	 
		 Random random = new Random();
		 for(char c : Index.toCharArray()) 
		 {
			      int a=Integer.parseInt(String.valueOf(c));//Convert char to int 
			      arrayParam[a-1] = random.nextInt(Constantes.DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN; //reshuffle les des a la position demander 	  
		 }
		 
		 return arrayParam;
	} 
	
	
	
	
	public static int countOccurrences(int array[], int dup) /*Fonction a enlever et changer plutard*/
    {
        int resultat = 0;
        for (int i=0; i<array.length; i++)
            if (dup == array[i]) {
            	resultat++;
            }
        return resultat;
    }
	
	
	
	
	
	public static int CountDuplicates(int[]array) //conter le nombre de fois qu'une valeur se repete dans le tableau
	{
		
	    int a=0;
	    
		for (int i = 0; i < array.length; i++) 
		{
		     for (int j = i + 1 ; j < array.length; j++) 
		       {
		    	 
		        if(array[i]==array[j]) 
		        {
		        	 a++;
		        }
		    	  
		        }
		          
		     }
		
		    return a;
		 }
		
	
	
	
	
	
	public static boolean mainPleine(int [] tabOccurrence) {//Trouve si il y a une main pleine 
		 
		boolean mainPleine = false;	 
		int identique2 = 0; 
		int identique3 = 0; 
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==3) { 
				identique3++; 
			} 
			if(tabOccurrence[i]==2) { 
				identique2++; 
			}	 
		} 
		 
		if(identique3 != 0 && identique2 != 0) { 
			mainPleine = true; 
		} 
 
		return mainPleine; 
	} 
	
	
	
	public static boolean longueSequence(int [] tabOccurrence) {//Trouve si il y a une longue sequence 
 
		boolean longueSequence = false;	 
		int compteur = 0; 
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==1) { 
				compteur++; 
			}	 
		} 
		 
		if(compteur==5) { 
			if(tabOccurrence[1] == 0 || tabOccurrence[6] == 0) { 
				longueSequence = true; 
			} 
			 
		} 
 
		return longueSequence; 
	} 
	
	
	
	public static boolean courteSequence(int [] tabOccurrence) {//Trouve si il y a une courte sequence 
 
		boolean courtSequence = false;	 
		int compteur = 0; 
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==1 && compteur < 4) { 
				compteur++; 
			}	 
		} 
		 
		if(compteur==4) { 
			if(tabOccurrence[1] == 0 || tabOccurrence[6] == 0 || tabOccurrence[5] == 0 || tabOccurrence[2] == 0) { 
				courtSequence = true; 
			} 
		} 
 
		return courtSequence; 
	} 
	
	
	public static void RemplirTabOccurrence(int [] tabDes, int []tabOccurrence) { 
		for(int i=0;i<tabDes.length;i++){ 
			tabOccurrence[tabDes[i]]++;//Ajouter au tableau le nombre d'occurence d'un dés en utilisant la position dans le tableau qui lui correspond 
		} 
	}
	

	public static String InputDesARouler() 
	{
		   System.out.print("Entrer  les des  a changer (0) si vous vouler garder vos dés- " );
		   String NumberChangeOfDice = clavier.nextLine();//Input le string qui represent les des a changer 
		   return NumberChangeOfDice;
		
	}
	
	
	
	public static void Additiondelespoints(int[] tab) 
	{
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
				
		
		for(int i=0;i<tab.length;i++) 
		{
			
			if (tab[i] != 0){
				
			if(tab[i]==1) 
			{
				 a += tab[i];
			}
			
			if(tab[i]==2) 
			{
				 b += tab[i];
			}
			
			if(tab[i]==3) 
			{
				 c += tab[i];
			}
			
			if(tab[i]==4) 
			{
				 d += tab[i];
			}
			
			if(tab[i]==5) 
			{
				 e += tab[i];
			}
			
			if(tab[i]==6) 
			{
				 f += tab[i];
			}
			
			}
			
			
		}	
		
		  Grillepossibilite[1]= a;
		  Grillepossibilite[2]= b;
		  Grillepossibilite[3]= c;
		  Grillepossibilite[4]= d;
		  Grillepossibilite[5]= e;
		  Grillepossibilite[6]= f;
		
	}
	
	
}
