package Edit.EcoTesting;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Clase3 {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	
	@Test
	public void irAContactUs() {
	
		System.setProperty("webdriver.chrome.driver", driverPath);
		

		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url); // Es igual a driver.get(url);
		driver.manage().window().maximize(); // Maximiza la ventana
		driver.manage().deleteAllCookies(); // Borra las cookies
		
		
		driver.findElement(By.linkText("Contact us")).click();
		
		
		Select lista = new Select(driver.findElement(By.tagName("select")));
		lista.selectByVisibleText("Webmaster");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correo1@mailinator.com");
		
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\Users\\admin\\addIntegerData.txt");
		
		driver.findElement(By.cssSelector("#message")).sendKeys("Comentarios sobre el contacto");
		
		
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
	}
}
