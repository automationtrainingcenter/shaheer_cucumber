package com.banking.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/features" }, glue = {
		"stepdefinitions" }, dryRun = true, monochrome = true)
public class TestRunner {

}
