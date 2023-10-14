package separatepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonfunction.Abstractcomponent;

public class Loginpage extends Abstractcomponent {

		 WebDriver driver;
		 
			public Loginpage (WebDriver driver)           
				{
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver, this);
				}
			
			@FindBy(xpath="//input[@id='txt_username']")
			WebElement user;
			
			@FindBy(xpath="//input[@id='txt_password']")
			WebElement password;
			
			@FindBy(xpath="//button[@id='btn_login']")
			WebElement submit;
			
			public void logindetails(String userid, String pwd) {
				
				user.sendKeys(userid);
				password.sendKeys(pwd);
				submit.click();		
			}
			public void environmenturl() {
				
				driver.get("https://devlocal.kantimehealth.net/identity/v2/Accounts/Authorize?product=hh_admin&state=");
			}		

	}

