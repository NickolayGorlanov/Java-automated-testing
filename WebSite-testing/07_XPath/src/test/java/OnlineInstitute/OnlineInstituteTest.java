package OnlineInstitute;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineInstituteTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.skillbox.ru/module16/maincatalog/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findLocatorsInstitute() {
        InstitutePage institutePage = new InstitutePage(driver);
        institutePage.findHeaderTitle();
        institutePage.findLastPeriodElement();
        institutePage.findParentLink();
        institutePage.findFiveElement();
        institutePage.findHeaderAllCourses();
    }

   
}
