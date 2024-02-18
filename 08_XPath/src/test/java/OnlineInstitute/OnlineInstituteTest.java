//package OnlineInstitute;
//
//import org.junit.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class OnlineInstituteTest {
//
//       private WebDriver driver;
//
//        @Before
//        public void setUp() {
//            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("http://qa.skillbox.ru/module16/maincatalog/");
//        }
//
//        @After
//        public void tearDown() {
//            driver.quit();
//        }
//
//    public static class LocatorsInstitute {
//        static By headerTitle = By.xpath("(//span[@class='baseCard__title'])[5]");
//        static By lastPeriodElement = By.xpath("(//div[@class='baseCondition'])[last()]");
//        static By parentforLink = By.xpath("//a[@href='#']/parent::div");
//
//        static By fiveElement = By.xpath("(//div[@class='baseCondition'])[5]");
//        static By headerAllCourses = By.xpath("(//div[@class='pageCreate__title']/ancestor::div)");
//    }
//
//
//    @Test
//        public void FindLocatorsInstitute() {
//
//        driver.findElement(LocatorsInstitute.headerTitle);
//        driver.findElement(LocatorsInstitute.lastPeriodElement);
//        driver.findElement(LocatorsInstitute.parentforLink);
//        driver.findElement(LocatorsInstitute.fiveElement);
//        driver.findElement(LocatorsInstitute.headerAllCourses);
//
//        }
//    }
//
//
//

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

    public static class LocatorsInstitute {
        static By headerTitle = By.xpath("(//span[@class='baseCard__title'])[5]");
        static By lastPeriodElement = By.xpath("(//div[@class='baseCondition'])[last()]");
        static By parentforLink = By.xpath("//a[@href='#']/parent::div");
        static By fiveElement = By.xpath("(//div[@class='baseCondition'])[5]");
        static By headerAllCourses = By.xpath("(//div[@class='pageCreate__title']/ancestor::div)");
    }
}
