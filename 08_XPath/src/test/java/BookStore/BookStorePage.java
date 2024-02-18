package BookStore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BookStorePage {
    private final WebDriver driver;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAboutUs() {
        driver.findElement(LocatorsBookStore.aboutUs).click();
    }

    public void navigateToBestSellers() {
        driver.findElement(LocatorsBookStore.bestSeller).click();
    }

    public void searchFor(String searchTerm) {
        driver.findElement(LocatorsBookStore.searchString).sendKeys(searchTerm + Keys.ENTER);
    }

    public void addFirstBookToCart() {
        driver.findElement(LocatorsBookStore.bookAddButton).click();
    }


}
