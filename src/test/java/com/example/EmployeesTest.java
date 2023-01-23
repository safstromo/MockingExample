package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class EmployeesTest {
	EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(List.of
			(new Employee("1", 123), new Employee("2", 12345)));
	BankService bankService = Mockito.mock(BankService.class);
	Employees employees = new Employees(employeeRepository, bankService);


	@Test
	void payEmployeesPaymentIncrease() {
		assertEquals(2, employees.payEmployees());
	}

	@Test
	void employeePaid() {
		employees.payEmployees();

		assertTrue(employeeRepository.findAll().get(0).isPaid());
	}

	@Test
	void payEmployeeNotPaid() {
		doThrow(RuntimeException.class).when(bankService).pay("1", 123);
		employees.payEmployees();

		assertFalse(employeeRepository.findAll().get(0).isPaid());

	}

}