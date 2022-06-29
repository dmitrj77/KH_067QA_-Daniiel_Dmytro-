package TestSuit5;

import TestSuit5.listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task5.HomePage;


@Listeners(CustomListener.class)
public class AddProductToCart extends BaseTest {

    @Test(dataProvider = "addProductViaSearch", groups = {"non-register", "positive"})
    public void addOneProductToCart(String search, int index) {

       .search(search);
        searchResultsPage.clickProductByIndex(index);


        Assert.assertEquals(search, search);
    }

    @Test(groups = {"addProduct", "non-register"})
    public void addTwoProductToBag() {

    }

    @Test(dataProvider = "addProductViaSearch", groups = {"addProduct", "non-register"})
    public void addProductViaSearch(String search) {

    }

    @Parameters("@search")
    @Test(groups = {"addProduct", "non-register"})
    public void addProductNonExist(@Optional("~@@") String search) {

    }


}
