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


public class ViewTaskListStepdef extends CommonSteps {

    WebDriver driver = Hooks.driver;
    public int noOfItemsLeft;

    @And("Go To List")
    public void gotoList(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("List");
            todomvcPage.clickListOption(taskName);
        }
    }

    @And("Check the number of items left")
    public void checkTheNumberOfItemsLeft() {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        noOfItemsLeft = Integer.parseInt(todomvcPage.getNoOfItemsLeft());

    }

    @And("Remove active Task")
    public void removeActiveTask(DataTable dataTable) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);
        List<Map<String, String>> test = dataTable.asMaps();

        for (Map<String, String> form : test) {
            String taskName = form.get("TaskName");
            todomvcPage.removeTask(taskName);
        }
    }

    @Then("Validate that the number of items left is updated after removing task")
    public void validateThatTheNumberOfItemsLeftIsUpdated() {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        int updatedToDoCount = Integer.parseInt(todomvcPage.getNoOfItemsLeft());
        Assert.assertTrue(updatedToDoCount + 1 == noOfItemsLeft);

    }

    @Then("Validate that the number of items left is updated after adding task")
    public void validateThatTheNumberOfItemsLeftIsUpdatedAfterAddingTask() {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        int updatedToDoCount = Integer.parseInt(todomvcPage.getNoOfItemsLeft());
        Assert.assertTrue(updatedToDoCount - 1 == noOfItemsLeft);

    }
}
