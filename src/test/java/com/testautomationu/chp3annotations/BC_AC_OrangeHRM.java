package com.testautomationu.chp3annotations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.testautomationu.utility.Highlighter;

public class BC_AC_OrangeHRM {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\victo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        System.out.println("1. Open Chrome & Application");
    }
    @Test
    public void signIn ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.name("password"));
        Highlighter.highlightElement(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.className("oxd-button"));//xpath("1"));
        Highlighter.highlightElement(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("2. Sign In");
    }

    @Test
    public void userSearch ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menuAdmin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Admin")));

//        WebElement menuAdmin = driver.findElement(By.partialLinkText("Admin"));// .id("menu_admin_viewAdminModule"));
        Highlighter.highlightElement(driver, menuAdmin);
        menuAdmin.click();

//        WebElement textUserName = driver.findElement(By.id("searchSystemUser_userName"));
        WebElement textUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")));
        Highlighter.highlightElement(driver, textUserName);
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[text()= ' Search ']"));// .id("searchBtn"));
        Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("3. Search For User");
    }
/*
    @Test
    public void userSignOut ()
    {
        WebElement linkWelcome = driver.findElement(By.id("welcome"));
        Highlighter.highlightElement(driver, linkWelcome);
        linkWelcome.click();

        WebElement linkLogout = driver.findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
        Highlighter.highlightElement(driver, linkLogout);
        linkLogout.click();

        System.out.println("4. Sign Out");
    }
*/
    @AfterClass
    public void tearDown ()
    {
        System.out.println("5. Close Chrome & Application");
        //driver.quit();
    }
}
