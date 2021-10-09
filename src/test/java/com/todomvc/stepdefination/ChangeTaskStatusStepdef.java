package com.todomvc.stepdefination;

import com.todomvc.pages.TodomvcPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChangeTaskStatusStepdef extends CommonSteps {

    WebDriver driver = Hooks.driver;

    @And("Change \"([^\"]*)\" \"([^\"]*)\"$")
    public void changeTaskStatus(String task, String status) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        if (status.equalsIgnoreCase("Complete")) {
            todomvcPage.completeTaskFromList(task);
        } else if (status.equalsIgnoreCase("Active")) {
            todomvcPage.completeTaskFromList(task);
            todomvcPage.completeTaskFromList(task);
        }
    }
}
