package Activity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity1 {
    public static void main(String[]args)
    {
        //WebDriverManager.firefoxdriver().setup();
        WebDriver D=new FirefoxDriver();
        D.get("https://v1.training-support.net");
        Object PageTitle=D.getTitle();
        System.out.println(PageTitle);
        D.quit();
    }
}
