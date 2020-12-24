package java8Feature.com.java8.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceInStream {
	public static void main(String[] args) {

		List<Product> productsList = new ArrayList<Product>();

		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f, "Faulty"));
		productsList.add(new Product(2, "Dell Laptop", 30000f, "New"));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f, "New"));
		productsList.add(new Product(4, "Sony Laptop", 28000f, "Faulty"));
		productsList.add(new Product(5, "Apple Laptop", 90000f, "New"));

		List<Float> productPriceList = productsList.stream().filter(p -> p.getPrice() > 30000)// filtering data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList);
	}
}
