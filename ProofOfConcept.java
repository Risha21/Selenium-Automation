import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProofOfConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		linksOnPage();
		linksOnFooterOfPage();
		footerFirstColumnLinksCount();
		checkLinksAreWorkable();
	}

	public static void linksOnPage() {
		// Give me the count of links on page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links available on web page are:" + links.size());

	}

	public static void linksOnFooterOfPage() {
		// Give me the count of links available on footer of the page
		// create a webelement which selects entire footer
		WebElement footer = driver.findElement(By.id("gf-BIG"));//
		System.out.println(footer.getText());
		// footer can play the role of driver here and it will have all the functions
		// which driver supports
		List<WebElement> footerlinks = footer.findElements(By.tagName("a"));
		System.out.println(footerlinks.size());
	}

	public static void footerFirstColumnLinksCount() {
		// Give me the count of links available on column 1
		WebElement firstColumn = driver.findElement(By.xpath("//li[@class='gf-li']/parent::ul"));
		System.out.println(firstColumn.getText());
		System.out.println("Number of links available on column1:" + firstColumn.findElements(By.tagName("a")).size());
	}

	public static void checkLinksAreWorkable() {
		// click on each link and check if the links are working
		WebElement firstColumn = driver.findElement(By.xpath("//li[@class='gf-li']/parent::ul"));
		System.out.println(firstColumn.getText());
		List<WebElement> firstColumnLinks = firstColumn.findElements(By.tagName("a"));
		for (int i = 1; i < firstColumnLinks.size(); i++)

		{
			String clickOnLinkToOpenTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumnLinks.get(i).sendKeys(clickOnLinkToOpenTab);
			// String mainWindow=driver.getWindowHandle();
			// System.out.println(mainWindow);
		} // Opens all the tabs

		Set<String> w1 = driver.getWindowHandles();
		Iterator<String> itr1 = w1.iterator();

		while (itr1.hasNext()) {
			driver.switchTo().window(itr1.next());
			System.out.println(driver.getTitle());
		}

	}
}
