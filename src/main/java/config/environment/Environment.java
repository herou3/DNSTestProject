package config.environment;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Environment {
  PROD("https://www.dns-shop.ru/"){
  };

  @Getter
  @NonNull
  String url;

  @Getter
  private static Environment currentEnvironment = resolveEnvironment();


  private static Environment resolveEnvironment() {
    String env = System.getenv().get("environment");
    Environment result = env == null ? PROD : Environment.valueOf(env.toUpperCase());
    return result;
  }
}
