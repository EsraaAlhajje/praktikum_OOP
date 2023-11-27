package fabrikMethode;

import java.io.IOException;

public class ConcreteCsvCreator  extends Creator{

	@Override
	public Product factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteCsvProduct()  ;
	}

}