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
            driver.quit();
        }

    public static class LocatorsBookStore {
        static By aboutUs = By.xpath("//footer[@id='footer']//a[text()='О магазине']");
        static By bestSeller = By.xpath("//h1[text()='Бестселлеры']");
        static By serchString = By.xpath("//input[@id='search-input']");
        static By bookAdd = By.xpath("(//div[@class='book-price'][1]/button[@class='book-add'])[1]");

    }

    @Test

        public void FindLocatorsBookStore() {
        driver.get("https://qajava.skillbox.ru/index.html");
        driver.findElement(LocatorsBookStore.aboutUs);
        driver.findElement(LocatorsBookStore.bestSeller);
        driver.findElement(LocatorsBookStore.serchString);
        driver.findElement(LocatorsBookStore.bookAdd).click();
        }

        public static class LocatorTotalPrice {
            static By totalPrice = By.xpath("//div[@id='total']");
            static By yourOrdering = By.xpath("//div[contains(text(), 'Ваш заказ:')]");
            static By cancelButton = By.xpath("(//button[@class='filter-button' and text()='Отменить'])");
        }
    @Test

        public void FindTotalPrice(){
            driver.get("https://qajava.skillbox.ru/checkout.html");
            driver.findElement(LocatorTotalPrice.totalPrice);
            driver.findElement(LocatorTotalPrice.yourOrdering);
    }

    @Test
        public void SearchPage(){
            driver.get("https://qajava.skillbox.ru/search.html");
            driver.findElement(LocatorTotalPrice.cancelButton);

    }

    }





