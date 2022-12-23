package com.practice1;


import org.testng.annotations.Test;

public class Apsrtc_BusApp extends Insert_drivers{
    @Test
	public void first_Class() throws InterruptedException {
		Apsrtc_BusApp apsrtc=new Apsrtc_BusApp();
		apsrtc.select_driver("chrome");
		apsrtc.enter_Url("https://apsrtconline.in/oprs-web/guest/home.do?h=1");
				
						
	}
}	
	
	

