package TestSuit1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    WebDriver driver = new ChromeDriver();
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    By searchFirstCategoryOfCatalogXpath = By.xpath("//span[@class='icon style-32020']");
    By searchSecondCategoryOfCatalogXpath = By.xpath("//a[contains(@href,'utugi')]");
    By searchFirstCategoryOfProductXpath = By.xpath("//a[@class='item__list_link']");
    By searchOfProductCss = By.cssSelector(".card__body");
    By searchBuyButtonOfProductCss = By.cssSelector(".product-box__main-buy__button");
    By searchTitleOfProductInCartCss = By.cssSelector(".header-tooltip__cards-item__title");
    By searchDeleteButtonCss = By.cssSelector(".js-delete-product-from-basket-list");
    By searchBuyButtonCss = By.cssSelector(".product-buy-button");
    By searchHeardSelectionXpath = By.xpath("//i[@class='icon-heart']");
    By searchInputToAccountWindowCss = By.cssSelector(".auth__title");

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://www.foxtrot.com.ua/ ");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void AfterSuite() {
        driver.quit();
    }

}

