package com.scale.github.apitests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class SampleTest{
	
	// Web Driver can be override from CLI using -D webdriver.driver="<driver>"
	@Managed
	WebDriver driver;
	
	
	@Test
	@Title("Test001 - Sample Test ")
	public void sampleTest(){
		System.out.println("test");

	}
}
