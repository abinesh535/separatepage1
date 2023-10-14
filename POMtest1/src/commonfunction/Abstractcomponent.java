package commonfunction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Abstractcomponent {
		
		WebDriver driver;
		
		public Abstractcomponent(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
        
		public void windowhandling() {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Set<String> allhandles= driver.getWindowHandles();
			List<String> list=new ArrayList<String>(allhandles);
			driver.switchTo().window(list.get(1));
		}
		public void windowhandling1() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 Set<String> allhandles1= driver.getWindowHandles();
		 		List<String> list1=new ArrayList<String>(allhandles1);
		 		driver.switchTo().window(list1.get(2));
		}	
		public void windowhandling2() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 Set<String> allhandles2= driver.getWindowHandles();
		 		List<String> list2=new ArrayList<String>(allhandles2);
		 		driver.switchTo().window(list2.get(3));
		}	
		
	}

