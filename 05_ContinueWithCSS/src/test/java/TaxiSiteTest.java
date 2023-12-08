import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class TaxiSiteTest {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        Map<String, Object> var = new HashMap<String, Object>();
        driver.manage().window().maximize();
        driver.get("https://lm.skillbox.cc/qa_tester/module04/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testForm() {
        driver.findElement(By.cssSelector("input:not([id])"));
        driver.findElement(By.cssSelector("p[class^='form']:not([class$='error'])"));
        driver.findElement(By.cssSelector("div.form-inner p.form-row:nth-child(1)"));
    }
}
