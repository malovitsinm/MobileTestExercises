package page_objects.native_app;

import entities.nativeApp.Contact;
import enums.CONTACT_MANAGER_CONSTATNS;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverBundle;

import java.sql.Driver;

import static enums.CONTACT_MANAGER_CONSTATNS.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddContactForm extends BasePageNative {

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    private WebElement nameTextField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Name']")
    private WebElement nameTitle;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    private WebElement phoneTextField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Phone']")
    private WebElement phoneTitle;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    private WebElement emailTextField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Email']")
    private WebElement emailTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Save']")
    private WebElement saveButton;


    public void sendKeysViaKeyboard(String text, WebElement target) {
        target.click();
        DriverBundle.getDriver().getKeyboard().sendKeys(text);
        assertEquals(target.getText(), text, target.toString() + " element's content doesn't match expected values");
    }

    private void checkLabel(WebElement label, String expected) {
        assertTrue(label.isDisplayed(), "label with expected value [" + expected + "] is not displayed");
        assertEquals(label.getText(), expected, "label content does not match ");
    }

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
