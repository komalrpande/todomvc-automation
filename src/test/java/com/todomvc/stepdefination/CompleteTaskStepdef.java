package com.todomvc.stepdefination;

import com.todomvc.pages.TodomvcPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class CompleteTaskStepdef extends CommonSteps {

    WebDriver driver = Hooks.driver;

    @And("^Complete active \"([^\"]*)\"$")
    public void completeActiveTask(String task) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        todomvcPage.completeTaskFromList(task);
    }

    @Then("Validate that the tasks are completed successfully")
    public void checkIfTaskCompletedSuccessfully(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");
            Assert.assertEquals(true, todomvcPage.checkIfTaskCompletedsuccessfully(taskName));
        }

    }

    @Then("Validate that the tasks are Active")
    public void checkIfTasksActive(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");
            Assert.assertEquals(true, todomvcPage.checkIftaskaddedsuccessfully(taskName));
        }
    }

    @Then("Validate that all tasks are displayed")
    public void checkIfAllTasksAreDisplayed(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");
            Assert.assertEquals(true, todomvcPage.checkIftaskaddedsuccessfully(taskName));
        }

    }


    @Then("^Validate that the \"([^\"]*)\" \"([^\"]*)\" is updated successfully$")
    public void validateThatTheIsUpdatedSuccessfully(String task, String status) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        if (status.equalsIgnoreCase("Complete")) {
            Assert.assertEquals(true, todomvcPage.checkIfTaskCompletedsuccessfully(task));
        } else if (status.equalsIgnoreCase("Active")) {
            Assert.assertEquals(true, todomvcPage.checkifTaskStatusIsActive(task));
        }
    }

    @And("Clear Completed Tasks")
    public void clearCompletedTasks() {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        todomvcPage.clickOnClearCompletedButton();
    }

    @And("Complete all Tasks")
    public void completeAllTasks() {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        todomvcPage.markAllTaskComplete();

    }

    @And("Complete Multiple Tasks")
    public void completeMultipleTasks(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");

            todomvcPage.completeTaskFromList(taskName);
        }
    }


    @Then("Validate that the Completed tasks are cleared successfully")
    public void validateThatTheCompletedTasksAreClearedSuccessfully(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");
            Assert.assertEquals(false, todomvcPage.checkIftaskaddedsuccessfully(taskName));
        }

    }
}
