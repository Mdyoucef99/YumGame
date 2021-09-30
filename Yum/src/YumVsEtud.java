
package src;

import java.util.Random;
import java.util.Scanner;


/*

 ** Programme principal qui dï¿½marre le jeu de YUM pour un seul joueur. 
 *  
 * Une sï¿½rie de 5 dï¿½s est gï¿½nï¿½rï¿½ alï¿½atoirement et le joueur a droit 
 * a changer les dï¿½s qu'il dï¿½sire ï¿½ deux reprises ï¿½ moins qu'il les 
 * garde tous. 
 *  
 * Par la suite, le programme offre toutes les possibilitï¿½s de points  
 * pouvant ï¿½tre jouï¿½s et le joueur dï¿½cide quel est son choix parmi  
 * ces possibilitï¿½s. 
 *  
 * Dans le cadre du cours inf111 (voir ï¿½nnoncï¿½ fourni). 
 *  
 * Auteur : Mettez le nom de chaque membre du groupe qui a suffisamment  
 *          contribuï¿½ en ï¿½criture de code et de commentaires. 
 *           
 *          
 * Auteur : Youcef mekki daouadji
 * Auteur : Rada Leng
 * Auteur : Antoine Bolduc
 * Auteur :
 * Auteur :
 * 
 * 
 * Auteur : Pierre Bï¿½lisle 
 *          
 * Version : Copyright A2021
 */

public class YumVsEtud {

	
	// Les constantes sont dï¿½fines dans le module Constantes.java
	// Si vous en ajoutez, faites-le ici.
	
	  public static int[] Grillepossibilite = new int[Constantes.NB_CASES];
	  public static int  CompteurTour = 1;
	  public static int[] tabOccurrence = new int[7];//Tableau pour accumuler les occurences des 
	  public static int[] ArrayDice = new int[Constantes.NB_DES]; //creation des 5 des. 
	  public static int[] ArrayPoint = new int[Constantes.NB_CASES];
	 
	// Permet la saisie de donnï¿½ au clavier en mode console.
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args){
		
		
           ModAffichage.afficherGrille(ArrayPoint);
		   InitialShuflle(ArrayDice); //
		   ModAffichage.afficherDes(ArrayDice);//affichage des dï¿½s 
		   RemplirTabOccurrence(ArrayDice,tabOccurrence); 
		   Additiondelespoints(ArrayDice,Grillepossibilite);
		   CheckCondition();
		   ModAffichage.afficherGrillePossibilite(Grillepossibilite);
		   
		   
		   while(CompteurTour< Constantes.NB_ESSAIS) 
		  		 {
		  			 String Input = InputDesARouler();
		  			 int intdice = Integer.parseInt(Input);  //Convertion du string en integer
		  			 
		  			 if(intdice<=0) 
		  			 {
		  				 System.out.print("Le joueur ne veux pas relancer.  \n" );//Affichage message pour ne relancer 
		  				 ModAffichage.afficherDes(ArrayDice);
		  				 
		  				 
		  				 Additiondelespoints(ArrayDice,Grillepossibilite);
		  				 CheckCondition();
		  				 ModAffichage.afficherGrillePossibilite(Grillepossibilite);
		  				 CompteurTour=Constantes.NB_ESSAIS;
		  				 System.out.print("COMPTEUR EST A  : " + CompteurTour + "\n" );
		  			 }
		  			 
  
		  			  else if(intdice>0)
		  			  {
		  				   System.out.print("Nouvelle main de dées :  \n" );
		  				   ReshuffleDice(ArrayDice,Input);
		  				   
		  				   ModAffichage.afficherDes(ArrayDice);
		  				   Additiondelespoints(ArrayDice,Grillepossibilite);
		  				   CheckCondition();
		  				   ModAffichage.afficherGrillePossibilite(Grillepossibilite);
		  				   CompteurTour++;
		  				   System.out.print("COMPTEUR EST A  : " + CompteurTour + "\n" );
		  				   
		  			  }
		  			 
		  		 }
		   
 
	    /* Traduisez ici l'algorithme du programme principal
	    
	     */
		   
	    System.out.print(" \nMerci d'avoir joue au YUM avec nous");

	}
	
	
	/*
	 * Ãƒâ€°crivez TOUS vos sous-programmes ici.  Il y en a entre 15 et 20.
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
	
	public static boolean yum(int [] tabOccurrence) {//Trouve si il y a un yum 
		 
		boolean yum = false;	  
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]==5) { 
				yum = true; 
			}	 
		} 
 
		return yum; 
	}
	
	public static int carre(int [] tabOccurrence) {//Trouve si il y a un carre 
		 
		int total= 0;  
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]>=4) { 
				total = 4*i; 
				
			}	 
		} 
		
		 Grillepossibilite[Constantes.CARRE] = total;
		
 
		return total; 
	}
	public static int berlan(int [] tabOccurrence) 
	{//Trouve si il y a un berlan 
		 
		int total= 0;  
		 
		for (int i = 0; i < tabOccurrence.length; i++) { 
			if(tabOccurrence[i]>=3) { 
				total = 3*i; 
			}	 
		} 
		   Grillepossibilite[Constantes.BRELAN] = total;
		return total; 
	}
	
	public static int surplus(int [] tab) 
	{ 
		 
		int total= 0;  
		 
		for (int i = 0; i < tab.length; i++) { 
			total += tab[i];	 
		} 
 
		 Grillepossibilite[Constantes.SURPLUS] = total;
		return total; 
	}
	public static void RemplirTabOccurrence(int [] tabDes, int []tabOccurrence) 
	{ 
		for(int i=0;i<tabDes.length;i++){ 
			tabOccurrence[tabDes[i]]++;//Ajouter au tableau le nombre d'occurence d'un des en utilisant la position dans le tableau qui lui correspond 
		} 
	}
	

	public static String InputDesARouler() 
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
	
	
	public static void CheckCondition() 
	{
		
		if(mainPleine(tabOccurrence)) 
		   { 
			   Grillepossibilite[Constantes.MAIN_PLEINE] = 25;
			   
		   } 
		    
		   if(courteSequence(tabOccurrence)) { 

			   Grillepossibilite[Constantes.PETITE_SUITE] = 15;
			   
		   } 
		    
		   if(longueSequence(tabOccurrence)) { 
			  
			   Grillepossibilite[Constantes.GROSSE_SUITE] = 20;
			   
		   }
		   
		   if(yum(tabOccurrence)) { 

			   Grillepossibilite[Constantes.YUM] = 30;
 
		   }
 
		   carre(tabOccurrence);

		   berlan(tabOccurrence);
		   
		   surplus(ArrayDice);

		   
	}

}
