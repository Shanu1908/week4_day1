package week4_day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

					import org.openqa.selenium.By;
					import org.openqa.selenium.WebElement;
					import org.openqa.selenium.chrome.ChromeDriver;
					import org.openqa.selenium.interactions.Actions;
					import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
				{
					WebDriverManager.chromedriver().setup();
					ChromeDriver driver = new ChromeDriver();
					driver.get("http://leaftaps.com/opentaps/control/login");
					driver.manage().window().maximize();
					driver.findElement(By.id("username")).sendKeys("DemosalesManager");
					driver.findElement(By.id("password")).sendKeys("crmsfa");
					driver.findElement(By.className("decorativeSubmit")).click();
					driver.findElement(By.linkText("CRM/SFA")).click();
					driver.findElement(By.linkText("Contacts")).click();
					driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
					Thread.sleep(2000);
					//expand the widget
					driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a")).click();
					Thread.sleep(1000);
									
							//Switch to Open window
							Set<String> window1 = driver.getWindowHandles();
						
							List<String> load = new ArrayList<String>(window1);
							//Switch to new Window
							driver.switchTo().window(load.get(1)); 
							//Finding firsst element and click it
							driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
							//switch to parent window
							driver.switchTo().window(load.get(0));
							//Click on the widget from the To Contact
							driver.findElement(By.xpath("//input[@id = 'partyIdTo']/following::a")).click();
							Thread.sleep(1000);
							
							//switch to the already opened window
							Set<String> window2 = driver.getWindowHandles();
							List<String> display1 = new ArrayList<String>(window2);
							driver.switchTo().window(display1.get(1));
							//Click on the second resulting element
							driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
							driver.switchTo().window(display1.get(0)); 
							//Move to the parent window
							
							//Click on the merge button
							driver.findElement(By.xpath("//a[text() = 'Merge']")).click();
							//Accept the alert
							driver.switchTo().alert().accept();
							//verify the Title
							String title = driver.getTitle();
							System.out.println(title);
							if(title.contains("Contact")) {
								System.out.println("Merge is Done");
							}else {
								System.out.println("Merge is not Done");
							}
							driver.close();
							
						}
					
					
}
}

