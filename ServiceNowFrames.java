package week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev103372.service-now.com/navpage.do");
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("user_password")).sendKeys("Anitha@1604");
driver.findElement(By.xpath("//button[@type='submit']")).click();
driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident",Keys.ENTER);
driver.findElement(By.linkText("All")).click();
driver.switchTo().frame(0);
driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(list.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("incident.short_description")).sendKeys("sampledemo");
		String attribute = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		 System.out.println("The incident number is:"+attribute);
		 driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		 driver.findElement(By.xpath("//input[@class='form-control'][1]")).sendKeys(attribute,Keys.ENTER);
		String str= driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println("The Incident number1 is:"+str);
		if(attribute.equals(str)) {
			System.out.println("The incident number is same");
		}
		else
		{
			System.out.println("The incident number is not same");
		}
		
		WebElement snap=driver.findElement(By.xpath("//a[@class='linked formlink']"));
		File screenshot= snap.getScreenshotAs(OutputType.FILE);
		 File image=new File("./snaps/img003.png");
		 FileUtils.copyFile(screenshot, image);

	}

}
