package separatepage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonfunction.Abstractcomponent;

public class AddMedication extends Abstractcomponent {

	WebDriver driver;

	public AddMedication(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "MainContent_btn_AddMedication")
	WebElement medbutton;
	@FindBy(id = "txt_Medication")
	WebElement medfield;
	@FindBy(id = "txt_Dosage")
	WebElement dosagefield;
	@FindBy(id = "txtAutoRouteFill")
	WebElement routefield;
	@FindBy(id = "txt_FrequencyAutoFill")
	WebElement frequencyfield;
	@FindBy(id = "txt_Purpose")
	WebElement purposefield;
	@FindBy(xpath = "//input[@id='chkbx_AnnotationLongStand']/following::span")
	WebElement clickLS;
	@FindBy(xpath = "//*[@id='Chk_prn' and @name='Chk_prn']/following::span[1]")
	WebElement prn;
	
	@FindBy(id="datemask_VisitStartDate")
	WebElement enterdate;
	
//	@FindBy(id = "calendar1")
//	WebElement clickcalendar;
//	@FindBy(xpath = "//*[@class='ui-datepicker-month']//following::option[@selected]")
//	WebElement currentmonth;
//	@FindBy(xpath = "//*[@class='ui-datepicker-year']//following::option[@selected]")
//	WebElement currentyear;
//	@FindBy(xpath = "//*[@class='ui-icon ui-icon-circle-triangle-w']")
//	WebElement previous;
//	@FindBy(xpath="//a[@class='ui-state-default' and text()='10']")
//	WebElement selectdate;
	@FindBy(id = "btn_SaveNClose")
	WebElement clicksave;
	@FindBy(xpath = "//*[@class='btn button-primary btn_sec' and @value='Continue']")
	WebElement custom;
	@FindBy(id="LabelEpisode")
	WebElement epi;
	@FindBy(xpath="//*[@class='col-12 mt-2' and @id='tableDataDays']")
	WebElement addedmed;

	public void openMedpage() throws InterruptedException {
		medbutton.click();
		windowhandling1();
		Thread.sleep(2000);
	}

	public void addmed(String entermed, String enterdosage, String enterroute, String enterfre, String enterpurpose)
			throws InterruptedException {
        String episode=epi.getText();
        
        String[] epistart= episode.split(" ");
        System.out.println(epistart[0]);
        System.out.println(epistart[1]);
        System.out.println(epistart[2]);
        System.out.println(epistart[3]);
        System.out.println(epistart[4]);
      
        for (int i = 0; i < 3; i++) {        //to execute same code multiple times
		WebElement random1 = medfield;
		Random nran = new Random();
		int ranvalue = nran.nextInt(100); // along with input, it will add value from 1 to 99 randomly
		random1.sendKeys("medication" + ranvalue);
		dosagefield.sendKeys(enterdosage);
		routefield.sendKeys(enterroute);
		frequencyfield.sendKeys(enterfre);
		purposefield.sendKeys(enterpurpose);
		clickLS.click();
		prn.click();
//		clickcalendar.click();
//		Thread.sleep(2000);
//		String month = currentmonth.getText();
//		String year = currentyear.getText();
//		Thread.sleep(5000);
//
//		while (!(month.equals("Sep") && (year.equals("2021")))) {  //this code can use to select calendar and add date from calendar
//
//			previous.click();
//			month = currentmonth.getText();  
//			year = currentyear.getText();
//		}
//		selectdate.click();
		enterdate.sendKeys(epistart[2]);
		Thread.sleep(2000);
		clicksave.click();
		Thread.sleep(3000);
		custom.click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("/html/body/div[3]/p")).getText());
		
		Thread.sleep(3000);
        }
        String Medname=addedmed.getText();
		System.out.println("Newly added Medication: "+Medname);
		Thread.sleep(3000);
		driver.close();
	}
}
