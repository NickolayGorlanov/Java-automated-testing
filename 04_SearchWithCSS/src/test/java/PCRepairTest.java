import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class PCRepairTest {

    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qajava.skillbox.ru/module04/lesson3/os.html");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static class LocatorsPC {
     static By nameLocator = By.cssSelector(".data.text");
     static By emailLocator = By.cssSelector(".data.field");
     static By messageBoxLocator = By.cssSelector(".field.text");
     static By buttonLocator = By.id("comment");
     static By feedbackLocator = By.className("message-header");
    }

    @Test
    public void repairPC() {

        driver.findElement(LocatorsPC.nameLocator).sendKeys("Василиса");
        driver.findElement(LocatorsPC.emailLocator).sendKeys("test@test.inf");
        driver.findElement(LocatorsPC.messageBoxLocator).sendKeys("Здравствуйте, криво прошили bios для сокета LGA2011-V3 HELP!!!");
        driver.findElement(LocatorsPC.buttonLocator).click();
        Assert.assertEquals("Спасибо за отзыв!", driver.findElement(LocatorsPC.feedbackLocator).getText());
        driver.navigate().refresh();
    }


        @Test
        public void emailNotfound(){
            var email = "";
            driver.findElement(LocatorsPC.nameLocator).sendKeys("Василиса");
            driver.findElement(LocatorsPC.emailLocator).sendKeys("");
            driver.findElement(LocatorsPC.messageBoxLocator).sendKeys("Здравствуйте, криво прошили bios для сокета LGA2011-V3 HELP!!!");
            driver.findElement(LocatorsPC.buttonLocator).click();
            driver.findElement(LocatorsPC.emailLocator).getText();
            driver.navigate().refresh();
        }

        @Test
        public void nameNotFound(){

            driver.findElement(LocatorsPC.nameLocator).sendKeys("");
            driver.findElement(LocatorsPC.emailLocator).sendKeys("test@test.inf");
            driver.findElement(LocatorsPC.messageBoxLocator).sendKeys("Здравствуйте, криво прошили bios для сокета LGA2011-V3 HELP!!!");
            driver.findElement(LocatorsPC.buttonLocator).click();
            driver.findElement(LocatorsPC.nameLocator).getText();
            driver.navigate().refresh();

        }

        @Test
        public void textBoxNotFound(){

            driver.findElement(LocatorsPC.nameLocator).sendKeys("Василиса");
            driver.findElement(LocatorsPC.emailLocator).sendKeys("test@test.inf");
            driver.findElement(LocatorsPC.messageBoxLocator).sendKeys("");
            driver.findElement(LocatorsPC.buttonLocator).click();
            driver.findElement(LocatorsPC.messageBoxLocator).getText();
            driver.navigate().refresh();
        }
}

