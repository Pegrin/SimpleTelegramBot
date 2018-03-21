import com.beust.jcommander.JCommander;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.wtiger.telegram.bot.MyLongPollBot;
import org.wtiger.telegram.bot.MyWebHookBot;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    ApiContextInitializer.init();

    TelegramBotsApi botsApi = new TelegramBotsApi();
    MyLongPollBot myLongPollBot = new MyLongPollBot();
    MyWebHookBot myWebHookBot = new MyWebHookBot();
    JCommander.newBuilder()
        .addObject(myLongPollBot)
        .addObject(myWebHookBot)
        .build()
        .parse(args);
    try {
      System.out.println("Registering bot");
      botsApi.registerBot(myLongPollBot);
      botsApi.registerBot(myWebHookBot);
      System.out.println("Registering successful");
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}
