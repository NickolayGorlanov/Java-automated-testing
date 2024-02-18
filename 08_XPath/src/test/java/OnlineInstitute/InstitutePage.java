package OnlineInstitute;

import org.openqa.selenium.WebDriver;

public class InstitutePage {
    private final WebDriver driver;

    public InstitutePage(WebDriver driver) {
        this.driver = driver;
    }

    public void findHeaderTitle() {
        driver.findElement(OnlineInstituteTest.LocatorsInstitute.headerTitle);
    }

    public void findLastPeriodElement() {
        driver.findElement(OnlineInstituteTest.LocatorsInstitute.lastPeriodElement);
    }

    public void findParentLink() {
        driver.findElement(OnlineInstituteTest.LocatorsInstitute.parentforLink);
    }

    public void findFiveElement() {
        driver.findElement(OnlineInstituteTest.LocatorsInstitute.fiveElement);
    }

    public void findHeaderAllCourses() {
        driver.findElement(OnlineInstituteTest.LocatorsInstitute.headerAllCourses);
    }
}
