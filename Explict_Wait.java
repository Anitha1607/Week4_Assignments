package week4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explict_Wait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/TextChange.html");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Click ME!']")));
		driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("The message is :"+alert.getText());
		alert.accept();
			 
		

	}

}
