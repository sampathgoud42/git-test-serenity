package com.scale.github.apitests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



// This is the only suite I have created, For better Test management we can create multiple suites and configure using Surefire plugin
@RunWith(Suite.class)
@SuiteClasses({ 
	//add all testcases here
	TC01_git_api_search_users_filters.class	
})

public class API_TestSuite {

}
