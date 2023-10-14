package separatepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonfunction.Abstractcomponent;

public class HHApage extends Abstractcomponent {
	
	WebDriver driver;
	 
	public HHApage (WebDriver driver)            
		{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="MainContent_txt_HHAName")
	WebElement selecthha;
	
	@FindBy(xpath="//*[@class='search_ico']")
	WebElement searchhha;

	@FindBy(xpath="//*[@title='Login - Support']")
	WebElement supportlogin;
	
	@FindBy(xpath="//*[@id='15']")
	WebElement menu;
	
	@FindBy (xpath="//*[@id='td_2']")
	WebElement submenu;
	
	@FindBy(xpath="//input[@id='txtSearch']")
	WebElement namesearch;
	
	@FindBy(id="MainContent_btn_Search")
	WebElement search;
	
	@FindBy(xpath="//a[@title='Click here to view Client Profile']")
	WebElement clickclient;
	
	@FindBy(xpath="//*[normalize-space(text())='Clinical']")
	WebElement clinicalmenu;
	@FindBy(xpath="//*[@id=\"td_sub1\"]")
	WebElement penadr;
    public void hha(String hhaid) throws InterruptedException {
 //   	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    Thread.sleep(3000);
	    selecthha.sendKeys(hhaid);
	    Thread.sleep(3000);
	    searchhha.click();
	    Thread.sleep(4000);
//	    selecthha.sendKeys(Keys.ARROW_DOWN);
//	    selecthha.sendKeys(Keys.ENTER);
    	supportlogin.click();
    	windowhandling();      	
    }
    
    public void client(String cname) throws InterruptedException{
    	windowhandling();
    	menu.click();
    	submenu.click();
    	namesearch.sendKeys(cname);
    	search.click();
    	Thread.sleep(4000);
    	clickclient.click();
    }
   public void adr() {
	   
	   clinicalmenu.click();
	   Actions obj= new Actions(driver);
	   obj.moveToElement(driver.findElement(By.xpath("//*[@id=\"td_0\"]/table/tbody/tr/td[1]")));
	   obj.build().perform();
	   penadr.click();

	   
   }

}
