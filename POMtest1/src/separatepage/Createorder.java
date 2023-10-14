package separatepage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonfunction.Abstractcomponent;

public class Createorder extends Abstractcomponent {
	
	WebDriver driver;

	public Createorder(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
     @FindBy(xpath="(//button[@class='KT_btn'])[2]")
     WebElement orderaction;
     @FindBy(xpath="(//*[normalize-space(text())='Ventilator Order'])[3]")
     WebElement openventorder;
     @FindBy(xpath="//input[@id='Chk_VerbalOrder']")
     WebElement ordertype;
     @FindBy(xpath="//input[@id='txtOrderDate']")
     WebElement orderdate;
     @FindBy(xpath="//input[@id='txt_Eff_orderDate']")
     WebElement effectivedate;
     @FindBy(xpath="//*[@id=\"ddlShiftname_0\"]/option[4]")
     WebElement setting;
     @FindBy(xpath="//input[@id='CHKSignature2']")
     WebElement sign;
     @FindBy(xpath="//input[@id='btnAddModify']")
     WebElement submit;
	
     public void ventorder() {
    	 
    	 orderaction.click();
    	 openventorder.click();
     }
     public void orderpage(String date, String edate) {
    	 windowhandling1();
        ordertype.click();
        orderdate.sendKeys(date);
		Select staff=new Select(driver.findElement(By.xpath("//*[@id='ddl_clinician']")));
		int dropdown=driver.findElements(By.xpath("//*[@id=\"ddl_clinician\"]/option")).size();
		Random staffdrop=new Random();
		int index=staffdrop.nextInt(dropdown);
		staff.selectByIndex(index);
		effectivedate.sendKeys(edate);
		setting.click();
		sign.click();
		submit.click();
		
    	 
     }
}
