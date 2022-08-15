package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kitehome {
	@FindBy(xpath="//span[@class='user-id']") private WebElement userid;
	@FindBy(xpath="//a[@target='_self']") private WebElement logout;
	//@FindBy(xpath="(/button[@type='button'])[1]") private WebElement investbtn;

	
	 
	
	public Kitehome(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public String getcrtuserid() {
		String acttext= userid.getText();
		return acttext;
	}
	public void clickonuserid() {
		userid.click();
	}
	public void clickonlogout() {
		logout.click();
	}
}
