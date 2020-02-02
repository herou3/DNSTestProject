package config;

import config.browser.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Logger;

import static config.browser.Browsers.CHROME;

public class WebDriverFactory {

  private static final String moduleDir = System.getProperty("user.dir");

  static public WebDriver getDriver(Browsers browser) {
    WebDriver driver;

    switch (browser) {
      case CHROME:
        Logger.getLogger().addInfo("starting CHROME");
        String chromdriverBinaryPath;
        if (SystemUtils.IS_OS_MAC) {
          browser = Browsers.CHROME_MAC;
          chromdriverBinaryPath = moduleDir + browser.getRelativePathToDriver();
        } else {
          browser = CHROME;
          chromdriverBinaryPath = moduleDir + browser.getRelativePathToDriver();
        }
        Logger.getLogger().addInfo("chromedriver set " + chromdriverBinaryPath);
        System.setProperty("webdriver.chrome.driver", chromdriverBinaryPath);

        ChromeOptions options = new ChromeOptions();
          Logger.getLogger().addInfo("headless chrome mode...");
          options.addArguments("--dns-prefetch-disable");
          options.addArguments("--test-type");
          options.addArguments("--disable-extensions");
          options.addArguments("--disable-infobars");
          options.addArguments("--no-sandbox");
          options.addArguments("--window-size=1920,3200");
          options.addArguments("--ignore-certificate-errors");
          DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setCapability(ChromeOptions.CAPABILITY, options);
          capabilities.setCapability("pageLoadStrategy", "none");

          driver = new ChromeDriver(capabilities);
          return driver;
      case OPERA:
        Logger.getLogger().addInfo("starting OPERA");
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
      default:
        Logger.getLogger().addInfo("!!!starting CHROME without options!!! browser not recognized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
  }
}
