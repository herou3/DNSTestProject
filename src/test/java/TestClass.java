import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import uitests.pages.CommonSteps;
import uitests.pages.mainpage.MainPage;
import utils.Logger;

import static uitests.config.Hooks.startUpBrowser;

public class TestClass {

  @BeforeSuite
  public void prepareStage(){
    startUpBrowser();
  }

  @AfterSuite
  public void clearStage() {
    CommonSteps.clearCookie();
    CommonSteps.clearLocalStorage();
  }
  @Test
  public static void testMethod() {
    MainPage mainPage = new MainPage();
    MainPage.openDns();
    MainPage.isDnsOpen();
    mainPage.shouldBeShown();
  }

}
