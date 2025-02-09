package Abc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Facbook
 {
	WebDriver driver;

	void apple() {
		driver = new FirefoxDriver();

	}

	void facebook() {
		driver.get("https://www.facebook.com/"); // for open any Url
	}

	void fetchtitle() {
		String aaa = driver.getTitle(); // for taking title name

		System.out.println("The title name is : " + aaa);
	}

	void idUsername() {
		WebElement Zoom = driver.findElement(By.id("email"));

		// By.css
		// By.name
		// By.xpath
		System.out.println("The id is: " + Zoom);

		Zoom.sendKeys("Apple@gamil.com"); // jo variable run karunga ohi
		// variable .send key use hoga

		Zoom.submit();
	}

	void idpassword() {
		WebElement loop = driver.findElement(By.id("pass"));// name="pass"
		// By.css
		// By.name
		// By.xpath

		// System.out.println("The id is: "+ loop);

		loop.sendKeys("okk");

		loop.submit(); /// for submit
	}

	void off() {

		driver.close();
	}

	// 25/09/2024
	void submitbutton() {
		WebElement koko = driver.findElement(By.name("login"));
		koko.click();

	}

	void PageSource() {
		String name1 = driver.getPageSource();

		System.out.println("The page source is : " + name1);
	}

	void CurrentUrl() {
		String name2 = driver.getCurrentUrl();

		System.out.println("The current Url is : " + name2);
	}

	public static void main(String[] args) {

		Okk obj = new Okk();

		obj.apple();
		obj.facebook();
//		obj.fetchtitle();
//		obj.idpassword();
//		obj.idUsername();
		// obj.off();
		// 25/09/2024
		obj.submitbutton();
		obj.PageSource();
		obj.CurrentUrl();

	}

}
