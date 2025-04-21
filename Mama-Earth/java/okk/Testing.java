package okk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Testing {

    public static void main(String[] args) throws InterruptedException ,ClassNotFoundException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Adjust as needed

        String baseUrl = "https://magento.softwaretestingboard.com/";

        // Test 1: Home Page Load
        driver.get(baseUrl);
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("Page URL: " + currentUrl);
        System.out.println("Page Title: " + title);
        assert currentUrl.equals(baseUrl) : "URL mismatch: Expected " + baseUrl + ", Actual " + currentUrl;
        assert title.equals("Magento Demo Store") : "Title mismatch: Expected 'Magento Demo Store', Actual " + title;
        System.out.println("Home Page Test Passed");

        // Test 2: Navigate to Jackets
        Actions actions = new Actions(driver);
        WebElement menMenu = driver.findElement(By.id("ui-id-5")); // Adjust locator if needed
        WebElement topsMenu = driver.findElement(By.id("ui-id-17")); // Adjust locator if needed
        WebElement jacketsMenu = driver.findElement(By.id("ui-id-19")); // Adjust locator if needed

        actions.moveToElement(menMenu).moveToElement(topsMenu).click(jacketsMenu).build().perform();

        currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals(baseUrl + "men/tops-men/jackets-men.html") : "URL mismatch: Expected " + (baseUrl + "men/tops-men/jackets-men.html") + ", Actual " + currentUrl;
        System.out.println("Navigate to Jackets Test Passed");

        // Test 3: Filter Hoodies
        WebElement menMenu1 = driver.findElement(By.id("ui-id-5")); // Adjust locator if needed
        WebElement topsMenu1 = driver.findElement(By.id("ui-id-17")); // Adjust locator if needed
        WebElement jacketsMenu1 = driver.findElement(By.id("ui-id-20"));
        actions.moveToElement(menMenu1).moveToElement(topsMenu1).click(jacketsMenu1).build().perform();
        // Add assertion to check if hoodies are displayed
        System.out.println("Filter Hoodies Test Executed");

        // Test 4: Filter Price
        WebElement priceCheckbox = driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[10]"));
        priceCheckbox.click();
        WebElement priceCheckbox1 = driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[10]/div[2]/ol/li[2]/a"));
        priceCheckbox1.click();
        // Add assertion to check if hoodies are displayed
        System.out.println("Filter Price Test Executed (Assertion needs to be added)");

        // Test 5: Add to Cart
        WebElement productLink = driver.findElement(By.xpath("//li[1]//div[1]//a[1]//span[1]//span[1]//img[1]")); // Update the xpath
        productLink.click();

        WebElement size = driver.findElement(By.xpath("//div[@aria-label='XL']")); // Update the xpath
        size.click();

        WebElement color = driver.findElement(By.xpath("//div[@aria-label='Black']")); // Update the xpath
        color.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@title='Add to Cart']")); // Update the xpath
        addToCartButton.click();
        // Add assertion to check if hoodies are displayed
        System.out.println("Add to Cart Test Executed (Assertion needs to be added)");
        Thread.sleep(5000);
        // Test 6: Checkout
        WebElement cartLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")); // Update the xpath
        cartLink.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id='top-cart-btn-checkout\']" ) ); // Update the xpath
        checkoutButton.click();
        
        Thread.sleep(10000);
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id='customer-email']")); // Update the xpath
        Thread.sleep(5000);
        emailAddress.sendKeys("test@gmail.com");

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']")); // Update the xpath
        firstName.sendKeys("Test");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']")); // Update the xpath
        lastName.sendKeys("user");

        WebElement streetAddress = driver.findElement(By.xpath("//input[@name='street[0]']")); // Update the xpath
        streetAddress.sendKeys("street address");

        WebElement city = driver.findElement(By.xpath("//input[@name='city']")); // Update the xpath
        city.sendKeys("jalandhar");

        WebElement state = driver.findElement(By.xpath("//select[@name='region_id']")); // Update the xpath
        state.sendKeys("jalandhar");

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='postcode']")); // Update the xpath
        zipCode.sendKeys("144411");

        WebElement country = driver.findElement(By.xpath("//select[@name='country_id']")); // Update the xpath
        country.sendKeys("India");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='telephone']")); // Update the xpath
        phoneNumber.sendKeys("1234567890");

        WebElement shippingButton = driver.findElement(By.xpath("//button[@data-role='opc-continue']//span")); // Update the xpath
        shippingButton.click();

        WebElement paymentButton = driver.findElement(By.xpath("//button[@title='Place Order']//span")); // Update the xpath
        paymentButton.click();

        // Add assertion to check if hoodies are displayed
        System.out.println("Checkout Test Executed (Assertion needs to be added)");

        driver.close();
    }
}
