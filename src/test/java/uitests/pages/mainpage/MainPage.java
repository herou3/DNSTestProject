package uitests.pages.mainpage;

import uitests.pages.BasePage;
import uitests.pages.components.Footer;

import static uitests.assistants.StepsUtils.waitPageIsLoaded;

public class MainPage extends BasePage {
  Footer footer = new Footer();

  @Override
  public void shouldBeShown() {
    waitPageIsLoaded();
    footer.shouldBeVisible();
  }
}
