package com.todomvc.stepdefination;


import com.todomvc.commonutils.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Hooks {

    public static WebDriver driver;
    String baseUrl;
    String exeType;

    @Before
    public void launchTodoMVC() throws MalformedURLException {

        ConfigFileReader configFileReader = new ConfigFileReader();
        baseUrl = configFileReader.property("appUrl");
        exeType = configFileReader.property("execution");

        if(exeType.equalsIgnoreCase("local")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }
        else if(exeType.equalsIgnoreCase("remote")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        }
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
