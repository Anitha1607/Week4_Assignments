package week4;

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

public class Assign5AlertsandWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/");
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		driver.findElement(By.xpath("//div[@class='text-center col-xs-12']/button")).click();
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list =new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(1));
	  driver.findElement(By.xpath("//a[@id='dropdown10']")).click();
		String str =driver.findElement(By.partialLinkText("flights")).getAttribute("href");
		System.out.println("The Email Id is :"+str);
		
		driver.switchTo().window(list.get(1)).close();
		

	}

}
