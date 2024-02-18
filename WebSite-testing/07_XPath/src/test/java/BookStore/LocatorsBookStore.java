package BookStore;

import org.openqa.selenium.By;

public class LocatorsBookStore {
    static By aboutUs = By.xpath("//footer[@id='footer']//a[text()='О магазине']");
    static By bestSeller = By.xpath("//h1[text()='Бестселлеры']");
    static By searchString = By.xpath("//input[@id='search-input']");
    static By bookAddButton = By.xpath("(//div[@class='book-price'][1]/button[@class='book-add'])[1]");
}
