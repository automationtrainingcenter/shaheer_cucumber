package com.banking.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/features/role.feature" }, glue = {
		"stepdefinitions" }, 
		dryRun = false, 
		monochrome = true,
		plugin = {"pretty", "html:target/report", "json:/target/json"})
public class TestRunner {

}
