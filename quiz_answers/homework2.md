>For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?

I believe no. There is a slight performance boost while using xpath, but since in this project we are dealing with UI testing it does not make a difference.

>Modify existing tests to run on a real device. What should be changed?

DeviceName should be changed to real device's "serial number" in DesiredCapabilities object used to init AppiumDriver.

>Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?

I've noticed a minor decrease in performance, although I can't confidently say what is the reason.

>What should be improved/changed in existing test code? Why, for what?

The usual suspects:
- We need to get rid of thread.wait() (this is just criminal) and implement some kind of timed waiter;
- All of hardcoded values should be replaced either by ENUM constants or values read from properties so all of the data would be stored in one place (a single change to code would not result in full project rebuild and would affect all of it's uses);
- Our tests are not really tests, we should figure out what are we even testing and create pageObject classes;