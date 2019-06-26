package java8Feature.com.ramesh.java8.streamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertListToMap {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<>();
		List<Person> personList = new ArrayList<>();

		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f, "Faulty"));
		productsList.add(new Product(2, "Dell Laptop", 30000f, "New"));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f, "New"));
		productsList.add(new Product(4, "Sony Laptop", 28000f, "Faulty"));
		productsList.add(new Product(5, "Apple Laptop", 90000f, "New"));

		personList.add(new Person("Shahzad", "Hussain", 27, Gender.MALE));
		personList.add(new Person("Ejaz", "Hussain", 25, Gender.MALE));
		personList.add(new Person("Sahil", "Hussain", 20, Gender.MALE));
		personList.add(new Person("abc", "hh", 27, Gender.FEMALE));
		personList.add(new Person("xyz", "yy", 25, Gender.FEMALE));

		listToMap(productsList);
		iterateMap(productsList);

		groping(personList);

		getMapping(personList);

	}

	private static void groping(List<Person> productsList) {
		Map<Gender, Integer> collect = productsList.stream().collect(
				Collectors.groupingBy(Person::getGender, Collectors.reducing(0, Person::getAge, Integer::sum)));
		System.out.println("[GENDER]" + collect);
	}

	private static void getMapping(List<Person> productsList) {
		Map<Gender, List<String>> collect = productsList.stream().collect(Collectors.groupingBy(Person::getGender,
				Collectors.mapping(Person::getFirstName, Collectors.toList())));
		System.out.println("[FIRSTNAME]" + collect);
	}

	private static void listToMap(List<Product> productsList) {
		// Converting Product List into a Map
		Map<Integer, String> productPriceMap = productsList.stream()
				.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
		System.out.println(productPriceMap);
	}

	private static void iterateMap(List<Product> productsList) {
		Map<String, Long> collect = productsList.stream()
				.collect(Collectors.groupingBy(Product::getType, Collectors.counting()));

		long faultyCount = 0;
		long newCount = 0;
		Set<Entry<String, Long>> entrySet = collect.entrySet();
		for (Entry<String, Long> entry : entrySet) {
			if ("Faulty".equals(entry.getKey())) {
				faultyCount = entry.getValue();
			} else if ("New".equals(entry.getKey())) {
				newCount = entry.getValue();
			}
		}
		System.out.println("Total New Item =>" + newCount + " and Fault =>" + faultyCount);

	}
}
