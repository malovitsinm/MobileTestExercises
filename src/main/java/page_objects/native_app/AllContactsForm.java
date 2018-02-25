package page_objects.native_app;

import enums.CONTACT_MANAGER_CONSTANTS;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AllContactsForm extends BasePageNative {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Add Contact']")
    private WebElement addContactButton;

    /**
     * Checks page elements according to following criteria:
     *  - 'Add Contact' button is displayed
     *  - 'Add Contact' button is enabled for usage
     *  - 'Add Contact' button text is valid
     * */
    public void checkAddButton(){
        assertTrue(addContactButton.isDisplayed(), "'Add contact' button is not displayed");
        assertTrue(addContactButton.isEnabled(), "'Add contact' button is not enabled");
        assertEquals(addContactButton.getText(), CONTACT_MANAGER_CONSTANTS.ADDBTN.getText(),
                "'Add contact' button content does not match expected value");
    }

    public void addContact(){
        addContactButton.click();
    }
}
