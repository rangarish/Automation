package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EBHomePage;
import pages.EBProductCatalog;
import pages.EBLoginPage;

public class EBPCatalog extends TestBase {

	@Test (priority = 0)
	public void FilterControl() {
		EBProductCatalog ProductCatalog = PageFactory.initElements(driver, EBProductCatalog.class);
		ProductCatalog.clearSearchProduct();
		ProductCatalog.selectFiltercategory();
		System.out.println("Book Category selected");
		Assert.assertEquals(ProductCatalog.getProductcountonCategory(), "2","Product count is not match on Product category control ");
		Assert.assertEquals(ProductCatalog.getsFirstCategoryProductName(), "The History Of Sampco","Product List is not Filtered  based on product category ");
		ProductCatalog.ResetFiltercategory();
		System.out.println("All Category selected");
	}
	@Test (priority = 2)
	public void SearchControl() throws Exception{
		
		//EBLoginPage loginpage = PageFactory.initElements(driver, EBLoginPage.class);
		EBProductCatalog ProductCatalog = PageFactory.initElements(driver, EBProductCatalog.class);
		driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);			
		ProductCatalog.setSearchProduct("12oz Sampco Mug");
		Assert.assertEquals(ProductCatalog.getserchedProductName(), "12oz Sampco Mug");
		Assert.assertEquals(ProductCatalog.getserchedProductPrice(),"12.00");
		System.out.println("Product Search Sucessfully");
		
		
}
	@Test (priority = 1)
	public void SortControl() {
		
		EBProductCatalog ProductCatalog = PageFactory.initElements(driver, EBProductCatalog.class);
		ProductCatalog.clearSearchProduct();
		ProductCatalog.ResetFiltercategory();
		ProductCatalog.Sortby_high_to_low();
		driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
		Assert.assertEquals(ProductCatalog.getsFirstProductName(), "Rectangular Conference Table","Product List is not sorted based on Price high to low ");
		ProductCatalog.Sortby_low_to_high();
		driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
		Assert.assertEquals(ProductCatalog.getsFirstProductName(),"4oz Sampco Glass","Product List is not sorted based on Price low to High");
		
	}
	@Test (priority = 3)
	public void PagginationControl() {
		
		EBProductCatalog ProductCatalog = PageFactory.initElements(driver, EBProductCatalog.class);
		ProductCatalog.clearSearchProduct();
		driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
		ProductCatalog.ResetFiltercategory();
		driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
		ProductCatalog.clickPaggination();
		driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
		String firstProductsecondpage = ProductCatalog.getsFirstProductName();
		System.out.println(firstProductsecondpage);
		Assert.assertEquals(ProductCatalog.getsFirstProductName(),"12oz Sampco Mug","Product name mismatch on second page");
		
	}
	
	
}