package com.Groups;

import org.testng.annotations.Test;

public class Groups_Practice {
	@Test(groups = {"smoke","regression"})
	public void testcase1() {
		System.out.println("testcase-1");
	}
	@Test(groups = {"regression"})
	public void testcase2() {
		System.out.println("testcase-2");
	}
	@Test(groups = {"smoke","regression"})
	public void testcase3() {
		System.out.println("testcase-3");
	}
	@Test(groups = {"sanity"})
	public void testcase4() {
		System.out.println("testcase-4");
	}
	@Test(groups = {"smoke","regression"})
	public void testcase5() {
		System.out.println("testcase-5");
	}
	@Test(groups = {"smoke"})
	public void testcase6() {
		System.out.println("testcase-6");
	}

}
