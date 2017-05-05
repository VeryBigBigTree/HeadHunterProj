package tests;

import org.testng.annotations.Test;
import pages.IntermediatePage;
import pages.MainSearchPage;
import pages.NovOblPage;
import pages.SearchResultPage;

import static org.testng.Assert.assertTrue;

public class HhTests extends Fixture {

    // TODO
    @Test
    public void searchCompany() {
        driver.get("https://spb.hh.ru");
        IntermediatePage intermediatePage = new IntermediatePage(driver);
        MainSearchPage mainSearchPage = intermediatePage.goToCorrectPage();
        SearchResultPage searchResultPage = mainSearchPage.fillTextToSearch("новые облачные")
                .setDropdownItem("Компании").search();
    }

    @Test
    public void checkJobsCount() {
        driver.get("https://spb.hh.ru/employer/213397");
        NovOblPage novOblPage = new NovOblPage(driver);
        assertTrue(novOblPage.getJobsCount() == 12);
    }

    @Test
    public void isJobExists() {
        driver.get("https://spb.hh.ru/employer/213397");
        NovOblPage novOblPage = new NovOblPage(driver);
        novOblPage.openRegionJobs();
        assertTrue(novOblPage.doesJobExist("Аналитик"));
    }
}
