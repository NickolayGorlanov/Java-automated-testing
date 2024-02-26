package OnlineInstitute;

import org.openqa.selenium.By;

public  class LocatorsInstitute {
    static By headerTitle = By.xpath("(//span)[5]");
    static By lastPeriodElement = By.xpath("(//div[@class='baseCondition']//p)[last()]");
    static By parentLink = By.xpath("//a[@href='#']/parent::div");
    static By fiveElement = By.xpath("(//div[@class='baseCondition'])[5]");
    static By headerAllCourses = By.xpath("(//div[@class='pageCreate__title']/ancestor::div)");
}
