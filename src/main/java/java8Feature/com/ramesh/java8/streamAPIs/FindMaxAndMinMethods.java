package java8Feature.com.ramesh.java8.streamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class FindMaxAndMinMethods {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f, "Faulty"));
		productsList.add(new Product(2, "Dell Laptop", 30000f, "New"));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f, "New"));
		productsList.add(new Product(4, "Sony Laptop", 28000f, "Faulty"));
		productsList.add(new Product(5, "Apple Laptop", 90000f, "New"));

		OptionalDouble max = productsList.stream().mapToDouble(o -> o.getPrice()).max();
		System.out.println(max.getAsDouble());

		// max() method to get max Product price
		Product productA = productsList.stream()
				.max((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1).get();

		System.out.println(productA.getPrice());
		// min() method to get min Product price
		Product productB = productsList.stream()
				.max((product1, product2) -> product1.getPrice() < product2.getPrice() ? 1 : -1).get();
		System.out.println(productB.getPrice());
	}
}
