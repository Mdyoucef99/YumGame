package src;

import java.util.Random;
import java.util.Scanner;


/*
 ** Programme principal qui démarre le jeu de YUM pour un seul joueur. 
 *  
 * Une série de 5 dés est généré aléatoirement et le joueur a droit 
 * a changer les dés qu'il désire é éeux reprises  moins qu'il les 
 * garde tous. 
 *  
 * Par la suite, le programme offre toutes les possibilités de points  
 * pouvant étre joués et le joueur décide quel est son choix parmi  
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
 * Auteur : Antoine Bolduc
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
	
	 public static int[] grillePossibilite = new int[25];
	 public static int  compteurTour = 1;
	 public static int[] tabOccurrence = new int[7];//Tableau pour accumuler les occurences des des 
	  public static int[] arrayDice = new int[5]; //creation des 5 des. 
	  public static int[] arrayPoint = new int[19];
	 
	// Permet la saisie de donn�es au clavier en mode console.
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args){
		
	/* Traduisez ici l'algorithme du programme principal*/
		
		   initialisePointGrille(arrayPoint);
           ModAffichage.afficherGrille(arrayPoint);
		   initialShuflle(arrayDice);
		   ModAffichage.afficherDes(arrayDice);
		   remplirTabOccurrence(arrayDice,tabOccurrence); 
		   additionDesPoints(arrayDice);

		   checkCondition();
		   ModAffichage.afficherGrillePossibilite(grillePossibilite);
		   
		   
		   while(compteurTour< Constantes.NB_ESSAIS) 
		  		 {
		  			 String Input = inputDesARouler();
		  			 int intdice = Integer.parseInt(Input);  //Convertion du string en integer
		  			 
		  			 if(intdice<=0) 
		  			 {
		  				 System.out.print("Le joueur ne veux pas relancer.  \n" );//Affichage message pour ne relancer 
		  				 ModAffichage.afficherDes(arrayDice);
		  				 additionDesPoints(arrayDice);
		  				 checkCondition();
		  				 ModAffichage.afficherGrillePossibilite(grillePossibilite);
		  				 compteurTour=Constantes.NB_ESSAIS;
		  				 System.out.print("COMPTEUR EST A  : " + compteurTour + "\n" );
		  			 }
		  			 
  
		  			  else if(intdice>0)
		  			  {
		  				   System.out.print("Nouvelle main de d�es :  \n" );
		  				   reshuffleDice(arrayDice,Input);
		  				   ModAffichage.afficherDes(arrayDice);
		  				   additionDesPoints(arrayDice);
		  				   checkCondition();
		  				   ModAffichage.afficherGrillePossibilite(grillePossibilite);
		  				   compteurTour++;
		  				   System.out.print("COMPTEUR EST A  : " + compteurTour + "\n" );
		  				   
		  			  }
		  			 
		  		 }
           ajoutPointGrille(arrayPoint,45);
           ModAffichage.afficherGrille(arrayPoint);
		   
	    System.out.print(" \nMerci d'avoir joue au YUM avec nous");

	}
	
	
	/*
	 * Ã‰crivez TOUS vos sous-programmes ici.  Il y en a entre 15 et 20.
	 */
	
	/*
	fonction imcomplet pour rajouter les points dans la grille principale
	*/

	public static int[] initialisePointGrille(int[] array) {
		
		for(int i = 0 ; i < array.length ; i++) {
			array[i] = -1;
		}
		array[Constantes.SOUS_TOTAL_HAUT] = 0;
		array[Constantes.BONUS_DU_HAUT] = 0;
		array[Constantes.TOTAL_HAUT] = 0;
		array[Constantes.TOTAL_BAS] = 0;
		array[Constantes.GRAND_TOTAL] = 0;
		return array;
	}
	
	public static int[] ajoutPointGrille(int[] array, int point) {
		
		
		System.out.println("(1 a 6) ou 10 = Brelan, 11 = Carre, 12 = Main pleine, 13 = Petite, 14 = Grosse, 15 = Surplus, 16 = Yum");
		int choix = clavier.nextInt();

		
		if (choix == 1) {
			array[1] =point;
		}
		else if (choix == 2) {
			array[2] = point;
		}
		else if (choix == 3) {
			array[3] = point;
		}
		else if (choix == 4) {
			array[4] = point;
		}
		else if (choix == 5) {
			array[5] = point;
		}
		else if (choix == 6) {
			array[6] = point;
		}
		else if (choix == 10) {
			array[Constantes.BRELAN] = point;
		}
		else if (choix == 11) {
			array[Constantes.CARRE] = point;
		}
		else if (choix == 12) {
			array[Constantes.MAIN_PLEINE] = point;
		}
		else if (choix == 13) {
			array[Constantes.PETITE_SUITE] = point;
		}
		else if (choix == 14) {
			array[Constantes.GROSSE_SUITE] = point;
		}
		else if (choix == 15) {
			array[Constantes.SURPLUS] = point;
		}
		else if (choix == 16) {
			array[Constantes.YUM] = point;
		}

		array[Constantes.SOUS_TOTAL_HAUT] += point;
		array[Constantes.TOTAL_HAUT] += point;
		array[Constantes.GRAND_TOTAL] += point;
		return array;
	}
	
	
	public static int[] initialShuflle(int[] array) //fonction qui permet de donner 5 des different
	{   
	    Random random = new Random();
	    
	    for (int i = 0; i < array.length; i++) 
	    {
	        array[i] = random.nextInt(Constantes.NB_DES - Constantes.DES_MIN) + Constantes.DES_MIN;
	        
	    }
	 
	    return array;
	}
			
	
	
	public static int[] reshuffleDice(int[] arrayParam, String Index) // fonction qui shuffle les des selectionner.
	{	 
		
		 Random random = new Random();
		 for(char c : Index.toCharArray()) 
		 {
			      int a=Integer.parseInt(String.valueOf(c));//Convert char to int 
			      arrayParam[a-1] = random.nextInt(Constantes.NB_DES - Constantes.DES_MIN) + Constantes.DES_MIN; //reshuffle les des a la position demander 	  
		 }
		 
		 return arrayParam;
	} 
	
	/*	Trouver une main pleine dans un tableau re�u en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverMainPleine(int [] tabOccurrence) { 
		 	 
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
			grillePossibilite[Constantes.MAIN_PLEINE] = 25; 
		}  
	}
	
	/*	Trouver une longue s�quence dans un tableau re�u en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverLongueSequence(int [] tabOccurrence) { 
 
		int compteur = 0; 
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==1) { 
				compteur++; 
			}	 
		} 
		 
		if(compteur==5) { 
			if(tabOccurrence[1] == 0 || tabOccurrence[6] == 0) { 
				grillePossibilite[Constantes.GROSSE_SUITE] = 20; 
			} 
			 
		}  
	}
	
	/*	Trouver une courte s�quence dans un tableau re�u en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverCourteSequence(int [] tabOccurrence) {
 	 
		int compteur = 0; 
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==1 && compteur < 4) { 
				compteur++; 
			}	 
		} 
		 
		if(compteur==4) { 
			if(tabOccurrence[1] == 0 || tabOccurrence[6] == 0 || tabOccurrence[5] == 0 || tabOccurrence[2] == 0) { 
				grillePossibilite[Constantes.PETITE_SUITE] = 15; 
			} 
		}  
	}
	
	/*	Trouver le yum dans un tableau re�u en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverYum(int [] tabOccurrence) { 
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==5) { 
				grillePossibilite[Constantes.YUM] = 30; 
			}	 
		} 
	}
	
	/*	Trouver un carr� dans un tableau re�u en param�tre et 
	 * 	mettre le total dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverCarre(int [] tabOccurrence) { 
		 
		int total= 0;  
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]>=4) { 
				total = 4*i; 
				
			}	 
		} 		
		grillePossibilite[Constantes.CARRE] = total;
	}
	
	/*	Trouver un brelan dans un tableau re�u en param�tre et 
	 * 	mettre le total dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverBerlan(int [] tabOccurrence) { 
		 
		int total= 0;  
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]>=3) { 
				total = 3*i; 
			}	 
		} 
		grillePossibilite[Constantes.BRELAN] = total; 
	}
	
	/*	Trouver le surplus dans un tableau re�u en param�tre et 
	 * 	mettre le total dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverSurplus(int [] tab) 
	{ 
		int total= 0;  
		 
		for (int i = 0; i < tab.length; i++) { 
			total += tab[i];	 
		} 
 
		grillePossibilite[Constantes.SURPLUS] = total;
	}
	
	/*	Remplir un nouveau tableau avec le nombre d'occurrences de chaque d� � chaque position qui lui correspond
	 *  avec les donn�es du tableau des d�s initial. Par exemple, si mes d�s sont {1,2,3,5,5} 
	 *  mon nouveau tableau sera : {0,1,1,1,0,2,0}  
	 * 
	 *  @param tabDes : un tableau
	 *  @param tabOccurrence : un nouveau tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void remplirTabOccurrence(int [] tabDes, int []tabOccurrence) 
	{ 
		for(int i=0;i<tabDes.length;i++){ 
			tabOccurrence[tabDes[i]]++;
		} 
	}
	

	public static String inputDesARouler() 
	{
		   System.out.print("Entrer  les des  a changer (0) si vous vouler garder vos dés " );
		   String NumberChangeOfDice = clavier.nextLine();//Input le string qui represent les des a changer 
		   return NumberChangeOfDice;
		
	}
	

	public static int[] Additiondelespoints(int[] tab,int[] grille) 
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
		
		grille[1]= a;
		grille[2]= b;
		grille[3]= c;
		grille[4]= d;
		grille[5]= e;
		grille[6]= f;
		
		return grille;
		
	}
	
	/*	Appel des fonctions de v�rification des combinaisons possibles.
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void checkCondition() 
	{ 
		   trouverMainPleine(tabOccurrence);
		   trouverCourteSequence(tabOccurrence);
		   trouverLongueSequence(tabOccurrence);
		   trouverYum(tabOccurrence);		   
		   trouverCarre(tabOccurrence);
		   trouverBerlan(tabOccurrence);	   
		   trouverSurplus(arrayDice);	   
	}

}