import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;


public class OnlineNotesTest {
        private WebDriver driver;
        private WebDriverWait wait;
        JavascriptExecutor js;


        @Before
        public void setUp() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            js = (JavascriptExecutor) driver;
            Map<String, Object> var = new HashMap<String, Object>();
            driver.manage().window().maximize();
            driver.get("http://qa.skillbox.ru/module15/bignotes/#/");
        }

        @After
        public void tearDown() {
            driver.quit();
        }


        private static class LocatorNotes{
            static By popupTitle = By.className(".popup__content");
            static By popupButton = By.cssSelector("button.baseButton.pageCreate__baseButton");
        }

        @Test
        public void testForm() {

        driver.findElement(By.cssSelector(".pageCreate__sidebarHeaderAdd use")).click();


        driver.findElement(By.cssSelector(".baseInput__field")).click();

        driver.findElement(By.cssSelector(".baseInput__field")).sendKeys("123");

        driver.findElement(By.cssSelector(".baseTextarea__text")).click();

        driver.findElement(By.cssSelector(".baseTextarea__text")).sendKeys("321");

        driver.findElement(LocatorNotes.popupButton).click();

           wait.until(ExpectedConditions.invisibilityOfElementLocated(LocatorNotes.popupTitle));







        }}




