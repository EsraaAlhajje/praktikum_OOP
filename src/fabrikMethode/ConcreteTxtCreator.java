package fabrikMethode;

import java.io.IOException;

import fabrikMethode.ConcreteTxtProduct;
import fabrikMethode.Creator;
import fabrikMethode.Product;

public class ConcreteTxtCreator extends Creator {

	@Override
	public Product factoryMethod() throws IOException {
		return new ConcreteTxtProduct()  ;
	}

}