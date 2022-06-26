package TestSuit2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddProductToBag extends BaseTest {
    @Test(groups = {"addProduct", "non-register"})
    public void addOneProductToBag() {
        //Search Story button
        WebElement searchStoreButton = driver.findElement(searchStoreButtonCss);
        searchStoreButton.click();

        //Search Category of product
        List<WebElement> searchCategoryMac = driver.findElements(searchCategoryMacCss);
        searchCategoryMac.get(0).click();

        //Choice first product
        List<WebElement> searchProduct = driver.findElements(searchProductXpath);
        searchProduct.get(0).click();

        //Search buy button
        List<WebElement> searchBuyButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchBuyButtonCss));
        searchBuyButton.get(0).click();

        //Choice select button
        WebElement searchSelectButton = driver.findElement(searchSelectButtonXpath);
        searchSelectButton.click();

        //Add product to bag
        WebElement searchAddBagButton = driver.findElement(searchAddBagButtonCss);
        searchAddBagButton.click();

        //Assert that product in bag
        WebElement searchNameBagProduct = driver.findElement(searchNameBagProductCss);
        Assert.assertEquals(searchNameBagProduct.isDisplayed(), true);
    }


    @Test(groups = {"addProduct", "non-register"})
    public void addTwoProductToBag() {
        //Search Story button
        WebElement searchStoreButton = driver.findElement(searchStoreButtonCss);
        searchStoreButton.click();

        //Search Category of product
        List<WebElement> searchCategoryMac = driver.findElements(searchCategoryMacCss);
        searchCategoryMac.get(0).click();

        //Choice first product
        List<WebElement> searchProduct = driver.findElements(searchProductXpath);
        searchProduct.get(0).click();

        //Search buy button
        List<WebElement> searchBuyButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchBuyButtonCss));
        searchBuyButton.get(0).click();

        //Choice select button
        WebElement searchSelectButton = driver.findElement(searchSelectButtonXpath);
        searchSelectButton.click();

        //Add product to bag
        WebElement searchAddBagButton = driver.findElement(searchAddBagButtonCss);
        searchAddBagButton.click();

        //Search "Review Bag" button
        WebElement searchReviewBagButton = driver.findElement(searchReviewBagButtonCss);
        searchReviewBagButton.click();

        //Assert that product in bag
        List<WebElement> searchNameAddProduct = driver.findElements(searchNameAddProductXpath);
        Assert.assertTrue(searchNameAddProduct.get(0).isDisplayed());

        //Search second category
        WebElement searchAccessoriesButton = driver.findElement(searchAccessoriesButtonCss);
        searchAccessoriesButton.click();

        //Search accessories to Mac
        List<WebElement> searchAccessByMac = driver.findElements(searchAccessByMacCss);
        searchAccessByMac.get(0).click();

        //Search second product
        List<WebElement> searchAccessByProduct = driver.findElements(searchAccessByProductCss);
        searchAccessByProduct.get(4).click();

        //Add second product to bag
        WebElement searchAccessByButtonProduct = driver.findElement(searchAccessByButtonProductCss);
        searchAccessByButtonProduct.click();

        //Assert that second product is in bag
        searchNameAddProduct = driver.findElements(searchNameAddProductXpath);
        Assert.assertTrue(searchNameAddProduct.get(0).isDisplayed());
    }

    @Test(dataProvider = "addProductViaSearch", groups = {"addProduct", "non-register"})
    public void addProductViaSearch(String search) {
        //Search "search" icon
        WebElement searchSearchIcon = driver.findElement(searchSearchIconCss);
        searchSearchIcon.click();

        //Enter product name into "search" field
        WebElement searchInputField = driver.findElement(searchInputFieldCss);
        searchInputField.sendKeys(search + Keys.ENTER);

        //Choice first link
        List<WebElement> searchFirstLinkOfSearchResult = driver.findElements(searchFirstLinkOfSearchResultCss);
        searchFirstLinkOfSearchResult.get(0).click();

        //Choice first product
        List<WebElement> searchFirstProductOfSearch = driver.findElements(searchFirstProductOfSearchCss);
        searchFirstProductOfSearch.get(0).click();

        //Search "Select" button
        List<WebElement> searchSelectButton = driver.findElements(searchSelectButtonCss);
        searchSelectButton.get(0).click();

        //Search "add to bag" button
        WebElement searchAddBagButton = driver.findElement(searchAddBagButtonCss);
        searchAddBagButton.click();

        //Search "Review Bag" button
        WebElement searchReviewBagButton = driver.findElement(searchReviewBagButtonCss);
        searchReviewBagButton.click();

        //Assert that product in bag
        List<WebElement> searchNameAddProduct = driver.findElements(searchNameAddProductXpath);
        Assert.assertTrue(searchNameAddProduct.get(0).isDisplayed());
    }
    @Parameters("@search")
    @Test(groups = {"addProduct", "non-register"})
    public void addProductNonExist(@Optional("~@@") String search){
        //Search "search" icon
        WebElement searchSearchIcon = driver.findElement(searchSearchIconCss);
        searchSearchIcon.click();

        //Enter product name into "search" field
        WebElement searchInputField = driver.findElement(searchInputFieldCss);
        searchInputField.sendKeys(search + Keys.ENTER);

        //Assert that search is wrong
       List< WebElement> searchResponseOnBadRequest=driver.findElements(searchResponseOnBadRequestCss);
       Assert.assertEquals(searchResponseOnBadRequest.get(0).getText(),"Sorry, no matches were found.");
    }
}

