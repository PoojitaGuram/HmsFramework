package pratice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinktest {
	public static void main(String[] args) throws IOException {
		//launch browser
		WebDriver driver=new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		//enter url
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		// wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		//find all the links
		List<WebElement> Alllinks = driver.findElements(By.xpath("//a"));
		ArrayList<String> Arraylinks = new ArrayList<String>();
		System.out.println(Alllinks.size());
		// for each loop
		for (WebElement webElement : Alllinks) {
			String eachlink = webElement.getAttribute("href");
			URL url=null;
			int statuscode=0;
			try {
				 url = new URL(eachlink);
				HttpURLConnection httpurlconn = (HttpURLConnection) url.openConnection();
				statuscode = httpurlconn.getResponseCode();
				
				if(statuscode>=400) {
					Arraylinks.add(eachlink);
					System.out.println(eachlink +"----->"+ statuscode);
				}
			}
				catch (MalformedURLException exp) {
			
				}
					
			
		}
			
		}
		
	}


