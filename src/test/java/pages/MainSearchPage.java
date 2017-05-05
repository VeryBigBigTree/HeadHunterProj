package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainSearchPage extends Page {
    private WebElement searchBtn;
    private WebElement searchField;
    private WebElement dropdown;

    MainSearchPage(WebDriver driver) {
        this.driver = driver;
        waitTextOnPage("Группа компаний HeadHunter");
        searchField = driver.findElement(By.name("text"));
        searchBtn = driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div[2]/div/div[2]/form[1]/div/div[4]/button"));
        dropdown = driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div[2]/div/div[2]/form[1]/div/div[3]/select"));
    }

    public MainSearchPage fillTextToSearch(String text) {
        searchField.sendKeys(text);
        return this;
    }

    public MainSearchPage setDropdownItem(String text) {
        new Select(dropdown).selectByVisibleText(text);
        return this;
    }

    public SearchResultPage search() {
        try {
            searchBtn.click();
        } catch (ElementNotVisibleException e) {
            searchBtn = driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div[2]/div/div[2]/form[1]/div/div[3]/button"));
            searchBtn.click();
        }
        return new SearchResultPage(driver);
    }
}
