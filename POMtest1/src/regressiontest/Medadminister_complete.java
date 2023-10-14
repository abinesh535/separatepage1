package regressiontest;

import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import separatepage.Clientpage;
import separatepage.HHApage;
import separatepage.Loginpage;
import separatepage.Medperform_complete;

public class Medadminister_complete {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver116.exe");
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.addArguments("--remote-allow-origins=*"); // added as some connection fail exception showed
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Loginpage working = new Loginpage(driver);
		working.environmenturl();
		working.logindetails("kadmin", "demo");
		HHApage hid = new HHApage(driver);
		hid.hha("901246");
		hid.client("1254");
		Thread.sleep(3000);
		Clientpage profile = new Clientpage(driver);
		profile.episodetab();
		Medperform_complete perform = new Medperform_complete(driver);
		perform.openchart();
		perform.administertab();
		perform.administermedbutton();
		Thread.sleep(3000);
		try {
			if (driver.getCurrentUrl().contains("visitChart_MedicationsEdit.aspx")) {
			}
			perform.administerpageold();
		} catch (Exception e) {
			if (driver.getCurrentUrl().contains("VisitChart_Medications_Edit_New.aspx")) {
			}
			perform.administerpagenew();
		}

		//driver.quit();
	}
}

