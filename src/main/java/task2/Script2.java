package task2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static task2.Main.getDeleteProduct;


public class Script2 {
    public static void getBuyTwoProducts() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        //Search input field and input a link
        String searchInputGoogleXpath = "//input[@name='q']";
        WebElement inputLink = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchInputGoogleXpath)));
        inputLink.sendKeys("rozetka.com.ua" + Keys.ENTER);

        //Choice first link of searched links
        String searchLinkXpath = "//h3[@class='LC20lb MBeuO DKV0Md']";
        List<WebElement> clickLink = driver.findElements(By.xpath(searchLinkXpath));
        clickLink.get(0).click();

        //Search a menu of categories
        String searchMenuCategoriesXpath = "//a[@class='menu-categories__link']";
        List<WebElement> searchMenuCategories = driver.findElements(By.xpath(searchMenuCategoriesXpath));
        searchMenuCategories.get(0).click();

        //Choice first category of catalog
        String searchCategory1tXpath = "//a[contains(@href, 'monitors')]";
        js.executeScript("scroll(0, 250);");
        WebElement searchProduct = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchCategory1tXpath)));
        searchProduct.click();

        //Choice a producer of product
        String searchCheckBoxXpath = "//a[@data-id='Rozetka']";
       driver.findElement(By.xpath(searchCheckBoxXpath)).click();

        //Choice first product
        String searchFirstProductXpath = "//span[@class='goods-tile__title']";
        List<WebElement> searchFirstProduct = driver.findElements(By.xpath(searchFirstProductXpath));
        searchFirstProduct.get(0).click();

        //Add first product to cart
        actions.moveByOffset(250, 250).build().perform();
        //String searchBuyButtonXpath = "//button[@class='buy-button button button--with-icon button--green button--medium ng-star-inserted']";
        String searchBuyButtonXpath = "//span[contains(@class,'buy-button')]";
        driver.findElement(By.xpath(searchBuyButtonXpath)).click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        //Choice second category of catalog
        String searchCategory2Xpath = "//a[contains(@href, 'mouses')]";
        js.executeScript("scroll(0, 450);");
        WebElement searchCategory2 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchCategory2Xpath)));
        searchCategory2.click();

        //Choice second product of category
        String searchProduct2Xpath = "//span[@class='goods-tile__title']";
        List<WebElement> searchProduct2 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(searchProduct2Xpath)));
        searchProduct2.get(0).click();

        //Add second product to cart
        actions.moveByOffset(250, 250).build().perform();
        driver.findElement(By.xpath(searchBuyButtonXpath)).click();

        getDeleteProduct(driver);
        getDeleteProduct(driver);
        driver.close();

    }

}
