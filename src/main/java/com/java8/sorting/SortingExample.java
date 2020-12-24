package com.java8.sorting;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.utils.DateUtil;

public class SortingExample {

	public static void main(String[] args) throws ParseException {

		List<Person> collect = Stream
				.of(new Person(1, "ABC",
						DateUtil.getLocalDateFromDate(DateUtil.parseDate("19-07-2003", DateUtil.DD_MM_YYYY))),
						new Person(2, "XYX",
								DateUtil.getLocalDateFromDate(DateUtil.parseDate("19-07-2002", DateUtil.DD_MM_YYYY))))
				.collect(Collectors.toList());
		System.out.println("Without sorting => " + collect);
		List<Person> collect1 = collect.stream().sorted(Comparator.comparing(Person::getBirthDate))
				.collect(Collectors.toList());
		System.out.println("After sorting[ASC] => " + collect1);

		List<Person> collec2 = collect.stream().sorted(Comparator.comparing(Person::getBirthDate).reversed())
				.collect(Collectors.toList());

		System.out.println("After sorting[DESC] => " + collec2);

		List<Person> collect3 = collect.stream().sorted((s1, s2) -> s2.getBirthDate().compareTo(s1.getBirthDate()))
				.collect(Collectors.toList());
		System.out.println("After sorting[DESC] => " + collect3);
	}
}

class Person implements Serializable {

	private int id;
	private String firstName;
	private LocalDate birthDate;

	public Person() {
	}

	public Person(int id, String firstName, LocalDate birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", birthDate=" + birthDate + "]";
	}

}