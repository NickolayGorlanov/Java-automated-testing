import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class FindNelementTest {
    private static WebDriver driver;
    private static Map<String, Object> var;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static class LocatorsFindElement {


        static By locatorAboutUs = By.cssSelector("[test-info = about-us]");

        static By locatorEmptyLink = By.cssSelector("a[href = '']");
         static By locatorYears = By.cssSelector("[selected]");
        static By locatorBookPrice = By.cssSelector("div.book-price");
        static By locatorBookBegins = By.cssSelector("button[class^='book']");
        static By locatorMain = By.cssSelector("[class $= 'main']");
        static By locatorSubstring = By.cssSelector("a[class*='menu']");
        static By locatorFooter = By.cssSelector("footer > div");
        static By locatorMenuMain = By.cssSelector("li#genres + *");
        static By locatorFilterContainer = By.cssSelector(".filter-container + *");

         static By locatorSectionH1 = By.cssSelector("section.important-section-block > h1:first-child");
         static  By locatorLoginForm = By.cssSelector("#login-form > p:last-child");
        static By locatorFooterN3 = By.cssSelector("body > *:nth-child(3)");
         static By locatorFooterMenuList = By.cssSelector("div.footer__menuList > a:first-of-type");
        static By locatorFooterMenu = By.cssSelector("div.footer__menu > div.footer__menuList:nth-of-type(1) > a.footer__menuItem:nth-of-type(1)");


    }

    @Test
    public void enterFormSock() {
        driver.get("https://qajava.skillbox.ru/index.html");

        driver.findElement(LocatorsFindElement.locatorAboutUs);
        driver.findElement(LocatorsFindElement.locatorEmptyLink);


        driver.findElement(LocatorsFindElement.locatorBookPrice);
        driver.findElement(LocatorsFindElement.locatorBookBegins);
        driver.findElement(LocatorsFindElement.locatorMain);
        driver.findElement(LocatorsFindElement.locatorSubstring);
        driver.findElement(LocatorsFindElement.locatorFooter);
        driver.findElement(LocatorsFindElement.locatorMenuMain);


    }

    @Test
    public void FindPageBooks(){
        driver.get("https://qajava.skillbox.ru/search.html");
        driver.findElement(LocatorsFindElement.locatorYears);
        driver.findElement(LocatorsFindElement.locatorFilterContainer);
    }

    @Test
    public void HappySocksClub(){
        driver.get("https://qajava.skillbox.ru/module05/auth/index.html/");

        driver.findElement(LocatorsFindElement.locatorSectionH1);
        driver.findElement(LocatorsFindElement.locatorLoginForm);
        driver.findElement(LocatorsFindElement.locatorFooterN3);
        driver.findElement(LocatorsFindElement.locatorFooterMenuList);
        driver.findElement(LocatorsFindElement.locatorFooterMenu);

    }
}