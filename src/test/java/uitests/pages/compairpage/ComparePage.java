package uitests.pages.compairpage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.assistants.CollectionUtils;
import uitests.pages.BasePage;
import uitests.pages.components.Footer;
import uitests.pages.components.Header;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComparePage extends BasePage {

  private Header header = new Header();
  private Footer footer = new Footer();

  private static final String COMPARE_BLOCK_XPATH = "//div[@class='compare-page']";
  private static final String pageTitleXpath = "//h1[@class='hidden-sm hidden-xs']";
  private static final String onlyEqualsPropertiesSpanXpath = COMPARE_BLOCK_XPATH + "//child::span[@class='ui-toggle__slider']";

  private static final String PRODUCT_CELLS_XPATH = "//div[@class='product']";
  private static final String codeProductSpanXpath = PRODUCT_CELLS_XPATH + "//child::span[@data-product-param='code']";
  private static final String DIFFERENT_CELL_XPATH = "//div[@class='table-row different']";

  @Override
  public void shouldBeShown() {
    header.shouldBeVisible();
    footer.shouldBeVisible();
    $(By.xpath(pageTitleXpath)).shouldBe(Condition.visible);
  }

  public void clickOnlyEqualsPropertiesSpanXpath() {
    $(By.xpath(onlyEqualsPropertiesSpanXpath)).click();
  }

  public boolean isDifferentValues() {
    String firstProductCode = $$(By.xpath(codeProductSpanXpath)).get(0).getText();
    String secondProductCode = $$(By.xpath(codeProductSpanXpath)).get(1).getText();

    return CollectionUtils.isDifferentCollectionsValues($$(By.xpath(DIFFERENT_CELL_XPATH+"//child::div[@data-product-id='"+firstProductCode+"']")),
                                                        $$(By.xpath(DIFFERENT_CELL_XPATH+"//child::div[@data-product-id='"+secondProductCode+"']")));
  }
}
