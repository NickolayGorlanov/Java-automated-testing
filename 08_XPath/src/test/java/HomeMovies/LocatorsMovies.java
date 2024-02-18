package HomeMovies;

import org.openqa.selenium.By;

public class LocatorsMovies {
    static By arrowBack = By.xpath("//span[@class='da-arrows-prev']");
    static By learnMore = By.xpath("//div[@id='da-slider']//div[1]//a[@class='da-link button']");
    static By inactiveFilters = By.xpath("//ul[@class='nav nav-pills']/li[@class='filter' and not(@class='active')]");
    static By buttonClass = By.xpath("//*[starts-with(@class, 'button')]");
    static By subscribeButton = By.xpath("//a[text()='Подписаться сейчас']");
    static By clientsImage = By.xpath("//ul[@class='row client-slider']//li//img");
}
