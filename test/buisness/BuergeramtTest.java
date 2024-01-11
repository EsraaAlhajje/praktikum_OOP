package buisness;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Buergeramt;

public class BuergeramtTest {
	
	
	private Buergeramt buergeramt;
	

	@BeforeEach
	
	 void ausfuellen() throws Exception {
        buergeramt = new Buergeramt("Bürgerbüro", 9.00f, 17.00f, "Querenburg Höhhe 256", new String[]{"Hauptwohnsitz", "Nebenwohnsitz"});
    }
	
	@Test
    void TextBuergeramt() {
    	assertTrue(()->this.buergeramt.getGeoeffnetVon()==9.00f);
    	
    	
	}
}
