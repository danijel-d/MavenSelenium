package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	private WebDriver driver;

	public void timOut() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		// URL of website
		driver.get("https://the-internet.herokuapp.com/");
		// maximize window
		driver.manage().window().maximize();
		timOut(); // time out after 3 seconds
		// elements that contains "a" in tag name
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// print number of list elements
		System.out.println(links.size());
		// print title
		System.out.println(driver.getTitle());
		// webelement shifting by xpath
		WebElement shifty = driver.findElement(By.xpath("//a[contains(text(),'Shifting Content')]"));
		shifty.click();
		timOut(); // time out after 3 seconds
		// webelement menu by xpath
		WebElement menu1 = driver.findElement(By.xpath("//a[contains(text(),'Example 1: Menu Element')]"));
		menu1.click();
		// webelement by rag name "li" that will click on first that finds
		WebElement menu = driver.findElement(By.tagName("li"));

		menu.click();

		timOut(); // time out after 3 seconds
		// find link by link text
//		WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
//		inputsLink.click();
		driver.quit();
	}

	public static void main(String[] args) {
		BaseTest test = new BaseTest();
		test.setUp();

	}

}
