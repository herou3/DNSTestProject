package uitests.pages.productlistpage.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import uitests.assistants.CollectionUtils;
import uitests.model.DisplayAble;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Products implements DisplayAble<Products> {

  private static final String PRODUCT_BLOCK_XPATH = "//div[@class='catalog-item']";
  private static final String PRODUCT_CATALOG_XPATH = "//div[@class='products-list__content']";

  @Override
  public Products shouldBeVisible() {
    $(By.xpath(PRODUCT_CATALOG_XPATH)).shouldBe(Condition.visible);
    return this;
  }

  @Override
  public Products shouldNotBeVisible() {
    return null;
  }

  public SelenideElement getTitleCellByIndex(int index) {
    return $$(By.xpath(PRODUCT_BLOCK_XPATH+"//child::a[@class='ui-link']")).get(index);
  }

  public void addElementForCompare(int index) {
    $$(By.xpath(PRODUCT_BLOCK_XPATH+"//child::span[@class='ui-checkbox__box']")).get(index).click();
  }

  public boolean isContainsText(String nameProduceCompany) {
    ElementsCollection selenideElements = $$(By.xpath(PRODUCT_BLOCK_XPATH+"//child::a[@class='ui-link']"));
    return CollectionUtils.allElementsShouldHaveText(selenideElements,nameProduceCompany);
  }

  public boolean isContainsText(String valueOne, String valueTwo) {
    ElementsCollection selenideElements = $$(By.xpath(PRODUCT_BLOCK_XPATH+"//child::a[@class='ui-link']"));
    return CollectionUtils.allElementsShouldHaveText(selenideElements,valueOne,valueTwo);
  }

  public boolean isSearchResultEquals(int count) {
    if ($$(By.xpath(PRODUCT_BLOCK_XPATH+"//child::a[@class='ui-link']")).size() == count) {
      return true;
    } else {
      return false;
    }
  }
}
