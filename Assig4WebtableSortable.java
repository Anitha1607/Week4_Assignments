package week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assig4WebtableSortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/sorttable.html");
		 WebElement table = driver.findElement(By.xpath("//table[@id='table_id']"));
		
		 List<WebElement> cols= table.findElements(By.tagName("th"));
		 int colssize= cols.size();
		System.out.println("The count of column:"+colssize);
		
		 List<WebElement> rows= table.findElements(By.tagName("tr"));
			int rowssize= rows.size();
			System.out.println("The count of rows:"+rowssize);
			
			List<String> s1=new ArrayList<String>();
			
			  for (int i=1;i<rowssize;i++) { 
				WebElement eachrow = rows.get(i);
			WebElement allcols= eachrow.findElements(By.tagName("td")).get(1);
			s1.add(allcols.getText());
			Collections.sort(s1);
			 			  
			  }
			  System.out.println("The sorted List is:"+s1);
			  
			  List<String> s2=new ArrayList<String>();
			  table.findElement(By.xpath("//th[text()='Name']")).click();
			  List<WebElement> rows1= table.findElements(By.tagName("tr"));
			  for (int j=1;j<rows1.size();j++) { 
					WebElement eachrow1 = rows1.get(j);
					WebElement allcols1= eachrow1.findElements(By.tagName("td")).get(1);
				s2.add(allcols1.getText());
			  }
			  System.out.println("The sorted List is:"+s2);
			  if(s1.equals(s2)) {
				  System.out.println("The List is same");
			  }
			  else
			  {
				  System.out.println("The List is not same");
			  }
			  
			  

	}

}
