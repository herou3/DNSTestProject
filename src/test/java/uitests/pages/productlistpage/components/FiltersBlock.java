package uitests.pages.productlistpage.components;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.model.DisplayAble;

import static com.codeborne.selenide.Selenide.$;

public class FiltersBlock implements DisplayAble<FiltersBlock> {

  private static final String BASE_LEFT_BLOCK_XPATH = "//div[@class='products-page__left-block']";
  private static final String filterOfPriceSpanXpath = BASE_LEFT_BLOCK_XPATH + "//child::span[(contains(text(), 'Цена'))]";

  // Optional elements
  private static final String showMoreProducersButtonXpath = "//div[@class='ui-collapse__content ui-collapse__content_list ui-collapse__content_in']//child::a[@class='ui-link ui-link_blue ui-link_pseudolink ui-list-controls__link ui-list-controls__link_fold']";
  private static final String checkBoxListXpath = "//label[@class='ui-checkbox ui-checkbox_list']";
  private static final String countMemoryFilterSpanXpath = "//div[@class='ui-list-controls ui-collapse ui-collapse_list']//child::span[contains(text(),'Объем встроенной памяти')]";
  private static final String priceRadioButtonListXpath = "//label[@class='ui-radio__item ui-radio__item_list']";
  private static final String applyfiltersButtonXpath = "//button[@class='button-ui button-ui_brand left-filters__button']";
  private static final String yearOfProductionSpanXpath = "//span[@class='ui-collapse__link-text' and contains(text(), 'Год выпуска')]";
  private static final String applyFlyDivXpath = "//div[@class='apply-filters-float-btn']";

  @Override
  public FiltersBlock shouldBeVisible() {
    $(By.xpath(filterOfPriceSpanXpath)).shouldBe(Condition.visible);
    return this;
  }

  @Override
  public FiltersBlock shouldNotBeVisible() {
    return this;
  }

  public void clickShowMoreProducersButton() {
    $(By.xpath(showMoreProducersButtonXpath)).click();
  }

  public void clickCountMemoryFilter() {
    $(By.xpath(countMemoryFilterSpanXpath)).click();
  }

  public void selectProducerProduct(String producerName) {
    $(By.xpath(checkBoxListXpath + "//child::span[contains(text(),'" + producerName + "')]")).click();
  }

  public void selectMemoryForPhone(int countMemory) {
    $(By.xpath(checkBoxListXpath + "//child::span[contains(text(),'" + countMemory + "')]")).click();
  }

  public void applyFiltersWithUseButtun() {
    $(By.xpath(yearOfProductionSpanXpath)).click();
    $(By.xpath(applyfiltersButtonXpath)).click();
  }

  public void applyFiltersWithUseFlyDiv() {
    $(By.xpath(applyFlyDivXpath)).click();
  }

  public void selectPriceForProducts(String price) {
    $(By.xpath(priceRadioButtonListXpath + "//child::span[contains(text(),'" + price + "')]")).click();
  }

}
