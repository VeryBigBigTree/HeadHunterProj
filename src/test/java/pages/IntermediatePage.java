package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntermediatePage extends Page {
    private WebElement searchBtn;

    public IntermediatePage(WebDriver driver) {
        this.driver = driver;
        waitTextOnPage("Группа компаний HeadHunter");
        searchBtn = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/div[2]/form[1]/div/div[3]/button"));
    }

    public MainSearchPage goToCorrectPage() {
        searchBtn.click();
        return new MainSearchPage(driver);
    }
}
