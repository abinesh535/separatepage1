package separatepage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonfunction.Abstractcomponent;

public class AddADR extends Abstractcomponent {
	
	WebDriver driver;

		public AddADR(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);		
		}
    
		@FindBy(xpath="//input[@value='Display']")
		WebElement display;
		
		@FindBy(id="orderTab")
		WebElement order;
		
		@FindBy(xpath="//input[@id=\"Tab9\"]//following::span[1]")
		WebElement scheckbox;
		
		@FindBy(id="btn_GeneratePDF")
		WebElement pdf;
		
		@FindBy(id="btn_Verify")
		WebElement verify;
		
		@FindBy(xpath="//*[@id='btn_CLose_Verify']")
		WebElement close;
		
		@SuppressWarnings("unused")
		public void adrpage() throws InterruptedException {
			display.click();	
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement scroll=driver.findElement(By.xpath("(//img[@title='Manage ADR Documents'])[2]"));
			je.executeScript("arguments[0].scrollIntoView(true);",scroll);			
			WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
			scroll.click();
	        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(30));		
		}
		public void manageadr() {
			windowhandling1();
			order.click();
			scheckbox.click();
		}
		
	public void pdfandverify() {
	
		pdf.click();
		verify.click();
		 @SuppressWarnings("unused")
		WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(20));
		close.click();
	}}

