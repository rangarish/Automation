package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class EBHomePage {
 
 WebDriver driver;
 
        public EBHomePage(WebDriver driver){ 
                this.driver=driver; 
        }
 
        //Using FindBy for locating elements
 @FindBy(how=How.XPATH, using="//*[@id=\"myNavbar\"]/ul[2]/li[2]/a/span[1]") WebElement profileDropdown;
 @FindBy(how=How.XPATH, using="//*[@id=\"myNavbar\"]/ul[2]/li[2]/ul/li[2]/a") WebElement logoutLink;
 @FindBy(how=How.XPATH, using="//div[text()='Good afternoon, SoftwareTesting!']") WebElement loggedInUserNameText;
 
        
 // Defining all the user actions (Methods) that can be performed in the Facebook home page
 
        // This method to click on Profile Dropdown
 public void clickOnProfileDropdown() throws InterruptedException{
	 Thread.sleep(5000);
 profileDropdown.click();
 Thread.sleep(5000);
 driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS) ;
 System.out.println("Profile clicked suecessfully");
 
 }

 // This method to click on Logout link
 public void clickOnLogoutLink() throws InterruptedException{
	 Thread.sleep(2000);
//driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
 logoutLink.click();
 driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
 System.out.println("Profile clicked suecessfully");
 }
 
 /*
  // This method to verify LoggedIn Username Text
 public String verifyLoggedInUserNameText(){
 String userName = loggedInUserNameText.getText();
 return userName;
 }*/
 
}