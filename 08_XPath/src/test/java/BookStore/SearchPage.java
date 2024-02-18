package BookStore;

import org.openqa.selenium.WebDriver;

public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cancelSearch() {
        driver.findElement(BookStoreTest.LocatorTotalPrice.cancelButton).click();
    }
}
