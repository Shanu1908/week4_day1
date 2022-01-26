package week4_day1;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class Frame { 

				public static void main(String[] args) throws InterruptedException 
				{
					WebDriverManager.chromedriver().setup();
					ChromeDriver driver = new ChromeDriver();
					driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
					driver.manage().window().maximize();
   
				driver.switchTo().frame("iframeResult");
		
				driver.findElement(By.xpath("//button[text()='Try it']")).click();
			
				
				Alert set = driver.switchTo().alert();
				set.sendKeys("Shankari");
				set.accept();
	}
	
}
