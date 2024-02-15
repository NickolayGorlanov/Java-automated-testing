import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoMostRegistrationFormTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://uae.videomost.com/service/welcome");
    }

    @ParameterizedTest(name = "Registration Test - Email: {0}, First Name: {1}, Last Name: {2}, Password: {3}, Confirm Password: {4}")
    @CsvSource({
            ",,,,",
            "email.domain.com,,,,",
            "@domain.com,,,,",
            "#@%^%#$@#$@#.com,,,,",
            "joe smith <email@domain.com>,,,,",
            "email@domain.com (joe smith),,,,",
            "email@domain@domain.com,,,,",
            ".email@domain.com,,,,",
            "email.@domain.com,,,,",
            "email..email@domain.com,,,,",
            "あいうえお@domain.com,,,,",
            "email@-domain.com,,,,",
            "email@.domain.com,,,,",
            "email@111.222.333.44444,,,,",
            "email@domain..com,,,,",
            ",Аб,,,,",
            ",Лсзвлмузхмтшййаяфэазыущцфосъшр,,,,",
            ",а,,,,",
            ",ёкбььуеэыгтддцдкечйчхъицекыанъщ,,,,",
            ",,,,,",
            ", ,,,,",
            ",-,,,,",
            ",--,,,,",
            ",gYsQZn,,,,",
            ",龍門大酒家,,,,",
            ",صسغذئآ,,,,",
            ",0123456789,,,,",
            ",,_=d;-A#b,,,,",
            ",,$b_.A|S!-=/-a+,A`S|?,,,,",
            ",_=d;-Ab,,,,",
            ",$b_.A|S!-=/-a+,A`S|?;,,,,",
            ",,,,,",
            ",gYsQZn,,,,",
            ",龍門大酒家,,,,",
            ",صسغذئآ,,,,",
            ",0123456789,,,,",
            ",АбвЦуКепрррр,,,,"
    })
    public void testRegistration(String email, String firstName, String lastName, String password, String cpassword) {
        fillRegistrationForm(email, firstName, lastName, password, cpassword);
        submitForm();
        assertRegistrationResult();
        goBackToRegistrationForm();
    }

    @Step("Нажать кнопку Sign Up")
    private void signUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.action-row > p:nth-child(1)")));
        submitButton.click();
    }

    @Step("Заполнение формы регистрации")
    private void fillRegistrationForm(String email, String firstName, String lastName, String password, String cpassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(3) > input[type=text]")));
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(4) > input[type=text]")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(5) > div.inp-with-eye > input[type=password]")));
        WebElement confirmPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("div:nth-child(6) > div.inp-with-eye > input[type=password]")));

        emailInput.clear();
        firstNameInput.clear();
        lastNameInput.clear();
        passwordInput.clear();
        confirmPasswordInput.clear();

        emailInput.sendKeys(email);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(cpassword);
    }

    @Step("Отправка формы регистрации")
    private void submitForm() {
        WebElement submitButton = driver.findElement(By.className(".button-sign-up"));
        submitButton.click();
    }

    @Step("Проверка результата регистрации")
    private void assertRegistrationResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Thanks for registration')]")));
        assertTrue(successMessage.isDisplayed());
    }

    @Step("Вернуться на страницу с формой")
    private void goBackToRegistrationForm() {
        WebElement backButton = driver.findElement(By.className("back-text"));
        backButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type=email]")));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
