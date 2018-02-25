Q1.	For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?

A1. I believe no. There is a slight performance boost while using xpath, but since in this project we are dealing with UI testing it does not make a difference.

Q2.	Modify existing tests to run on a real device. What should be changed?

A2. DeviceName should be changed to real device's "serial number" in DesiredCapabilities object used to init AppiumDriver.

Q3.	Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?

A3. I've noticed a minor decrease in performance, although I can't confidently say what is the reason.

Q4.	What should be improved/changed in existing test code? Why, for what?

A4. The usual suspects:
    - We need to get rid of thread.wait() (this is just criminal) and implement some kind of timed waiter;
    - All of hardcoded values should be replaced either by ENUM constants or values read from properties;
    - Our tests are not really tests, we should figure out what are we even testing and create pageObject classes;