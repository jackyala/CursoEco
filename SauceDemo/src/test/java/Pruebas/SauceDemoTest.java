package Pruebas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Paginas.AHome;
import Paginas.BYourCart;
import Paginas.CCheckout;
import Paginas.DInformation;



public class SauceDemoTest {
	String url = "https://www.saucedemo.com";
	String driverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void ingresar() {
		AHome inicio = new AHome(driver);
		
		inicio.escribirUsuario("standard_user");
		inicio.escribirClave("secret_sauce");
		inicio.login();
	}
	
	@Test(priority=2)
	public void generarOrden() {
		BYourCart orden = new BYourCart(driver);
		
		orden.producto1();
		orden.producto2();
		orden.carrito();
		
	}
	
	@Test(priority=3)
	public void irAPagar() {
		CCheckout pago = new CCheckout(driver);
		
		pago.pagar();
	}
	
	@Test(priority=4)
	public void DatosPago( ) {
		DInformation datos = new DInformation(driver);
		
		datos.campoNombre("maria");
		datos.campoApellido("campos");
		datos.campoCodPost("12002");
		datos.sigPagina();
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
	
	
}
