
package BookStore;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookStoreTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findLocatorsBookStore() {
        driver.get("https://qajava.skillbox.ru/index.html");
        BookStorePage bookStorePage = new BookStorePage(driver);
        bookStorePage.navigateToAboutUs();
        bookStorePage.navigateToBestSellers();
        bookStorePage.searchFor("book");
        bookStorePage.addFirstBookToCart();
    }

    @Test
    public void findTotalPrice() {
        driver.get("https://qajava.skillbox.ru/checkout.html");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getTotalPrice();
        checkoutPage.getYourOrdering();
    }

    @Test
    public void searchPage() {
        driver.get("https://qajava.skillbox.ru/search.html");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.cancelSearch();
    }

}






