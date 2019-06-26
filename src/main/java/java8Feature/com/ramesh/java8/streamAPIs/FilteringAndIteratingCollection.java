package java8Feature.com.ramesh.java8.streamAPIs;

import java.util.ArrayList;
import java.util.List;

public class FilteringAndIteratingCollection {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f, "Faulty"));
		productsList.add(new Product(2, "Dell Laptop", 30000f, "New"));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f, "New"));
		productsList.add(new Product(4, "Sony Laptop", 28000f, "Faulty"));
		productsList.add(new Product(5, "Apple Laptop", 90000f, "New"));
		// This is more compact approach for filtering data
		productsList.stream().filter(product -> product.getPrice() == 30000)
				.forEach(product -> System.out.println(product.getPrice()));
	}
}
