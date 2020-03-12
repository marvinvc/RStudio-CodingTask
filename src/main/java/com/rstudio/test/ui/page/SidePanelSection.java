package com.rstudio.test.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanelSection extends BasePage{

    public SidePanelSection(WebDriver driver){
        this.driver = driver;
    }

    public void clickNewSpaceButton(){
        driver.findElement(By.xpath("//button[@class='menuItem newSpace']")).click();
    }

    public void typeNewSpaceName(String spaceName){
        driver.findElement(By.id("name")).sendKeys(spaceName);
    }

    public void typeNewSpaceInfo(String info){
        driver.findElement(By.id("description")).sendKeys(info);
    }

    public void clickCreateNewSpaceButton(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
