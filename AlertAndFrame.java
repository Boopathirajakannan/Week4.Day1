package week4.day1;



import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAndFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//call WDM 
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		//load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//Maxi the Browser
		driver.manage().window().maximize();
		//Click TryIt
		WebElement findElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(findElement);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Click Cancel on the alert
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		//driver.switchTo().defaultContent();
		//Print the resulting text
		//WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		//driver.switchTo().frame(frame1);
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		
	}
	}
