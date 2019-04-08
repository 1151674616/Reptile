

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstText {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		// 如果测试的浏览器没有安装在默认目录，那么必须在程序中设置
		// bug1:System.setProperty("webdriver.chrome.driver", "C://Program Files
		// (x86)//Google//Chrome//Application//chrome.exe");
		// bug2:System.setProperty("webdriver.chrome.driver",
		// "C://Users//Yoga//Downloads//chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "F://chromedriver//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://i.qq.com/");
		
		WebElement xf = driver.findElement(By.id("login_frame"));
		
		driver.switchTo().frame(xf);
		driver.findElement(By.id("switcher_plogin")).click();
		Thread.sleep(1000L);		
		driver.findElement(By.id("u")).sendKeys("1151674616");
		driver.findElement(By.id("p")).sendKeys("liuwei520!!");
		
		driver.findElement(By.id("login_button")).click();
		
		// 获取 网页的 title
		System.out.println("The testing page title is: " + driver.getTitle());
		//Thread.sleep(10000L);
	
		
	}
}
