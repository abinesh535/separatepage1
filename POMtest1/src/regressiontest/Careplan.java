package regressiontest;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import separatepage.Addcareplan;
import separatepage.Clientpage;
import separatepage.HHApage;
import separatepage.Loginpage;

public class Careplan {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver2.exe");
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
		profile.careplans();
		Addcareplan cp=new Addcareplan(driver);
		cp.opencareplanpage();
		Thread.sleep(3000);
		cp.addcareplan();

	}

}
