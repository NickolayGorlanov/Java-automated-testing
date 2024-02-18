package HomeMovies;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeMoviesTest {


    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.skillbox.ru/module19/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public static class LocatorsMovies {
        static By arrowBack = By.xpath("//span[@class='da-arrows-prev']");
        static By learnMore = By.xpath("//div[@id='da-slider']//div[1]//a[@class='da-link button']");
        static By inactiveFilters = By.xpath("//ul[@class='nav nav-pills']/li[@class='filter' and not(@class='active')]");
        static By buttonClass = By.xpath("//*[starts-with(@class, 'button')]");
        static By subscribeButton = By.xpath("//a[text()='Подписаться сейчас']");
        static By clientsImage = By.xpath("//ul[@class='row client-slider']//li//img");
    }


    @Test
    public void FindLocatorsMovies() {
    driver.findElement(LocatorsMovies.arrowBack);
    driver.findElement(LocatorsMovies.learnMore);
    driver.findElement(LocatorsMovies.inactiveFilters);
    driver.findElement(LocatorsMovies.buttonClass);
    driver.findElement(LocatorsMovies.subscribeButton);
    driver.findElement(LocatorsMovies.clientsImage);

    }
}

