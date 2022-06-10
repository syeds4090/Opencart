import java.io.FileInputStream;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;

public class SelTc7 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost/opencartsite/");
        driver.manage().window().maximize();
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
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a")).click();
        Thread.sleep(2000);
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]")).click();	  
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[1]")).click();
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/div[2]/button[1]")).click();
 	   Thread.sleep(2000);
 	  driver.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]/a[2]")).click();
 	  driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
 	  driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
 	  driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]")).click();
 	  driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]")).click();
 	  driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
 	  driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]")).click();
 	  driver.findElement(By.xpath("//*[@id=\"button-confirm\"]")).click();
 	  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
 	  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
 	  System.out.println("Pass");

	}

}
