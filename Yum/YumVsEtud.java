package src;
import java.util.Random;
import java.util.Scanner;

/*
 ** Programme principal qui démarre le jeu de YUM pour un seul joueur. 
 *  
 * Une série de 5 dés est g�n�r� al�atoirement et le joueur a droit 
 * a changer les d�s qu'il d�sire � �eux reprises  moins qu'il les 
 * garde tous. 
 *  
 * Par la suite, le programme offre toutes les possibilit�s de points  
 * pouvant �tre jou�s et le joueur d�cide quel est son choix parmi  
 * ces possibilit�s. 
 *  
 * Dans le cadre du cours inf111 (voir �nnonc� fourni). 
 *  
 * Auteur : Mettez le nom de chaque membre du groupe qui a suffisamment  
 *          contribu� en �criture de code et de commentaires. 
 *           
 *          
 * Auteur : Youcef mekki daouadji
 * Auteur : Rada Leng
 * Auteur : Antoine Bolduc
 * Auteur :
 * Auteur :
 * 
 * 
 * Auteur : Pierre B�lisle 
 *          
 * Version : Copyright A2021
 */

public class YumVsEtud {

	
	// Les constantes sont d�fines dans le module Constantes.java
	// Si vous en ajoutez, faites-le ici.
	
	 public static int[] grillePossibilite = new int[25];
	 public static int  compteurTour = 1;
	 public static int[] tabOccurrence = new int[7];//Tableau pour accumuler les occurences des des 
	 public static int[] arrayDice = new int[5]; //creation des 5 des. 
	 public static int[] arrayPoint = new int[19];
	 public static int point = 0;
	public static final int DES_MAX = 7;
	 
	// Permet la saisie de donn�es au clavier en mode console.
	public static Scanner clavier = new Scanner(System.in);
	public static Scanner clavier2 = new Scanner(System.in);

