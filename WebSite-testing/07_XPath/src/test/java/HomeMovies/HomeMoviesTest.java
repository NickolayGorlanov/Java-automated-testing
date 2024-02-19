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
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findLocatorsMovies() {
        HomePage homePage = new HomePage(driver);
        homePage.findArrowBack();
        homePage.findLearnMore();
        homePage.findInactiveFilters();
        homePage.findButtonClass();
        homePage.findSubscribeButton();
        homePage.findClientsImage();
    }


}
