package com.todomvc.stepdefination;

import com.todomvc.pages.TodomvcPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class RemoveTaskStepdef extends CommonSteps {

    WebDriver driver = Hooks.driver;

    @And("Remove active \"([^\"]*)\"$")
    public void removeActiveTask(String task) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        todomvcPage.removeTaskFromTaskList(task);
    }

    @And("Remove Completed \"([^\"]*)\"$")
    public void removeCompletedTask(String task) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        todomvcPage.removeTaskFromTaskList(task);
    }

    @Then("^Validate that the \"([^\"]*)\" is removed successfully$")
    public void checkIfTaskIsRemovedSuccessfully(String task) {

        todomvcPage = PageFactory.initElements(driver, TodomvcPage.class);

        Assert.assertEquals(false, todomvcPage.checkIftaskaddedsuccessfully(task));

    }

}
