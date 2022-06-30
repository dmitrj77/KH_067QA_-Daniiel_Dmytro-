package TestSuit5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private By deleteButton = new By.ByCssSelector(".js-delete-product-from-basket-list");
    private By titleOfProduct = new By.ByCssSelector(".header-tooltip__cards-item__title ");
    private By priceOfProduct = new By.ByCssSelector(".header-tooltip__cards-item__price");

    public CartPage(WebDriver driver) {

        super(driver);
    }

    public String getTitleElement() {
        List<WebElement> elements = driver.findElements(titleOfProduct);
        return elements.get(0).getText();
    }


    public void deleteProduct(int index) {
        List<WebElement> elements = driver.findElements(deleteButton);
        elements.get(index).click();
    }
}