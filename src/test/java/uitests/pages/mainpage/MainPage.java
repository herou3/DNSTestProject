package uitests.pages.mainpage;

import uitests.pages.BasePage;
import uitests.pages.components.Footer;
import uitests.pages.components.Header;
import uitests.pages.mainpage.components.MenuDesktop;

import static uitests.assistants.StepsUtils.waitPageIsLoaded;

public class MainPage extends BasePage {
  private Footer footer = new Footer();
  private Header header = new Header();
  private MenuDesktop menuDesktop = new MenuDesktop();

  @Override
  public void shouldBeShown() {
    waitPageIsLoaded();
    footer.shouldBeVisible();
    header.shouldBeVisible();
    menuDesktop.shouldBeVisible();
  }

  public void selectSmartPhones(String nameFirstLevelLink, String nameSecondLink, String nameThirdLink) {
    menuDesktop.focusAnFirstLevelLink(nameFirstLevelLink);
    menuDesktop.focusAnSecondLevelLink(nameSecondLink);
    menuDesktop.clickToTheThirdLevelLink(nameThirdLink);
  }
}
