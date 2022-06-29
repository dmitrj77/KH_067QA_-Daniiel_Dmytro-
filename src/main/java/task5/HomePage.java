package task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By searchInput =  By.cssSelector("header-search__field");
    private By searchButton = new By.ByCssSelector("header-search__button");

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public SearchResultsPage search(String searchQuery) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchQuery);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
}
