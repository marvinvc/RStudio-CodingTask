package com.rstudio.test.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {

    public ProjectsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProjectTitle(){
        return driver.findElement(By.xpath("//div[@id='headerTitle']")).getText();
    }

    public void clickOnInfoLink(){
        driver.findElement(By.linkText("Info")).click();
    }

    public void clickProjectsLink(){
        driver.findElement(By.linkText("Projects")).click();
    }

    public void clickNewProjectButton(){
        driver.findElement(By.xpath("//button[@class='action newProject menuInstant']")).click();
    }
}
