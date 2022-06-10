import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import jxl.Sheet;
import jxl.Workbook;

public class SelTc6 {

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
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Canon");//search
 	   driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();//search button
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img")).click();
 	   Select color = new Select(driver.findElement((By.name("option[226]"))));//select color
 	   color.selectByValue("15");
 	   driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).clear();
 	   driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).sendKeys("5");
 	   driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
       Thread.sleep(2000);
 	   driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]/a[2]")).click();
 	   System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")).getText());
 	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/a")).click();
 	   System.out.println("Pass");
	}

}
