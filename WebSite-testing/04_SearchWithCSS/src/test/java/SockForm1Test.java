import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class SockForm1Test {
    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qajava.skillbox.ru/module04/homework/auth/index.html");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static class LocatorsFormSock1 {
        static By emailLocator = By.id("email");

        static By passwordLocator = By.name("password");


        static By buttonEnterLocator = By.className("form-submit");

        static By errorMessageLocator = By.id("error");

        static By forgotMessageLocator = By.className("form-description");
        static By forgotEmailLocator = By.id("forgot-email");
        static By forgotButtonLocator = By.cssSelector("button.form-submit-another");
        static By forgotMessageEmailLocator = By.cssSelector("pre.form-error");
        static By forgotNewEmailLocator = By.cssSelector("div.mail__message.animated.fadeInDown");



    }

    @Test
    public void enterFormSock() {

        driver.findElement(SockForm1Test.LocatorsFormSock1.emailLocator).sendKeys("@");
        driver.findElement(SockForm1Test.LocatorsFormSock1.passwordLocator).sendKeys("123");

        driver.findElement(SockForm1Test.LocatorsFormSock1.buttonEnterLocator).click();

        Assert.assertEquals("Некорректный email или пароль", driver.findElement(SockForm1Test.LocatorsFormSock1.errorMessageLocator).getText());


    }

    @Test
    public void forgotPasswordFormSock() {


        driver.findElement(By.linkText("Забыли пароль")).click();

        Assert.assertEquals("Введите e-mail, указанный при регистрации, и мы отправим новый пароль", driver.findElement(SockForm1Test.LocatorsFormSock1.forgotMessageLocator).getText());

        driver.findElement(LocatorsFormSock1.forgotEmailLocator).sendKeys("test@test.inf");
        driver.findElement(LocatorsFormSock1.forgotButtonLocator).click();
        Assert.assertEquals("Такой email не зарегистрирован", driver.findElement(LocatorsFormSock1.forgotMessageEmailLocator).getText());
        Assert.assertEquals("У вас новое письмо. Нажмите сюда, чтобы просмотреть.", driver.findElement(LocatorsFormSock1.forgotNewEmailLocator).getText());
        driver.navigate().refresh();
    }
}

