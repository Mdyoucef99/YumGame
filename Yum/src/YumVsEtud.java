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
 * Auteur :
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
	
	
	// Permet la saisie de donn�e au clavier en mode console.
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args){
		
		
		   int[] ArrayDice = new int[5]; //creation des 5 des.
		   
		   RandomNumberInArray(ArrayDice,Constantes.DES_MIN,Constantes.DES_MAX); //g�n�ration des chiffre al�atoirement entre 1 et 6; 
		   ModAffichage.afficherDes(ArrayDice);//affichage des d�s 
		   
		   System.out.print("Entrer  les des  a changer - " );
		   String NumberChangeOfDice = clavier.nextLine();//Input le string qui represent les des a changer 
		   System.out.print(System.lineSeparator());//next line 
		   ReshuffleDice(ArrayDice,NumberChangeOfDice); //changement des des 
		  
		   ModAffichage.afficherDes(ArrayDice);//affichage des nouveaux des
		   
		   
	    /* Traduisez ici l'algorithme du programme principal
	     * d�crit dans l'�nonc� et commenter votre code au fur et � mesure.
	     */
		   
	
	    System.out.print("Merci d'avoir joue au YUM avec nous");
	}
	
	
	/*
	 * �crivez TOUS vos sous-programmes ici.  Il y en a entre 15 et 20.
	 */
	public static int[] RandomNumberInArray(int[] array, int min, int max) //fonction qui permet de donner 5 des different
	{
	    Random random = new Random();
	    for (int i = 0; i < array.length; i++) 
	    {
	        array[i] = random.nextInt(max - min) + min;
	    }
	    return array;
	}
				
	public static void ReshuffleDice(int[] arrayParam, String Index) // fonction qui shuffle les des selectionner.
	{	
		 Random random = new Random();
		 System.out.print("Nouvelle main de des" );
		 System.out.print(System.lineSeparator());
		 
		 for(char c : Index.toCharArray()) 
		 {
			      int a=Integer.parseInt(String.valueOf(c));
			      if(a <=0) 
			      {
			    	  System.out.println("player decided to not shuffle");
			      }
			      
			      else {
			    	  arrayParam[a-1] = random.nextInt(Constantes.DES_MAX - Constantes.DES_MIN) + Constantes.DES_MIN; 
			      }
				
		 }
		 
	   
	} 
	
}