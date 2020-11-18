package Test;

import WebPages.Chapter1Page;
import WebPages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class Test_cases {

    WebDriver driver;

    ExtentReports extent;
    ExtentTest logger;
    ExtentHtmlReporter htmlReporter;
    String htmlReportPath = ".//Resource//Reports//ExtentReport.html"; //Path for the HTML report to be saved

    @BeforeClass
    public void setup(){
        htmlReporter = new ExtentHtmlReporter(htmlReportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
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

    @AfterTest
    public void testend() throws Exception {
        extent.flush();
    }

    @AfterClass
    public void close(){
        driver.close();
    }

}
