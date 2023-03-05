package com.testrunner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions
	( 
	  dryRun = true,
	  monochrome = true,
	  features = "./Features//Add_Customer",
	//  tags = "@Sanity_Testing",
	  glue = "./com.stepdefinitions//Add_Customer",
	  plugin = {"pretty", "html:test-output" }
	)

public class TestRunner {

}
