package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Script1 {
    public static void getBuyOneProduct() {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        //Searching input field and input a link
        String searchInputGoogleXpath = "//input[@name='q']";
        WebElement inputLink = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchInputGoogleXpath)));
        inputLink.sendKeys("rozetka.com.ua" + Keys.ENTER);

        //Choice first link of searched links
        String searchLinkXpath = "//h3[@class='LC20lb MBeuO DKV0Md']";
        List<WebElement> clickLink = driver.findElements(By.xpath(searchLinkXpath));
        clickLink.get(0).click();

        //Searching a menu of categories
        String searchMenuCategoriesXpath = "//a[@class='menu-categories__link']";
        List<WebElement> searchMenuCategories = driver.findElements(By.xpath(searchMenuCategoriesXpath));
        searchMenuCategories.get(0).click();

        //Choice a category of catalog
        String searchCategoryXpath = "//a[contains(@href, 'monitors')]";
        WebElement searchProduct = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchCategoryXpath)));
        actions.moveToElement(searchProduct).build().perform();
        searchProduct.click();

        //Choice a seller
        By sellerFilterBy = By.xpath("//div[@data-filter-name='seller']");
        WebElement sellerFilter = driver.findElement(sellerFilterBy);
        List<WebElement> elements = sellerFilter.findElements(By.cssSelector(".checkbox-filter__link"));
        elements.get(0).click();

        //Choice first product
        String searchFirstProductXpath = "//span[@class='goods-tile__title']";
        List<WebElement> searchFirstProduct = driver.findElements(By.xpath(searchFirstProductXpath));
        searchFirstProduct.get(0).click();

        //Adding a product to cart
        String searchBuyButtonXpath = "//span[contains(@class,'buy-button')]";
        WebElement searchBuyButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchBuyButtonXpath)));
        actions.moveToElement(searchBuyButton).build().perform();
        searchBuyButton.click();

        driver.close();


    }

}

