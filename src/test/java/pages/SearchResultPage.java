package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultPage extends Page {
    SearchResultPage(WebDriver driver) {
        this.driver = driver;
        waitTextOnPage("Показать компании, у которых нет открытых вакансий");
    }
}
