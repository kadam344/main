package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kitelogin2 {
	
	@FindBy(xpath="//input[@id='pin']") private WebElement pin;
	@FindBy(xpath="//button[@class='button-orange wide']") private WebElement cntbutton;

	public Kitelogin2(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void enterpin(String PIN) {
		pin.sendKeys(PIN);
	}
	public void clickonctn() {
		cntbutton.click(); 
	}
}
