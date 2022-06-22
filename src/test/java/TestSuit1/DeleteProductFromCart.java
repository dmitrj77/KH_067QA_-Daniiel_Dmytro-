package TestSuit1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DeleteProductFromCart extends BaseTest {

    @BeforeMethod
    public void BeforeMethod() {
        super.BeforeMethod();
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
        // String expectedText = elements.get(0).getText();
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

    }

    @Test(groups = {"non-register", "positive"})
    public void deleteOneProduct() {

        //Search Delete button
        List<WebElement> searchDeleteButtonBefore = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchDeleteButtonCss));
        searchDeleteButtonBefore.get(0).click();
        int sizeBefore = searchDeleteButtonBefore.size();

        //Assert that product is deleted
        List<WebElement> searchDeleteButtonAfter = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchDeleteButtonCss));
        int sizeAfter = searchDeleteButtonAfter.size();
        boolean isEquals;
        if (sizeAfter < sizeBefore) {
            isEquals = true;
        } else {
            isEquals = false;
        }
        Assert.assertTrue(isEquals);

    }


    @Test(groups = {"non-register", "positive"})
    public void deleteTwoProduct() {

        //Search Delete button
        List<WebElement> searchDeleteButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchDeleteButtonCss));
        searchDeleteButton.get(0).click();
        // int sizeBefore = searchDeleteButton.size();

        //Search Delete button again
        searchDeleteButton = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchDeleteButtonCss));
        searchDeleteButton.get(0).click();

        //Assert that product is deleted
        List<WebElement> searchDeleteButtonAfter = driver.findElements(searchDeleteButtonCss);
        int sizeAfter = searchDeleteButtonAfter.size();

        boolean isEquals;
        if (sizeAfter == 0) {
            isEquals = true;
        } else {
            isEquals = false;
        }
        Assert.assertTrue(isEquals);

    }
}
