package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YumTest {

	@Test // Test unitaire pour le premier lancer de dés  @Youcef mekki daouadji
	void test_InitialShuffle() {

		
		System.out.print("\nMain de des : \n");
		int[] array = new int[5];
		YumVsEtud.initialShuflle(array);
		for(int i=0;i<array.length;i++) 
		{
		
		System.out.print(array[i]);
			
		}
		

	}
	@Test
	void test_Reshuffle() {  //Test unitaire  pour la  procedure de relancer les dés  @Youcef mekki daouadji

		System.out.print("Nouvelle main de des : \n ");
		int[] array = {1,5,6,1,5};
		YumVsEtud.reshuffleDice(array,"234");
		
		for(int i=0;i<array.length;i++) 
		{
		
		System.out.print(array[i]);
			
		}
		
	}
	

	@Test 
	void test_Inputdes() //Test unitaire pour s'assurer que le joueur peut entrer les dés à relancer  @Youcef mekki daouadji
	{
		 String Input = "123"; 
		 assertEquals(Input,YumVsEtud.inputDesARouler());

	}
	
	
	@Test 
	void Test_ajoutdespoints()  // Test unitaire pour ajouter les points dans une grille de choix  @Youcef mekki daouadji
	{
		int[] grille = new int[7];
		int[] des = {1,2,4,4,5};
		int [] resultat = {0,1,2,0,8,5,0};
		assertArrayEquals(resultat, YumVsEtud.additionDesPoints(des,grille) );  //devrai afficher 1=1, 2=2, 4=8,5=5 

	}
	
		 
		@Test 
		void Test_Affichagegrille()  
		{ 
			int array[] ={1,1,2,2,4}; 
			int[] grille = new int[7];
			YumVsEtud.additionDesPoints(array,grille); 
		} 
		 
		@Test 
		void Test_TrouverMainePleine()// Test unitaire pour trouver la maine pleine  @Antoine Bolduc  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverMainPleine(array); 
		} 
		 
		@Test 
		void Test_TrouverYum()// Test unitaire pour trouver le yum  @Antoine Bolduc  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverYum(array); 
		} 
		 
		@Test 
		void Test_TrouverSurplus()// Test unitaire pour touver le surplus  @Antoine Bolduc  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverSurplus(array); 
		} 
		 
		@Test 
		void Test_TrouverLongueSequence()// Test unitaire pour touver la longue séquence  @Antoine Bolduc  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverLongueSequence(array); 
		} 
		 
		@Test 
		void Test_TrouverCourteSequence()// Test unitaire pour touver le courte séquence  @Antoine Bolduc  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverCourteSequence(array); 
		} 
		 
		@Test 
		void Test_TrouverCarre()// Test unitaire pour touver le carre  @Antoine Bolduc  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverCarre(array); 
		} 
		 
		@Test 
		void Test_TrouverBerlan()// Test unitaire pour touver le berlan  @Antoine Bolduc  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverBerlan(array); 
		} 
		 
		@Test 
		void Test_RemplirTabOccurrence()// Test unitaire pour remplir la tab occurrence  @Antoine Bolduc  
		{ 
			int array1[] ={1,1,2,2,4}; 
			int array2[] = {0,0,0,0,0,0,0}; 
			int arrayRep[] = {0,2,2,0,1,0,0}; 
			YumVsEtud.remplirTabOccurrence(array1,array2); 
			assertArrayEquals(array2,arrayRep); 
			 
		} 
		
		// test unitaire pour voir si la grille est bien iniatilise @Rada Leng
		@Test 
	    void Test_initialisePointGrille() { 
		int array[] = {-1,-1,-1,-1,-1,-1,-1,0,0,0,-1,-1,-1,-1,-1,-1,-1,0,0}; 
		int array2[] = new int[19]; 
		YumVsEtud.initialisePointGrille(array2); 
		assertArrayEquals(array2,array); 
	} 
	

}
