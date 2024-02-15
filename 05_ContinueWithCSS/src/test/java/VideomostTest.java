import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VideomostTest {

    private static WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;

    @BeforeAll
    public static void setUpClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDownClass() {
        // Close the browser after all tests
        driver.quit();
    }

    @BeforeEach
    public void setUp() {
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    private void registerUser(String email, String firstName, String lastName, String password, String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://uae.videomost.com/service/welcome");

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
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    public void testRegistration(
            String email, String name, String password) {
        // Тестирование поля email
        registerUser(email, "GeneratedFirstName", "GeneratedLastName", "GeneratedPassword", "GeneratedPassword");
        performTest("Email", email);

        // Тестирование поля firstname
        registerUser(generateRandomEmail(), name, "GeneratedLastName", "GeneratedPassword", "GeneratedPassword");
        performTest("FirstName", name);

        // Тестирование поля lastname
        registerUser(generateRandomEmail(), generateRandomName(), name, "GeneratedPassword", "GeneratedPassword");
        performTest("LastName", name);

        // Тестирование поля password
        registerUser(generateRandomEmail(), generateRandomName(), generateRandomName(), password, "GeneratedPassword");
        performTest("Password", password);

        // Тестирование поля cpassword
        registerUser(generateRandomEmail(), generateRandomName(), generateRandomName(), "GeneratedPassword", password);
        performTest("CPassword", password);

        // Остальные поля тестируются сгенерированными данными
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String generateRandomEmail() {
        int randomNum = (int) (1 + Math.random() * 999); // Генерация случайного числа от 1 до 999
        return "qatest" + randomNum + "@mitico.org";
    }

    private void performTest(String fieldName, String expectedValue) {
        driver.findElement(By.cssSelector(".button-sign-up")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        if (confirmationMessageVisible()) {
            WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success_wrap .send-info p")));
            Assertions.assertEquals("Thanks for registration", confirmationMessage.getText());
            System.out.println("Registration successful for " + fieldName + ": " + expectedValue);
        } else {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error_wrap .send-info p")));
            System.out.println("Registration failed for " + fieldName + ": " + expectedValue + " with error: " + errorMessage.getText());
        }

        driver.navigate().refresh(); // Refresh the page for the next test
    }

    private boolean confirmationMessageVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success_wrap .send-info p")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}







//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//public class VideomostTest {
//
//    private static WebDriver driver;
//    private Map<String, Object> vars;
//    private JavascriptExecutor js;
//
//    @BeforeAll
//    public static void setUpClass() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        driver = new ChromeDriver(options);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        driver.manage().window().maximize();
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//        // Close the browser after all tests
//        driver.quit();
//    }
//
//    @BeforeEach
//    public void setUp() {
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<>();
//    }
//
//    private void registerUser(String email, String firstName, String lastName, String password, String confirmPassword) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        driver.get("https://uae.videomost.com/service/welcome");
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.action-row > p:nth-child(1)")));
//        driver.findElement(By.cssSelector("div.action-row > p:nth-child(1)")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
//
//        driver.findElement(By.name("email")).sendKeys(email);
//        driver.findElement(By.name("firstname")).click();
//        driver.findElement(By.name("firstname")).sendKeys(firstName);
//        driver.findElement(By.name("lastname")).sendKeys(lastName);
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.cssSelector(".form-entry:nth-child(5) .eye")).click();
//        driver.findElement(By.cssSelector(".sup_wrap")).click();
//        driver.findElement(By.name("cpassword")).click();
//        driver.findElement(By.name("cpassword")).sendKeys(confirmPassword);
//        driver.findElement(By.cssSelector(".sup_wrap")).click();
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
//    public void testRegistration(
//            String email, String name, String password) {
//        registerUser(email, name, password, password, password);
//
//        driver.findElement(By.cssSelector(".button-sign-up")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success_wrap .send-info p")));
//
//        Assertions.assertEquals("Thanks for registration", confirmationMessage.getText());
//
//        driver.navigate().refresh(); // Refresh the page for the next test
//    }
//}
