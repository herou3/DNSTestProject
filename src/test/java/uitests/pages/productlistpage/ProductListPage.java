package uitests.pages.productlistpage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.pages.BasePage;
import uitests.pages.components.Footer;
import uitests.pages.components.Header;
import uitests.pages.productlistpage.components.FiltersBlock;
import uitests.pages.productlistpage.components.Products;
import uitests.pages.productlistpage.components.SortingBlock;

import static com.codeborne.selenide.Selenide.$;

public class ProductListPage extends BasePage {

  private int valueScrollOne = 3;
  private int valueScrollTwo = 9;

  private Footer footer = new Footer();
  private Header header = new Header();
  private FiltersBlock filtersBlock = new FiltersBlock();
  private SortingBlock sortingBlock = new SortingBlock();
  private Products products = new Products();

  private final static String nameTitleOfPageXpath = "//div[@class='products-page__title']//child::h1";
  private final static String productCountXpath = "//div[@class='products-page__title']//span[@class='products-count']";

  @Override
  public void shouldBeShown() {
    footer.shouldBeVisible();
    header.shouldBeVisible();
    filtersBlock.shouldBeVisible();
    sortingBlock.shouldBeVisible();
    products.shouldBeVisible();
    $(By.xpath(nameTitleOfPageXpath)).shouldBe(Condition.visible);
    $(By.xpath(productCountXpath)).shouldBe(Condition.visible);
  }

  private void scrollAnElement(int index) {
    products.getTitleCellByIndex(index).scrollTo();
  }

  public void chooseFilterForProducts(String price, String producerName, int memoryValuefirst, int memoryValueSecond) {
    filtersBlock.selectPriceForProducts(price);
    scrollAnElement(valueScrollOne);
    filtersBlock.clickShowMoreProducersButton();
    filtersBlock.selectProducerProduct(producerName);
    filtersBlock.clickCountMemoryFilter();
    filtersBlock.selectMemoryForPhone(memoryValuefirst);
    sleep(1);
    filtersBlock.selectMemoryForPhone(memoryValueSecond);
    scrollAnElement(valueScrollTwo);
    filtersBlock.applyFiltersWithUseButtun();
  }

  public void chooseFilterForProductions(String price) {
    filtersBlock.selectPriceForProducts(price);
    scrollAnElement(valueScrollTwo);
    filtersBlock.applyFiltersWithUseButtun();
  }

  public void chooseFilterForProductions(String price, String producerName) {
    filtersBlock.selectPriceForProducts(price);
    scrollAnElement(valueScrollOne);
    filtersBlock.selectProducerProduct(producerName);
    sleep(1);
    filtersBlock.applyFiltersWithUseFlyDiv();
  }

  public boolean isContainsValue(String text) {
    return products.isContainsText(text);
  }

  public boolean isContainsValue(String valueOne, String valueTwo) {
    return products.isContainsText(valueOne, valueTwo);
  }

  public void addElementForCompare(int index) {
    products.addElementForCompare(index);
    sleep(2);
  }

  public void openProductDetailPage(int index) {
    sleep(2);
    if(products.getTitleCellByIndex(index).isDisplayed() && products.getTitleCellByIndex(index).isEnabled())
      products.getTitleCellByIndex(index).click();
  }

  public void directToCompairePage() {
    header.clickCompaireButton();
  }

  public void selectSortingRule(int number) {
    sortingBlock.selectSortingRule(number);
  }
}
