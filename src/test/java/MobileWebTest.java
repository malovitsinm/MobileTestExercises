import bases.Hooks;
import data_providers.WebTestPanelsContentProvider;
import entities.web.PanelContent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.web.HomePage;

import static utils.DriverBundle.*;

@Test(groups = {"Web"})
public class MobileWebTest extends Hooks {
    private HomePage homePage;

    @BeforeClass
    public void initPageObjects() {
        homePage = PageFactory.initElements(getDriver(), HomePage.class);
    }


    @Test(dataProvider = "homePageContentTestDP", dataProviderClass = WebTestPanelsContentProvider.class)
    public void homePageContentTest(PanelContent panelContent) {
        homePage.open();
        homePage.checkPanelsContent(panelContent);

    }

    @Test
    public void homePageLinksTest() {
        homePage.open();
        homePage.checkLinks();
    }
}
