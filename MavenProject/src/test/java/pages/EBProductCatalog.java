package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class EBProductCatalog {

	WebDriver driver;

	public EBProductCatalog(WebDriver driver) {
		this.driver = driver;
	}

	// Using FindBy for locating elements
	@FindBy(how = How.XPATH, using = "//*[@id=\"productCatalog\"]/div[1]/div/div[2]/span[1]/input")
	WebElement SearchTextBox;
	@FindBy(how = How.XPATH, using = "//span[@class='ebusiness-product-price']")
	WebElement Price;
	@FindBy(how = How.XPATH, using = "//a[@class='ebusiness-product-list-product-name']")
	WebElement ProductName;
	@FindBy(how = How.XPATH, using ="//*[@id=\"filterSort\"]/div/div[1]/ul/li[1]/label/input")
	WebElement RedioBtnSort_Price_High_to_Low;
	@FindBy(how = How.XPATH, using ="//*[@id=\"filterSort\"]/div/div[1]/ul/li[2]/label/input")
	WebElement RedioBtnSort_Price_Low_to_High;
	@FindBy(how = How.XPATH, using ="//*[@id=\"productCatalog\"]/div[3]/div[5]/div[1]/div/div[2]/p[1]/a")
	WebElement FirstProduct;	
	@FindBy(how = How.XPATH, using ="//*[@id=\"filterSort\"]/div/div[2]/div[2]/ul[2]/li[1]/label/span/span[1]")
	WebElement FilterCategory_Book;	
	@FindBy(how = How.XPATH, using ="//*[@id=\"filterSort\"]/div/div[2]/div[2]/ul[1]/li/label/span/span[1]")
	WebElement FilterCategory_All;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"productCatalog\"]/div[3]/div[5]/div[1]/div/div[2]/p[1]/a")
	WebElement FirstCategoryProduct_book;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"filterSort\"]/div/div[2]/div[2]/ul[2]/li[1]/label/span/span[2]")
	WebElement FirstCategoryProductCount;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"productCatalog\"]/div[3]/div[6]/div/div/ul[1]/li[3]")
	WebElement SecondPage;
	
	
	//input[starts-with(@value,'hightolow')
	
	public void Sortby_high_to_low()
	{
		
		RedioBtnSort_Price_High_to_Low.click();
		boolean issort = false;	
		issort =RedioBtnSort_Price_High_to_Low.isSelected();
		System.out.println(issort);
		System.out.println("Price High to Low redio button is selected");
		
		
		
	}
	public void Sortby_low_to_high() {
		RedioBtnSort_Price_Low_to_High.click();
		boolean issort2 =RedioBtnSort_Price_Low_to_High.isSelected();
		System.out.println(issort2);
		System.out.println("Price Low to High redio button is selected");
		
	}
	
	public void setSearchProduct(String strProductName) throws InterruptedException {
		try {
			SearchTextBox.sendKeys(strProductName);
			Thread.sleep(5000);
			String PProPrice = Price.getText();
			String PProductName = ProductName.getText();
			System.out.println("Product Price is " + PProPrice);
			System.out.println("Product Name is " + PProductName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Product Not found");
		}

	}
public void clearSearchProduct() {
	try {
		SearchTextBox.getText();
		SearchTextBox.clear();
		System.out.println("Text is clear");
		SearchTextBox.getText();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	public String getserchedProductPrice() {
		String PProPrice = Price.getText();
		return PProPrice;
	}

	public String getserchedProductName() {
		String PProductName = ProductName.getText();
		return PProductName;
	}
	public String getsFirstProductName() {
		String PProductName = FirstProduct.getText();
		return PProductName;
	}
	
	public String getsFirstCategoryProductName() {
		String PProductName2 = FirstCategoryProduct_book.getText();
		System.out.println(PProductName2);
		return PProductName2;
	}
	
 

	public void selectFiltercategory() {
		// TODO Auto-generated method stub
		FilterCategory_Book.click();
	}
	public void ResetFiltercategory() {
		FilterCategory_All.click();
		System.out.println("Filter based on category reseted");
	}
	public String getProductcountonCategory() {
		
		String Productcount = FirstCategoryProductCount.getText();
		System.out.println(Productcount);
		return Productcount;
	}

	public void clickPaggination() {
		SecondPage.click();
		System.out.println("****Goingo to secong page. ******");
	}
}
