package Task;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Flipkart {
	WebDriver driver;
	String actualTitle;
	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("geckodriver", "C:\\Program Files\\Java\\jdk1.7.0_79");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		 if (driver.getTitle().equals("Home page")) {
			 System.out.println("ActualTitle is +");
	        } else {
	            System.out.println("ActualTitle not matched expected title is "
	                + driver.getTitle());
	        }	
	}
	@Test(priority=1)
	public void SearchMobiles() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search for products, brands and more']")));
		driver.findElement(By.xpath("//div[@class='O8ZS_U']/input")).sendKeys("mobiles");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg")).click();
	}
	
	@Test(priority=2)
	 public void SearchAllMobileSorting() throws InterruptedException
	 {
	   Thread.sleep(2000);
	  List<WebElement> element = driver.findElements(By.xpath(""));
	  for(WebElement web:element ) {
		  String mobilelist= web.getText();
		  System.out.println("mobilelist is +");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[4]")).click();
		  List<WebElement> sortedList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]"));   
		for(WebElement s:element){
		  sortedList.add(s);
		  }
		Assert.assertTrue(sortedList.equals(element));  
	  }
	 }
	@Test(priority=3)
	 public void clickonMobile() throws InterruptedException
	 {
	   Thread.sleep(2000);
	   Select s= new Select(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")));
	   s.selectByVisibleText("class");
	 }
	@Test(priority=4)
	 public void NavigatetoWindow() throws InterruptedException
	 {
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
	 String handle = driver.getWindowHandle();
	 System.out.println(handle);
	 }
	
@AfterClass
public void closeBrowser() throws InterruptedException
{
 Thread.sleep(2000);
 driver.close();
 
}
}
