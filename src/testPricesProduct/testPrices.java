package testPricesProduct;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testPrices {
	WebDriver myD = new ChromeDriver();  
	String user = "standard_user"; 
	String password = "secret_sauce"; 
	String website = "https://www.saucedemo.com/"; 
	String login = "//input[@type='submit']";
	
	@Test(priority = 1 )
	public void setup() {
		myD.get(website);
		WebElement textUser =  myD.findElement(By.xpath("//input[@id='user-name']"));
		WebElement textPassword =  myD.findElement(By.xpath("//input[@id='password']"));
		WebElement btnLogin = myD.findElement(By.xpath(login));
		textUser.sendKeys(user);
		textPassword.sendKeys(password);
	    btnLogin.click();	
		
	}
	
	@Test(priority = 2 )
	public void addThePricesUpper$15() {
		
		List<WebElement> Prices = myD.findElements(By.xpath("//div[@data-test='inventory-item-price']")); 
		List<WebElement> btnCard = myD.findElements(By.className("btn_primary"));
 
		for(int i= 0 ;i<Prices.size() ;i++ ){
			
        	 double val = Double.parseDouble(Prices.get(i).getText().replace("$", ""));
			
			if(val < 15 ){btnCard.get(i).click();}
	
			
		}
		
		
	}
	
	
}
