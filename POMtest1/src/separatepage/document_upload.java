package separatepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonfunction.Abstractcomponent;

public class document_upload extends Abstractcomponent {
	WebDriver driver;
	
	public document_upload(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//*[@id=\"UploadIcon_0\"]/a/img")
	WebElement adddocumentpopup;
	
	@FindBy(id="MainContent_FileUploadNew")
	WebElement adddocumentbutton;
	
	@FindBy(id="MainContent_btnAddDocument")
	WebElement savedocument;

	 public void document() throws InterruptedException {
		 Thread.sleep(3000);
		 adddocumentpopup.click();
		 windowhandling1();
		 Thread.sleep(3000);
		 adddocumentbutton.sendKeys("C:\\Users\\abineshg\\Desktop\\test.pdf");
		 Thread.sleep(4000);
		 savedocument.click();
		 Thread.sleep(4000);
		 System.out.println(driver.findElement(By.id("uploaded_id")).getText());
		 
	 }
	

}
