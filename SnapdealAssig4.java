package week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealAssig4 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.xpath("(//span[@class='catText'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='linkTest']//parent::a)[1]")).click();
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("The total count of shoes:"+count);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		 driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
 driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
 driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
 driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("500");
 driver.findElement(By.xpath("//input[@name='toVal']")).clear();
 driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
   driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
   Thread.sleep(1500);
   driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
   WebElement mouseover = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
   Actions builder =new Actions(driver);
   builder.moveToElement(mouseover).perform();
   Thread.sleep(1500);
   driver.findElement(By.xpath("(//div[contains(text(), 'Quick View')])[1]")).click();
     String text1 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
   System.out.println("The cost of the shoe:"+text1);
   String text2 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
   System.out.println("The discount percentage of the shoe:"+text2);
  WebElement snap= driver.findElement(By.xpath("//img[@class='cloudzoom']"));
 File screenshot= snap.getScreenshotAs(OutputType.FILE);
 File image=new File("./snaps/img002.png");
 FileUtils.copyFile(screenshot, image);
 WebElement Element = driver.findElement(By.xpath("//div[@class='close close1 marR10']"));
 Element.click();
 driver.close();

   
   
   
   
	}

}
