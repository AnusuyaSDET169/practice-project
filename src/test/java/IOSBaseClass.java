

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.remote.MobilePlatform.IOS;


public class IOSBaseClass {
    public IOSDriver driver;

    @BeforeClass
    public void setupConfig() throws URISyntaxException, MalformedURLException {

        //Capabilities of IOS device are added using XCUI Options
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 13 Pro");
        options.setPlatformVersion("15.5");
        //options.setApp("//Users//anusuyaselvaraj//IdeaProjects//Appium//src//test//java//Utils//TestApp 3.app");
        options.setApp("/Users/anusuyaselvaraj/Library/Developer/Xcode/DerivedData/UIKitCatalog-ecnzlawiyrgnrogkfxfjbvivbywv/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        //Appium->uses WebDriver Agent->to talk to IOS devices(Where appium directly talks tp Android using UIautomator2 options)
        options.setWdaLaunchTimeout(Duration.ofSeconds(25));
        //invoking IOS driver which is used to automate on IOS devices
        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void touchAndHold(WebElement ele)
    {
        //either pass keyvalue pairs as ImmutableMap or we can also use Hash Map Concept(same key value pair)
        HashMap<String,Object> value=new HashMap<>();
        value.put("element",((RemoteWebElement)ele).getId());
        value.put("duration",5);
        driver.executeScript("mobile:touchAndHold",value);
    }
    @AfterClass
    public void closeAndExit(){

        driver.quit();
//service.stop();

    }
}

