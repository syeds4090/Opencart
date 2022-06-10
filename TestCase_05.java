import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;

public class SelTc5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
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
	   driver.findElement(By.xpath("/html/body/footer/div/div/div[3]/ul/li[2]/a")).click();//gift certificate
	   FileInputStream f2 = new FileInputStream("D:\\gift.xls");
	   Workbook wl = Workbook.getWorkbook(f2);
	   Sheet sl = wl.getSheet(0);
	   String recipientname= sl.getCell(0,0).getContents();
       String recipentmail= sl.getCell(1,0).getContents();
       String message= sl.getCell(2,0).getContents();
       String amount= sl.getCell(3,0).getContents();
       driver.findElement(By.name("to_name")).sendKeys(recipientname);
       driver.findElement(By.name("to_email")).sendKeys(recipentmail);
       driver.findElement(By.name("voucher_theme_id")).click();
       driver.findElement(By.name("message")).sendKeys(message);
       driver.findElement(By.name("amount")).clear();
       driver.findElement(By.name("amount")).sendKeys(amount);
       driver.findElement(By.name("agree")).click();
       driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[8]/div/input[2]")).click();
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();//continue
       driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button/i")).click();//remove product
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();//continue
       driver.findElement(By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a")).click();//contact us
       driver.findElement(By.name("enquiry")).sendKeys("This is the change of address/phone no");//message report
       driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();//submit
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();//continue
       driver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[3]/a")).click();//wishlist
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();//continue
       driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).click();//edit
       FileInputStream f3 = new FileInputStream("D:\\telechange.xls");
	   Workbook w2 = Workbook.getWorkbook(f3);
	   Sheet s5 = w2.getSheet(0);
	   String telephone= s5.getCell(0,0).getContents();
	   driver.findElement(By.id("input-telephone")).clear();
	   driver.findElement(By.id("input-telephone")).sendKeys(telephone);
	   driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	   driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[4]/a")).click();//view return request
	   driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
	   driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[3]/a")).click();//modify address book
	   driver.findElement(By.linkText("New Address")).click();//edit
	   Thread.sleep(3000);
	   FileInputStream f4 = new FileInputStream("D:\\modifya.xls");
	   Workbook w3 = Workbook.getWorkbook(f4);
	   Sheet s6 = w3.getSheet(0);
	   String firstname= s6.getCell(0,0).getContents();
       String lastname= s6.getCell(1,0).getContents();
       String address1= s6.getCell(2,0).getContents();
       String address2= s6.getCell(3,0).getContents();
       String city= s6.getCell(4,0).getContents();
       String pincode= s6.getCell(5,0).getContents();
       driver.findElement(By.name("firstname")).clear();
	   driver.findElement(By.name("firstname")).sendKeys(firstname);
	   driver.findElement(By.name("lastname")).clear();
	   driver.findElement(By.name("lastname")).sendKeys(lastname);
	   driver.findElement(By.name("address_1")).clear();
	   driver.findElement(By.name("address_1")).sendKeys(address1);
	   driver.findElement(By.name("address_2")).clear();
	   driver.findElement(By.name("address_2")).sendKeys(address2);
	   driver.findElement(By.name("city")).clear();
	   driver.findElement(By.name("city")).sendKeys(city);
	   driver.findElement(By.name("postcode")).clear();
	   driver.findElement(By.name("postcode")).sendKeys(pincode);
	   Select Country = new Select(driver.findElement((By.id("input-country"))));
	   Country.selectByValue("99");
	   Thread.sleep(2000);
	   new Select(driver.findElement((By.id("input-zone")))).selectByValue("1503");
	   driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	   driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
	   driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
	   System.out.println("Pass");
        
        

	}

}
