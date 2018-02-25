>Q1: Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?

Well, yes. The whole idea of this pattern is beneficial in our case.
It's implementation guaranties us that only one instance of AppiumDriver and WebDriverWait is available at one moment.
Although it's current realisation can't be used to run test in parallel. I've tried to fix it by implementing Double-checked locking.

>Q2: Suggest improvements for .properties reading. What are the purposes?

- Hardcode is gone as should be, obviously.
- I ensured that property keys would be identical to MobileCapabilities group of consts to reduce their total amount. 
- Also the configuration for Driver is passed through TestNG TestContext using <code>\<parameter\></code> value.
Which didn't become a silver bullet I hoped it would be since tearDown method still exists in two instances separted by testNg groups. 
Though I think it's still a neat trick.
>Q3: Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test.

Done.

>Q4: Add keyboard presence check in “native” test.

Done.(Although it's became kind of integral to the test itself)

>Q5: Which checks would you place in the “web” test?

The default test coverage should contain checking general functionality of the website. Which can include:  
- The main information text blocks are visible and contain valid information;
- The navigation between pages is available through main section titles

>Q6: Implement checks for “web” test in code and try to use.

Done.
