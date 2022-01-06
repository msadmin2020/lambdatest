package lambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lambdatest {

	public RemoteWebDriver driver = null;
	String username = "nagarjuna";
	String accessKey = "gz9Mq7Sas2tLE6gaCNNafk5Ntoqh5XAak3sop6px8c7fMjZea1";

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("version", "97.0");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("resolution","1920x1080");
		capabilities.setCapability("build", "MysampleTest");
		capabilities.setCapability("name", "MYSampleTestOne");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
	}

	@Test(enabled = true)
	public void testScript() throws Exception {
		try {
			driver.get("https://lambdatest.github.io/sample-todo-app/");
			driver.findElement(By.name("li1")).click();
			driver.findElement(By.name("li2")).click();
			driver.findElement(By.id("sampletodotext")).clear();
			driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
			driver.findElement(By.id("addbutton")).click();
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