	public static void main(String[] args)  {
		
	/* Traduisez ici l'algorithme du programme principal*/
		   
		   initialisePointGrille(arrayPoint);
           for(int i = 1 ; i < Constantes.NB_TOURS +1 ; i++) {

        	ModAffichage.afficherGrille(arrayPoint);
        	System.out.printf("vous etes au tour %d",i);
           System.out.println(); 
		   initialShuflle(arrayDice);
		   ModAffichage.afficherDes(arrayDice);
		   remplirTabOccurrence(arrayDice,tabOccurrence); 
		   additionDesPoints(arrayDice,grillePossibilite);
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
		  				 remplirTabOccurrence(arrayDice,tabOccurrence);
		  				 additionDesPoints(arrayDice,grillePossibilite);
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
		  				   remplirTabOccurrence(arrayDice,tabOccurrence);
		  				   additionDesPoints(arrayDice,grillePossibilite);
		  				   checkCondition();
		  				   ModAffichage.afficherGrillePossibilite(grillePossibilite);
		  				   compteurTour++;
		  				   System.out.print("COMPTEUR EST A  : " + compteurTour + "\n" );
		  				   
		  			  }
		  			 
		  		 }
		   compteurTour = 1;
           ajoutPointGrille(arrayPoint);
           for (int j = 0; j < 50; ++j) System.out.println();
		   }
	    System.out.print(" \nMerci d'avoir joue au YUM avec nous");

	}
	
	/*
	 *�crivez TOUS vos sous-programmes ici.  Il y en a entre 15 et 20.
	 */

	
	/*
	 * 
	 * Initialise la grille de point avec des valeur -1
	 * sauf pour les grille total ou il commence avec 0 initiallement
	 * 
	 * Auteur : Rada Leng
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
	
	/*
	 * fonction qui retourne un le tableau de grille de point
	 * Puisque le tableau Grillepossibilite est la meme taille que grilledepoint
	 * la valeur de grilledepossibilite[i] choisi sera implemente dans le array[i]
	 * du grille de point. dependement de quel i on choisi le sous_total
	 * total_haut etc sera += (additionne) et le total final est laddition de tout.
	 * 
	 * si la grille choisi nest pas -1 on redemande une valeur
	 * 
	 * Autour : Rada Leng
	 */
	
	public static int[] ajoutPointGrille(int[] array) {
		
		System.out.println("(1 a 6) ou 10 = Brelan, 11 = Carre, 12 = Main pleine, 13 = Petite, 14 = Grosse, 15 = Surplus, 16 = Yum : ");
		int choix = clavier2.nextInt();

		int bonus = 0;
		
		int total_haut = 0;
		int total_bas = 0;
		int sous_total = 0;

		while(array[choix] != -1) {
			System.out.println("le choix a deja une valeur veuillez refaire votre choix");
			System.out.println("(1 a 6) ou 10 = Brelan, 11 = Carre, 12 = Main pleine, 13 = Petite, 14 = Grosse, 15 = Surplus, 16 = Yum : ");
			choix = clavier2.nextInt();
		}
		
		if (choix == 1) {
			array[1] = grillePossibilite[1];
			point = grillePossibilite[1];
			sous_total += point;
			total_haut += point;

		}
		else if (choix == 2) {
			array[2] = grillePossibilite[2];
			point = grillePossibilite[2];
			sous_total += point;
			total_haut += point;

		}
		else if (choix == 3) {
			
			array[3] = grillePossibilite[3];
			point = grillePossibilite[3];
			sous_total += point;
			total_haut += point;
			

		}
		else if (choix == 4) {
			array[4] = grillePossibilite[4];
			point = grillePossibilite[4];
			sous_total += point;
			total_haut += point;

		}
		else if (choix == 5) {
			array[5] = grillePossibilite[5];
			point = grillePossibilite[5];
			sous_total += point;
			total_haut += point;

		}
		else if (choix == 6) {
			array[6] = grillePossibilite[6];
			point = grillePossibilite[6];
			sous_total += point;
			total_haut += point;

		}
		else if (choix == 10) {
			array[Constantes.BRELAN] = grillePossibilite[Constantes.BRELAN];
			point = grillePossibilite[Constantes.BRELAN];
			total_bas += point;
		}
		else if (choix == 11) {
			array[Constantes.CARRE] = grillePossibilite[Constantes.CARRE];
			point = grillePossibilite[Constantes.CARRE];
			total_bas += point;
		}
		else if (choix == 12) {
			array[Constantes.MAIN_PLEINE] = grillePossibilite[Constantes.MAIN_PLEINE];
			point = grillePossibilite[Constantes.MAIN_PLEINE];
			total_bas += point;
		}
		else if (choix == 13) {
			array[Constantes.PETITE_SUITE] = grillePossibilite[Constantes.PETITE_SUITE];
			point = grillePossibilite[Constantes.PETITE_SUITE];
			total_bas += point;
		}
		else if (choix == 14) {
			array[Constantes.GROSSE_SUITE] = grillePossibilite[Constantes.GROSSE_SUITE];
			point = grillePossibilite[Constantes.GROSSE_SUITE];
			total_bas += point;
		}
		else if (choix == 15) {
			array[Constantes.SURPLUS] = grillePossibilite[Constantes.SURPLUS];
			point = grillePossibilite[Constantes.SURPLUS];
			total_bas += point;
		}
		else if (choix == 16) {
			array[Constantes.YUM] = grillePossibilite[Constantes.YUM];
			point = grillePossibilite[Constantes.YUM];
			total_bas += point;
		}


		bonus = array[1] + array[2] + array[3] + array[4] +array[5] +array[6];
		if(bonus >= Constantes.MIN_BONUS) {
			array[Constantes.BONUS_DU_HAUT] = Constantes.POINT_BONUS_HAUT;
			point += array[Constantes.BONUS_DU_HAUT];
			total_haut += array[Constantes.BONUS_DU_HAUT];
		}

		array[Constantes.TOTAL_BAS] += total_bas;
		array[Constantes.SOUS_TOTAL_HAUT] += sous_total;
		array[Constantes.TOTAL_HAUT] += total_haut;
		array[Constantes.GRAND_TOTAL] += point;
		return array;
	}
	
	
	public static int[] initialShuflle(int[] array) //fonction qui permet de donner 5 des different
	{   
	    Random random = new Random();
	    
	    for (int i = 0; i < array.length; i++) 
	    {
	        array[i] = random.nextInt(DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN;
	        
	    }
	 
	    return array;
	}
			

	public static int[] reshuffleDice(int[] arrayParam, String Index) // fonction qui shuffle les des selectionner.
	{	 
		
		 Random random = new Random();
		 for(char c : Index.toCharArray()) 
		 {
			      int a=Integer.parseInt(String.valueOf(c));//Convert char to int 
			      arrayParam[a-1] = random.nextInt(DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN; //reshuffle les des a la position demander 	  
		 }
		 
		 return arrayParam;
	} 
	
	/*	Trouver une main pleine dans un tableau  en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverMainPleine(int [] tabOccurrence) { 
		 	 
		int identique2 = 0; 
		int identique3 = 0;
		grillePossibilite[Constantes.MAIN_PLEINE] = 0; 
		 
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
	
	/*	Trouver une longue s�quence dans un tableau en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverLongueSequence(int [] tabOccurrence) { 
 
		int compteur = 0;
		grillePossibilite[Constantes.GROSSE_SUITE] = 0; 
		 
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
	
	/*	Trouver une courte s�quence dans un tableau en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverCourteSequence(int [] tabOccurrence) {
 	 
		int compteur = 0;
		grillePossibilite[Constantes.PETITE_SUITE] = 0; 
		 
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
	
	/*	Trouver le yum dans un tableau en param�tre et 
	 * 	mettre les donn�es dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverYum(int [] tabOccurrence) {

		grillePossibilite[Constantes.YUM] = 0; 
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==5) { 
				grillePossibilite[Constantes.YUM] = 30; 
			}	 
		} 
	}
	
	/*	Trouver un carr� dans un tableau  en param�tre et 
	 * 	mettre le total dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverCarre(int [] tabOccurrence) { 
		 
		int total= 0;
		grillePossibilite[Constantes.CARRE] = 0;  
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]>=4) { 
				total = 4*i; 
				
			}	 
		} 		
		grillePossibilite[Constantes.CARRE] = total;
	}
	
	/*	Trouver un brelan dans un tableau en param�tre et 
	 * 	mettre le total dans la grille de possibilit�s.
	 * 
	 *  @param tabOccurrence : un tableau
	 *  
	 *  Auteur: Antoine Bolduc
	 */
	public static void trouverBerlan(int [] tabOccurrence) { 
		 
		int total= 0;
		grillePossibilite[Constantes.BRELAN] = 0;  
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]>=3) { 
				total = 3*i; 
			}	 
		} 
		grillePossibilite[Constantes.BRELAN] = total; 
	}
	
	/*	Trouver le surplus dans un tableau  en param�tre et 
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
	
	/*	Remplir un nouveau tableau avec le nombre d'occurrences de chaque d�s chaque position qui lui correspond
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
		for(int i=0;i<tabOccurrence.length;i++){
			tabOccurrence[i] = 0;
		}
		for(int i=0;i<tabDes.length;i++){
			tabOccurrence[tabDes[i]]++;
		} 
	}
	

	public static String inputDesARouler() 
	{
		   System.out.print("Entrer  les des  a changer (0) si vous vouler garder vos d�s " );
		   String NumberChangeOfDice = clavier.nextLine();//Input le string qui represent les des a changer 
		   return NumberChangeOfDice;
		
	}
	

	
	public static int[] additionDesPoints(int[] tab,int[] grille) 
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