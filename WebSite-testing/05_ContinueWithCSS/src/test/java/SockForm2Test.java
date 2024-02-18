import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class SockForm2Test {

    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static class LocatorsFormSock2 {
        static By emailLocator = By.cssSelector("input#email.form-input");

        static By passwordLocator = By.cssSelector("input#password.form-input");


        static By buttonEnterLocator = By.cssSelector("button#submit.form-submit");

        static By errorMessageLocator = By.cssSelector("pre#error.form-error-password-email");

        static By forgotEmailLocator = By.id("forgot-email");

        static By forgotMessageLocator = By.className("form-description");
        static By forgotButtonLocator = By.cssSelector("button.form-submit-another");
        static By forgotMessageEmailLocator = By.cssSelector("pre.form-error");
        static By forgotNewEmailLocator = By.cssSelector("div.mail__message.animated.fadeInDown");



    }

    @Test
    public void enterFormSock() {

        driver.findElement(SockForm2Test.LocatorsFormSock2.emailLocator).sendKeys("@");
        driver.findElement(SockForm2Test.LocatorsFormSock2.passwordLocator).sendKeys("123");

        driver.findElement(SockForm2Test.LocatorsFormSock2.buttonEnterLocator).click();

        Assert.assertEquals("Некорректный email или пароль", driver.findElement(SockForm2Test.LocatorsFormSock2.errorMessageLocator).getText());

        driver.navigate().refresh();
    }

    @Test
    public void forgotPasswordFormSock() {


        driver.findElement(By.linkText("Забыли пароль")).click();

        Assert.assertEquals("Введите e-mail, указанный при регистрации, и мы отправим новый пароль", driver.findElement(SockForm2Test.LocatorsFormSock2.forgotMessageLocator).getText());


        driver.findElement(SockForm2Test.LocatorsFormSock2.forgotEmailLocator).sendKeys("test@test.inf");
        driver.findElement(SockForm2Test.LocatorsFormSock2.forgotButtonLocator).click();
        Assert.assertEquals("Такой email не зарегистрирован", driver.findElement(SockForm2Test.LocatorsFormSock2.forgotMessageEmailLocator).getText());
        Assert.assertEquals("У вас новое письмо. Нажмите сюда, чтобы просмотреть.", driver.findElement(SockForm2Test.LocatorsFormSock2.forgotNewEmailLocator).getText());
        driver.navigate().refresh();
    }
}


