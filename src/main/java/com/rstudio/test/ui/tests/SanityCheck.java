package com.rstudio.test.ui.tests;

import com.rstudio.test.ui.page.LandingPage;
import com.rstudio.test.ui.page.ProjectsPage;
import com.rstudio.test.ui.page.SidePanelSection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SanityCheck {

    WebDriver driver;
    LandingPage landingPage;
    SidePanelSection sidePanelSection;
    ProjectsPage projectsPage;

    @BeforeClass(groups = "ui")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        landingPage = new LandingPage(driver);
        sidePanelSection = new SidePanelSection(driver);
        projectsPage = new ProjectsPage(driver);

        driver.get("https://rstudio.cloud/");
        landingPage.clickLoginLink();
        landingPage.typeUsername("mvtest@rstudio.com");
        landingPage.typePassword("Automation123");
        landingPage.clickLoginButton();
    }

    @Test(groups = "ui")
    public void testAddingNewSpace() throws InterruptedException {
        String newTestSpaceName = "Test Space 6";
        String newTestSpaceInfo = "InformationTest";

        sidePanelSection.clickNewSpaceButton();
        Thread.sleep(500);
        sidePanelSection.typeNewSpaceName(newTestSpaceName);
        sidePanelSection.typeNewSpaceInfo(newTestSpaceInfo);
        sidePanelSection.clickCreateNewSpaceButton();
        Thread.sleep(2000);
        projectsPage.clickOnInfoLink();

        assertEquals(projectsPage.getProjectTitle(), newTestSpaceName);
        assertTrue(driver.getPageSource().contains(newTestSpaceInfo));
    }


    @Test(groups = "ui")
    public void testAddingANewProject() {
        projectsPage.clickProjectsLink();
        projectsPage.clickNewProjectButton();
        fail("Currently broken and cannot continue automation");
    }

    @Test(groups = "ui")
    public void testRStudioIDELoads() {
        fail("Currently broken and cannot continue automation");
    }

    @AfterClass(groups = "ui")
    public void tearDown() {
        driver.quit();
    }
}
