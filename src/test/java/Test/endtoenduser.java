package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class endtoenduser {

	WebDriver driver;

	@BeforeMethod
	public void BrowserSetUp() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.get("http://localhost:8082/medicare/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}


	
	
	@Test

	public void Endtoendtesting() throws InterruptedException {

		Thread.sleep(5000);

		// -------------Login process to Login with exsisting email id---------------------

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("abc@xyz");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(5000);

		// Add to cart

		//----------------------- view all the Prdouct------------------------
		
		WebElement ViewallProducts = driver.findElement(By.xpath("//a[contains(text(),'View Products')]"));
		ViewallProducts.click();
		
		
		//----------------------- Add Paracetamol------------------------
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();

		Thread.sleep(3000);

		WebElement Addtocart = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		Addtocart.click();

		// driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1");
		// driver.findElement(By.xpath("//span[@class='glyphicon
		// glyphicon-refresh']")).click();

		
		//----------------------- Add to shopping cart & continue shopping------------------------
		
		Thread.sleep(3000);
		WebElement Addcartcontshopping = driver.findElement(By.xpath("//a[@class='btn btn-warning']")); // continue
																										// shopping

		Addcartcontshopping.click();

		
		
		
	//	----------------adding second itema and refresh button
		
		driver.findElement(By.xpath("//tbody/tr[2]/td[6]/a[1]/span[1]")).click();
		WebElement Addtocart2 = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		Thread.sleep(5000);
		Addtocart2.click();

		WebElement Checkout = driver.findElement(By.xpath("//a[@class='btn btn-success btn-block']"));
		Thread.sleep(3000);
		Checkout.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

		// a[@class='btn btn-warning']

		// WebElement ParacetmolAddtocart =
		// driver.findElement(By.xpath("a[href='/medicare/cart/add/1/product']")).click();
		// Paracetmolview.click();
		// ParacetmolAddtocart.click();

		
		
		//-----------Payment and deliver---------------------------
		
		
		driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("4367 4698 4689");

		driver.findElement(By.xpath("//input[@id='expityMonth']")).sendKeys("08");
		driver.findElement(By.xpath("//input[@id='expityYear']")).sendKeys("2025");
		driver.findElement(By.xpath(" //input[@id='cvCode']")).sendKeys("584");

		driver.findElement(By.xpath("//a[@role='button']")).click();

		Thread.sleep(10000);

	}

	/*
	 * // WebElement ViewallProducts = //
	 * driver.findElement(By.xpath("//a[contains(text(),'View Products')]"));
	 * 
	 * // WebElement ViewallProducts=
	 * driver.findElement(By.linkText("View Products"));
	 * 
	 * Thread.sleep(5000);
	 * 
	 * /* //SIGNUP FORM TO FILL
	 * 
	 * WebElement RegisterSignup =
	 * driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	 * RegisterSignup.click();
	 * 
	 * WebElement SignupFirstName =
	 * driver.findElement(By.xpath("//input[@id='firstName']")); WebElement
	 * SignupLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
	 * WebElement SignupEmailid =
	 * driver.findElement(By.xpath("//input[@id='email']")); WebElement
	 * Signupcontactnum =
	 * driver.findElement(By.xpath("//input[@id='contactNumber']")); WebElement
	 * SignupPassword = driver.findElement(By.xpath("//input[@id='password']"));
	 * WebElement SignupCPassword =
	 * driver.findElement(By.xpath("//input[@id='confirmPassword']"));
	 * SignupFirstName.sendKeys("Yashdeep"); SignupLastName.sendKeys("Singh");
	 * SignupEmailid.sendKeys("Yash@abc"); Signupcontactnum.sendKeys("123456");
	 * SignupPassword.sendKeys("abc"); SignupCPassword.sendKeys("abc");
	 * 
	 * WebElement SignupUser =
	 * driver.findElement(By.xpath("//*[@class='radio-inline']"));
	 * 
	 * WebElement SignupBilling =
	 * driver.findElement(By.xpath("//*[@type='submit']")); SignupBilling.click();
	 * 
	 * //ADDRESS FORM TO FILL
	 * 
	 * WebElement AddressLineone=
	 * driver.findElement(By.xpath("//input[@id='addressLineOne']")); WebElement
	 * AddressLinetwo=
	 * driver.findElement(By.xpath("//input[@id='addressLineTwo']")); WebElement
	 * AddressLinecity= driver.findElement(By.xpath("//input[@id='city']"));
	 * WebElement AddressLinepostcode =
	 * driver.findElement(By.xpath("//input[@id='postalCode']")); WebElement
	 * AddressLinestate = driver.findElement(By.xpath("//input[@id='state']"));
	 * WebElement AddressLineCountry =
	 * driver.findElement(By.xpath("//input[@id='country']"));
	 * 
	 * AddressLineone.sendKeys("H.NO:-206/15");
	 * AddressLinetwo.sendKeys("Model Town"); AddressLinecity.sendKeys("Pehowa");
	 * AddressLinepostcode.sendKeys("136128"); AddressLinestate.sendKeys("Haryana");
	 * AddressLineCountry.sendKeys("India");
	 * 
	 * 
	 * 
	 * 
	 * driver.findElement(By.xpath("//button[@name='_eventId_confirm']")).click();
	 * WebElement AddressBack_personal =
	 * driver.findElement(By.xpath("//button[@name='_eventId_personal']")); // Going
	 * back previous
	 * 
	 */

	/*
	 * Login process
	 * driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	 * Thread.sleep(5000);
	 * 
	 * driver.findElement(By.xpath("//input[@id='username']")).sendKeys("abc@xyz");
	 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd");
	 * driver.findElement(By.xpath("//input[@value='Login']")).click();
	 */

	// Add to cart medicine
	/*
	 * Thread.sleep(5000);
	 * 
	 * WebElement ViewallProducts =
	 * driver.findElement(By.xpath("//a[contains(text(),'View Products')]"));
	 * ViewallProducts.click();
	 * driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement Addtocart =
	 * driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	 * Addtocart.click();
	 * 
	 * // driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1"); //
	 * driver.findElement(By.xpath("//span[@class='glyphicon //
	 * glyphicon-refresh']")).click();
	 * 
	 * Thread.sleep(3000); WebElement Addcartcontshopping =
	 * driver.findElement(By.xpath("//a[@class='btn btn-warning']")); // continue //
	 * shopping
	 * 
	 * Addcartcontshopping.click();
	 * 
	 * driver.findElement(By.xpath("//tbody/tr[2]/td[6]/a[1]/span[1]")).click();
	 * WebElement Addtocart2 =
	 * driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	 * Thread.sleep(5000); Addtocart2.click();
	 * 
	 * WebElement Checkout =
	 * driver.findElement(By.xpath("//a[@class='btn btn-success btn-block']"));
	 * Thread.sleep(3000); Checkout.click(); Thread.sleep(3000);
	 * 
	 * driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	 * 
	 * // a[@class='btn btn-warning']
	 * 
	 * // WebElement ParacetmolAddtocart = //
	 * driver.findElement(By.xpath("a[href='/medicare/cart/add/1/product']")).click(
	 * ); // Paracetmolview.click(); // ParacetmolAddtocart.click();
	 */

}
