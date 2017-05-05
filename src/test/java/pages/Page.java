package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    private final long timeout = 10;

    protected Page waitTextOnPage(String pageLoadedText) {
        (new WebDriverWait(driver, timeout)).until(
                (ExpectedCondition<Boolean>) d -> d.getPageSource().contains(pageLoadedText));
        return this;
    }
}
