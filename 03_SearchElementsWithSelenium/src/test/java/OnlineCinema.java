import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OnlineCinema {
    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {
       /* System.setProperty("webdriver.chrome.driver", "путь_к_драйверу/chromedriver");*/
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://lm.skillbox.cc/qa_tester/module07/practice3/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    //Проверка заполненных полей
    @Test
    public void FieldsAreFilled() {
        // Введите текст в поле "Ваши любимые фильмы"
        WebElement moviesInput = driver.findElement(By.id("films"));
        moviesInput.sendKeys("Интерстеллар");

        // Введите текст в поле "Ваши любимые сериалы"
        WebElement seriesInput = driver.findElement(By.id("serials"));
        seriesInput.sendKeys("Ведьмак");

        // Нажмите "Сохранить"
        WebElement saveButton = driver.findElement(By.id("save"));
        saveButton.click();

        // Нажмите на кнопку 2
        WebElement button2 = driver.findElement(By.id("two"));
        button2.click();

        // Нажмите на кнопку "ВВОД"
        WebElement enterButton = driver.findElement(By.id("save"));
        enterButton.click();

        // Нажмите на кнопку "ОК"
        WebElement okButton = driver.findElement(By.id("ok"));
        okButton.click();



        // Проверьте, что текст после нажатия "ОК" совпадает с введенным в поле "Ваши любимые фильмы"
        WebElement filmResult = driver.findElement(By.id("best_films"));
        assertEquals("Интерстеллар", filmResult.getText());

        // Проверьте, что текст после нажатия "ОК" совпадает с введенным в поле "Ваши любимые сериалы"
        WebElement serialResult = driver.findElement(By.id("best_serials"));
        assertEquals("Ведьмак", serialResult.getText());
        driver.navigate().refresh();
    }

    // Проверка, что нажат чек-бокс и нажата радио-кнопка
    @Test
    public void Switch() {
        // Введите текст в поле "Ваши любимые фильмы"
        WebElement moviesInput = driver.findElement(By.id("films"));
        moviesInput.sendKeys("Интерстеллар");

        // Введите текст в поле "Ваши любимые сериалы"
        WebElement seriesInput = driver.findElement(By.id("serials"));
        seriesInput.sendKeys("Ведьмак");

        // Нажмите "Сохранить"
        WebElement saveButton = driver.findElement(By.id("save"));
        saveButton.click();

        // Нажмите на кнопку 2
        WebElement button2 = driver.findElement(By.id("two"));
        button2.click();

        driver.findElement(By.cssSelector(".module__input:nth-child(4) .fake-checkbox")).click();
        driver.findElement(By.cssSelector(".module__input:nth-child(4) .fake-radiobutton")).click();



        // Нажмите на кнопку "ВВОД"
        WebElement enterButton = driver.findElement(By.id("save"));
        enterButton.click();

        // Нажмите на кнопку "ОК"
        WebElement okButton = driver.findElement(By.id("ok"));
        okButton.click();



        // Проверьте, что текст после нажатия "ОК" совпадает с введенным в поле "Ваши любимые фильмы"
        WebElement filmResult = driver.findElement(By.id("best_films"));
        assertEquals("Интерстеллар", filmResult.getText());

        // Проверьте, что текст после нажатия "ОК" совпадает с введенным в поле "Ваши любимые сериалы"
        WebElement serialResult = driver.findElement(By.id("best_serials"));
        assertEquals("Ведьмак", serialResult.getText());


        // Проверьте, что нажат чек-бокс
        WebElement textResult = driver.findElement(By.id("language"));
        assertEquals("В дубляже", textResult.getText());

        // Проверьте, что нажата радио-кнопка
        WebElement ageResult = driver.findElement(By.id("age"));
        assertEquals("31-35", ageResult.getText());


        driver.navigate().refresh();
    }




    // Проверка на пустые поля, не нажат чек-бокс, не нажата радио-кнопка
    @Test
    public void EmptyFields(){

        // Нажмите на кнопку 2
        WebElement button2 = driver.findElement(By.id("two"));
        button2.click();

        // Нажмите на кнопку "ВВОД"
        WebElement enterButton = driver.findElement(By.id("save"));
        enterButton.click();

        // Нажмите на кнопку "ОК"
        WebElement okButton = driver.findElement(By.id("ok"));
        okButton.click();
    }


}


