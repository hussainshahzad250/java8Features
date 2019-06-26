/*************************************************************************
* 
* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
* __________________
* 
*  [2018] SATIN CREDITCARE NETWORK LIMITED
*  All Rights Reserved.
* 
* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
* is obtained from SATIN CREDITCARE NETWORK LIMITED.
*/
package java8Feature.collector;

import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class CollectorsExample {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		Double sumPrices = productsList.stream().collect(Collectors.summingDouble(x -> x.price)); // collecting as list
		System.out.println("Sum of prices: " + sumPrices);
		Integer sumId = productsList.stream().collect(Collectors.summingInt(x -> x.id));
		System.out.println("Sum of id's: " + sumId);

		Double average = productsList.stream().collect(Collectors.averagingDouble(p -> p.price));
		System.out.println("Average price is: " + average);

		Long noOfElements = productsList.stream().collect(Collectors.counting());
		System.out.println("Total elements : " + noOfElements);
	}
}