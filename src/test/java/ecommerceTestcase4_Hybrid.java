import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Android.FormPage;
import pageObjects.Android.ProductCataloguePage;
import pageObjects.Android.ViewCartPage;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class ecommerceTestcase4_Hybrid extends BaseClass {

    @Test
    public void Testcase4() throws InterruptedException {


        formpage.setCountrySelection("Australia");
        formpage.setNameField("Anusuya Selvaraj");
        formpage.setGender("female");
        ProductCataloguePage productcatalog=formpage.SubmitForm();
        productcatalog.setProductsAddedByIndex(0);
        productcatalog.setProductsAddedByIndex(0);
        ViewCartPage viewCartPage=productcatalog.setViewCartButton();
        viewCartPage.getProductPrice();
        Double sum=viewCartPage.getSumOfProductsAdded();
        Double TotalSumValue=viewCartPage.getTotalSumDisplayed();
        Assert.assertEquals(sum,TotalSumValue);
        viewCartPage.AcceptTermsAndCondition();
        viewCartPage.SubmitOrder();

      //  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

       //Switching to WebBrowser from native app -Context Chnage from native to Web
       Set<String> context= driver.getContextHandles();
       for(String contextName:context) {
           System.out.println(contextName);
       }
       /*     NATIVE_APP
             WEBVIEW_com.google.android.googlequicksearchbox:search
             WEBVIEW_com.androidsample.generalstore
        */
      driver.context( "WEBVIEW_com.androidsample.generalstore");

      driver.findElement(By.name("q")).sendKeys("rahulacademy");
      driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
      driver.pressKey(new KeyEvent(AndroidKey.BACK));
      //switching context to native
       // driver.context("NATIVE_APP");
    }

    }


