package separatepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonfunction.Abstractcomponent;

public class Medperform extends Abstractcomponent {

		WebDriver driver;

			public Medperform(WebDriver driver) {
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver, this);		
			}     
			
			@FindBy(xpath="//*[text()='Medications']//parent::span[@class='rtsIn']")
			WebElement administer;
			
			@FindBy(xpath="//input[@id=\"btn_EditTask\"]")
			WebElement administerpage;
			
			@FindBy(xpath="//input[@id=\"chkMedication0\"]")
			WebElement selectcheckbox;
			
			@FindBy(id="txtComment0")
			WebElement entercomment;
			
			@FindBy(xpath="//input[@id=\"btnSave\"]")
			WebElement save;
			
			@FindBy(xpath="//input[@id=\"chkMedication0\"]")
			WebElement unselectcheckbox;
           
			@FindBy(id="imgAutoFill_0")
			WebElement timeautofill;
			
			@FindBy(id="Img_MedAdmEdit_0")
			WebElement clickedit;
			
			@FindBy(id="txtComment_0_0")
			WebElement entercommentnew;    
			
			@FindBy(id="Img_MedAdmSave_0")
			WebElement savenew;
			
			@FindBy(id="Img_MedAdmContinue_0")
			WebElement clickcontinue;
			
			@SuppressWarnings("deprecation")
			public void openchart() {
        	 JavascriptExecutor je = (JavascriptExecutor) driver;
     		WebElement scroll=driver.findElement(By.xpath("//*[@id=\"td_Schedule_EchartLink_ 10137668\"]/a"));
     		je.executeScript("arguments[0].scrollIntoView(true);",scroll);
     		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     		scroll.click();
     		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
     		windowhandling1();
    }
			public void administertab() {
			administer.click();		
			}
			public void administermedbutton() {
			administerpage.click();
			windowhandling2();
			}
			public void administerpageold() throws InterruptedException {
			Thread.sleep(3000);
			selectcheckbox.click();
			Thread.sleep(3000);			
			timeautofill.click();
			entercomment.sendKeys("test");;
			save.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		    unselectcheckbox.click();
		    save.click();
		    Thread.sleep(2000);
		    driver.switchTo().alert().getText();
		    driver.switchTo().alert().accept();  
			}
			public void administerpagenew() throws InterruptedException {
			Thread.sleep(3000);
			clickedit.click();
			Thread.sleep(2000);
			entercommentnew.sendKeys("test");
			savenew.click();
			Thread.sleep(3000);
			clickcontinue.click();
			
			}
}