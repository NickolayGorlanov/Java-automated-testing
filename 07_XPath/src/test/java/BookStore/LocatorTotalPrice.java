package BookStore;

import org.openqa.selenium.By;

public class LocatorTotalPrice {
    static By totalPrice = By.xpath("//div[@id='total']");
    static By yourOrdering = By.xpath("//div[contains(text(), 'Ваш заказ:')]");
    static By cancelButton = By.xpath("(//button[@class='filter-button' and text()='Отменить'])");
}
