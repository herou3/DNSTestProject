package uitests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.environment.Environment;
import org.openqa.selenium.By;
import utils.Logger;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

  public static boolean isDnsOpen(){
    return WebDriverRunner.getWebDriver().getCurrentUrl().contains(Environment.getCurrentEnvironment().getUrl());
  }

  public static void openDns(){
    System.out.println(Environment.getCurrentEnvironment().getUrl());
    WebDriverRunner.getWebDriver().get(Environment.getCurrentEnvironment().getUrl());
  }

  public abstract void shouldBeShown();

  public static void sleep(int seconds) {
    Selenide.sleep(seconds * 1000);
  }

  public static void waitOneOf(long millis, By... locators) {
    int sleepTime = 500;
    do {
      for (By loc : locators) {
        if ($(loc).isDisplayed()) {
          Selenide.sleep(sleepTime);
          if ($(loc).isDisplayed()) //first time it can be displayed before java script hides it
            return;
        }
      }
      Selenide.sleep(sleepTime);
      millis -= sleepTime;
    } while (millis > 0);
    Logger.getLogger().addInfo("no one locator is found");
  }
}
