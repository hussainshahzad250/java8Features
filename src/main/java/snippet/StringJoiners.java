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
/**
 * 
 */
package snippet;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shahzad.hussain
 *
 */
public class StringJoiners {

	public static void main(String[] args) {

		stringjoiner();
		findMinMax();

		comparing();

		findMinMaxFromString();
		findMinMaxFromNumber();
		findMinMaxFromDate();

	}

	private static void findMinMaxFromDate() {
		LocalDate start = LocalDate.now();
		LocalDate lastDate = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		LocalDate firstDate = LocalDate.now().plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("start = " + start);
		System.out.println("end = " + lastDate);
		System.out.println("firstDate = " + firstDate);

		// Create stream of dates
		List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
				.limit(ChronoUnit.DAYS.between(start, lastDate)).collect(Collectors.toList());

		// Get Min or Max Date
		LocalDate maxDate = dates.stream().max(Comparator.comparing(LocalDate::toEpochDay)).get();

		LocalDate minDate = dates.stream().min(Comparator.comparing(LocalDate::toEpochDay)).get();

		System.out.println("maxDate = " + maxDate);
		System.out.println("minDate = " + minDate);
	}

	private static void findMinMaxFromNumber() {
		// Get Min or Max Number
		Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).max(Comparator.comparing(Integer::valueOf)).get();

		Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).min(Comparator.comparing(Integer::valueOf)).get();

		System.out.println("maxNumber = " + maxNumber);
		System.out.println("minNumber = " + minNumber);
	}

	private static void findMinMaxFromString() {
		// Get Min or Max String/Char
		String maxChar = Stream.of("H", "T", "D", "I", "J").max(Comparator.comparing(String::valueOf)).get();

		String minChar = Stream.of("H", "T", "D", "I", "J").min(Comparator.comparing(String::valueOf)).get();

		System.out.println("maxChar = " + maxChar);
		System.out.println("minChar = " + minChar);
	}

	private static void comparing() {
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1, "Lokesh", 36));
		employees.add(new Employee(2, "Alex", 46));
		employees.add(new Employee(3, "Brian", 52));
		employees.add(new Employee(4, "Subham", 25));

		Comparator<Employee> comparator = Comparator.comparing(Employee::getAge);

		// Get Min or Max Object
		Employee minObject = employees.stream().min(comparator).get();
		Employee maxObject = employees.stream().max(comparator).get();
		Employee as = employees.stream().max(Comparator.comparing(o -> o.getAge())).get();
		System.out.println(as);

		System.out.println("minObject = " + minObject);
		System.out.println("maxObject = " + maxObject);

		employees.sort(Comparator.comparing(Employee::getAge).reversed());
		System.out.println("[employees] " + employees);
	}

	private static void findMinMax() {
		List<Integer> list = Arrays.asList(1, 3, 4, 5, 2, 8, 9, 3, 6, 10, 23, 2, 5);
		Optional<Integer> value = list.stream().sorted(Collections.reverseOrder()).limit(2).findFirst();
		Optional<Integer> value1 = list.stream().sorted(Collections.reverseOrder()).limit(2).skip(1).findFirst();
		System.out.println(value);
		System.out.println(value1);

	}

	private static void stringjoiner() {
		StringJoiner joinNames = new StringJoiner(",", "[", "]");
		joinNames.add("Rahul");
		joinNames.add("Raju");
		joinNames.add("Peter");
		joinNames.add("Raheem");
		System.out.println(joinNames);
	}
}
