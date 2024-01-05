import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

public class DeleteNotesTest {

    private WebDriver driver;
    private WebDriverWait wait;
    Duration seconds = Duration.ofSeconds(10);



    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, seconds);
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private final By note = By.cssSelector(".articlePreview__link");
    private final By title = By.cssSelector(".articlePreview__title");
    private final By text = By.cssSelector(".articlePreview__text");
    private final By titleIn = By.cssSelector(".baseInput__field");
    private final By textIn = By.cssSelector(".baseTextarea__text");
    private final By basket = By.cssSelector(".pageArticle__buttons .pageArticle__button:nth-of-type(2)");
    private final By writing = By.cssSelector(".articlePreview__link");

    @Test
    public void checkSite() {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        driver.findElement(note).click();
        Assert.assertEquals("Значения не совпадают", driver.findElement(title).getText(), driver.findElement(titleIn).getText());
        wait.until(ExpectedConditions.attributeToBe(textIn, "_value", driver.findElement(text).getText()));
        Assert.assertEquals("Значения не совпадают", driver.findElement(text).getText(), driver.findElement(textIn).getAttribute("_value"));
        driver.findElement(basket).click();
        driver.findElement(writing).click();
        driver.findElement(basket).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(writing));
        Assert.assertTrue(driver.findElement(writing).isDisplayed());
    }


}