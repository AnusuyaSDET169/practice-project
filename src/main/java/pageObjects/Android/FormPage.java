package pageObjects.Android;

import Utils.AndroidGestureActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidGestureActions {
    AndroidDriver driver;

     public FormPage(AndroidDriver driver)
     {
         super(driver);
         this.driver=  driver;
         PageFactory.initElements(new AppiumFieldDecorator(driver),this);
     }

  //This PageObjectPattern of defining the locator

    @AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countrySelection;

     @AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\\\"com.androidsample.generalstore:id/nameField\\\"])")
     private WebElement nameField;

     @AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
     private  WebElement femaleOption;
    @AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radiomale\"]")
    private  WebElement maleOption;

     @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private  WebElement letShopButton;


     //Once Locator is defined  then we need to create Action methods to perform action

    public void setCountrySelection(String countryName) {
        countrySelection.click();
        ScrollToElement(countryName);
        // as its selected Dynamically , we need to pass the country name we need on runtime
        driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
    }

    public void setNameField(String name) {
          nameField.sendKeys(name);
          driver.hideKeyboard();
       }

    public void setGender(String gendername) {

        if (gendername.contains("female"))
            femaleOption.click();
        else
            maleOption.click();
    }
    public ProductCataloguePage SubmitForm(){

        letShopButton.click();
       return new ProductCataloguePage(driver);
      }

}
