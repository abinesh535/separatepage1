package separatepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonfunction.Abstractcomponent;

public class document_download extends Abstractcomponent {
	WebDriver driver;

	public document_download(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="AttachmentPinIcon_0")
	WebElement downloadicon;
	
	@FindBy(xpath="//*[@id=\"RowID0\"]/td[2]/span[1]/img")
	WebElement selectfile;
	
	public void document() throws InterruptedException {
		downloadicon.click();
		selectfile.click();
	
	}

}
