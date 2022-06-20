package TestSuit1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class NonRegisterUser extends BaseTest {

    By searchMainCatalogXpath = By.xpath("//a[@class='js-hover-catalog']");
    By searchFirstCategoryOfCatalogXpath = By.xpath("(//span[@class='icon style-32020'])[2]");
    By searchSecondCategoryOfCatalogXpath = By.xpath("(//a[contains(@href,'utugi')])[2]");
    By searchFirstCategoryOfProductXpath = By.xpath("(//a[@class='item__list_link'])[15]");
    By searchOfProductCss = By.cssSelector(".card__body");
    By searchBuyButtonCss = By.cssSelector(".product-buy-button");
    By searchBuyButtonOfProductCss = By.cssSelector(".product-box__main-buy__button");
    By searchTitleOfProductInCartCss = By.cssSelector(".header-tooltip__cards-item__title");


    @Test(groups = {"non-register", "positive"})
    public void getBuyOneProduct() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.foxtrot.com.ua/ ");
        driver.manage().window().maximize();

        //Choice a first category of catalog
        WebElement searchCategory = driver.findElement(searchFirstCategoryOfCatalogXpath);
        searchCategory.click();

        //Choice category of product
        js.executeScript("scroll(0, 250);");
        WebElement searchCategoryOfProduct = driver.findElement(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.click();

        //Choice first of product
        WebElement searchFirstOfProduct = driver.findElement(searchOfProductCss);
        List<WebElement> elements = searchFirstOfProduct.findElements(By.xpath(".//a"));
        String expectedText = elements.get(0).getText();
        elements.get(0).click();

        //Add product into cart
        WebElement searchBuyButtonOfProduct = driver.findElement(searchBuyButtonOfProductCss);
        searchBuyButtonOfProduct.click();

        // Search title of added product in cart
        WebElement searchTitleOfProductInCart = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(searchTitleOfProductInCartCss));
        String actionText = searchTitleOfProductInCart.getText();

        //Assert that product is in cart
        Assert.assertEquals(expectedText, actionText);

    }

    @Test(groups = {"non-register", "positive"})
    public void getBuyTwoProduct() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.foxtrot.com.ua/ ");
        driver.manage().window().maximize();

        //Choice a first category of catalog
        WebElement searchFirstCategory = driver.findElement(searchFirstCategoryOfCatalogXpath);
        searchFirstCategory.click();

        //Choice category of product
        js.executeScript("scroll(0, 250);");
        WebElement searchCategoryOfProduct = driver.findElement(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.click();

        //Choice first of product
        WebElement searchFirstOfProduct = driver.findElement(searchOfProductCss);
        List<WebElement> elements = searchFirstOfProduct.findElements(By.xpath(".//a"));
        String expectedText = elements.get(0).getText();
        elements.get(0).click();

        //Add product into cart
        WebElement searchBuyButtonOfProduct = driver.findElement(searchBuyButtonOfProductCss);
        searchBuyButtonOfProduct.click();

        //Search title of added product in cart
        WebElement searchTitleOfProductInCart = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(searchTitleOfProductInCartCss));
        String actionText = searchTitleOfProductInCart.getText();

        //Assert that product is in cart
        Assert.assertEquals(expectedText, actionText);

        driver.navigate().back();
        driver.navigate().back();

        //Choice a second category of catalog
        WebElement searchSecondCategoryOfCatalog = driver.findElement(searchSecondCategoryOfCatalogXpath);
        searchSecondCategoryOfCatalog.click();

        //Add second product to cart
        WebElement searchSecondOfProduct = driver.findElement(searchOfProductCss);
        List<WebElement> elementsList = searchSecondOfProduct.findElements(By.xpath(".//a"));
        String expectedText1 = elementsList.get(0).getText();
        elementsList.get(0).click();

        //Add product into cart
        searchBuyButtonOfProduct = driver.findElement(searchBuyButtonOfProductCss);
        searchBuyButtonOfProduct.click();

        //Search title of added product in cart
        List<WebElement> searchTitleOfProduct2tInCart = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchTitleOfProductInCartCss));
        String actionText1 = searchTitleOfProduct2tInCart.get(0).getText();

        //Assert that product is in cart
        Assert.assertEquals(expectedText1, actionText1);


    }

    @Test(groups = {"non-register", "positive"})
    public void getAddProductViaBuyButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.foxtrot.com.ua/ ");
        driver.manage().window().maximize();

        //Choice a third category of catalog
        WebElement searchCategory = driver.findElement(searchFirstCategoryOfCatalogXpath);
        searchCategory.click();

        //Choice category of product
        js.executeScript("scroll(0, 250);");
        WebElement searchCategoryOfProduct = driver.findElement(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.click();

        //Add product to cart
        WebElement searchBuyButton = driver.findElement(searchBuyButtonCss);
        searchBuyButton.click();

        //Search item on buy button
        String expectedText = "В КОРЗИНЕ";
        searchBuyButton = driver.findElement(searchBuyButtonCss);

        //Assert that product is in cart
        Assert.assertEquals(expectedText, searchBuyButton.getText());

    }

    @Test(groups = {"non-register", "positive"})
    public void getDeleteOneProduct() {

    }

    @Test(groups = {"non-register", "positive"})
    public void getDeleteTwoProduct() {

    }

    @Test(groups = {"non-register", "negative"})
    public void getVerifyAddToSelection() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.foxtrot.com.ua/ ");
        driver.manage().window().maximize();

        //Choice a first category of catalog
        WebElement searchCategory = driver.findElement(searchFirstCategoryOfCatalogXpath);
        searchCategory.click();

        //Choice category of product
        js.executeScript("scroll(0, 250);");
        WebElement searchCategoryOfProduct = driver.findElement(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.click();

        //card__rating

    }

}
