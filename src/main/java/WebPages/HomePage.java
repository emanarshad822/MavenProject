package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="http://book.theautomatedtester.co.uk/";

    //Locators

    @FindBy(how = How.LINK_TEXT, using = "Chapter1")
    private WebElement Chapter1Link;

    @FindBy(how = How.LINK_TEXT, using = "Home Page")
    private WebElement Home;

    @FindBy(xpath = "//div[contains(text(),'Selenium: Beginners Guide')]")
    private WebElement heading;



    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return heading.getText().toString().contains("Selenium: Beginners Guide");
    }

    public void clickOnLink(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Chapter1Link.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}

