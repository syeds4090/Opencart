import java.io.FileInputStream;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;

public class SeleTc4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/opencartsite/");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Login")).click();
        FileInputStream f1= new FileInputStream("D:\\opencart.xls");
        Workbook w= Workbook.getWorkbook(f1);
        Sheet s=w.getSheet(0);
        String Email=s.getCell(2,0).getContents();
        String pass=s.getCell(4,0).getContents();
        
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img")).click();//opencart button to home page
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/a/img")).click();//feature
 	   System.out.println("no related products");
 	   driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();//add to cart
 	   driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i")).click();//shopping cart
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")).clear();
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")).sendKeys("5");//change quantity
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]/i")).click();//update
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();//checkout	 	  
 	   //Select address = new Select(driver.findElement((By.name("address_id"))));//address
 	   //address.selectByValue("existing");
 	   driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
 	   driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]")).click();
 	   driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]")).click();
 	   driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
 	   driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]")).click();
 	   driver.findElement(By.xpath("//*[@id=\"button-confirm\"]")).click();
 	   driver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[2]/a")).click();//order history
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[7]/a/i")).click();
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a[2]/i")).click();
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[4]/div/div[2]/label/input")).click();
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
 	   driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
 		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
 		  System.out.println("Pass");
	}

}
