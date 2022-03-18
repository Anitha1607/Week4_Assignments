package week4;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign6Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String replace=text.replace(",", "");
		Float value=Float.parseFloat(replace);
		int x=Math.round(value);
				
		System.out.println("The price is:" +x);
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]")).click();
		
		String text2 = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']")).getText();
		System.out.println("The customer rating is:" + text2);

		String attribute = driver.findElement(By.xpath("(//div[@role='progressbar'])[1]")).getAttribute("aria-valuenow");
		System.out.println("The rating percentage:"+attribute);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
       ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandles);
       
     String newwindow=  windowHandlesList.get(1);
     driver.switchTo().window(newwindow);
     driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
     driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();
     System.out.println("The current url1:" +driver.getCurrentUrl()); 
   
     Thread.sleep(1000);
     WebElement findElement = driver.findElement(By.xpath("//a[@id='nav-cart']"));
     System.out.println(findElement.getAttribute("href"));
      findElement.click();
     
     String text3= driver.findElement(By.xpath("(//span[@class='currencyINR']/parent::span)[1]")).getText();
     String replace1=text3.replace(",", "");
		Float value1=Float.parseFloat(replace1);
		int y=Math.round(value1);
          
     System.out.println("The subtotal is :"+y); 
     
     
      if(x==y){
    	  
    	  System.out.println("The price is same");
      }
      else
      {
    	  System.out.println("The price is not same");
      }
       
		
	}

}

