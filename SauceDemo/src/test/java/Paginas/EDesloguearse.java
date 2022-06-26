package Paginas;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EDesloguearse {
	WebDriver driver;
	
	//Elementos de pagina
	@FindBy(css="#react-burger-menu-btn")
	WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logout;
	
	//Constructor
	public EDesloguearse(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Acciones en elementos
	public void desplegarMenu() {
		menu.click();
	}
	
	public void salir() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}
	
}
