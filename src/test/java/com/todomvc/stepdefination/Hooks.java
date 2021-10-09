package com.todomvc.stepdefination;


import com.todomvc.commonutils.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Hooks {

    public static WebDriver driver;
    String baseUrl;

    @Before
    public void launchTodoMVC() {

        ConfigFileReader configFileReader = new ConfigFileReader();
        baseUrl = configFileReader.property("appUrl");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriverManager.chromedriver().browserVersion("94.0.4606.71").setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @After
    public void closeApp() {
        driver.quit();
    }

}
