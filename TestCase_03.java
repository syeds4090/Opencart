import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;

public class SelTc3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost/opencartsite");
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
        driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img")).click();//opencart button to home page
 	   Thread.sleep(3000);
 	  // driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div[1]")).click();//samsung galaxy tab link
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[1]/li[1]/a/img")).click();//main picture tab
 	   driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();//next button 2
 	   driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();//3
 	   driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();//4
 	   driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();//5
 	   driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();//6
 	   driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();//7
 	   driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/button")).click();//close window
 	   driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();//add to cart
 	   Thread.sleep(3000);
 	   driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]/a[2]")).click();//ribbon shopping cart
 	   driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();//estimate shipping
 	   Select country = new Select(driver.findElement((By.name("country_id"))));//select country
 	   country.selectByValue("99");
 	   Thread.sleep(2000);
 	   Select religion = new Select(driver.findElement((By.name("zone_id"))));//select religion
 	   religion.selectByValue("1503");
 	   driver.findElement(By.name("postcode")).sendKeys("638501");
 	   driver.findElement(By.id("button-quote")).click();
 	   Thread.sleep(2000);
 	   WebElement radio = driver.findElement(By.xpath("//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input"));
 	   radio.click();
 	   System.out.println(radio.isSelected());
 	   Thread.sleep(3000);
 	   driver.findElement(By.xpath("//*[@id=\"button-shipping\"]")).click();//shipping apply
 	   driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")).click();//cupon button
 	   driver.findElement(By.xpath("//*[@id=\"input-coupon\"]")).sendKeys("KSOWDL99");//enter cupon
 	   driver.findElement(By.xpath("//*[@id=\"button-coupon\"]")).click();//apply cupon
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();//checkout
	   System.out.println("Fail");
        
        
        
        
        
        
        
        

	}

}
