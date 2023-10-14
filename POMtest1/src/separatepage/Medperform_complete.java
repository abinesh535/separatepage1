package separatepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonfunction.Abstractcomponent;

public class Medperform_complete extends Abstractcomponent {

	WebDriver driver;

	public Medperform_complete(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Medications']//parent::span[@class='rtsIn']")
	WebElement administer;

	@FindBy(xpath = "//input[@id=\"btn_EditTask\"]")
	WebElement administerpage;

	@FindBy(xpath = "//input[@id=\"chkMedication0\"]")
	WebElement selectcheckbox;

	@FindBy(id = "txtComment0")
	WebElement entercomment;

	@FindBy(xpath = "//input[@id=\"btnSave\"]")
	WebElement save;

	@FindBy(xpath = "//input[@id=\"chkMedication0\"]")
	WebElement unselectcheckbox;

	@FindBy(id = "imgAutoFill_0")
	WebElement timeautofill;

	@FindBy(id = "Img_MedAdmEdit_0")
	WebElement clickedit;

	@FindBy(id = "txtComment_0_0")
	WebElement entercommentnew;

	@FindBy(id = "Img_MedAdmSave_0")
	WebElement savenew;

	@FindBy(id = "Img_MedAdmContinue_0")
	WebElement clickcontinue;

	@SuppressWarnings("deprecation")
	public void openchart() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"td_Schedule_EchartLink_ 10137668\"]/a"));
		je.executeScript("arguments[0].scrollIntoView(true);", scroll);
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
		entercomment.sendKeys("test");
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

	@SuppressWarnings({ "deprecation", "null", "unused" })
	public void administerpagenew() throws InterruptedException {
		Thread.sleep(2000);

		List<WebElement> edit = driver.findElements(By.xpath("//*[@title='Click here to edit.']"));
		System.out.println("Number of Medications in visit: " + edit.size());
		int plannedcount1 = 0;

		List<WebElement> medname = driver.findElements(By.xpath("//*[contains(@id,'tr_MedAdmt')]/td[2]/div[1]/span[4]"));

		for (int i = 0; i < medname.size(); i++) {
			WebElement med = medname.get(i);
			String printmed = med.getText();

			WebElement editc = edit.get(i);
			List<WebElement> editmedcount = editc.findElements(By.cssSelector("span[style*='color: red']"));
			plannedcount1 = editmedcount.size();
			System.out.println("\nMedication: " + printmed + "| planned Med time at initial: " + plannedcount1);
		}
		
		List<WebElement> icon = driver.findElements(By.xpath("//*[@title='edit']"));
		int editcount = icon.size();
		System.out.println(editcount);

		List<WebElement> red = driver.findElements(By.xpath("//*[contains(@id,'plannedspndatetime') and contains(@style, 'color:')]"));
		int redcount = red.size();

		driver.findElement(By.id("Img_MedAdmEdit_ALL")).click();
		Thread.sleep(2000);
	
		for (int i = 0; i < red.size(); i++) {
			WebElement pred = red.get(i);
			String rdate = pred.getText();
			
			List<WebElement> enterdate = driver.findElements(By.xpath("//input[contains(@placeholder, 'Performed on')]"));
		    
		    if (!enterdate.isEmpty()) {
		        WebElement datetime = enterdate.get(i);
		        datetime.clear(); // Clear the input field if it exists
		        datetime.sendKeys(rdate);
		    }
		}
     	System.out.println("Total planned Medications: " + redcount);

		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"PageContent\"]/div/div[1]/div[4]/div/table/tbody/tr/th[7]/input[1]"));
		je.executeScript("arguments[0].scrollIntoView(true);", scroll);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		scroll.click();
		Thread.sleep(2000);
		List<WebElement> message=driver.findElements(By.xpath("//*[contains(@id,\"spn_ErrorMsg_\")]/p"));
		for (int i = 0; i < message.size(); i++) {
			WebElement error = message.get(i);
			String printmed = error.getText();
			System.out.println(printmed);
		}
		Thread.sleep(6000);

		for (WebElement editc : edit) {
			List<WebElement> editmedcount = editc.findElements(By.cssSelector("span[style*='color: red']"));
			int plannedcount2 = editmedcount.size();
			System.out.println("\n planned Med time at final: " + plannedcount2);

			if (plannedcount1 != plannedcount2) {
				System.out.println("Medication not performed as per planned count");
			} else {
				System.out.println("Medication performed as planned");
			}
		}
		List<WebElement> green = driver.findElements(By.xpath("//*[contains(@id,'plannedspndatetime') and contains(@style, 'color: green;')]"));
		int greencount = green.size();
		System.out.println("\nTotal performed Medications: " + greencount);
		if (redcount == greencount) {
			System.out.println("\nAll planned Meds are performed in the visit");
		}
	}
}