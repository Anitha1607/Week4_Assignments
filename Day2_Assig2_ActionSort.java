package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2_Assig2_ActionSort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/sortable.html");
		WebElement drag = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement drop = driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		Actions builder=new Actions(driver);
		builder.click(drag).clickAndHold().moveToElement(drop).moveByOffset(0, 10).release().perform();

	}

}
