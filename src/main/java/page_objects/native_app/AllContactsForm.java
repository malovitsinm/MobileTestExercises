package page_objects.native_app;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AllContactsForm extends BasePageNative {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Add Contact']")
    private WebElement addContactButton;

    public void checkAddButton(){
        assertTrue(addContactButton.isDisplayed(), "'Add contact' button is not displayed");
        assertTrue(addContactButton.isEnabled(), "'Add contact' button is not enabled");
        assertEquals(addContactButton.getText(), "Add Contact",
                "'Add contact' button content does not match expected value");
    }

    public void addContact(){
        addContactButton.click();
    }
}
