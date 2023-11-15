package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[]args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Page Title: "+driver.getTitle());
        String head3=driver.findElement(By.xpath("//h3[@id=\"third-header\"]")).getText();
        System.out.println("Page Header 3: "+head3);
        String head5=driver.findElement(By.xpath("//h5[@class=\"ui green header\"]")).getCssValue("color");
        System.out.println("Page Header 3: "+head5);
        System.out.println(driver.findElements(By.xpath("//button[text()='Violet']")).getClass());
        System.out.println(driver.findElement(By.xpath("//button[@class=\"ui grey button\"]")).getText());
        driver.quit();
    }
}
