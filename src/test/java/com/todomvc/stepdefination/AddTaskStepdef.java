package com.todomvc.stepdefination;

import com.todomvc.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Map;


public class AddTaskStepdef extends CommonSteps {

    WebDriver driver = Hooks.driver;

    @Given("^ToDoMVC application is launched$")
    public void checkIfTodomvcAppLaunched() {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        Assert.assertTrue("TodoMVC application is launched successfully",
                todomvcPage.checkIfTodosIsDisplayed());

    }

    @When("^Add To do \"([^\"]*)\"$")
    public void addToDoTask(String task) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        todomvcPage.enterWhatNeedsToBeDone(task);
    }

    @Then("^Validate that the \"([^\"]*)\" is added successfully$")
    public void checkIfTaskIsAddedSuccessfully(String task) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        Assert.assertEquals(true, todomvcPage.checkIftaskaddedsuccessfully(task));

    }

    @When("Add Multiple Tasks")
    public void addMultipleTask(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");
            todomvcPage.enterWhatNeedsToBeDone(taskName);
        }

    }

    @Then("Validate that multiple tasks are added successfully")
    public void validateThatMultipleTasksAreAddedSuccessfully(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");
            Assert.assertEquals(true, todomvcPage.checkIftaskaddedsuccessfully(taskName));
        }

    }
}
