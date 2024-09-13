package pageObjects.Android;

import Utils.AndroidGestureActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewCartPage extends AndroidGestureActions {

    AndroidDriver driver;

    public ViewCartPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Add thh sum of two products price and check total sum amount is same
    //This PageObjectPattern of defining the locator
    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    private List<WebElement> ProductPrices;

    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement TotalSumValue;


    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    private WebElement TermsAndCondition;
    @AndroidFindBy(id="android:id/button1")
    private WebElement CloseTerms;
    //checkbiox code

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    private WebElement SubmitOrder;

    //Actions Methods for the locators above

    public List<WebElement> getProductPrice()
    {

        return ProductPrices;
    }

    public double getSumOfProductsAdded()
    {
        int count=ProductPrices.size();
        double sum=0;
        for(int i=0;i<count;i++){
            String amountString= ProductPrices.get(i).getText();
            //$160.09-remove dollar from this string and then it has decimal so convert to double     `
            Double price=GetFormattedAmount(amountString);
            sum=sum+price;//160.97+120.0

        }
        return sum;
    }

    public Double getTotalSumDisplayed(){

        return GetFormattedAmount(TotalSumValue.getText());


    }
    public void AcceptTermsAndCondition() {
        LongPressAction(TermsAndCondition);
        CloseTerms.click();

    }

    public void SubmitOrder()
    {
        SubmitOrder.click();
    }






}
