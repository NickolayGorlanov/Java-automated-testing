import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShuesSaleTest {


    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        var = new HashMap<String, Object>();
        driver.manage().window().maximize();
        driver.get("https://lm.skillbox.cc/qa_tester/module03/practice1/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void SizeCorrect() {

        enterSizeAndClickButton("41");
        driver.findElement(By.id("check-size-button")).click();
        assertThat(driver.findElement(By.id("size-success")).getText(), is("В нашем магазине есть обувь вашего размера"));
        assertThat("Текст не совпадает", driver.findElement(By.id("size-success")).getText(), is("В нашем магазине есть обувь вашего размера"));
    }


    @Test
    public void SizeIncorrect() {


        enterSizeAndClickButton("0");
        assertThat(driver.findElement(By.id("size-error")).getText(), is("В нашем магазине нет обуви вашего размера"));

        enterSizeAndClickButton("45");
        assertThat(driver.findElement(By.id("size-error")).getText(), is("В нашем магазине нет обуви вашего размера"));

        enterSizeAndClickButton("AAA");
        assertThat(driver.findElement(By.id("size-error")).getText(), is("Введите размер обуви!"));


    }


    private void enterSizeAndClickButton(String size) {
        WebElement sizeInput = driver.findElement(By.id("size"));
        sizeInput.clear();  // Очистить поле ввода
        sizeInput.sendKeys(size);
        driver.findElement(By.id("check-size-button")).click();
    }

}


