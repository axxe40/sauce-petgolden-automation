package com.petsgolden.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features/web",
  glue = {"com.petsgolden.automation.ui"},
  plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class UITest {}
