package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestYum {

	@Test
	void Test_countDuplicates() 
	{
		int array[] ={1,1,2,2,4};
		assertEquals(2,YumVsEtud.CountDuplicates(array));
		
	}
	
	@Test
	void Test_Affichagegrille() 
	{
		int array[] ={1,1,2,2,4};
		YumVsEtud.Additiondelespoints(array);
		
	}
	
	

}
