package src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/*

 * Programme principal qui démarre le jeu de YUM pour un seul joueur.
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
 * Auteur :
 * Auteur :
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

	
	// Les constantes sont définies dans le module Constantes.java
	// Si vous en ajoutez, faîtes-le ici.
	
	public static int IncrementTour=0;
	// Permet la saisie de donnée au clavier en mode console.
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args){
		
		
		   int[] ArrayDice = new int[5]; //creation des 5 des.
		   
		   InitialShuflle(ArrayDice); //génération des chiffre aléatoirement entre 1 et 6; 
		   ModAffichage.afficherDes(ArrayDice);//affichage des dés 
		   ModAffichage.afficherGrillePossibilite(ArrayDice);//Affichage grille possibilite pares shuffle initial 
		   
		   System.out.print("Entrer  les des  a changer - " );
		   String NumberChangeOfDice = clavier.nextLine();//Input le string qui represent les des a changer 
		   System.out.print(System.lineSeparator());//next line 
		   ReshuffleDice(ArrayDice,NumberChangeOfDice); //changement des des 
		   
		   
		   
	    /* Traduisez ici l'algorithme du programme principal
	     * décrit dans l'énoncé et commenter votre code au fur et à mesure.
	     */
		   
	
	    System.out.print("Merci d'avoir joue au YUM avec nous");
	}
	
	
	/*
	 * Écrivez TOUS vos sous-programmes ici.  Il y en a entre 15 et 20.
	 */
	public static int[] InitialShuflle(int[] array) //fonction qui permet de donner 5 des different
	{   
	    Random random = new Random();
	    for (int i = 0; i < array.length; i++) 
	    {
	        array[i] = random.nextInt(Constantes.DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN;
	    }
	 
	    return array;
	}
				
	public static void ReshuffleDice(int[] arrayParam, String Index) // fonction qui shuffle les des selectionner.
	{	 IncrementTour++;
		 Random random = new Random();
		 System.out.print("Nouvelle main de des" );
		 System.out.print(System.lineSeparator());
		 
		 for(char c : Index.toCharArray()) 
		 {
			      int a=Integer.parseInt(String.valueOf(c));//Convert char to int 
			      if(a <=0) 
			      {
			    	  System.out.println("player decided to not shuffle");
			      }
			      
			      else {
			    	  arrayParam[a-1] = random.nextInt(Constantes.DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN; //reshuffle les des a la position demander 
			      }
				  
		 }
		 ModAffichage.afficherGrillePossibilite(arrayParam);//affichage the possibilité dans la grille
		 
	} 
	
}