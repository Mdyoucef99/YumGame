package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestYum {

	@Test
	void Test_Affichagegrille() 
	{
		int array[] ={1,1,2,2,4};
		YumVsEtud.additionDesPoints(array);
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
