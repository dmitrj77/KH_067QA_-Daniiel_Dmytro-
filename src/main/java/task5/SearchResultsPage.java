package task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {
    private By results = new By.ByCssSelector(".sc-product");
    private By titleXpath=new By.ByCssSelector(".card__body");


    public SearchResultsPage (WebDriver driver) {
        super(driver);
    }

    public ProductPage clickProductByIndex(int index) {
        List<WebElement> resultsWebElements = driver.findElements(results);
        resultsWebElements.get(index).click();
        return new ProductPage(driver);
    }
}
