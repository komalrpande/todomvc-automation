package com.todomvc.commonutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonLibrary {

    WebDriver driver;
    WebElement element;

    public CommonLibrary(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    /**
     * Check if the Webelement isdisplayed
     */
    public Boolean checkifItemDisplayed(String ipTaskAdded) {

        try {
            if(driver.findElement(By.xpath("//div/label[normalize-space(text())='" + ipTaskAdded + "']")).isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * click on Link
     */
    public void clickLink(String ipLinkName) {

        element = driver.findElement(By.xpath("//a[normalize-space(text())='" + ipLinkName + "']"));
        element.click();

    }

    /**
     * click on button
     */
    public void clickbButton(String ipButtonName) {

        element = driver.findElement(By.xpath("//button[normalize-space(text())='" + ipButtonName + "']"));
        element.click();

    }

    /**
     * remove task
     */
    public void removeTask(String ipTaskToBeRemoved) {

        int i = 1;
        String task;
        WebElement xIcon;
        while (driver.findElement(By.xpath("//li[" + i + "]/div/label")).isDisplayed()) {
            element = driver.findElement(By.xpath("//li[" + i + "]/div/label"));
            xIcon = driver.findElement(By.xpath("//section/ul/li[" + i + "]/div/button"));
            task = element.getText();
            if (task.equalsIgnoreCase(ipTaskToBeRemoved)) {
                element.click();
                xIcon.click();
                break;
            } else {
                i++;
            }
        }

    }

    /**
     * complete task
     */
    public void completeTask(String ipTaskCompleted) {

        int i = 1;
        String task;
        WebElement completeCheckbox;
        while (driver.findElement(By.xpath("//section/ul/li[" + i + "]/div/label")).isDisplayed()) {
            element = driver.findElement(By.xpath("//section/ul/li[" + i + "]/div/label"));
            completeCheckbox = driver.findElement(By.xpath("//section/ul/li[" + i + "]/div/input"));
            task = element.getText();
            if (task.equalsIgnoreCase(ipTaskCompleted)) {
                completeCheckbox.click();
                break;
            } else {
                i++;
            }
        }

    }

    /**
     * Check if the task is completed
     */
    public Boolean checkifTaskIsCompleted(String ipTaskCompleted) {

        try {
            if (driver.findElement(By.xpath("//li[@class='todo completed']//label[normalize-space(text())='" + ipTaskCompleted + "']")).isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if the task is completed
     */
    public Boolean checkifTaskStatusIsActive(String ipTaskCompleted) {

        try {
            if (driver.findElement(By.xpath("//li[@class='todo']//label[normalize-space(text())='" + ipTaskCompleted + "']")).isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
