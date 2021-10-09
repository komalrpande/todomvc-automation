package com.todomvc.stepdefination;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty","html:target/cucumber-reports/report.html"},
        publish=true,
        glue="com.todomvc.stepdefination",
        features="src/test/resources/features/",
        tags="@testpack",
        monochrome=true
)
public class RuncukeTest {

}
