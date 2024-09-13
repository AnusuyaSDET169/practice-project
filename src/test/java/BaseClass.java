import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import pageObjects.Android.FormPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class BaseClass {
public AndroidDriver driver;
public FormPage formpage;

    @BeforeClass
    public void setupConfig() throws MalformedURLException, URISyntaxException {

        //code to start appium server programatically
   /* AppiumDriverLocalService service=new AppiumServiceBuilder()
            .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
            .withIPAddress("http://127.0.0.1").usingPort(4723).build();
    service.start();*/

//Capabilities pf Android device are added using UIautomator2options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("AnuAndroidEmulator");
        options.setDeviceName("ViniHybridEmulator");
      //options.setApp("//Users//anusuyaselvaraj//IdeaProjects//Appium//src//test//java//Utils//ApiDemos-debug.apk");
        options.setApp("//Users//anusuyaselvaraj//IdeaProjects//Appium//src//test//java//Utils//General-Store.apk");
        options.setChromedriverExecutable("//Users//anusuyaselvaraj//Downloads//chromedriver 2");
        //invoking driver which is used to automate on Android devices
        //Any Appium/java code--->Appium server- it redirects the actions to be executed in --> Android Virtual Device (UIAutomator2)
        //Android driver
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         formpage=new FormPage(driver);

    }
    public void LongPressAction(WebElement actualelement)
    {
        ((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)actualelement).getId(),
                        "duration",2000));
    }


    public void ScrollToEndAction()
    {//when u dont where to go no idea where to go just scroll little by little
        // based on co ordinates-scroll untill end using dowhile loop
     boolean canScrollMore;
     do {
          canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                   "direction", "down",
                    "percent", 3.0
         ));
       }while(canScrollMore);
    }

    public void SwipeAction(WebElement ele,String direction)
    {
        //Swipe Code -Appium GITHUB Gestures
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "direction",direction ,
                        "percent", 0.75));

    }

    public void DragAndDropAction(WebElement source)
    {

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 277,
                "endY", 762
        ));
    }

    public Double GetFormattedAmount(String amountString)
    {

        Double price=  Double.parseDouble(amountString.substring(1));
         return price;
    }
/*
@AfterClass
    public void closeAndExit(){

driver.quit();
//service.stop();

    }*/
}

