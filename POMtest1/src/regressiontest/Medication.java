package regressiontest;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import separatepage.AddMedication;
import separatepage.Clientpage;
import separatepage.HHApage;
import separatepage.Loginpage;


public class Medication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriverv114.exe");
    	ChromeOptions options=new ChromeOptions();
    	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	    options.addArguments("--remote-allow-origins=*");         //added as some connection fail exception showed
        WebDriver driver=new ChromeDriver(options); 
		driver.manage().window().maximize();
		Loginpage working=new Loginpage(driver);
		working.environmenturl();
		working.logindetails("kadmin", "demo");
		HHApage hid=new HHApage(driver);
		hid.hha("901246");
		hid.client("2321477");
		Thread.sleep(3000);
		Clientpage profile=new Clientpage(driver);
		profile.medications();
		AddMedication med=new AddMedication(driver);
		med.openMedpage();
		med.addmed("Medication test1","dosage 1","route 1", "frequency 1", "purpose 1");	
	}
}
