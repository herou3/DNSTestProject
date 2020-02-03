package uitests.pages.detailproductpage;

import org.openqa.selenium.By;
import uitests.pages.BasePage;
import uitests.pages.CommonSteps;
import uitests.pages.components.Footer;
import uitests.pages.components.Header;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DetailProductPage extends BasePage {

  Header header = new Header();
  Footer footer = new Footer();

  private static final String priceCurrentPriceXpath = "//span[@class='current-price-value']";
  private static final String extraWarrantySelectXpath = "//select[@class='form-control select']";

  @Override
  public void shouldBeShown() {
    header.shouldBeVisible();
    footer.shouldBeVisible();
  }

  public int selectCurrentPrice() {
    return CommonSteps.valueWithoutSpace($$(By.xpath(priceCurrentPriceXpath)).get(0).text());
  }

  public void chooseExtraWarranty() {
    $(By.xpath(extraWarrantySelectXpath)).click();
    $(By.xpath(extraWarrantySelectXpath+"//child::option[@value='1']")).click();
  }
}
