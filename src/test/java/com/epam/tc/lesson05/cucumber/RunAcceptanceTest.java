package com.epam.tc.lesson05.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:/com/epam/tc/lesson05/features/"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
