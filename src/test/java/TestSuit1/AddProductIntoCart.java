package TestSuit1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddProductIntoCart extends BaseTest {
    @Test(groups = {"non-register", "positive"})
    public void addOneProductToCart() {
        //Choice a first category of catalog
        List<WebElement> searchFirstCategory = driver.findElements(searchFirstCategoryOfCatalogXpath);
        searchFirstCategory.get(1).click();

        //Choice category of product
        js.executeScript("scroll(0, 250);");
        List<WebElement> searchCategoryOfProduct = driver.findElements(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.get(14).click();

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
        Assert.assertEquals(actionText, expectedText);
    }

    @Test(groups = {"non-register", "positive"})
    public void addTwoProductToCart() {
        //Choice a first category of catalog
        List<WebElement> searchFirstCategory = driver.findElements(searchFirstCategoryOfCatalogXpath);
        searchFirstCategory.get(1).click();

        //Choice category of product
        js.executeScript("scroll(0, 250);");
        List<WebElement> searchCategoryOfProduct = driver.findElements(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.get(14).click();

        //Choice first of product
        WebElement searchFirstOfProduct = driver.findElement(searchOfProductCss);
        List<WebElement> elements = searchFirstOfProduct.findElements(By.xpath(".//a"));
        String expectedText = elements.get(0).getText();
        elements.get(0).click();

        //Add product into cart
        WebElement searchBuyButtonOfProduct = driver.findElement(searchBuyButtonOfProductCss);
        searchBuyButtonOfProduct.click();

        driver.navigate().back();
        driver.navigate().back();

        //Choice a second category of catalog
        List<WebElement> searchSecondCategoryOfCatalog = driver.findElements(searchSecondCategoryOfCatalogXpath);
        searchSecondCategoryOfCatalog.get(1).click();

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
        Assert.assertEquals(actionText1, expectedText1);

    }

    @Test(groups = {"non-register", "positive"})
    public void getAddProductViaBuyButton() {
        //Choice a first category of catalog
        List<WebElement> searchFirstCategory = driver.findElements(searchFirstCategoryOfCatalogXpath);
        searchFirstCategory.get(1).click();


        //Choice category of product
        js.executeScript("scroll(0, 250);");
        List<WebElement> searchCategoryOfProduct = driver.findElements(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.get(14).click();

        //Add product to cart
        WebElement searchBuyButton = driver.findElement(searchBuyButtonCss);
        searchBuyButton.click();

        //Search item on buy button
        String expectedText = "В КОРЗИНЕ";
        searchBuyButton = driver.findElement(searchBuyButtonCss);

        //Assert that product is in cart
        Assert.assertEquals(expectedText, searchBuyButton.getText());


    }

    @Test(groups = {"non-register", "negative"})
    public void getVerifyAddToSelection() {
        //Choice a first category of catalog
        List<WebElement> searchFirstCategory = driver.findElements(searchFirstCategoryOfCatalogXpath);
        searchFirstCategory.get(1).click();

        //Choice category of product
        js.executeScript("scroll(0, 250);");
        List<WebElement> searchCategoryOfProduct = driver.findElements(searchFirstCategoryOfProductXpath);
        searchCategoryOfProduct.get(14).click();

        //Choice first of product
        WebElement searchFirstOfProduct = driver.findElement(searchOfProductCss);
        List<WebElement> elements = searchFirstOfProduct.findElements(By.xpath(".//a"));
        String expectedText = elements.get(0).getText();
        elements.get(0).click();

        //Search heardSelection
        WebElement searchHeardSelection = driver.findElement(searchHeardSelectionXpath);
        searchHeardSelection.click();

        //Search "Вхід до особистого кабінету" pop-up window
        WebElement searchInputToAccountWindow = driver.findElement(searchInputToAccountWindowCss);
        boolean IsDisplayed = searchInputToAccountWindow.isDisplayed();

        //Assert that displayed pop-up window
        Assert.assertTrue(IsDisplayed);


    }


}
