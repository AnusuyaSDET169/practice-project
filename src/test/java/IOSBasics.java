

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseClass{

    @Test
    public void IOSBasicsTest() throws InterruptedException {
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Alert Views'`]")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Text Entry\"")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`label=='Horizontal scroll bar, 1 page'`]")).sendKeys("Anusuya");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"OK\"`]")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm / Cancel\" AND value==\"Confirm / Cancel\"")).click();
        String Text=driver.findElement(AppiumBy.accessibilityId("A message should be a short, complete sentence.")).getText();
        System.out.println(Text);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label=='Confirm'`]")).click();

        // Thread.sleep(2000);


    }
}
