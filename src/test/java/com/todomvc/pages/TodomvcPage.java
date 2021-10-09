package com.todomvc.pages;

import com.todomvc.commonutils.CommonLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodomvcPage extends CommonLibrary {

    private WebDriver driver;
    private WebElement element;

    @FindBy(xpath = ".//h1[contains(.,'todos')]")
    private WebElement todosLogo;

    @FindBy(xpath = "//header/input")
    private WebElement ibWhatneedstobeddone;

    @FindBy(xpath = "//section[@class='main']/label")
    private WebElement markAllComplete;

    @FindBy(xpath = "//section[@class='main']/label")
    private WebElement removetask;

    @FindBy(xpath = "//section/footer/span/strong")
    private WebElement noOfItemsLeft;

    public TodomvcPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    /**
     * check if todos logo is displayed
     */
    public Boolean checkIfTodosIsDisplayed() {

        Boolean result;
        result = todosLogo.isDisplayed();
        return result;

    }

    /**
     * Enter what needs to be done
     */
    public void enterWhatNeedsToBeDone(String ipWhatNeedsToBeDone) {

        ibWhatneedstobeddone.sendKeys(ipWhatNeedsToBeDone);
        ibWhatneedstobeddone.sendKeys(Keys.RETURN);

    }

    /**
     * check if task added successfully
     */
    public Boolean checkIftaskaddedsuccessfully(String ipTaskAdded) {

        return checkifItemDisplayed(ipTaskAdded);

    }

    /**
     * check if task completed successfully
     */
    public Boolean checkIfTaskCompletedsuccessfully(String ipTaskCompleted) {

        return checkifTaskIsCompleted(ipTaskCompleted);

    }

    /**
     * click Link option All/Active/Completed
     */
    public void clickListOption(String ipLinkName) {

        clickLink(ipLinkName);

    }

    /**
     * click on Mark All Task Complete icon
     */
    public void markAllTaskComplete() {

        markAllComplete.click();

    }

    /**
     * click on Mark All Task Complete icon
     */
    public void clickOnClearCompletedButton() {

        clickbButton("Clear completed");

    }

    /**
     * remove task
     */
    public void removeTaskFromTaskList(String ipTaskToBeRemoved) {

        removeTask(ipTaskToBeRemoved);

    }

    /**
     * complete task
     */
    public void completeTaskFromList(String ipTaskToBeCompleted) {

        completeTask(ipTaskToBeCompleted);
    }

    /**
     * active task
     */
    public void activeTaskFromList(String ipTask) {

        completeTask(ipTask);
    }

    /**
     * get number of items left
     */
    public String getNoOfItemsLeft() {

        return noOfItemsLeft.getText();
    }
}
