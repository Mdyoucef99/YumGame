package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YumTest {

	@Test // Test unit pour initilashuffle procedure @Youcef mekki daouadji
	void test_InitialShuffle() {

		
		System.out.print("\nMain de des : \n");
		int[] array = new int[5];
		YumVsEtud.InitialShuflle(array);
		for(int i=0;i<array.length;i++) 
		{
		
		System.out.print(array[i]);
			
		}
		

	}
	
	@Test
	void test_Reshuffle() {  //Test unitaire  pour la   procedure de relancer les des  @Youcef mekki daouadji

		System.out.print("Nouvelle main de des : \n ");
		int[] array = {1,2,3,4,5};
		YumVsEtud.ReshuffleDice(array,"235");
		
		for(int i=0;i<array.length;i++) 
		{
		
		System.out.print(array[i]);
			
		}
		
	}
	

	@Test 
	void test_Inputdes() //Test unitaire pour s'assurer que le joueur peut entrer les des a relancer
	{
		
		 String Input = "123"; 
		 assertEquals(Input,YumVsEtud.InputDesARouler());

	}
	
	
	@Test 
	void Test_ajoutdespoints()  // Test unitaire pour ajouter les points dans une grille et les afficher
	{
		int[] grille = new int[7];
		int[] des = {1,2,4,4,5};
		
		YumVsEtud.Additiondelespoints(des,grille); 
		ModAffichage.afficherGrillePossibilite(grille); //devrai afficher 1=1, 2=2, 4=8,5=5
		
		
		
	}
	
	
	
	
	
	
	

}
