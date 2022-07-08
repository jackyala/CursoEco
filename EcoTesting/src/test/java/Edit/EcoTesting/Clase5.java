package Edit.EcoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Clase5 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	WebDriver driver; //variable global
	
	@BeforeSuite
	public void abrirPagina() {//suele llamarse setUp
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize(); // Maximiza la ventana
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP ir a Contact Us", priority=1, enabled=true)
	public void irContactUs(){
				
		driver.findElement(By.linkText("Contact us")).click();
				
		Select lista = new Select(driver.findElement(By.tagName("select")));
		lista.selectByVisibleText("Webmaster");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correo1@mailinator.com");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\Users\\admin\\addIntegerData.txt");
		driver.findElement(By.cssSelector("#message")).sendKeys("Comentarios sobre el contacto");
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
	}
	
	@Test(description="CP Buscar Palabra", priority=2, enabled=true)
	public void buscarPalabra() {
		
		//Paso 3 Escribir la palabra o frase a buscar
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		//Paso 4 Hacer la busqueda
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
		
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}

}
