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

        /*Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>.
        Осуществите поиск только по атрибуту test-info, равному about-us.
         */
        static By locatorAboutUs = By.cssSelector("[test-info = about-us]");
        /*Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».*/
        static By locatorEmptyLink = By.cssSelector("a[href = '']");
        /*
                Локатор на странице поиска для всех элементов с тегом option и с атрибутом selected. Осуществите поиск только по атрибуту selected.*/
        static By locatorYears = By.cssSelector("[selected]");
        /*
                Локатор на главной странице для элемента <div class="book-price">. Осуществите поиск одновременно по тегу и классу, равному book-price.*/
        static By locatorBookPrice = By.cssSelector("div.book-price");
        /*
                Локатор на главной странице для всех элементов с тегом button и с атрибутом class, начинающимся на book.*/
        static By locatorBookBegins = By.cssSelector("button[class^='book']");
        /*
                Локатор на главной странице для всех элементов, у которых атрибут class заканчивается на main.*/
        static By locatorMain = By.cssSelector("[class $= 'main']");
        /*
                Локатор на главной странице для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.*/
        static By locatorSubstring = By.cssSelector("a[class*='menu']");
        /*
                На главной странице найдите все теги div, которые являются дочерними элементами первого уровня у элемента <footer id="footer">.*/
        static By locatorFooter = By.cssSelector("footer > div");
        /*
                На главной странице найдите любой тег, который расположен сразу после <li id="genres">.*/
        static By locatorMenuMain = By.cssSelector("li#genres + *");
        /*
                На странице поиска найдите любые теги, которые расположены после <div class="filter-container"> (необязательно ближайший сосед).*/
        static By locatorFilterContainer = By.cssSelector(".filter-container > *");
        /*
                Первый тег h1, находящийся сразу на первом уровне вложенности внутри <section class="important-section-block" for="main-header-page">. Используйте поиск по первому child.*/
        static By locatorSectionH1 = By.cssSelector("section.important-section-block > h1:first-child");
        /*
                Последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">. Используйте поиск по child.*/
        static By locatorLoginForm = By.cssSelector("#login-form > p:last-child");
        /*
                Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.*/
        static By locatorFooterN3 = By.cssSelector("body > *:nth-child(3)");
        /*
                Все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">. Используйте поиск по type.*/
        static By locatorFooterMenuList = By.cssSelector("div.footer__menuList > a:first-of-type");
        /*
                По желанию: найдите элемент с тегом <a>, который является первым дочерним элементом данного типа у своего родителя <div class="footer__menuList">,
                при этом <div class="footer__menuList"> является первым дочерним элементом у своего родителя <div class="footer__menu">. Составленный поиск должен вернуть ровно один найденный элемент.*/
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
    public void FindPageBooks() {
        driver.get("https://qajava.skillbox.ru/search.html");
        driver.findElement(LocatorsFindElement.locatorYears);
        driver.findElement(LocatorsFindElement.locatorFilterContainer);
    }

    @Test
    public void HappySocksClub() {
        driver.get("https://qajava.skillbox.ru/module05/auth/index.html/");

        driver.findElement(LocatorsFindElement.locatorSectionH1);
        driver.findElement(LocatorsFindElement.locatorLoginForm);
        driver.findElement(LocatorsFindElement.locatorFooterN3);
        driver.findElement(LocatorsFindElement.locatorFooterMenuList);
        driver.findElement(LocatorsFindElement.locatorFooterMenu);

    }
}