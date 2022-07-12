package Pruebas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Paginas.AHome;
import Paginas.BYourCart;
import Paginas.CCheckout;
import Paginas.DInformation;
import Paginas.EDesloguearse;
import Utilities.DatosExcel;




public class SauceDemoTest {
	String url = "https://www.saucedemo.com";
	String driverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	
	
	@BeforeSuite()
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		
	}
	
		
	//1- Ingresar Usuario (pagina AHome)
	@Test(priority=1)
	public void ingresar() {
		AHome inicio = new AHome(driver);
		
		inicio.escribirUsuario("standard_user");
		inicio.escribirClave("secret_sauce");
		inicio.login();
	}
	
	
	
	//2- Ingresar Productos en el carrito (pagina BYourCart)
	@Test(priority=2)
	public void generarOrden() {
		BYourCart orden = new BYourCart(driver);
		
		orden.producto1();
		orden.producto2();
		orden.carrito();
		
	}
	
	//3- Ir a Pagar (pagina CCheckout)
	@Test(priority=3)
	public void irAPagar() {
		CCheckout pago = new CCheckout(driver);
		
		pago.pagar();
	}
	
	//4- Ingresar datos para el pago (pagina DInformacion)
	@Test(priority=4)
	public void DatosPago( ) {
		DInformation datos = new DInformation(driver);
		
		datos.campoNombre("marta");
		datos.campoApellido("martinez");
		datos.campoCodPost("12000");
		datos.sigPagina();
		datos.finalizar();
	}
	
		
	
	//5- Desloguearse (pagina EDesloguearse)
	@Test(priority=5)
	public void salirDePagina() {
		EDesloguearse salir1 = new EDesloguearse(driver);
		
		salir1.desplegarMenu();
		salir1.salir();
	
		
		
	}
		
	
	
}
