package page_objects.web;

import entities.web.PanelContent;
import enums.PAGE_TITLES;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverBundle;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.DriverBundle.getBaseUrl;
import static utils.DriverBundle.getDriver;
import static utils.DriverBundle.getWaiter;

public class HomePage {
    /**
     * Checks text content of main section of site's home page
     *
     * @param entity - PanelContent type object representing full text content from one of the panel sections
     *               of the main page
     */
    public void checkPanelsContent(PanelContent entity) {
        String baseLocator = entity.getBlockLocator();

        WebElement title = DriverBundle.getDriver().findElement(By.cssSelector(baseLocator + " a"));
        WebElement content = DriverBundle.getDriver().findElement(By.cssSelector(baseLocator + " p"));
        List<WebElement> links = DriverBundle.getDriver().findElements(By.cssSelector(baseLocator + " li"));

        assertTrue(title.isDisplayed(), "Title of " + baseLocator + " block doesn't match");
        assertEquals(title.getText(), entity.getTitle(), "Title of " + baseLocator + " block isn't displayed");

        assertTrue(content.isDisplayed(), "Content of " + baseLocator + " block isn't displayed");
        assertEquals(content.getText(), entity.getBodyContent(), "Content of " + baseLocator + " block doesn't match");

        assertEquals(links.size(), entity.getLinkList().size());
        for (int i = 0; i < entity.getLinkList().size(); i++) {
            assertTrue(
                    links.get(i).isDisplayed(),
                    "List element " + entity.getLinkList().get(i) + " of " + baseLocator + " block isn't displayed");
            assertEquals(
                    links.get(i).getText(),
                    entity.getLinkList().get(i),
                    "List element of " + baseLocator + " block doesn't match");
        }
    }

    /**
     * Checks validity of header links on main section of site's home page
     */
    public void checkLinks() {
        for(int i = 0; i < PAGE_TITLES.values().length; i++) {
            WebElement curElem = (WebElement) getDriver().findElements(By.cssSelector("#home-panels h2 a")).get(i);
            String linkURL = curElem.getAttribute("href");

            curElem.click();
            getWaiter().until(ExpectedConditions.urlToBe(linkURL));

            assertEquals(getDriver().getTitle(), PAGE_TITLES.values()[i].getName());
            assertEquals(getDriver().getCurrentUrl(), linkURL);

            getDriver().get(getBaseUrl());
            getWaiter().until(ExpectedConditions.urlToBe(getBaseUrl()));
        }

    }

    /**
     * Method for navigating to current page according to pageObject pattern
     * */
    public void open() {
        getDriver().get(getBaseUrl());
        getWaiter().until(ExpectedConditions.urlToBe(getBaseUrl()));
    }

}
