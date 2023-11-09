import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*import java.util.*;*/

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

    private static WebDriver driver;

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


}
