package regressiontest;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import separatepage.AddADR;
import separatepage.HHApage;
import separatepage.Loginpage;

public class ADR {

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
		hid.adr();
		AddADR ad=new AddADR(driver);
		ad.adrpage();
		ad.manageadr();
		ad.pdfandverify();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"Span_Status\"]")).getText());

	}

}
