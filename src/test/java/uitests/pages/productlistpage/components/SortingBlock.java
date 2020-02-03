package uitests.pages.productlistpage.components;

import org.openqa.selenium.By;
import uitests.model.DisplayAble;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SortingBlock implements DisplayAble<SortingBlock> {

  private final static String sortingOptionsXpath = "//div[@class='top-filter popover-wrapper']";
  private final static String breadCrumbXpath = "//ol[@class='breadcrumb']";
  private final static String sortingButtonXpath = "//span[@class='top-filter__selected']";
  private final static String sortingValuesXpath = "//div[@class='popover-block popover-block_show']//child::span[@class='ui-radio__content']";
  @Override
  public SortingBlock shouldBeVisible() {
    if($(By.xpath(breadCrumbXpath)).is(empty)) {
      $$(By.xpath(sortingOptionsXpath)).shouldHave(size(3));
    } else {
      $$(By.xpath(sortingOptionsXpath)).shouldHave(size(4));
    }
    return this;
  }

  @Override
  public SortingBlock shouldNotBeVisible() {
    return this;
  }

  public void selectSortingRule(int number) {
    $$(By.xpath(sortingButtonXpath)).get(0).click();
    $$(By.xpath(sortingValuesXpath)).get(number).click();
  }
}
