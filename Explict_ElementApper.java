package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explict_ElementApper {


	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/appear.html");
		System.out.println(driver.findElement(By.xpath("(//button/b)[1]")).getText());
		System.out.println(driver.findElement(By.xpath("(//button/b)[2]")).getText());
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button/b)[3]")));
			
		
		System.out.println(driver.findElement(By.xpath("(//button/b)[3]")).getText());
		System.out.println(driver.findElement(By.xpath("(//button/b)[4]")).getText());
		System.out.println(driver.findElement(By.xpath("(//button/b)[5]")).getText());

	}

}
