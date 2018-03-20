import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.generics.BotOptions;
import org.telegram.telegrambots.generics.LongPollingBot;

import java.util.List;

/**
 * Created by SBT-khayrutdinov-mr on 20.03.2018.
 */
public class MyBot extends TelegramLongPollingBot {
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage message = new SendMessage()
          .setChatId(update.getMessage().getChatId())
          .setText(update.getMessage().getText());
      try {
        execute(message);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  public void onUpdatesReceived(List<Update> updates) {

  }

  public String getBotUsername() {
    return "<>";
  }

  public String getBotToken() {
    return "<>";
  }
}
