package week4.day1;

	import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LearnAlert {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub

			//call WDM 
					WebDriverManager.chromedriver().setup();
					//Launch the browser
					ChromeDriver driver = new ChromeDriver();
					//load the URL
					driver.get("http://www.leafground.com/pages/Alert.html");
					//Maxi the Browser
					driver.manage().window().maximize();
					
					//click prompt box.
					driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
					
					//get the text
					Alert alert = driver.switchTo().alert();
					alert.sendKeys("Test");
					String text = alert.getText();
					System.out.println(text);
					
					//click ok
					alert.accept();
					
					//check
					String text2 = driver.findElement(By.id("result1")).getText();
					System.out.println(text2);
		}			


}
