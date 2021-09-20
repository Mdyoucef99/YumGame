package src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/*

 * Programme principal qui d�marre le jeu de YUM pour un seul joueur.
 * 
 * Une s�rie de 5 d�s est g�n�r� al�atoirement et le joueur a droit
 * a changer les d�s qu'il d�sire � deux reprises � moins qu'il les
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
 * Auteur : Youcef mekki daouadji
 * Auteur :
 * Auteur :
 * Auteur :
 * Auteur :
 * 
 * 
 * Auteur : Pierre B�lisle
 *          
 * Version : Copyright A2021
 */

public class YumVsEtud {

	
	// Les constantes sont d�finies dans le module Constantes.java
	// Si vous en ajoutez, fa�tes-le ici.
	
	public static int IncrementTour=0;
	// Permet la saisie de donn�e au clavier en mode console.
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args){
		
		   int[] ArrayDice = new int[5]; //creation des 5 des.
		   InitialShuflle(ArrayDice); //g�n�ration des chiffre al�atoirement entre 1 et 6; 
		   
		   ModAffichage.afficherDes(ArrayDice);//affichage des d�s 
		   ModAffichage.afficherGrillePossibilite(ArrayDice);//Affichage grille possibilite pares shuffle initial 
		  
		  
		   System.out.print("Entrer  les des  a changer - " );
		   String NumberChangeOfDice = clavier.nextLine();//Input le string qui represent les des a changer 
		   int intdice = Integer.parseInt(NumberChangeOfDice);  //Convertion du string en integer
		   
		   if(intdice<=0) //checker si le input est positif
		   {
			   System.out.print("Le joueur ne veux pas relancer.  \n" );//Affichage message pour ne relancer 
			   ModAffichage.afficherDes(ArrayDice);
		   }
		   else if(intdice>0)
		   {
			   ReshuffleDice(ArrayDice,NumberChangeOfDice); //changement des des
			  
			   ModAffichage.afficherDes(ArrayDice);
			   CountDuplicates(ArrayDice);
		   }
		   
		 
		   
		   
		 
		   
	    /* Traduisez ici l'algorithme du programme principal
	     * d�crit dans l'�nonc� et commenter votre code au fur et � mesure.
	     */
		   
	    System.out.print(" \nMerci d'avoir joue au YUM avec nous");
	}
	
	
	/*
	 * �crivez TOUS vos sous-programmes ici.  Il y en a entre 15 et 20.
	 */
	public static int[] InitialShuflle(int[] array) //fonction qui permet de donner 5 des different
	{   
		IncrementTour++;
	    Random random = new Random();
	    for (int i = 0; i < array.length; i++) 
	    {
	        array[i] = random.nextInt(Constantes.DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN;
	        
	       
	    }
	 
	    return array;
	}
				
	public static int[] ReshuffleDice(int[] arrayParam, String Index) // fonction qui shuffle les des selectionner.
	{	 
		 IncrementTour++;
		 Random random = new Random();
		 for(char c : Index.toCharArray()) 
		 {
			      int a=Integer.parseInt(String.valueOf(c));//Convert char to int 
			      arrayParam[a-1] = random.nextInt(Constantes.DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN; //reshuffle les des a la position demander 	  
		 }
		 
		 return arrayParam;
	} 
	
	public static void CountDuplicates(int[]array) //conter le nombre de fois qu'une valeur se repete dans le tableau
	{
		int r=0;
		
		for (int i = 0; i < array.length; i++) 
		{
		     for (int j = i + 1 ; j < array.length; j++) 
		          {
		          if (array[i]==array[j]) 
		          {
		            r++;   
		            
		            if(r==3) 
		            {
		            	System.out.println("Brelan "+ array[i]*3);
		            }
		            
		            else if(r==4) 
		            {
		            	System.out.println(" Carre "+array[i]*4);
		            }
		            
		          }
		          
		     }
		    
		 }
		
	}
	
}