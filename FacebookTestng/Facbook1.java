import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import FacbookTestNg.LogInPage;

public class Facbook1 {
    WebDriver driver;
    LogInPage loginPage;

    @BeforeClass
    public void setUp() {
        // Set path to geckodriver (if required)
       

        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com");

        // Initialize the loginPage object
        loginPage = new LogInPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        loginPage.enterUsername();  // Enter username
        loginPage.enterPassword();  // Enter password
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void verification() {
        System.out.println("Credentials not valid");
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // Close the browser after tests
    }
}
