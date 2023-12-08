import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class FindCSSNelementTest {
    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static class LocatorsFindElement {
        static By LocatorVersion = By.cssSelector("span:not(.baseCard__title");
        static By LocatorButton = By.cssSelector("button:not(disabled)");
        static By LocatorCourse = By.cssSelector(".baseCard.pageCreate__card:nth-child(4) .baseButton:not(.baseButton--noBorder)");


    }

    @Test
    public void enterFormSock() {
        driver.get("http://qa.skillbox.ru/module16/16_2/");
        driver.findElement(LocatorsFindElement.LocatorVersion);
        driver.findElement(LocatorsFindElement.LocatorButton);
        driver.findElement(LocatorsFindElement.LocatorCourse);

    }

}