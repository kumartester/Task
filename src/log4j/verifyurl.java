package log4j;
import org.openqa.selenium.WebDriver;
public class verifyurl {
	public static void validateurl(WebDriver driver, String expurl)
	{
		boolean result = false;
		if (driver.getCurrentUrl().equalsIgnoreCase(expurl))
		{
	}
}
}