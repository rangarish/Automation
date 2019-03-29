package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class EBLoginPage {
 
 WebDriver driver;
 
        public EBLoginPage(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements
 @FindBy(how=How.XPATH, using="//*[@id=\"login1\"]/div/form/div[2]/input") WebElement emailTextBox;
 @FindBy(how=How.XPATH, using="//*[@id=\"login1\"]/div/form/div[3]/input") WebElement passwordTextBox;
 @FindBy(how=How.XPATH, using="//*[@id=\"login1\"]/div/form/div[5]/button") WebElement signinButton;
 
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 
        // This method is to set Email in the email text box
 public void setEmail(String strEmail){
 emailTextBox.sendKeys(strEmail);
 }
 // This method is to set Password in the password text box
 public void setPassword(String strPassword){
 passwordTextBox.sendKeys(strPassword);
 }
 // This method is to click on Login Button
 public void clickOnLoginButton(){
 signinButton.click();
 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
 } 
}