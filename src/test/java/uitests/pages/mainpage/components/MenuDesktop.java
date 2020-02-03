package uitests.pages.mainpage.components;

import org.openqa.selenium.By;
import uitests.model.DisplayAble;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MenuDesktop implements DisplayAble<MenuDesktop> {
  private static final String BASE_MENU_GRID_XPATH = "//div[@class='menu-desktop']";
  private static final String FIRST_LVL_ROWS_LINKS_XPATH = BASE_MENU_GRID_XPATH + "//child::a[@class='ui-link menu-desktop__root-title']";
  private static final String SECOND_LVL_ROWS_LINKS_XPATH = BASE_MENU_GRID_XPATH + "//child::a[@class='ui-link menu-desktop__second-level']";
  private static final String THIRD_LVL_ROWS_LINKS_XPATH = BASE_MENU_GRID_XPATH + "//child::a[@class='ui-link menu-desktop__popup-link']";

  @Override
  public MenuDesktop shouldBeVisible() {
    $$(By.xpath(FIRST_LVL_ROWS_LINKS_XPATH)).shouldHave(size(10));
    return this;
  }

  @Override
  public MenuDesktop shouldNotBeVisible() {
    return this;
  }

  public void focusAnFirstLevelLink(String nameLink) {
    $(By.xpath(FIRST_LVL_ROWS_LINKS_XPATH +"[contains(text(),'" + nameLink + "')]")).hover();
  }

  public void focusAnSecondLevelLink(String nameLink) {
    $(By.xpath(SECOND_LVL_ROWS_LINKS_XPATH + "[contains(text(),'" + nameLink + "')]")).hover();
  }

  public void clickToTheThirdLevelLink(String nameLink) {
    $(By.xpath(THIRD_LVL_ROWS_LINKS_XPATH + "[contains(text(),'" + nameLink + "')]")).click();
  }
}
