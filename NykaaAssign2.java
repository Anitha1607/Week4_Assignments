package week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssign2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		WebElement moverover = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(moverover).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris",Keys.TAB);
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']/a)[1]")).click();
		System.out.println("The title of the page:"+driver.getTitle());
		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']/span")).click();
		driver.findElement(By.xpath("(//label[@class='control control-radio']//div)[8]")).click();
		driver.findElement(By.xpath("//span[text()='Category']/parent::div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair']/parent::div")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']/parent::div")).click();
		driver.findElement(By.xpath("(//label[@class='control control-checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj'])[6]")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div[@class='control-indicator checkbox '][1]")).click();
		driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> windowList = new ArrayList<String>(windowHandles);
		String newwindow = windowList.get(1);
		driver.switchTo().window(newwindow);
		WebElement ddown = driver.findElement(By.xpath("//div[@class='css-11wjdq4']/select"));
		Select sel =new Select(ddown);
		sel.selectByValue("0");
		WebElement findvalue = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
		System.out.println("The price of:"+findvalue.getText());
		driver.findElement(By.xpath("(//span[@class='btn-text']/parent::button)[1]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		driver.switchTo().frame(0);
		String subtotal = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		System.out.println(subtotal);
		
		String replace=subtotal.replace("₹", "");
		//Float total=Float.parseFloat(replace);
		int total=Integer.parseInt(replace);
		System.out.println("The subtotal is:"+total);
driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
driver.findElement(By.xpath("//button[@class='btn full big']")).click();
String subtotal1 = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
float total1=Float.parseFloat(subtotal1);
System.out.println("The grand subtotal:"+total1);
if(total==total1) {
	System.out.println("The value is same");
	}
else
{
	System.out.println("The value is not same");
}
driver.quit();
	}

}
