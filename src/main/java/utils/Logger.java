package utils;

public class Logger {

  private static Logger logger;

  private String logs = "";

  public static Logger getLogger() {
    if (logger == null) {
      logger = new Logger();
    }

    return logger;
  }

  private Logger() {}

  public void addInfo(String text) {
    this.logs += text + "\n";
  }

  public String showLogs() {
    return logs;
  }

  public void warn(String text, Exception e) {
    this.logs += text + "\n";
    this.logs += e.getMessage();
  }
}
