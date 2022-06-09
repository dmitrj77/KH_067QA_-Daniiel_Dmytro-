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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String searchInputGoogleXpath = "//input[@name='q']";
        WebElement inputLink = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchInputGoogleXpath)));
        inputLink.sendKeys("rozetka.com.ua" + Keys.ENTER);

        //Search input field to find product
        String searchLinkXpath = "//h3[@class='LC20lb MBeuO DKV0Md']";
        List<WebElement> clickLink = driver.findElements(By.xpath(searchLinkXpath));
        clickLink.get(0).click();

        //Input product name
        String searchInputProductXpath = "//input[@name='search']";
        WebElement searchProduct = driver.findElement(By.xpath(searchInputProductXpath));
        searchProduct.sendKeys("Apple iPhone 11" + Keys.ENTER);

        //Choice first founded product
        String searchProductXpath = "//a[@class='goods-tile__picture ng-star-inserted']";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> products = driver.findElements(By.xpath(searchProductXpath));
        products.get(0).click();

        //Click to non-clickable place
        String emptyClickXpath = "//span[@class='product__code-accent']";
        WebElement searchEmptyClick = driver.findElement(By.xpath(emptyClickXpath));
        searchEmptyClick.click();

        //Add product to cart
        //String searchBuyButtonXpath = "//button[@class='buy-button button button--with-icon button--green button--medium ng-star-inserted']";
        String searchBuyButtonXpath = "//span[contains(text(),'Купить')]";
        WebElement searchBuyButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchBuyButtonXpath)));
        searchBuyButton.click();

        //Delete added product from cart
        String searchDotCartMenuXpath = "//button[@id='cartProductActions0']";
        WebElement searchDotCarMenu = driver.findElement(By.xpath(searchDotCartMenuXpath));
        searchDotCarMenu.click();

        String searchDeleteButtonXpath = "//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']";
        WebElement searchDeleteButton = driver.findElement(By.xpath(searchDeleteButtonXpath));
        searchDeleteButton.click();

        scanner.next();


        driver.close();


    }
}

