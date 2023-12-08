import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DeleteNotesTest {

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
            driver.get("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        }

        @After
        public void tearDown() {
            driver.quit();
        }


        private static class LocatorNotes{

            static By DeleteButton = By.cssSelector("div.pageArticle__buttons > button:nth-child(2)");
//
//            static By title = By
        }

        @Test
        public void testForm() {

            driver.findElement(By.cssSelector(".articlePreview:nth-child(1) > .articlePreview__link")).click();
            WebElement title = driver.findElement(By.xpath("//p[contains(text(),'Путешествие на Восток')]"));

            WebElement deleteButton1 = wait.until(ExpectedConditions.elementToBeClickable(LocatorNotes.DeleteButton));
            deleteButton1.click();


            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='Путешествие на Восток']")));

            driver.findElement(By.cssSelector(".articlePreview:nth-child(1) > .articlePreview__link")).click();


            WebElement DeleteButton2 = wait.until(ExpectedConditions.elementToBeClickable(LocatorNotes.DeleteButton));
            DeleteButton2.click();



        }}






