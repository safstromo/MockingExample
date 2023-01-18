package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
	Employee employee = new Employee("1", 123);
	@Test
	void employeeToString() {
		assertEquals("Employee [id=1, salary=123.0]", employee.toString());

	}
	@Test
	void isNotPaid() {
		assertFalse(employee.isPaid());

	}

	@Test
	void isPaid() {
		employee.setPaid(true);
		assertTrue(employee.isPaid());

	}

	@Test
	void changeEmployeeId() {
		employee.setId("2");
		assertEquals("2", employee.getId());
	}

	@Test
	void changeEmployeeSalary() {
		employee.setSalary(1234);
		assertEquals(1234, employee.getSalary());

	}


}