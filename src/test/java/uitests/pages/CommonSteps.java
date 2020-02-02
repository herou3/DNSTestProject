package uitests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommonSteps {

  public static void clearCookie() {
    if (WebDriverRunner.hasWebDriverStarted() && !url().startsWith("data")) {
      try {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.clearBrowserCache();
        Logger.getLogger().addInfo("deleting cookies...");
      } catch (Exception e) {
        Logger.getLogger().warn("exception occurs while trying clear cookies {}", e);
      }
    }
  }

  public static void clearLocalStorage() {
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
    try {
      if (WebDriverRunner.hasWebDriverStarted() && !url().contains("data:")) {
        Logger.getLogger().addInfo("clearing local storage...");
        javascriptExecutor.executeScript("window.localStorage.clear();");
      }
    } catch (Exception e) {
      Logger.getLogger().warn("exception occurs while trying clear local storage {}", e);
    }
  }

  public static void refresh() {
    Selenide.refresh();
  }

  public static void goBack() {
    Selenide.back();
  }

  public static void elementWithTextShouldNotBeVisible(String text) {
    final By locator = By.xpath("//*[contains(text(),'" + text + "')]");
    $(locator).shouldNotBe(Condition.visible);
  }
}
