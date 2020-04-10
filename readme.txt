
This Document has 5 sections:
A] Pre-Requisits
B] Download Source Code
C] Import Code to Eclipse
D] Execution
E] Framework
F] Code Explanation


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
A] Pre-Requisits :
1) Dowload jdk 1.8
> url : https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
> Set JAVA_HOME path in windows ( url : https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html )
2) Download Eclipse IDE Mars (https://www.eclipse.org/downloads/packages/release/mars/2)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

B] Download Source Code :
> Go to below URL and download the source code zip file
 https://github.com/sonali0811/au.com.bunnings.git

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

C] Import Code to Eclipse :
> Extract the downloaded zip file in local system and import the project in Eclipse workspace
> Install "TestNG" Plugin from "Eclipse Marketplace"
> Right click on Project >> Go to "Build Path" >> Go to "Configure Build Path".
> Under "Libraries" tab, click on "Add Library" button and add "TestNG" libraries.
> Under "Libraries" tab, click on "Add External JARs" button and add Selenium and Apache POI jars available in "external-jars" folder of our project directory.
 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 

D] Run :
> Locate "testng.xml" file in our project directory
> Right click and select "Run As" >> TestNG Suite
> Execution will begin as follow :

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

E] Framework :
> Framework Structure : Hybrid Framework
I have used Hybrid Framework, that consists of 
i) Test Driver Framework : I've used TestNG to validate, assert end results & genertae Test reports
ii) Page Object Model : I've used Page Object Classes for Elements identification
ii) Data Driver Framework : I've read Test Data & congifuration data from Excel and properties file using Apache POI libraries.

> Under "src" >> Packages >> 
a) au.com.bunnings.lib.ui > Contains all Page Object Classes ( HomePage, Search Result Page, Product Details Page, Wishlist Page)
b) au.com.bunnings.lib.utils >
	CreateDriver.java - Class to initialize browser instance wrt data stored in config-data.properties file.
	DataHandlers.java - Class to read Test/configuration data from config-data.properties file and test-data.xlsx file.
c) au.com.bunnings.test.regression > Contains TestNG class "TestWishList.java".


> Folders >>
a) browser-servers >> Contains "chromedriver.exe" file.
b) config-data >> Contains " config-data.properties" file that has url and browser information. By changing url in this file we can run the same test for different environments.
c) test-data >> Contains "test-data.xlsx" file that has the test data used for Search in our Test Scenario.
d) external-jars >> Contains all the referenced libraries jar files such as "Selenium Java" and "Apache POI".
e) test-output/Suite >> Contains "TestNG" result reports such as "index.html" or " emailable-report.html.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

F] Code Explanation :
> TestNG Class "TestWishList" will get executed.
> Execution will start with BeforeMethod.
	- It will read configuration data from "config-data.properties" configuration file present under "config-data" folder by using "CreateDriver.java" 	  	  and "DataHandlers.java" classes present in "au.com.bunnings.lib.utils" package.
	- It will also initialize all required Page Object Classes present under "au.com.bunnings.lib.ui" package.
> After initializing driver & Page Object classes, Test Method will start execution.
> During execution of TestMethod "testWishListTC01()", it will use all required Page Object References and finally it will assert end results.
> After Execution of the test, AfterMethod functionality will Close the browser instance.
> For results please refer to "index.html" or " emailable-report.html" TestNG test result reports present under "test-output/Suites" folder in our project directory.