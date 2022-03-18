package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Explict_Elementdiasapper {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/disapper.html");
		@SuppressWarnings("deprecation")
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='btn']/b")));
		
		
		System.out.println(driver.findElement(By.tagName("strong")).getText());

	}

}
