package uitests.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverFactory;
import config.browser.Browsers;
import lombok.val;
import utils.Logger;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hooks {

  private static final String BROWSER_ENV_PROPERTY = "browser";
  private static final String HEADLESS_ENV_PROPERTY = "headless";
  private static final Properties properties = new Properties();

  public void prepareStage(){
    startUpBrowser();
  }

  public static void startUpBrowser() {
    Configuration.timeout = 20_000;
    Browsers browser = extractBrowser();
    boolean isHeadless = Boolean.parseBoolean(properties.getProperty(HEADLESS_ENV_PROPERTY));
    WebDriverRunner.setWebDriver(WebDriverFactory.getDriver(browser));
    WebDriverRunner.clearBrowserCache();
    WebDriverRunner.supportsJavascript();
    WebDriverRunner.getWebDriver().manage().window().maximize();
  }

  private static Browsers extractBrowser() {
    val browserProperty = properties.getProperty(BROWSER_ENV_PROPERTY);
    val browserEnvVar = System.getenv(BROWSER_ENV_PROPERTY);
    if(isBrowserValid(browserEnvVar)) {
      return Browsers.valueOf(browserEnvVar);
    }
    else if(isBrowserValid(browserProperty)){
      return Browsers.valueOf(browserProperty);
    }
    else {
      Logger.getLogger().addInfo("browser property {} not recognized, set default {}");
      return Browsers.CHROME;
    }
  }

  private static boolean isBrowserValid(String browser) {
    val browsersList = getBrowsersStringList();
    if (browser != null && browsersList.contains(browser.toUpperCase())) return true;
    return false;
  }

  private static List<String> getBrowsersStringList() {
    return Stream.of(Browsers.values())
      .map(Enum::name)
      .collect(Collectors.toList());
  }
}
