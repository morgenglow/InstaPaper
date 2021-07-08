import PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AppiumDriver driver;
    private String URL ="http://127.0.0.1:4723/wd/hub";
    public LoginPageObject loginPageObject;

    @Before
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("appPackage","com.instapaper.android");
        capabilities.setCapability("appActivity",".LoginActivity");
        capabilities.setCapability("app","C:\\Users\\morge\\IdeaProjects\\InstaPaper\\src\\libs\\apks\\instapaper_4.5.apk");
        driver = new AndroidDriver(new URL(URL), capabilities);
        loginPageObject = new LoginPageObject(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
