import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class PCRepairFormTest {

    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qajava.skillbox.ru/module04/lesson3/index.html");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static class LocatorsFormPC {
        static By nameLocator = By.cssSelector(".form-input.fio");
        static By streetLocator = By.cssSelector(".data.form-input.street");
        static By homeNumberLocator = By.cssSelector(".form-input.house");
        static By roomLocator = By.cssSelector(".form-input.flat");
        static By dayLocator = By.cssSelector(".form-input.date");
        static By masterButtonLocator = By.className("form-submit");

    }

    @Test
    public void repairFormPC() {

        driver.findElement(PCRepairFormTest.LocatorsFormPC.nameLocator).sendKeys("Василиса");
        driver.findElement(PCRepairFormTest.LocatorsFormPC.streetLocator).sendKeys("Василисы");
        driver.findElement(PCRepairFormTest.LocatorsFormPC.homeNumberLocator).sendKeys("5");
        driver.findElement(PCRepairFormTest.LocatorsFormPC.roomLocator).sendKeys("555");
        driver.findElement(PCRepairFormTest.LocatorsFormPC.dayLocator).sendKeys("23.05.20");
        driver.findElement(PCRepairFormTest.LocatorsFormPC.masterButtonLocator).click();
        driver.navigate().refresh();
    }
}
