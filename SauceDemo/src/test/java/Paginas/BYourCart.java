package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BYourCart {
	//Elementos de pagina
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement bike; //producto 1
	
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement backpack; //producto 2
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")
	WebElement cart; //Elemento carrito
	
	
	//Constructor
	public BYourCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Acciones en pagina
	public void producto1() {
		bike.click();
	}
	
	public void producto2() {
		backpack.click();
	}
	
	public void carrito() {
		cart.click();
	}
	
	

}
