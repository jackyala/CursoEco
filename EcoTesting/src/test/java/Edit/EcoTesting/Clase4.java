package Edit.EcoTesting;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clase4 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.id("email_create")).sendKeys("correo" + Math.random() + "@mailinator.com");
		driver.findElement(By.name("SubmitCreate")).click();
		
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tiempo máximo
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender2"))); // Condicion de parada
		
		driver.findElement(By.cssSelector("#id_gender2")).click();
		
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Jackary");
		
		driver.findElement(By.id("customer_lastname")).sendKeys("Rodriguez");
		
		WebElement txtPassword = driver.findElement(By.name("passwd"));
		txtPassword.clear();
		txtPassword.sendKeys("clave123");
		
		
		Select days = new Select(driver.findElement(By.cssSelector("#days")));
		days.selectByValue("20");
		
		Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByVisibleText("June  ");
		
		Select years = new Select(driver.findElement(By.id("years")));
		years.selectByValue("1991");
		
		
		driver.findElement(By.name("newsletter")).click(); // CheckBox Newsletter
		
		driver.findElement(By.cssSelector("#optin")).click(); // CheckBox Offers
		
		driver.findElement(By.cssSelector("#firstname")).clear();
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Jacky");//nombre
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Rodriguez");//apellido
		
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("EcoSistemas");//compañia
		
		driver.findElement(By.cssSelector("#address1")).sendKeys("Sreet 2800");//calle
		
		driver.findElement(By.name("city")).sendKeys("At");//ciudad
		
		Select estado = new Select(driver.findElement(By.id("id_state")));//Estado
		estado.selectByValue("10");
		
		driver.findElement(By.cssSelector("#postcode")).sendKeys("00000");//codigo postal
		
		driver.findElement(By.id("other")).sendKeys("Espero haber completado bien la tarea, gracias!!");
		
		driver.findElement(By.name("phone")).sendKeys("114455656");
		
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("121212112");
		
		driver.findElement(By.cssSelector("#alias")).clear();
		driver.findElement(By.cssSelector("#alias")).sendKeys("jacky123");
		
		driver.findElement(By.id("submitAccount")).click();
		
		
		
		
		
		
	
	}

}
