//package BookStore;
//
//import org.junit.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BookStoreTest {
//
//        private WebDriver driver;
//
//        @Before
//        public void setUp() {
//            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//
//        @After
//        public void tearDown() {
//            driver.quit();
//        }
//
//    public static class LocatorsBookStore {
//        static By aboutUs = By.xpath("//footer[@id='footer']//a[text()='О магазине']");
//        static By bestSeller = By.xpath("//h1[text()='Бестселлеры']");
//        static By searchString = By.xpath("//input[@id='search-input']");
//        static By bookAddButton = By.xpath("(//div[@class='book-price'][1]/button[@class='book-add'])[1]");
//
//    }
//
//    @Test
//
//        public void FindLocatorsBookStore() {
//        driver.get("https://qajava.skillbox.ru/index.html");
//        driver.findElement(LocatorsBookStore.aboutUs);
//        driver.findElement(LocatorsBookStore.bestSeller);
//        driver.findElement(LocatorsBookStore.searchString);
//        driver.findElement(LocatorsBookStore.bookAddButton).click();
//        }
//
//        public static class LocatorTotalPrice {
//            static By totalPrice = By.xpath("//div[@id='total']");
//            static By yourOrdering = By.xpath("//div[contains(text(), 'Ваш заказ:')]");
//            static By cancelButton = By.xpath("(//button[@class='filter-button' and text()='Отменить'])");
//        }
//    @Test
//
//        public void FindTotalPrice(){
//            driver.get("https://qajava.skillbox.ru/checkout.html");
//            driver.findElement(LocatorTotalPrice.totalPrice);
//            driver.findElement(LocatorTotalPrice.yourOrdering);
//    }
//
//    @Test
//        public void SearchPage(){
//            driver.get("https://qajava.skillbox.ru/search.html");
//            driver.findElement(LocatorTotalPrice.cancelButton);
//
//    }
//
//    }
//
//
//
//
//
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






