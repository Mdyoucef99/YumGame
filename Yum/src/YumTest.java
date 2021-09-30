package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YumTest {

	@Test // Test unit pour initilashuffle procedure @Youcef mekki daouadji
	void test_InitialShuffle() {

		
		System.out.print("\n Main de des : \n");
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
	

	@Test void test_Inputdes() 
	{
		
		 String Input = "123"; 
		 assertEquals(Input,YumVsEtud.InputDesARouler());

	}
	
	
	
	
	
	

}
