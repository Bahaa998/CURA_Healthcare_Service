package TestCURA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CURA {
	public WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://katalon-demo-cura.herokuapp.com/");

	}

	@Test()
	public void Make_Appointment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Click Button Make Appointment
		driver.findElement(By.id("btn-make-appointment")).click();

		// Login User
		driver.findElement(By.id("txt-username")).sendKeys("John Doe" + Keys.TAB + "ThisIsNotAPassword" + Keys.ENTER);

		// Fill in the information
		driver.findElement(By.id("combo_facility")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"radio_program_medicaid\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[4]/div/div/div/span")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[3]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("I feel stomach pain" + Keys.ENTER + ":(");

		Thread.sleep(2000);

		// Click Button Book Appointment
		driver.findElement(By.id("btn-book-appointment")).click();

		System.out.println("Appointment Confirmation");
		Thread.sleep(3000);

		// Back To Home
		driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a")).click();

	}
	
	
	
	@org.testng.annotations.AfterTest
	public void AfterTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"menu-toggle\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}


}
