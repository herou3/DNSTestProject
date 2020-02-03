package uitests.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import uitests.pages.BasePage;
import uitests.pages.CommonSteps;
import uitests.pages.compairpage.ComparePage;
import uitests.pages.detailproductpage.DetailProductPage;
import uitests.pages.mainpage.MainPage;
import uitests.pages.productlistpage.ProductListPage;

import static uitests.config.Hooks.startUpBrowser;

public class TestsIncludeOneFromThree {

  @BeforeSuite
  public void prepareStage(){
    startUpBrowser();
  }

  @AfterSuite
  public void clearStage() {
    CommonSteps.clearCookie();
    CommonSteps.clearLocalStorage();
  }
  @Test(priority = 1)
  public static void checkWorkOfFilters() {
    CommonSteps.openDns();
    MainPage mainPage = new MainPage();
    mainPage.selectSmartPhones("Смартфоны", "Смартфоны", "2019 года");
    ProductListPage productListPage = new ProductListPage();
    productListPage.shouldBeShown();
    productListPage.chooseFilterForProducts("27 001 - 40 000", "Xiaomi", 64, 128);
    BasePage.sleep(2);
    Assert.assertTrue(productListPage.isContainsValue("Xiaomi"));
    Assert.assertTrue(productListPage.isContainsValue("128","64"));
  }

  @Test(priority = 2)
  public static void checkToCompareDevices() {
    CommonSteps.openDns();
    MainPage mainPage = new MainPage();
    mainPage.selectSmartPhones("Смартфоны", "Смартфоны", "2019 года");
    ProductListPage productListPage = new ProductListPage();
    productListPage.shouldBeShown();
    productListPage.chooseFilterForProductions("27 001 - 40 000");
    productListPage.addElementForCompare(1);
    productListPage.addElementForCompare(3);
    productListPage.directToCompairePage();
    ComparePage comparePage = new ComparePage();
    comparePage.shouldBeShown();
    comparePage.clickOnlyEqualsPropertiesSpanXpath();
    Assert.assertTrue(comparePage.isDifferentValues());
  }

  @Test(priority = 3)
  public static void checkToSelectExtraWarranty() {
    CommonSteps.openDns();
    MainPage mainPage = new MainPage();
    mainPage.selectSmartPhones("Смартфоны", "Смартфоны", "2019 года");
    ProductListPage productListPage = new ProductListPage();
    productListPage.shouldBeShown();
    productListPage.chooseFilterForProductions("40 001","Apple");
    productListPage.selectSortingRule(1);
    productListPage.openProductDetailPage(1);
    DetailProductPage detailProductPage = new DetailProductPage();
    detailProductPage.shouldBeShown();
    int priceWithoutExtraWarranty = detailProductPage.selectCurrentPrice();
    detailProductPage.chooseExtraWarranty();
    int priceWithExtraWarranty = detailProductPage.selectCurrentPrice();
    Assert.assertTrue(priceWithExtraWarranty > priceWithoutExtraWarranty);
    System.out.println(priceWithExtraWarranty - priceWithoutExtraWarranty);
  }
}
