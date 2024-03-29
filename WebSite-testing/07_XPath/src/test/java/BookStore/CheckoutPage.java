package BookStore;

import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getTotalPrice() {
        driver.findElement(LocatorTotalPrice.totalPrice);
    }

    public void getYourOrdering() {
        driver.findElement(LocatorTotalPrice.yourOrdering);
    }
}
