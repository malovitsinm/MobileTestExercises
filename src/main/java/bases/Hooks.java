package bases;

import utils.DriverBundle;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {

    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext context) {
        DriverBundle.init(context);
    }

    @AfterSuite(groups = {"Native"})
    public void tearDownNative() {
        DriverBundle.getDriver().closeApp();
    }

    @AfterSuite(groups = {"Web"})
    public void tearDownWeb() {
        DriverBundle.getDriver().close();
    }
}
