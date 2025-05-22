package com.petsgolden.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features/api", 
  glue = {"com.petsgolden.automation.api"},
  plugin = {"pretty", "html:target/api-reports.html"}
)
public class APITest {}
