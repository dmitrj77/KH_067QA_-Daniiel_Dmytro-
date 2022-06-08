package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://www.google.com/");
        String searchInputXpath = "//input[@name='q']";
        WebElement inputLink = driver.findElement(By.xpath(searchInputXpath));
        inputLink.sendKeys("rozetka.com.ua" + Keys.ENTER);

        String searchLinkXpath = "//h3[@class='LC20lb MBeuO DKV0Md']";
        List<WebElement> clickLink = driver.findElements(By.xpath(searchLinkXpath));
        clickLink.get(0).click();

        String searchProductXpath = "//input[@name='search']";
        WebElement searchProduct = driver.findElement(By.xpath(searchProductXpath));
        searchProduct.sendKeys("Apple iPhone 11" + Keys.ENTER);

        String searchPhonesXpath = "//a[@class='goods-tile__picture ng-star-inserted']";
        List<WebElement> phones = driver.findElements(By.xpath(searchPhonesXpath));
        phones.get(0).click();

        String searchCartXpath = "(//button[@class='header__button ng-star-inserted'])[last()]";
        WebElement searchCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchCartXpath)));
        searchCart.click();

        String searchBuyButtonXpath = "(//button[@class='buy-button lite-tile__buy-button ng-star-inserted'])[last()]";
        WebElement searchBuyButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchBuyButtonXpath)));
        searchBuyButton.click();
        driver.close();


    }
}

