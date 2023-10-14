package regressiontest;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import separatepage.Clientpage;
import separatepage.HHApage;
import separatepage.Loginpage;
import separatepage.document_download;

public class Download_document {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriverv114.exe");
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.addArguments("--remote-allow-origins=*"); // added as some connection fail exception showed
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		String filedownload=System.getProperty("user.dir");
		chromePrefs.put("download.default_directory", filedownload);
		options.setExperimentalOption("prefs", chromePrefs);		
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
		profile.journalnotetab();
		document_download doc=new document_download(driver);
		doc.document();
		
		File f=new File(filedownload+"\\test.pdf");
		Thread.sleep(5000);
		if(f.exists()) {
			System.out.println("File downloaded successfully");
		}else {
			System.out.println("File not found");
		}}
}
