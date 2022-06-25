package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DInformation {
	//Elementos de la pagina
	
	@FindBy(id="first-name")
	WebElement nombre;
	
	@FindBy(id="last-name")
	WebElement apellido;
	
	@FindBy(id="postal-code")
	WebElement codPostal;
	
	@FindBy(id="continue")
	WebElement continuar;
	
	//Constructor
	public DInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Acciones
	public void campoNombre(String primerNombre) {
		nombre.sendKeys(primerNombre);
	}
	
	public void campoApellido(String apell) {
		apellido.sendKeys(apell);
	}
	
	public void campoCodPost(String cod) {
		codPostal.sendKeys(cod);
	}
	
	public void sigPagina() {
		continuar.click();
	}
	

}
