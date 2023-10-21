import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;



public class findElementsCatsTest {

    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qajava.skillbox.ru/module04/lesson2/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private By emailLocator = By.className("email");
    private By writeToMeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("result-email");

    @Test
    public void findElement () {
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        Assert.assertEquals("email введён", email, driver.findElement(resultEmailLocator).getText());
        driver.navigate().refresh();
    }

    @Test
    public void emptyEmail (){
        var email = "";
        driver.findElement(emailLocator).sendKeys("");
        driver.findElement(writeToMeLocator).click();
        Assert.assertEquals("email не введён", email, driver.findElement(resultEmailLocator).getText());

    }

}
