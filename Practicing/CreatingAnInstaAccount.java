package Practicing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreatingAnInstaAccount {
    WebDriver driver;
    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.instagram.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 /*   @AfterMethod
    public void cLosing() {
        driver.close();
    }*/
    @Test
    public void createAnAccount(){
        WebElement signUpBtn=driver.findElement(By.xpath("//span[text()='Sign up']"));
        signUpBtn.click();
        String handle=driver.getWindowHandle();
        driver.switchTo().window(handle);
        WebElement email=driver.findElement(By.xpath("//input[@name='emailOrPhone']"));
        email.sendKeys("kaankagan113@gmail.com");
        WebElement fullName=driver.findElement(By.xpath("//input[@name='fullName']"));
        fullName.sendKeys("Kaan Kagan");
        WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("kaankagan113");
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Syntax123");
        WebElement BtnSignUp=driver.findElement(By.xpath("//button[text()='Sign up']"));
        BtnSignUp.click();
        String handle1=driver.getWindowHandle();
        driver.switchTo().window(handle1);
        WebElement multipleDropDown=driver.findElement(By.xpath("//select[@title='Month:']"));
        Select selectMonth=new Select(multipleDropDown);
        WebElement dayDropDown=driver.findElement(By.xpath("//select[@title='Day:']"));
        Select selectDay=new Select(dayDropDown);
        selectDay.selectByValue("9");
        WebElement yearDropDown=driver.findElement(By.xpath("//select[@title='Year:']"));
        Select selectYear=new Select(yearDropDown);
        selectYear.selectByVisibleText("2017");
        driver.findElement(By.xpath("//button[text()='Next']")).click();

    }
}

