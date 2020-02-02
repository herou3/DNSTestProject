package uitests.assistants;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Logger;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class StepsUtils {

  public static void waitPageIsLoaded() {
    try {
      Function<WebDriver, Boolean> pageLoaded = wd -> ((JavascriptExecutor) wd).executeScript(
        "return document.readyState").equals("complete");
      new FluentWait<>(WebDriverRunner.getWebDriver())
        .withTimeout(Configuration.timeout, TimeUnit.MILLISECONDS)
        .until(pageLoaded);
    } catch (Exception e) {
      Logger.getLogger().addInfo(("error in waitPageIsLoaded(): " + e));
    }
  }

  public static void sleep(int seconds) {
    Selenide.sleep(seconds * 1000);
  }
}