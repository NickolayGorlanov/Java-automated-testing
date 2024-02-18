package HomeMovies;


import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void findArrowBack() {
        driver.findElement(HomeMoviesTest.LocatorsMovies.arrowBack);
    }

    public void findLearnMore() {
        driver.findElement(HomeMoviesTest.LocatorsMovies.learnMore);
    }

    public void findInactiveFilters() {
        driver.findElement(HomeMoviesTest.LocatorsMovies.inactiveFilters);
    }

    public void findButtonClass() {
        driver.findElement(HomeMoviesTest.LocatorsMovies.buttonClass);
    }

    public void findSubscribeButton() {
        driver.findElement(HomeMoviesTest.LocatorsMovies.subscribeButton);
    }

    public void findClientsImage() {
        driver.findElement(HomeMoviesTest.LocatorsMovies.clientsImage);
    }
}

