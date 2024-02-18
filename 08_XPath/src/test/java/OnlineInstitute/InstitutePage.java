package OnlineInstitute;

import org.openqa.selenium.WebDriver;

public class InstitutePage {
    private final WebDriver driver;

    public InstitutePage(WebDriver driver) {
        this.driver = driver;
    }

    public void findHeaderTitle() {
        driver.findElement(LocatorsInstitute.headerTitle);
    }

    public void findLastPeriodElement() {
        driver.findElement(LocatorsInstitute.lastPeriodElement);
    }

    public void findParentLink() {
        driver.findElement(LocatorsInstitute.parentLink);
    }

    public void findFiveElement() {
        driver.findElement(LocatorsInstitute.fiveElement);
    }

    public void findHeaderAllCourses() {
        driver.findElement(LocatorsInstitute.headerAllCourses);
    }
}
