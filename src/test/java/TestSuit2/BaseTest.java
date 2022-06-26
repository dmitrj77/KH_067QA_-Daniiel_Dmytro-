package TestSuit2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    WebDriver driver = new ChromeDriver();

    By searchStoreButtonCss = By.cssSelector(".ac-gn-link-store");
    By searchCategoryMacCss = By.cssSelector(".rf-productnav-card-title");// [0]
    By searchProductXpath = By.xpath("//h3[@class='rf-hcard-content-title']");//[0]
    By searchBuyButtonCss = By.cssSelector(".rf-digitalmat-button");//Buy [0]
    By searchSelectButtonXpath = By.xpath("//button[contains(@data-autom,'proceed-13inch-good')]");
    By searchAddBagButtonCss = By.cssSelector(".button-block");
    By searchReviewBagButtonCss = By.cssSelector(".button-super");
    By searchNameAddProductXpath = By.xpath("//h2[@class='rs-iteminfo-title']");
    By searchNameBagProductCss = By.cssSelector(".rf-summary-header-producttitle");//isDisplayed
    By searchAccessoriesButtonCss = By.cssSelector(".ac-gn-link-accessories");
    By searchAccessByMacCss = By.cssSelector(".rf-browser-itemicon");//[0]
    By searchAccessByProductCss = By.cssSelector(".ir.as-pinwheel-tileheroimage");//[4]
    By searchAccessByButtonProductCss = By.cssSelector(".rf-pdp-addtocart");
    By searchSearchIconCss = By.cssSelector(".ac-gn-link.ac-gn-link-search");
    By searchNameOfProductInBagXpath = By.xpath("//h2[@class='rs-iteminfo-title']");
    By searchRemoveButtonCss = By.cssSelector(".rs-iteminfo-remove");
    By searchInputFieldCss= By.cssSelector(".ac-gn-searchform-input");
    By searchFirstLinkOfSearchResultCss=  By.cssSelector(".rf-serp-productname-link");
    By searchFirstProductOfSearchCss= By.cssSelector(".bottom-intro");
    By searchSelectButtonCss=By.cssSelector(".rc-productbundle-buybtn");
    By searchResponseOnBadRequestCss=By.cssSelector(".rf-serp-nullsearch-title");


    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://www.apple.com ");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void AfterSuite() {

        driver.quit();
    }

    @DataProvider(name = "addProductViaSearch")
    public Object[][] createData() {
        return new Object[][]{
                {"MacBook Air"},
                {"MacBook Pro"},
        };
    }

}
