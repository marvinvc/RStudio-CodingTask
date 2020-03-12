package com.rstudio.test.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginLink(){
        driver.findElement(By.linkText("Log In")).click();
    }

    public void typeUsername(String username){
        driver.findElement(By.name("email")).sendKeys(username);
    }

    public void typePassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(By.xpath("//div[@id='login-sub-rstudio']//button[@type='submit']")).click();
    }
}
