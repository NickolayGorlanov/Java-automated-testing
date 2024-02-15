

    import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

    public class MostTest {

        private WebDriver driver;
        private Map<String, Object> vars;
        JavascriptExecutor js;

        @BeforeEach
        public void setUp() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            js = (JavascriptExecutor) driver;
            vars = new HashMap<>();
        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }

        @ParameterizedTest
        @CsvSource({
                "#@%^%#$@#$@#.com,sjdhfsdjf,sjdhfsjhdf,jshdf123,jshdf123",
                // Add more variations as needed
        })
        public void testRegistration1(
                String email, String firstName, String lastName, String password, String confirmPassword) {
            driver.get("https://uae.videomost.com/service/welcome");
            driver.manage().window().setSize(new Dimension(1552, 832));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.action-row > p:nth-child(1)")));
            driver.findElement(By.cssSelector("div.action-row > p:nth-child(1)")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));

            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("firstname")).click();
            driver.findElement(By.name("firstname")).sendKeys(firstName);
            driver.findElement(By.name("lastname")).sendKeys(lastName);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.cssSelector(".form-entry:nth-child(5) .eye")).click();
            driver.findElement(By.cssSelector(".sup_wrap")).click();
            driver.findElement(By.name("cpassword")).click();
            driver.findElement(By.name("cpassword")).sendKeys(confirmPassword);
            driver.findElement(By.cssSelector(".sup_wrap")).click();
            driver.findElement(By.cssSelector(".button-sign-up")).click();

            // Add assertions or verifications for expected behavior with invalid characters
//            assertTrue(driver.getCurrentUrl().contains("some_expected_url_part"));

            driver.navigate().refresh();
        }

            @ParameterizedTest
            @CsvSource({
                    "@domain.com,Аб,龍門大酒家,_=d;-A#b,$b_.A|S!-=/-a+,A`S|?;",
                    // Add more variations as needed
            })
            public void testRegistration2(
                    String email, String firstName, String lastName, String password, String confirmPassword) {
                driver.get("https://uae.videomost.com/service/welcome");
                driver.manage().window().setSize(new Dimension(1552, 832));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.action-row > p:nth-child(1)")));
                driver.findElement(By.cssSelector("div.action-row > p:nth-child(1)")).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));

                driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("firstname")).click();
                driver.findElement(By.name("firstname")).sendKeys(firstName);
                driver.findElement(By.name("lastname")).sendKeys(lastName);
                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.cssSelector(".form-entry:nth-child(5) .eye")).click();
                driver.findElement(By.cssSelector(".sup_wrap")).click();
                driver.findElement(By.name("cpassword")).click();
                driver.findElement(By.name("cpassword")).sendKeys(confirmPassword);
                driver.findElement(By.cssSelector(".sup_wrap")).click();
                driver.findElement(By.cssSelector(".button-sign-up")).click();

                // Add assertions or verifications for expected behavior with invalid characters
//            assertTrue(driver.getCurrentUrl().contains("some_expected_url_part"));

//                driver.navigate().refresh();

            // Close the browser
            driver.close();
        }
    }


