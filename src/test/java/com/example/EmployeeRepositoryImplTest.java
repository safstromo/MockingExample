package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest {

	EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(List.of
			(new Employee("1", 123), new Employee("2", 12345)));

	@Test
	void findAll() {
		var result1 = employeeRepository.findAll().get(0);
		var result2 = employeeRepository.findAll().get(1);

		assertEquals("1", result1.getId());
		assertEquals(12345,  result2.getSalary());
	}

	@Test
	void save() {
		Employee employee = new Employee("3", 31);
		employeeRepository.save(employee);

		assertEquals(employee, employeeRepository.findAll().get(2));

	}

	@Test
	void clearDatabase() {
		employeeRepository.ClearDatabase();

		assertEquals(0 , employeeRepository.findAll().size());

	}
}