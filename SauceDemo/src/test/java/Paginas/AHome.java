package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AHome {
	
	//Elementos de la Pagina
	
	@FindBy(css="#user-name")
	WebElement user;
	
	@FindBy(css="#password")
	WebElement password;
	
	@FindBy(css="#login-button")
	WebElement btnLogin;
	
	
	//Constructor
	public AHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Acciones sobre los elementos de la pagina
	public void escribirUsuario(String usuario) {
		user.sendKeys(usuario);
		
	}
	
	public void escribirClave(String clave) {
		password.sendKeys(clave);
	}
	
	public void login() {
		btnLogin.click();
	}

}
