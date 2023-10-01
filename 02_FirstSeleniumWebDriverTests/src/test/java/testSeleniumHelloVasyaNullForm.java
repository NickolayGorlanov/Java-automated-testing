import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testSeleniumHelloVasyaNullForm {
    @Test
    public void testHelloVasya(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");

        driver.findElement(By.className("button")).click();


        var  actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }
}
