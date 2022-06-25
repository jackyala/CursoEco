package Edit.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Asignacion2 {
	String url = "https://www.saucedemo.com/";
	String chromeDriverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\SauceDemo\\Drivers\\geckodriver.exe";
	
	@Test
	public void InicioDeSesion() {
		//1 Abra el navegador Chrome
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver navegador = new ChromeDriver();
				
		//2 Acceda a la página https://www.saucedemo.com/
		navegador.get(url);
		
		//3 Escriba el usuario (standard_user)
		WebElement user = navegador.findElement(By.cssSelector("#user-name"));
		user.sendKeys("standard_user");
		user.sendKeys(Keys.ENTER);
		
		
		//4 Escriba la contraseña (secret_sauce)
		WebElement pasword = navegador.findElement(By.cssSelector("#password"));
		pasword.sendKeys("secret_sauce");
		pasword.sendKeys(Keys.ENTER);
		
		//5 Haga clic en el botón LOGIN
		WebElement loggin = navegador.findElement(By.cssSelector("#login-button"));
		loggin.sendKeys(Keys.ENTER);
		
		
		
		
		
		

	}

}
