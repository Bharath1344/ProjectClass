package org.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

    //CHROME LAUNCH---------1
	public static  WebDriver chromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	//EDGE LAUNCH------------2
	public static WebDriver edgeLaunch() {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		 return driver;
		

	}
	
	public void browserlaunch(String browsername) {
		switch(browsername) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		}

	}
	
	

	//URL launch------------2
	public static void urllaunch(String url) {
		driver.get(url);
	}

	//implicityWait-----------3
	public static void implicityWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

    //Quit-----------4
	public static void quit() {
		driver.quit();
	}
	
	

	//Thread sleep------------5
	public static void threadsleep() throws Throwable {
		Thread.sleep(5000);
	}

	//Send keys-----------6
	public static void sendKeys(WebElement e, String data) {
		e.sendKeys(data);
	}

	//click-----------7
	public static void click(WebElement e) {
		e.click();
	}

	//get current url-----------8
	public static String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	//get attribute-----------9
	public static String getAttribute(WebElement e) {
		String s = e.getAttribute("value");
		return s;
	}

	//-------Actions--------
	//dragAndDrop-----------10
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a=new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}

	//Action click-----------11
	public static void actionClick(WebElement target ) {
		Actions a=new Actions(driver);
		a.click(target).perform();
	}

	//move to Element-----------12
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}

	//right click-----------13
	public static void contextClick(WebElement target) {
		Actions a=new Actions(driver);
		a.contextClick(target).perform();
	}

	//double click-----------14
	public static void doubleClick(WebElement target ) {
		Actions a=new Actions(driver);
		a.doubleClick(target).perform();
	}
	//CLICK & HOLD,RELEASE-----------15
	public static void clickAndHold(WebElement from, WebElement to) {
		Actions a = new Actions(driver);
		a.clickAndHold(from).moveToElement(to).release().perform();
	}

	//-------Alert-----
	//SimpleAlert-----------16
	public static void simpleAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}
    //ALERT DISMISS-----------17
	public static void dismissAlert() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	//PROMPT ALERT-----------18
	public static void promptAlert(String data) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(data);
	}

	//JavaScriptExecutor-----------19
	public static void jsSendkeys(WebElement target,String data) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttriute('value',("+data+"))", target);
	}

	//GETATTRIBUTE-----------20
	public static  String jsGetattribute(WebElement target) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object obj = js.executeScript("return arguments[0].getAttriute('value')", target);
		String s2=(String) obj;
		return s2;
	}

	//CLICK-----------21
	public static void jsClick(WebElement target) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].Click()", target);
	}

	//JAVA SCROLLDOWN-----------22
	public static void jsScrolldown(WebElement target) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argumens[0].scrollIntoView(true)", target);
	}

	//jsScrollup-----------23
	public static void jsScrollup(WebElement target) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argumens[0].scrollIntoView(false)", target);
	}

	//ScreenShot-----------24
	public static void ScreenShot(String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File from = ts.getScreenshotAs(OutputType.FILE);
		File to=new File("C:\\Users\\Admin\\eclipse-workspace\\MavenProjectJune\\ScreenShot\\"+name+"screenshot.png");
		FileUtils.copyFile(from, to);	   
	}
	
	//WINDOWS HANDLNG-----------25
	public static void windowsHandling(int index) {
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);
		List<String> li=new ArrayList<String>();
		li.addAll(allid);
		driver.switchTo().window(li.get(index));
	}

	//Frames-----------26
	public static void frameStringid(String id) {
		driver.switchTo().frame(id);
	}
    //FRAMES BY NAME-----------27
	public static void frameStringName(String name) {
		driver.switchTo().frame(name);
	}
    //FRAMES BY WEBELEMENT-----------28
	public static void frameWebelementName(WebElement data) {
		driver.switchTo().frame(data);
	}
    //FRAMES BY INDEX-----------29
	public static void frameIndex(String index) {

		driver.switchTo().frame(index);
    }
	
	//DROP DOWN
	// SELECT BY INDEX-----------30
	public static void selectByIndex(WebElement e, int index) {
		Select s=new Select(e); s.selectByIndex(index);
	}
	
		//SELECT BY VALUE-----------31
	public static void selecrByValue(WebElement e, String value) {
		Select s=new Select(e); s.selectByValue (value);
	}
	
	//SELECT BY VISIBLE TEXT-----------32
	public static void selectByVisibleText(WebElement e, String text) {
		Select s=new Select(e); s.selectByVisibleText(text);
	}

	//IS MULTIPLE-----------33
	public static void isMultiple(boolean b) {
		isMultiple(b);
	}

	//GET FIRST SELECTED OPTION-----------34
	public static void getFirstSelectedOptions (WebElement e) {
		Select s=new Select(e); s.getFirstSelectedOption();
	}
	
	//GET ALL SELECTED OPTIONS-----------35
	public static void getallselectedOptions1 (WebElement e) {
		Select s=new Select(e);
		s.getAllSelectedOptions();
	}
	
	//GET ALL SELECTED OPTIONS-----------36
	public static void getallselectedOptions (WebElement e) {
	Select s=new Select(e);
	s.getAllSelectedOptions();
	}
	
	//DESELECT BY INDEX-----------37
	public static void deSelectByIndex (WebElement e, int index) {
	Select s=new Select(e);
	s.deselectByIndex(index);
	}
	
	//DESELECT BY VALUE-----------38
	public static void deSelectByValue(WebElement e, String value) {
	Select s=new Select(e); s.deselectByValue(value);
	}
	
	//DESELECT BY VISIBLE TEXT-----------39
	public static void deSelectByVisibleText(WebElement e, String text) {
	Select s=new Select(e); s.deselectByVisibleText(text);
	}


	//NAVIGATE
	//Navigate URL launch---------40
	public static void navigateUrlLaunch(String data) {
		driver.navigate().to(data);
	}

	//Navigate back-----------41
	public static void navigateBack() {
		driver.navigate().back();
	}

	//Navigate forward-----------42
	public static void navigateForward() {
		driver.navigate().forward();
	}

	//Navigate Refresh-----------43
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}


	
	
	
	
	
	
	

}
