package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YumTest {

	@Test // Test unit pour initial shuffle procedure @Youcef mekki daouadji
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
	void test_Reshuffle() {  //Test unitaire  pour la   procedure de relancer les d�s  @Youcef mekki daouadji

		System.out.print("Nouvelle main de des : \n ");
		int[] array = {1,5,6,1,5};
		YumVsEtud.reshuffleDice(array,"234");
		
		for(int i=0;i<array.length;i++) 
		{
		
		System.out.print(array[i]);
			
		}
		
	}
	

	@Test 
	void test_Inputdes() //Test unitaire pour s'assurer que le joueur peut entrer les des a relancer  @Youcef mekki daouadji
	{
		 String Input = "123"; 
		 assertEquals(Input,YumVsEtud.inputDesARouler());

	}
	
	
	@Test 
	void Test_ajoutdespoints()  // Test unitaire pour ajouter les points dans une grille et les afficher  @Youcef mekki daouadji
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
		void Test_TrouverMainePleine()  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverMainPleine(array); 
		} 
		 
		@Test 
		void Test_TrouverYum()  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverYum(array); 
		} 
		 
		@Test 
		void Test_TrouverSurplus()  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverSurplus(array); 
		} 
		 
		@Test 
		void Test_TrouverLongueSequence()  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverLongueSequence(array); 
		} 
		 
		@Test 
		void Test_TrouverCourteSequence()  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverCourteSequence(array); 
		} 
		 
		@Test 
		void Test_TrouverCarre()  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverCarre(array); 
		} 
		 
		@Test 
		void Test_TrouverBerlan()  
		{ 
			int array[] ={1,1,2,2,4}; 
			YumVsEtud.trouverBerlan(array); 
		} 
		 
		@Test 
		void Test_RemplirTabOccurrence()  
		{ 
			int array1[] ={1,1,2,2,4}; 
			int array2[] = {0,0,0,0,0,0,0}; 
			int arrayRep[] = {0,2,2,0,1,0,0}; 
			YumVsEtud.remplirTabOccurrence(array1,array2); 
			assertArrayEquals(array2,arrayRep); 
			 
		} 
		
		
		@Test 
	void Test_initialisePointGrille() { 
		int array[] = {-1,-1,-1,-1,-1,-1,-1,0,0,0,-1,-1,-1,-1,-1,-1,-1,0,0}; 
		int array2[] = new int[19]; 
		YumVsEtud.initialisePointGrille(array2); 
		assertArrayEquals(array2,array); 
	} 
	

}
