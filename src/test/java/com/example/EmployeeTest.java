package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
	Employee employee = new Employee("1", 123);
	@Test
	void createEmployee() {
		assertEquals("1", employee.getId());
		assertEquals(123, employee.getSalary());
	}


}