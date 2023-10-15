import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkKino {
    @Test
    public void  GetElement() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var passwordConfirm = driver.findElement(By.name("confirm_password"));
        driver.quit();

    }
}
