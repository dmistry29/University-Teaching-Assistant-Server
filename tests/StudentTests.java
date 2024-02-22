package tests;

import org.junit.*;

import taPayrollManagerSystem.ADifferentialCourse;
import taPayrollManagerSystem.ARegularCourse;
import taPayrollManagerSystem.LarryList;
import taPayrollManagerSystem.SomeUniversity;

import static org.junit.Assert.*;

public class StudentTests {
	
	//Test to show that you can't create a course with a courseNumber under 100
	@Test 
	public void test1 () {
		assertEquals(null, SomeUniversity.createARegularCourse("CMSC", 35, 10));
	}
	
	//Test to show that you can't create a course with a blank department name
	@Test
	public void test2 () {
		assertEquals(null, SomeUniversity.createADifferentialCourse("", 140, 5));
	}

	//Test to show that if a 0 capacity is passed into a LarryList constructor, 
	//a list of size 1 is created
	@Test
	public void test3 () {
		LarryList list = new LarryList(0);
		assertEquals(1, list.getCurrCapacityAmt());
	}
	
	//Test to show you can't add a null element to LarryList and that you can't
	//add an element to LarryList if it is full
	@Test
	public void test4 () {
		LarryList list = new LarryList(1);
		list.add("Element");
		assertFalse(list.add(null));
		assertFalse(list.add("Another Element"));
	}
	
	//Test to show that you can replace an element in LarryList, however, you need
	//a valid position, meaning there needs to be an element at the given pos.
	@Test
	public void test5 () {
		LarryList list = new LarryList(8);
		list.add("First Element");
		list.add("Second Element");
		assertTrue (list.set(1, "Replacement Element"));
		assertFalse (list.set(5, "New Element"));
	}
	
	//Test checking the methods that deal with the availability of space in
	//LarryList.
	@Test
	public void test6 () {
		LarryList list = new LarryList(2);
		assertEquals(2, list.getCurrCapacityAmt());
		list.resize();
		assertEquals(4, list.getCurrCapacityAmt());
		assertFalse(list.isFull());
		list.add("Bird");
		list.add(1995);
		assertEquals(2, list.numCanBeAdded());
		list.add(false);
		list.add("End");
		assertTrue(list.isFull());
	}
	
	//Test to show that you can't get() an object at the pos if there isn't an
	//object at that position in the LarryList.
	@Test
	public void test7 () {
		LarryList list = new LarryList(10);
		list.add("Animal");
		assertEquals(null, list.get(5));
	}	
	
	//Test to show that you can't add a TA with negative or 0 salary amount or
	//an invalid name in any way.
	@Test
	public void test8 () {
		ARegularCourse English = new ARegularCourse("ENGL", 101, 5);
		ADifferentialCourse CS = new ADifferentialCourse("CMSC", 132, 10);
		assertFalse(English.addGradTA("Max", "Smith", 0));
		assertFalse(CS.addUGTA("Lucy", "Matthew", -5));
		assertFalse(English.addUGTA("", "Tan", 15));
		assertFalse(CS.addGradTA("Adam", null, 21000));
	}
	
	//Test to show that a TA can't hold 0 or negative office hours and to get a
	//TA's office hours, a valid name must be provided that matches a TA in TAList
	@Test
	public void test9 () {
		ARegularCourse English = new ARegularCourse("ENGL", 350, 10);
		ADifferentialCourse CS = new ADifferentialCourse("CMSC", 216, 15);
		English.addGradTA("Ashley", "Smith", 17000);
		CS.addUGTA("Samuel", "Birru", 15);
		CS.addGradTA("Sam", "Wachs", 11000);
		English.addUGTA("Om", "Desai", 14);
		assertFalse(English.holdSomeOfficeHours("Om", "Desai", -4));
		assertFalse(CS.holdSomeOfficeHours("Samuel", "Birru", 0));
		English.holdSomeOfficeHours("Ashley", "Smith", 10);
		CS.holdSomeOfficeHours("Sam", "Wachs", 15);
		assertEquals(-1, CS.numOfficeHoursHeld("John", "Don"));
		assertEquals(10, English.numOfficeHoursHeld("Ashley", "Smith"));
	}
	
	//Test to show that undergrad TAs can't work more than 20 hours and grad TAs
	//can't grade more than 150 projects.
	@Test
	public void test10() {
		ADifferentialCourse CS = new ADifferentialCourse("CMSC", 420, 10);
		CS.addGradTA("John", "Smart", 15000);
		CS.addUGTA("Tom", "Mitchell", 14);
		CS.gradeProjects("John", "Smart", 145);
		CS.holdSomeOfficeHours("Tom", "Mitchell", 16);
		assertEquals(145, CS.numProjectsGraded("John", "Smart"));
		assertEquals(0, CS.numProjectsGraded("Tom", "Mitchell"));
		assertFalse(CS.gradeProjects("John", "Smart", 10));
		assertFalse(CS.gradeProjects("Tom", "Mitchell", 10));
	}
	
	//Test to show that a differential course can have more than the allotted
	//limit of TAs assigned at the time of the creation of the course, but you
	//can't do it for a regular course.
	@Test
	public void test11 () {
		ADifferentialCourse CS = new ADifferentialCourse("CMSC", 475, 2);
		CS.addGradTA("John", "Smith", 18000);
		CS.addUGTA("Bruce", "Wayne", 18);
		assertTrue(CS.addGradTA("Sonam", "Patel", 20000));
		
		ARegularCourse Math = new ADifferentialCourse("MATH", 390, 2);
		CS.addGradTA("John", "Smith", 18000);
		CS.addUGTA("Bruce", "Wayne", 18);
		assertFalse(CS.addGradTA("Sonam", "Patel", 20000));
	}
 }
