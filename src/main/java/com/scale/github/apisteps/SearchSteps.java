package com.scale.github.apisteps;


import org.junit.Assert;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchSteps extends ScenarioSteps {
	
// the end point can be configured using properties file, I haven't configured it yet.
	   private String GITHUB_EP = "https://api.github.com/";
	   private String SEARCH_PATH="search/users";
	   private Response response;
	   

	   @Step
	   public void searchUsersWithFilters(String user, String repo, String followers) throws IOException{
		   String target_uri = GITHUB_EP + SEARCH_PATH;
		   System.out.println(target_uri);

           
	       response = SerenityRest.given().with().queryParam("q","sam" + " followers:>"+followers + " repos:>"+repo).
	    		   get(target_uri);
	       
/* For muliple path parameters use maps
 * 		   Map<String, Object> dataset_1 = new HashMap<String, Object>();
           dataset_1.put("q", user);
           dataset_1.put("repo", repo);
           dataset_1.put("followers", followers);	     
 */
	   }
	   
	   @Step
	   public void searchUsersWithTwoFilters(String user, String repo, String followers) throws IOException{
		   String target_uri = GITHUB_EP + SEARCH_PATH;
		   System.out.println(target_uri);

           
	       response = SerenityRest.given().with().queryParam("q","sam" + " followers:>"+followers + " repos:>"+repo).
	    		   get(target_uri);
	   }
	   
	   @Step
	   public void verifySearchIsExecutedSuccesfully(){
	       response.then().statusCode(200);
	   }
	   
	   @Step
	   @Pending
	   public void verifyResultsFilteredCorrectly(String user){
		   List<String> allItems=response.then().extract().body().jsonPath().get("items");
		   
		   System.out.println(allItems);
	   }
	     

	   @Step
	   public void verifyTotalCountAndResultBoolean(int expCount){
		
	       response.then().body("total_count", is(expCount));
	       response.then().body("incomplete_results",is(false)); 
	   }
	   
	   @Step
	   public void verifyCountinItemsWithTotalCount() {
		   List<String> allItems=response.then().extract().body().jsonPath().get("items");
		   int total_count=response.then().extract().body().jsonPath().get("total_count");
		   assertEquals(allItems.size(), total_count);
	   }

	

}
