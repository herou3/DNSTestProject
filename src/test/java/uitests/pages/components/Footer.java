package uitests.pages.components;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import uitests.model.DisplayAble;

import static com.codeborne.selenide.Selenide.$;

public class Footer implements DisplayAble<Footer> {

  public static final String BASE_FOOTER_XPATH = "//footer";
  public static final By dnsLink = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--dns']");
  public static final By technoPointLink = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--tp']");
  public static final By serviceLink = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--service']");
  public static final By clubLink = By.xpath(BASE_FOOTER_XPATH + "//child::a[@class='main-footer__sites-link main-footer__sites-link--club']");


  @Override
  public Footer shouldBeVisible() {
    $(dnsLink).shouldBe(Condition.visible);
    $(technoPointLink).shouldBe(Condition.visible);
    $(serviceLink).shouldBe(Condition.visible);
    $(clubLink).shouldBe(Condition.visible);
    return this;
  }

  @Override
  public Footer shouldNotBeVisible() {
    $(dnsLink).shouldBe(Condition.hidden);
    $(technoPointLink).shouldBe(Condition.hidden);
    $(serviceLink).shouldBe(Condition.hidden);
    $(clubLink).shouldBe(Condition.hidden);
    return this;
  }
}
