package BookStore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BookStorePage {
    private final WebDriver driver;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAboutUs() {
        driver.findElement(BookStoreTest.LocatorsBookStore.aboutUs).click();
    }

    public void navigateToBestSellers() {
        driver.findElement(BookStoreTest.LocatorsBookStore.bestSeller).click();
    }

    public void searchFor(String searchTerm) {
        driver.findElement(BookStoreTest.LocatorsBookStore.searchString).sendKeys(searchTerm + Keys.ENTER);
    }

    public void addFirstBookToCart() {
        driver.findElement(BookStoreTest.LocatorsBookStore.bookAddButton).click();
    }
}
