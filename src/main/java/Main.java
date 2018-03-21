import com.beust.jcommander.JCommander;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.wtiger.telegram.bot.MyBot;

public class Main {
  public static void main(String[] args) {
    ApiContextInitializer.init();

    TelegramBotsApi botsApi = new TelegramBotsApi();
    MyBot bot = new MyBot();
    JCommander.newBuilder().addObject(bot).build().parse(args);
    try {
      System.out.println("Registering bot");
      botsApi.registerBot(bot);
      System.out.println("Registering successful");
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}
