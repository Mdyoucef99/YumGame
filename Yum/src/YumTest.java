package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YumTest {

	@Test // Test unit pour initilashuffle procedure @Youcef mekki daouadji
	void test_InitialShuffle() {

		int[] array = new int[5];
		YumVsEtud.InitialShuflle(array);
		for(int i=0;i<array.length;i++) 
		{
		System.out.println(array[i]);
			
		}

	}
	

}
