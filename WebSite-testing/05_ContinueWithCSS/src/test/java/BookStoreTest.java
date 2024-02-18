import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class BookStoreTest {

    private WebDriver driver;
    private Map<String, Object> var;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        var = new HashMap<String, Object>();
        driver.manage().window().maximize();
        driver.get("https://qajava.skillbox.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBookStore() {

        // Найдите элементы
        WebElement feedbackLink = driver.findElement(By.linkText("Обратная связь"));
        WebElement preordersLink = driver.findElement(By.linkText("Предзаказы"));
        WebElement firstBookAddToCartButton = driver.findElement(By.xpath("(//button[@class='book-add'])[1]"));
        WebElement cartItemCount = driver.findElement(By.id("cart_count"));
        WebElement genresMenu = driver.findElement(By.id("genres"));
        WebElement searchInput = driver.findElement(By.id("search-input"));


        List<WebElement> bookInfoElements = driver.findElements(By.cssSelector("div.book-info"));

        // Проверьте, что их ровно 15
        assert (bookInfoElements.size() == 15);
    }
}

