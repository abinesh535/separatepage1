package separatepage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonfunction.Abstractcomponent;

public class Addcareplan extends Abstractcomponent {
		
		WebDriver driver;

			public Addcareplan(WebDriver driver) {
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver, this);		
			}
			
			@FindBy(id="btn_addGoal")
			WebElement careplanbutton;
			
			@FindBy(id="ddlDiscipline")
			WebElement discipline;
			
			@FindBy(id="ddlArea")
			WebElement area;
			
			@FindBy(id="chkGoals_STG0")
			WebElement goal;
			@FindBy(id="chkGoals_LTG0")
			WebElement goal1;
			
			@FindBy(id="btnSave")
			WebElement save;
			
			
			public void opencareplanpage() {
				careplanbutton.click();
				windowhandling1();
			}
			public void addcareplan() throws InterruptedException {
//				discipline.click();
//				discipline.sendKeys(Keys.ARROW_DOWN);
//				discipline.sendKeys(Keys.ENTER);
//				Thread.sleep(3000);
				Select discipline=new Select(driver.findElement(By.xpath("//select[@id='ddlDiscipline']")));
				int dropdown=driver.findElements(By.xpath("//select[@id='ddlDiscipline']//child::option")).size();
				System.out.println(dropdown);
				Random disdrop=new Random();
				int index=disdrop.nextInt(dropdown);
				discipline.selectByIndex(index);
				Thread.sleep(3000);
//				area.click();
//				area.sendKeys(Keys.ARROW_DOWN);
//				area.sendKeys(Keys.ENTER);
				Select area=new Select(driver.findElement(By.xpath("//select[@id='ddlArea']")));
				int dropdown1=driver.findElements(By.xpath("//select[@id='ddlArea']//child::option")).size();
				System.out.println(dropdown1);
				Random areadrop=new Random();
				int index1=areadrop.nextInt(dropdown1);
				area.selectByIndex(index1);
				try
				   {
				     goal.click();
				     goal1.click();
				   }
				catch(Exception e)
				  {
					
				save.click();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.close();
		
			}
		}}

