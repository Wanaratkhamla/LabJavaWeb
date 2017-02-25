
import java.util.ArrayList;

public class BeerExpert {
	public ArrayList<String> getBrands(String color) {

		ArrayList<String> brands = new ArrayList<String>();

		if (color.equals("amber")) {
			brands.add("Singha");
			brands.add("Asahi");
		} else {
			brands.add("Carlsberg");
			brands.add("Heineken");
			brands.add("Tiger");
		}
		return brands;
	}

}
