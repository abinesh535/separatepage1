package separatepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonfunction.Abstractcomponent;

public class Clientpage extends Abstractcomponent {
  
	WebDriver driver;
	 
	public Clientpage (WebDriver driver)            
		{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//*[normalize-space(text())='Orders']")
	WebElement ordertab;
	
	@FindBy(xpath="//*[normalize-space(text())='Medications']")
	WebElement medtab;
	
	@FindBy(id="tab_7")
	WebElement careplantab;
	
	@FindBy(id="tab_3")
	  WebElement epitab;
	
	@FindBy(id="li_JournalNote")
	WebElement journal;
	  
	
	public void order(){
		ordertab.click();
	}
	
	public void medications() {
		medtab.click();
		
	}
	public void careplans() {
		careplantab.click();
		
	}
	
	  public void episodetab(){
	  epitab.click();
	          }
	  public void journalnotetab() {
	  journal.click();
	  }
		
}
