package Test;

import WebPages.Chapter1Page;
import WebPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class Test_cases {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//drivers//chromedriver.exe");

        //use Chrome Driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void ActionClass() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);

        home.clickOnLink();
        //Create object of HomePage Class}

        Chapter1Page ch = new Chapter1Page(driver);

        ch.verifyText();
        ch.navigateToHome();

    }

    @AfterMethod
    public void close(){
        driver.close();
    }

}
