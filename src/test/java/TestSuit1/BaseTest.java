package TestSuit1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

//    @BeforeSuite
//    public static void getBeforeSuite(){
//
//    }
//
//    @BeforeClass
//    public static void getBeforeClass() {
//
//    }
//
//    @AfterClass
//    public static void getAfterClass() {
//
//
//    }

//    @BeforeMethod
//    public static void getBeforeMethod() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.foxtrot.com.ua/ ");
//        driver.manage().window().maximize();
//
//    }

    @AfterMethod
    public static void getAfterMethod() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

   // @BeforeTest
  //  public static void getRegisterUser() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        By enterToOwmCabinetXpath = By.xpath("//div[@class='nowrap']");
//        WebElement enterToOwmCabinet=driver.findElement(enterToOwmCabinetXpath);
//        By searchInputNumberId=By.id("auth-phone-input");
//        WebElement searchInputNumber=driver.findElement(searchInputNumberId);
//        searchInputNumber.sendKeys("0999227066"+ Keys.ENTER);

   // }
}

