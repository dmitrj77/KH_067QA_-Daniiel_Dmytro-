package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        Script1.getBuyOneProduct();

        Script2.getBuyTwoProducts();

    }

    public static void getDeleteProduct(WebDriver driver) {
        //Search modal close
        String searchModalCloseXpath = "//button[contains(@class, 'modal__close')]";
        WebElement searchModalClose = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchModalCloseXpath)));
        searchModalClose.click();

        //Search car button
        String searchCarMenuXpath = "//span[contains(@class, 'counter--green')]";
        WebElement searchCarMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchCarMenuXpath)));
        searchCarMenu.click();

        //Choice 3. menu
        String searchDotCartMenuXpath = "//button[@id='cartProductActions0']";
        WebElement searchDotCarMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchDotCartMenuXpath)));
        searchDotCarMenu.click();

        //Delete a product from cart
        String searchDeleteButtonXpath = "//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']";
        WebElement searchDeleteButton = driver.findElement(By.xpath(searchDeleteButtonXpath));
        searchDeleteButton.click();

    }


}
