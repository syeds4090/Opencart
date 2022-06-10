import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;

public class SelOPLog {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/opencartsite/");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Login")).click();
        FileInputStream f1= new FileInputStream("D:\\opencart.xls");
        Workbook w= Workbook.getWorkbook(f1);
        Sheet s=w.getSheet(0);
        String first=s.getCell(0,0).getContents();
        String last=s.getCell(1,0).getContents();
        String Email=s.getCell(2,0).getContents();
        String pass=s.getCell(4,0).getContents();
        
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).click();
 	   driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("apple");
 	   driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
 	   List<WebElement> agrid = driver.findElements(By.className("product-thumb"));
 	   System.out.println(agrid.size());
 	   Select category = new Select(driver.findElement((By.name("category_id"))));
 	   category.selectByValue("28");
 	   driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
 	   List<WebElement> mgrid = driver.findElements(By.className("product-thumb"));
 	   System.out.println(mgrid.size());
 	   driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a")).click();
 	   List<WebElement> pgrid = driver.findElements(By.className("product-thumb"));
 	   System.out.println(pgrid.size());
 	   Select price = new Select(driver.findElement((By.id("input-sort"))));
 	   price.selectByValue("http://localhost/opencartsite/index.php?route=product/category&path=24&sort=p.price&order=DESC");
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[3]/i")).click();
 	   Thread.sleep(3000);
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[3]/i")).click();
 	   Thread.sleep(3000);
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/div[2]/button[3]/i")).click();
 	   //Thread.sleep(3000);
 	   driver.findElement(By.xpath("//*[@id=\"compare-total\"]")).click();
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[1]/td[2]/a/strong")).click();
 	   System.out.println( driver.findElement(By.xpath("//*[@id=\"tab-description\"]/ul/li[5]")).getText());
 	   driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
 	   Thread.sleep(3000);
 	   driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();
 	   Thread.sleep(3000);
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
 	   driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
 		 driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]")).click();
 		   driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]")).click();
 		  driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
 		  Thread.sleep(2000);
 		   driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]")).click();
 		   driver.findElement(By.name("agree")).click();
 		   driver.findElement(By.xpath("//*[@id=\"button-confirm\"]")).click();
 		   Thread.sleep(3000);
 		 //driver.findElement(By.xpath("//*[@id=\"common-success\"]/ul/li[2]/a")).click();
 		 driver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[2]/a")).click();//order history
 		 driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[12]")).click();//newsletter
 		 driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[12]")).click();
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input")).click();
 		 driver.findElement(By.xpath("/html/body/footer/div/div/div[3]/ul/li[4]/a")).click();//specials
 		 driver.findElement(By.xpath("//*[@id=\"list-view\"]/i")).click();//list
 		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
 		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
 		  System.out.println("Pass");
        
	}

}
