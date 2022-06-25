package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CCheckout {
	//Elementos de pagina
	@FindBy(name="checkout")
	WebElement checkout;
	
	//Constructor
	public CCheckout(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Acciones en elementos
	public void pagar() {
		checkout.click();
	}

}
