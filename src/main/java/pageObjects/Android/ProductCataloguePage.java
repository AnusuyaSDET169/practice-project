package pageObjects.Android;

import Utils.AndroidGestureActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends AndroidGestureActions {
    AndroidDriver driver;

    public ProductCataloguePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //This PageObjectPattern of defining the locator
    //Adding any first two products in product list page //indexing will not as teh Add to cart will change to added to cart so use get(0)

    @AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
     private List<WebElement> ProductsAdded;

     @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
     private WebElement ViewCartButton;

     //Action methods for above page object locators
      public void setProductsAddedByIndex(int index)
      {
          ProductsAdded.get(index).click();

      }

      public ViewCartPage setViewCartButton()
      {
          ViewCartButton.click();
         return new ViewCartPage(driver);
      }



}