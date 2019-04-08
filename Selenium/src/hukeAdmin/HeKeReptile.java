package hukeAdmin;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.ImageDTO;
import util.ImageUtil;
import util.PubUtil;

public class HeKeReptile {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		// 如果测试的浏览器没有安装在默认目录，那么必须在程序中设置
		// bug1:System.setProperty("webdriver.chrome.driver", "C://Program Files
		// (x86)//Google//Chrome//Application//chrome.exe");
		// bug2:System.setProperty("webdriver.chrome.driver",
		// "C://Users//Yoga//Downloads//chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "F://chromedriver//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://27.24.159.151:8005/Login.aspx");
		// 获取 网页的 title
		System.out.println("The testing page title is: " + driver.getTitle());

		driver.findElement(By.id("txtUserName")).sendKeys("140321031");
		driver.findElement(By.id("txtPassWord")).sendKeys("xyz357357");
		// 获取验证码
		WebElement ele = driver.findElement(By.id("getcode"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);
		Point point = ele.getLocation();
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String path = "F:/Verification/"+df.format(new Date())+".png";
		File screenshotLocation = new File(path);
		PubUtil.copyFile(screenshot, screenshotLocation);
		ImageDTO dto =ImageUtil.wordsDistinguish(path);
		String code = dto.getWords_result().get(0).getWords();
		driver.findElement(By.id("txtVerifyCode")).sendKeys(code);
		Thread.sleep(2000L);
		driver.findElement(By.id("btnLogin")).click();;
		// driver.quit();
	}

}
