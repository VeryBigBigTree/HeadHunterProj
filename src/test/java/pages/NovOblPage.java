package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovOblPage extends Page {
    public NovOblPage(WebDriver driver) {
        this.driver = driver;
        waitTextOnPage("Безопасный HeadHunter");
    }

    public int getJobsCount() {
        return Integer.valueOf(driver.findElement(By.className("b-employerpage-vacancies-hint")).getText());
    }

    public NovOblPage openRegionJobs() {
        driver.findElement(By.linkText("Информационные технологии, интернет, телеком")).click();
        return this;
    }

    public boolean doesJobExist(String job) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        By jobEl = By.xpath("//table[@class='l-table']//div[.='" + job + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobEl));
        return (driver.findElements(jobEl).size() != 0);
    }
}
