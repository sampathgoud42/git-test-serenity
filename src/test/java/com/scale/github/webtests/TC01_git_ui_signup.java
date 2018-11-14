package com.scale.github.webtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.scale.github.tools.Features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

//Used empty classes to map features/userstories to test
@Story(Features.GUI.Signup.class)

@RunWith(SerenityRunner.class)
// we can implement data driven tests using the below annotation, I haven't
// configured this yet
@UseTestDataFrom(value = "", separator = ',')
public class TC01_git_ui_signup {
	@Managed (driver="chrome")
	WebDriver driver;
	
	// Test setup and tear down can be implemented for better usage of framework and
	@Before
	public void setup() {
		// launch browser and navigate, login etc..

	}

	@After
	public void tearDown() {
		// logout and close browsers
	}

	// Web Driver can be override from CLI using -D webdriver.driver="<driver>"


	@Test
	@Pending
	@Title("Test02 - Github Signup")
	public void tc01_git_ui_signup() {


	}
}
