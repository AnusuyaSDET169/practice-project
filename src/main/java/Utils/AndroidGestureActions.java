package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidGestureActions {
    AndroidDriver driver;

    public AndroidGestureActions(AndroidDriver driver)
    {
        this.driver=driver;
    }


    public void ScrollToElement(String Text)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Text\"));"));


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

}


