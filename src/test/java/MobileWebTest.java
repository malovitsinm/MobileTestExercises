import bases.Hooks;
import data_providers.WebTestPanelsContentProvider;
import entities.web.PanelContent;
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
        getDriver().navigate().to(getBaseUrl());
        System.out.println(getDriver().getCurrentUrl());
        getWaiter().until(ExpectedConditions.urlToBe(getBaseUrl()));
    }
}
