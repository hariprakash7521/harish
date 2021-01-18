package cloudpack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test131
{
	public static void main(String[] args) throws Exception
	{
		//Give Cloud(Sauce Labs) details
		String USERNAME="seleniumfullstack245246";
		String ACCESS_KEY="fec4d0ac-5d41-457f-9b03-8c6a676a1ab2";
		String endpoint="http://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:80/wd/hub";
		//Desired Capabilities to give required Test environment details
		DesiredCapabilities dc=new DesiredCapabilities();
		//About browser
		dc.setBrowserName("Chrome");
		dc.setCapability("version","80"); //Browser version
		//About OS
		dc.setCapability("platform",Platform.MAC); //OS
		//Open browser in specified OS
		URL u=new URL(endpoint);
		RemoteWebDriver driver=new RemoteWebDriver(u,dc);
		//Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//Validation
		if(driver.getTitle().equals("Google"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//Search for a word
		driver.findElement(By.name("q")).sendKeys("kalam",Keys.ENTER);
		Thread.sleep(5000);
		//Validation
		if(driver.getTitle().contains("kalam"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//Close site
		driver.close();
	}
}
