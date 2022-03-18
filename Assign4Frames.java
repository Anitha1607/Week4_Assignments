package week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/frame.html");
		driver.switchTo().frame(0);
		WebElement  frame=  driver.findElement(By.id("Click"));
		frame.click();
		System.out.println(frame.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement  frame2 =driver.findElement(By.xpath("//button[@id='Click1']"));
		frame2.click();
		System.out.println(frame2.getText());
		
		driver.switchTo().defaultContent();
		
		List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
		int count=0;
		 count =count+outerframe.size();
       System.out.println(count);
		for(int i=0;i<outerframe.size();i++) {
			driver.switchTo().frame(i);
			List<WebElement> innerframe = driver.findElements(By.id("frame2"));
			count=count+innerframe.size();
			driver.switchTo().defaultContent();
		}
			System.out.println("The size of frames is:"+count);
		
		
		
		
	}

}

