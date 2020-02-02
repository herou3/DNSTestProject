package config.browser;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.SystemUtils;

@RequiredArgsConstructor
public enum Browsers {
  CHROME("chromedriver.exe"),
  CHROME_MAC("chromedriver"),
  OPERA("operadriver.exe"),
  OPERA_MAC("operadriver");

  @NonNull
  String fileName;

  public String getRelativePathToDriver() {
    if(SystemUtils.IS_OS_MAC){
      return "/src/main/resources/drivers/" +fileName;
    } else {
      return "\\src\\main\\resources\\drivers\\" +fileName;
    }
  }

  @Override
  public String toString() {
    return this.name();
  }
}