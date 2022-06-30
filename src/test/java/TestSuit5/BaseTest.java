package TestSuit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



import java.time.Duration;

public class BaseTest {

    protected   WebDriver driver;

    @BeforeSuite
    public void setup() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup1() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://www.foxtrot.com.ua");
    }

    @AfterMethod
    public void teardown() {

        driver.quit();
    }


    @DataProvider(name = "addProductViaSearch")
    public Object[][] createData() {
        return new Object[][]{
                {"Конденціонери", 0},
                {"Праски", 3},
        };
    }
}
