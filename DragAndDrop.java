package week4.day1;


import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DragAndDrop {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub

			//call WDM 
					WebDriverManager.chromedriver().setup();
					//Launch the browser
					ChromeDriver driver = new ChromeDriver();
					//load the URL
					driver.get("https://jqueryui.com/droppable/");
					//Maxi the Browser
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					//switch to frame
					driver.switchTo().frame(0);
					//find webelement
					WebElement element1 = driver.findElement(By.id("draggable"));
					WebElement element2 = driver.findElement(By.id("droppable"));
					//find the initial point
					System.out.println(element1.getLocation());
					
					//actio
					Actions builder = new Actions(driver);
					//drag and drop
					builder.dragAndDrop(element1, element2).perform();
					
					System.out.println(element2.getLocation());
					System.out.println(element2.getText());
					
		}	


}
