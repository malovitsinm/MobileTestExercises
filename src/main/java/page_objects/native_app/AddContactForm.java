package page_objects.native_app;

import entities.nativeApp.Contact;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import utils.DriverBundle;

import static enums.CONTACT_MANAGER_CONSTANTS.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddContactForm extends BasePageNative {

    @iOSFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    private WebElement nameTextField;

    @iOSFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Name']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Name']")
    private WebElement nameTitle;

    @iOSFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    private WebElement phoneTextField;

    @iOSFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Phone']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Phone']")
    private WebElement phoneTitle;

    @iOSFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    private WebElement emailTextField;

    @iOSFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Email']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Email']")
    private WebElement emailTitle;

    @iOSFindBy(xpath = "//android.widget.Button[@content-desc='Save']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Save']")
    private WebElement saveButton;


    /**
     *  A method to send a String value using system keyboard to target WebElement
     *  @param text - String value to send
     *  @param target - target element to send keys using system keyboard
     * */
    public void sendKeysViaKeyboard(String text, WebElement target) {
        target.click();
        DriverBundle.getDriver().getKeyboard().sendKeys(text);
        assertEquals(target.getText(), text, target.toString() + " element's content doesn't match expected values");
    }


    /**
     * Checks label element according to following criteria:
     *  - Element is displayed
     *  - Element is enabled for usage
     *  - Element's content is equal to expected String
     *  @param label - element being checked
     *  @param expected - String value expected to be in element's text block
     * */
    private void checkLabel(WebElement label, String expected) {
        assertTrue(label.isDisplayed(), "label with expected value [" + expected + "] is not displayed");
        assertEquals(label.getText(), expected, "label content does not match ");
    }

    /**
     * Checks textFiled element according to following criteria:
     *  - Element is displayed
     *  - Element is enabled for usage
     *  - String sent using system keyboard is contained within element's text block
     *  @param textField - element being checked
     *  @param value - String value to input using system keyboard
     * */
    private void checkTextField(WebElement textField, String value) {
        assertTrue(textField.isDisplayed(), "text field with expected value [" + value + "] is not displayed");
        assertTrue(textField.isEnabled(), "text field with expected value [" + value + "] is not enabled");

        sendKeysViaKeyboard(value, textField);
        assertEquals(textField.getText(), value, "text field content does not match expected value");
    }

    public void checkLabels() {
        checkLabel(nameTitle, NAME.getText());
        checkLabel(phoneTitle, PHONE.getText());
        checkLabel(emailTitle, EMAIL.getText());
    }

    public void checkTextFields(Contact contact) {
        checkTextField(nameTextField, contact.getName());
        checkTextField(phoneTextField, contact.getPhone());
        checkTextField(emailTextField, contact.getEmail());
    }

    public void save(){
        saveButton.click();
    }

}
