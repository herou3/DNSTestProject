package uitests.pages.components;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.model.DisplayAble;

import static com.codeborne.selenide.Selenide.$;

public class Header implements DisplayAble<Header> {
  private static final String BASE_FOOTER_XPATH = "//header";
  private static final String searchBlockId = "header-search";
  private static final String headerTopBlockXpath = BASE_FOOTER_XPATH + "//child::div[@class='header-top']";
  private static final String dnsLogoId = "header-logo";
  private static final String compareButtonXpath = BASE_FOOTER_XPATH + "//span[contains(text(),'Сравнить')]";

  @Override
  public Header shouldBeVisible() {
    $(By.xpath(headerTopBlockXpath)).shouldBe(Condition.visible);
    $(By.id(searchBlockId)).shouldBe(Condition.visible);
    $(By.id(dnsLogoId)).shouldBe(Condition.visible);
    return this;
  }

  @Override
  public Header shouldNotBeVisible() {
    return this;
  }

  public void clickCompaireButton() {
    $(By.xpath(compareButtonXpath)).click();
  }
}
