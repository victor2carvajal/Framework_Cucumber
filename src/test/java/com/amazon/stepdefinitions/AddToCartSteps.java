package com.amazon.stepdefinitions;

import com.amazon.hooks.Hooks;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartSteps {

    WebDriver driver= null;
    Hooks hooks;

    @Given("^user is at (.*)$")
    public void user_is_at_home_page(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/amazon/drivers/chromedriver");
        driver = new ChromeDriver();
        hooks = new Hooks(driver);
        HomePage home = new HomePage(driver);
        home.openPage(url);
        hooks.takeScreenshot();
    }
    @When("^user search a new (.*)$")
    public void user_search_a_product(String product) {
        HomePage home = new HomePage(driver);
        home.searchProduct(product);
        hooks.takeScreenshot();
    }

    @And("^sort by (.*) order the list$")
    public void sort_by_list_order(int index){
        ProductPage product = new ProductPage(driver);
        product.sortBy(index);
        product.selectProduct();
        hooks.takeScreenshot();
    }

    @And("add the product")
    public void add_product(){
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        product.GoToCart();
        hooks.takeScreenshot();
    }

    @Then("delete the product")
    public void delete_product() {
        CartPage cart = new CartPage(driver);
        cart.VerifyAdd();
        hooks.takeScreenshot();
        cart.DeleteProduct();
        cart.VerifyDeleted();
        hooks.takeScreenshot();
        driver.close();
    }
}
