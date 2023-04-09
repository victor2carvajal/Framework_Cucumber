package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class home_page {

    WebDriver driver;

    By search_TXT = By.id("twotabsearchtextbox");
    By submitBTN = By.id("nav-search-submit-button");
    
    public home_page(){}

    public void openPage(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void searchProduct(String product){
        driver.findElement(search_TXT).sendKeys(product);
        driver.findElement(submitBTN).click();
    }
}
