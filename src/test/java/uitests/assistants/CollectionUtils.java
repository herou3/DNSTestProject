package uitests.assistants;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;

public class CollectionUtils {

  public static void AllElementsShouldHaveText(ElementsCollection collection, String desiredText) {
    collection
      .stream()
      .forEach(element -> element.shouldHave(text(desiredText)));
  }
}
