package utilities;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class Waits extends ReleventCodesReports {

	
	public static void ExplicitWait(long a, WebElement Xpath){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(a) );
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));
	}


}
