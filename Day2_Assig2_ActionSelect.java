package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2_Assig2_ActionSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/selectable.html");
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		Actions builder=new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).keyUp(Keys.CONTROL).perform();

	}

}
