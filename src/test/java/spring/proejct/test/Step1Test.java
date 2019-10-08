package spring.proejct.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Step1Test {
	
	int a = 5;
	int b = 7;
	
	Step1 s1 = new Step1();
	
	String name = "";
	
	@Before
	public void step_1() {
		System.out.println("before");
	}
	
	@After
	public void step_2() {
		System.out.println("after: " + name);
		System.out.println(s1.t);
	}
	
	@Test
	public void test1() {
		System.out.println("test1()");
		name = "test1";
		assertEquals(true, s1.sum(a, b));
	}
	
	@Test
	public void test2() {
		System.out.println("test2()");
		name = "test2";
		assertEquals((a + b), s1.t);
	}

}
