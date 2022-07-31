package week4.day1;


	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class SaleforceCustomerService {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub

			//call WDM 
			WebDriverManager.chromedriver().setup();
			//Launch the browser
			ChromeDriver driver = new ChromeDriver();
			//load the URL
			driver.get("https://login.salesforce.com/");
			//Maxi the Browser
			driver.manage().window().maximize();
			//Enter the username as 
			driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
			//Enter the password as
			driver.findElement(By.id("password")).sendKeys("Password$123");
			//click on the login button
			driver.findElement(By.id("Login")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String window1 = driver.getWindowHandle();
			System.out.println("The 1st Window is "+window1);
			//click on the learn more option in the Mobile publisher
			driver.findElement(By.xpath("//span[text()='Mobile Publisher']/following::button[1]")).click();
			//Switch to the next window 
			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println("The Number of windows is:" +windowHandles.size());
			//to get 2nd window need to change from set to List
			List<String> listwindowHandles = new ArrayList<String>(windowHandles);
			String window2 = listwindowHandles.get(1);
			System.out.println("The 2nd Window is "+window2);
			//switch to 2nd window
			driver.switchTo().window(window2);
			//click on the confirm button
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			//Get the title
			System.out.println("The Tittle of second window is "+driver.getTitle());
			//Get back to the parent window
			driver.switchTo().window(window1);
			System.out.println("The Tittle of parent window is "+driver.getTitle());
			//close the browser
			driver.quit();
			
		}
}
