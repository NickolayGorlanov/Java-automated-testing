package HomeMovies;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void findArrowBack() {
        driver.findElement(LocatorsMovies.arrowBack);
    }

    public void findLearnMore() {
        driver.findElement(LocatorsMovies.learnMore);
    }

    public void findInactiveFilters() {
        driver.findElement(LocatorsMovies.inactiveFilters);
    }

    public void findButtonClass() {
        driver.findElement(LocatorsMovies.buttonClass);
    }

    public void findSubscribeButton() {
        driver.findElement(LocatorsMovies.subscribeButton);
    }

    public void findClientsImage() {
        driver.findElement(LocatorsMovies.clientsImage);
    }
}
