package page_objects.native_app;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverBundle;

import java.util.concurrent.TimeUnit;

public abstract class BasePageNative {
    protected BasePageNative() {
        PageFactory.initElements(
                new AppiumFieldDecorator(DriverBundle.getDriver(), 20, TimeUnit.SECONDS), this);
    }
}
