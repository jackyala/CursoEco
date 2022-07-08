package Edit.EcoTesting;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

public class Asignacion5 {
	String url = "https://www.saucedemo.com";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	WebDriver driver;
	File pantalla;
	String dirEvidencias = "..\\EcoTesting\\Evidencias\\";
	String nombreDocumento = "Evidencias - SauceDemo.docx";
	
	@BeforeSuite
	public void abrirPagina() throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Evidencias - SauceDemo.docx", 20);
		
		
		
	}
	
	
	@Test(priority=1)
	public void inicioSesion() throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, InterruptedException {
		
		//1- Ingresar Usuario	
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Pantalla Principal");
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Luego de hacer clic en user-name");
		
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Luego de hacer clic en password");
		
		driver.findElement(By.cssSelector("#login-button")).click();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Luego de hacer clic en login-button");
		
				
		String urlEsperada = "https://www.saucedemo.com/inventory.html";
		String tituloEsperado = "Swag Labs";
		
		String urlObtenida = driver.getCurrentUrl();
		//3-Comprobacion 1) Url esperada vs Url obtenida
		Assert.assertEquals(urlEsperada,urlObtenida);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Comprobar URL");
		
		//4-Comprobacion 2) Titulo esperado distinto al obtenido
		Assert.assertNotEquals(tituloEsperado, "pagina");
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Comprobar Titulo");
		
		
				
	}
	
	
	@Test(priority=2)
	public void comprarProducto() throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, InterruptedException {
		//5-Colocar dos(2) produtos en el Carrito
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Colocar productos en el carrito");
		
		
		//NOTA: no supe como acortar la ruta del primer elemento, si me puedes dar un tip lo agradezco!
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
		driver.findElement(By.cssSelector("#checkout")).click();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Ir a pagar");
		
		driver.findElement(By.id("first-name")).sendKeys("Gabriela");
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Ingresar Nombre");
		
		driver.findElement(By.id("last-name")).sendKeys("Croxatto");
		driver.findElement(By.id("postal-code")).sendKeys("00002");
		driver.findElement(By.id("continue")).click();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Continuar");
		
		driver.findElement(By.id("finish")).click();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Finalizar");
		
				
		
	}
	
		
	
	@AfterSuite
	public void cerrarPagina() {
	   driver.close();
	}



}
