package com.scale.github.apitests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.scale.github.apisteps.SearchSteps;
import com.scale.github.tools.Features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

//Used empty classes to map features/userstories to test
@Story(Features.API.Search.class)

@RunWith(SerenityRunner.class)
// we can implement data driven tests using the below annotation, I haven't configured this yet
@UseTestDataFrom(value="", separator=',')
public class TC01_git_api_search_users_filters{
	//Test setup and tear down can be implemented for better usage of framework and test data
	@Before
	public void setup() {
		//login and common test data preparation
	}
	
	@After
	public void tearDown() {
      //logout and clean test data
	}
	
// Web Driver can be override from CLI using -D webdriver.driver="<driver>"
	//@Managed
	//WebDriver driver;
	@Steps 
	SearchSteps searchUserSteps;
	
	
//Actual Test starts here	
	@Test
	@Title("Test001 - Github Search users with filter ")
	public void tc01_github_search_users_with_filer() throws IOException{
		//* Test data can be driven from csv files,  need to implement
		searchUserSteps.searchUsersWithFilters("sam", "50", "1000");
		searchUserSteps.verifySearchIsExecutedSuccesfully();
		searchUserSteps.verifyTotalCountAndResultBoolean(8);
		searchUserSteps.verifyCountinItemsWithTotalCount();
		searchUserSteps.verifyResultsFilteredCorrectly("sam");
	}
	
	//We can add more testcases based on documentation https://developer.github.com/v3/search/#search-users
	//Add negative tests with different status codes
	
}
