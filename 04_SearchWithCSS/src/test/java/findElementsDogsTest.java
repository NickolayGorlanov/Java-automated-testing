import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;



public class findElementsDogsTest {

    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qajava.skillbox.ru/module04/lesson2/practice/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static class Locators {
        static By sendMe = By.id("sendMe");
        static By sendEmail = By.name("email");

        static By radiobuttonGirlElement = By.id("girl");
        static By radiobuttonBoyElement = By.id("boy");
    }

    @Test
    public void emptyEmail() {
        var email = "";
        driver.findElement(Locators.sendEmail).sendKeys("");
        driver.findElement(Locators.sendMe).click();
        Assert.assertEquals("E-mail не введен:", email, driver.findElement(Locators.sendEmail).getText());
        driver.navigate().refresh();
    }



    @Test
    public void findBoyElement (){
     driver.findElement(Locators.radiobuttonBoyElement).click();
     var email = "test@test.ru";
     driver.findElement(Locators.sendEmail).sendKeys(email);
     driver.findElement(Locators.sendMe).click();
     Assert.assertTrue("Хорошо, мы пришлём имя для вашего мальчика на e-mail:",  driver.findElement(Locators.sendEmail).isDisplayed());
     driver.navigate().refresh();

    }

    @Test
    public void findGirlElement (){
        driver.findElement(Locators.radiobuttonGirlElement).click();
        var email = "test@test.ru";
        driver.findElement(Locators.sendEmail).sendKeys(email);
        driver.findElement(Locators.sendMe).click();
        Assert.assertTrue("Хорошо, мы пришлём имя для вашей девочки на e-mail:", driver.findElement(Locators.sendEmail).isDisplayed());
        driver.navigate().refresh();
    }

}
