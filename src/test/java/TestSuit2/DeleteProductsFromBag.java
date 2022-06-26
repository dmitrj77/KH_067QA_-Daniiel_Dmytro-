package TestSuit2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DeleteProductsFromBag extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
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

    @Test(groups = {"deleteProduct", "non-register"})
    public void deleteOneProduct() {

        //Search name of product in bag before
        List<WebElement> searchNameOfProductInBag = driver.findElements(searchNameOfProductInBagXpath);
        String expectedText = searchNameOfProductInBag.get(0).getText();

        //Search "Remove" button
        WebElement searchRemoveButton = driver.findElement(searchRemoveButtonCss);
        searchRemoveButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Search name of product in bag after
        List<WebElement>searchNameOfProductInBag1 = new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchNameOfProductInBagXpath));
        String actualText = searchNameOfProductInBag1.get(0).getText();

        Assert.assertEquals(actualText,expectedText);

    }

    @Test(groups = {"deleteProduct", "non-register"})
    public void deleteTwoProducts() {

        //Search "Remove" button
        WebElement searchRemoveButton = driver.findElement(searchRemoveButtonCss);
        searchRemoveButton.click();

        //Search "Remove" button again
        searchRemoveButton = driver.findElement(searchRemoveButtonCss);
        searchRemoveButton.click();

        //Search name of product in bag after
       List<WebElement>  searchNameOfProductInBag = driver.findElements(searchNameOfProductInBagXpath);
        int sizeAfter = searchNameOfProductInBag.size();
        boolean isTrue;
        if (sizeAfter == 0) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        Assert.assertTrue(isTrue);
    }
}
