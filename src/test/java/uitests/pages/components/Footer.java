package uitests.pages.components;

import com.codeborne.selenide.Condition;
import lombok.Getter;
import org.openqa.selenium.By;
import uitests.model.DisplayAble;

import static com.codeborne.selenide.Selenide.$;

public class Footer implements DisplayAble<Footer> {

  private static final String BASE_FOOTER_XPATH = "//footer";
  @Getter
  private static final By dnsLinkXpath = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--dns']");
  private static final By technoPointLinkXpath = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--tp']");
  private static final By serviceLinkXpath = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--service']");
  private static final By clubLinkXpath = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--club']");


  @Override
  public Footer shouldBeVisible() {
    $(dnsLinkXpath).shouldBe(Condition.visible);
    $(technoPointLinkXpath).shouldBe(Condition.visible);
    $(serviceLinkXpath).shouldBe(Condition.visible);
    $(clubLinkXpath).shouldBe(Condition.visible);
    return this;
  }

  @Override
  public Footer shouldNotBeVisible() {
    $(dnsLinkXpath).shouldBe(Condition.hidden);
    $(technoPointLinkXpath).shouldBe(Condition.hidden);
    $(serviceLinkXpath).shouldBe(Condition.hidden);
    $(clubLinkXpath).shouldBe(Condition.hidden);
    return this;
  }
}
