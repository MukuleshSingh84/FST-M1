package Activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException
    {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);
    }
    @Test
    public void test()
    {
        //Addition
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_9")).click();
        driver.findElement(By.id("eq")).click();
        String result=driver.findElement(By.id("result")).getText();
        System.out.println("Sum of given number is: "+result);
        Assert.assertEquals(result,"14");
        //Substraction
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(By.id("op_sub")).click();
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("eq")).click();
        String result2=driver.findElement(By.id("result")).getText();
        System.out.println("Sum of given number is: "+result2);
        Assert.assertEquals(result2,"5");
        //Multiplication
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("op_mul")).click();
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(By.id("eq")).click();
        String result3=driver.findElement(By.id("result")).getText();
        System.out.println("Sum of given number is: "+result3);
        Assert.assertEquals(result3,"500");
        //Division
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(By.id("op_div")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();
        String result4=driver.findElement(By.id("result")).getText();
        System.out.println("Sum of given number is: "+result4);
        Assert.assertEquals(result4,"25");
    }
    @AfterClass
    public void testExit()
    {
        driver.quit();
    }
}
