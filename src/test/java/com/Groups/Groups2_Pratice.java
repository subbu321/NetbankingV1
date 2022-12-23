package com.Groups;

import org.testng.annotations.Test;

public class Groups2_Pratice {
	@Test(dependsOnMethods = "testcase9")
	public void testcase7() {
		System.out.println("testcase-7");
	}
	@Test
	public void testcase8() {
		System.out.println("testcase-8");
	}
	@Test(dependsOnMethods = "testcase11")
	public void testcase9() {
		System.out.println("testcase-9");
	}
	@Test
	public void testcase10() {
		System.out.println("testcase-10");
	}
	@Test(dependsOnMethods = "testcase12")
	public void testcase11() {
		System.out.println("testcase-11");
	}
	@Test
	public void testcase12() {
		System.out.println("testcase-12");
	}
}
