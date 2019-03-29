package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.EBHomePage;
import pages.EBLoginPage;

public class EBLoginTest extends TestBase{
	
	@Test
	public void init() throws Exception{

			//driver.get("https://www.facebook.com");
			EBLoginPage loginpage = PageFactory.initElements(driver, EBLoginPage.class);
			loginpage.setEmail("Abaldwin");
			loginpage.setPassword("Aptify50");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			loginpage.clickOnLoginButton();
			System.out.println("Sucessfully logged in");
			driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
			
		}
	
}