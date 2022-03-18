package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assig2_Action_Resize {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Resizable")).click();
		driver.switchTo().frame(0);
		WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		/*
		 * Point location = resize.getLocation(); int x=location.getX(); int
		 * y=location.getY();
		 */
		Actions builder =new Actions(driver);
		builder.clickAndHold(resize).moveByOffset(150, 100).perform();
		
	}

}
