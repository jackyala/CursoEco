package Edit.SauceDemo;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;

public class Asignacion7 {
	String url = "https://www.saucedemo.com/";
	String driverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
	@Test(dataProvider="DatosEntrada")
	public void generarOrden(String usuario, String pasword, String nombre, String apellido, String codPostal) {
		
		//1- Ingresar Usuario	
			
		driver.findElement(By.cssSelector("#user-name")).clear();
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys(usuario);
		
		driver.findElement(By.cssSelector("#password")).clear();
			
		driver.findElement(By.cssSelector("#password")).sendKeys(pasword);
			
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String tituloEsperado = "Swag Labs";
		Assert.assertEquals(driver.getTitle(),tituloEsperado);
		
		//2- Ingresar producto en Carrito
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		//3- Ir a Pagar
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[2]")).click();
		
		//4- Ingresar datos para el pago
		
		driver.findElement(By.id("first-name")).sendKeys(nombre);
		driver.findElement(By.id("last-name")).sendKeys(apellido);
		driver.findElement(By.id("postal-code")).sendKeys(codPostal);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		//5- Desloguearse
		
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
				
		WebElement Desloguearse = driver.findElement(By.cssSelector("#logout_sidebar_link"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Desloguearse));

        Desloguearse.click();
	}
	
			
			
	@DataProvider(name="DatosEntrada")
	public Object[][] obtenerDatosExcel() throws Exception{
		return DatosExcel.leerExcel("..\\SauceDemo\\Datos\\DatosEntrada.xlsx", "Hoja1");
				
	}
	
	@AfterSuite
    public void cerrar () {
        driver.close();
    }
	

}
