package week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Assign4Webtable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement table = driver.findElement(By.id("table_id"));
		
		 List<WebElement> cols= table.findElements(By.tagName("th"));
		 int colssize= cols.size();
		System.out.println("The count of column:"+colssize);
		
		 List<WebElement> rows= table.findElements(By.tagName("tr"));
			int rowssize= rows.size();
			System.out.println("The count of rows:"+rowssize);
			
			
			
			
			for(int i=1;i<rowssize;i++) {
				WebElement eachrow = rows.get(i);
				WebElement coldata = eachrow.findElements(By.tagName("td")).get(0);
				if(coldata.getText().equals("Learn to interact with Elements")) {
				String text = eachrow.findElements(By.tagName("td")).get(1).getText();
					System.out.println("The progress value is:" +text);
					}
			}
			List<Integer> s1=new ArrayList<Integer>();
			 List<WebElement> rows1= table.findElements(By.tagName("tr"));
			for(int j=1;j<rows1.size();j++) {
				WebElement eachrow1 = rows1.get(j);
				WebElement coldata1 = eachrow1.findElements(By.tagName("td")).get(1);
				String text = coldata1.getText();
				String replace=text.replace("%", "");
			int value=Integer.parseInt(replace);
				s1.add(value);
				Collections.sort(s1);
			}				
			
			Integer Pvalue = s1.get(0);	
			//System.out.println("The lowest value :"+Pvalue);	
			if (Pvalue.equals(30)) {
				
				driver.findElements(By.xpath("//td/input")).get(2).click();
			}
				
			
				
			
		

	}

}
