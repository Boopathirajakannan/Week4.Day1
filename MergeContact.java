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

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//call WDM 
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		//load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Maxi the Browser
		driver.manage().window().maximize();
		//find the user name and enter "demosalesmanager"
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[1]")).sendKeys("demosalesmanager");

		//find the password and enter "crmsfa"
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");

		//click on the login element and click
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		//Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//Click Merge Leads Link
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		//find 1st window handle
		String window1 = driver.getWindowHandle();
		System.out.println("The 1st window is "+window1);
		//Click the icon following the from lead
		driver.findElement(By.xpath("//span[text()='From Lead']/following::img[1]")).click();
		//To get number of windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("The Number of windows is:" +windowHandles.size());
		//to get 2nd window need to change from set to List
		List<String> listwindowHandles = new ArrayList<String>(windowHandles);
		String window2 = listwindowHandles.get(1);
		System.out.println("The 2nd Window is "+window2);
		//switch to 2nd window
		driver.switchTo().window(window2);
		//enter the name & click find Leads
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Boopathi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Click on first resulting lead
		driver.findElement(By.xpath("//div[text()='Lead ID']/following::a[@class='linktext'][1]")).click();
		////switch to 2nd window
		driver.switchTo().window(window1);
		//Click on Second Resulting Contact
		driver.findElement(By.xpath("//span[text()='To Lead']/following::img[1]")).click();
		//To get number of windows
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println("The Number of windows is:" +windowHandles.size());
		//to get 2nd window need to change from set to List
		List<String> listwindowHandles1 = new ArrayList<String>(windowHandles1);
		String window3 = listwindowHandles1.get(1);
		System.out.println("The 3rd Window is "+window3);
		//switch to 3nd window
		driver.switchTo().window(window3);
		//enter the name & click find Leads
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Boopathi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Click on first resulting lead
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a[1]")).click();
		////switch to 2nd window
		driver.switchTo().window(window1);
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		String title = driver.getTitle();
		if (title.contains("View Lead")){
			System.out.println("We have merged Susssfully");
		}else
		{System.out.println("Merge failed");

		}

	}

}
