import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class SeleniumOPTest {

  
  public void mainTest() throws Exception {
	  System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.get("http://localhost/opencartsite/");
      driver.manage().window().maximize();
     public void Registration() {
      //Registeration
      driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
      driver.findElement(By.linkText("Register")).click();
      Thread.sleep(10000);
      FileInputStream f1= new FileInputStream("D:\\opencart.xls");
      Workbook w= Workbook.getWorkbook(f1);
      Sheet s=w.getSheet(0);
      String first=s.getCell(0,1).getContents();
      String last=s.getCell(1,1).getContents();
      String Email=s.getCell(2,1).getContents();
      String tele=s.getCell(3, 1).getContents();
      String pass=s.getCell(4,1).getContents();
      String conpass=s.getCell(5,1).getContents();
      
      driver.findElement(By.name("firstname")).sendKeys(first);
      driver.findElement(By.name("lastname")).sendKeys(last);
      driver.findElement(By.name("email")).sendKeys(Email);
      driver.findElement(By.name("telephone")).sendKeys(tele);
      driver.findElement(By.name("password")).sendKeys(pass);
      driver.findElement(By.name("confirm")).sendKeys(conpass);
      driver.findElement(By.name("agree")).click();
     }
      driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();//continue
      driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/a")).click();
       driver.findElement(By.xpath("//*[@id=\"input-enquiry\"]")).sendKeys("This is to change addess or phone no");
       driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
       driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/h4/a")).click();
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/p/a[2]")).click();
       driver.findElement(By.xpath("//*[@id=\"input-name\"]")).sendKeys(first);
       driver.findElement(By.xpath("//*[@id=\"input-review\"]")).sendKeys("good");
       driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[4]")).click();
       File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(file,new File("F:\\screenshot.png"));
       driver.findElement(By.xpath("//*[@id=\"button-review\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]/i")).click();//add to wishlist    
       Thread.sleep(5000);
       driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]/button")).click();//close ribbon message
       driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();//wishlist
       driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span")).click();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button")).click();
       System.out.println("Pound Sterling:"+driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]/div")).getText());//pounds
       driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span")).click();
       driver.findElement(By.name("EUR")).click();
       System.out.println("Euro:"+driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]/div")).getText());//euro
       driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span")).click();
       driver.findElement(By.name("USD")).click();
       System.out.println("Usdollar:"+driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]/div")).getText());//usdollar
       driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button/i")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"account-wishlist\"]/div[1]/button")).click();
       driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a/i")).click();
       driver.findElement(By.linkText("Continue")).click();
       driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
       driver.findElement(By.linkText("Logout")).click();
       System.out.println("Pass");
  }
}

