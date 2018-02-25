import bases.Hooks;
import entities.nativeApp.Contact;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.native_app.AddContactForm;
import page_objects.native_app.AllContactsForm;


@Test(groups = {"Native"})
public class MobileAppTest extends Hooks{
    private AllContactsForm allContacts;
    private AddContactForm addContactForm;

    @BeforeClass
    public void initPages() {
        allContacts = new AllContactsForm();
        addContactForm = new AddContactForm();
    }


    @Test
    public void contactManagerTest(){
        allContacts.checkAddButton();
        allContacts.addContact();

        addContactForm.checkLabels();
        addContactForm.checkTextFields(Contact.IGOR);
        addContactForm.save();
    }
}
