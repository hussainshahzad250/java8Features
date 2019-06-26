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
package java8Feature.optionalapi;

import java.util.Optional;

public class Optionalapi {

	public static void main(String[] args) {
		isPresentOptionalAPI();
		createEmptyOptionalObject();
		createEmptyOptionalObjectWithStaticAPI();
		ifPresentOptionalAPI();
		orElseOptionalAPI();
		orElseOptionalAPI();
		orElseGetOptionalAPI();
		orElseThrowOptionalAPI();
		getOptionalAPI();
	}

	// Returns an Optional with the specified present non-null value.
	private static void isPresentOptionalAPI() {
		Optional<String> opt = Optional.of("Ramesh");
		System.out.println(opt.isPresent());
	}

	// Returns an Optional with the specified present non-null value.
	private static void createEmptyOptionalObject() {
		Optional<String> empty = Optional.empty();
		System.out.println(empty.isPresent());

		// Optional object with the static of API:
		String name = "Ramesh";
		Optional.of(name);
	}

	private static void createEmptyOptionalObjectWithStaticAPI() {
		String name = "baeldung";
		Optional.of(name);
	}

	// If a value is present, invoke the specified consumer with the value,
	// otherwise do
	// nothing.
	private static void ifPresentOptionalAPI() {
		// The ifPresent API enables us to run some code on the wrapped value if it is
		// found to be non-null.
		// Before Optional, we would do something like this:
		String name = "Ramesh";
		if (name != null) {
			System.out.println(name.length());
		}

		Optional<String> opt = Optional.of("Ramesh");
		opt.ifPresent(str -> System.out.println(str.length()));
	}

	// If a value is present, invoke the specified consumer with the value,
	// otherwise do
	// nothing.
	private static void orElseOptionalAPI() {
		// With orElse, the wrapped value is returned if it is present and the argument
		// given to
		// orElse is returned if the wrapped value is absent
		String nullName = null;

		// If a value is present, invoke the specified consumer with the value,
		// otherwise
		// do nothing.
		//
		String name = Optional.ofNullable(nullName).orElse("Ramesh");
		System.out.println(name);
	}

	// Return the value if present, otherwise invoke other and return the result of
	// that
	// invocation.
	private static void orElseGetOptionalAPI() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseGet(() -> "Ramesh");
		System.out.println(name);
	}

	// Return the contained value, if present, otherwise throw an exception to be
	// created
	// by the provided supplier.
	private static void orElseThrowOptionalAPI() {

		// This will throw exception
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
		System.out.println(name);
	}

	// If a value is present in this Optional, returns the value, otherwise throws
	// NoSuchElementException
	private static void getOptionalAPI() {
		Optional<String> opt = Optional.of("Ramesh");
		String name = opt.get();
		System.out.println(name);
	}

}
