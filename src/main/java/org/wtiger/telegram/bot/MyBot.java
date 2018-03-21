package org.wtiger.telegram.bot;

import com.beust.jcommander.Parameter;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;

/**
 * Основной класс бота
 */
public class MyBot extends TelegramLongPollingBot {
  @Parameter(names = {"-n", "--name"}, required = true, description = "Bot username in telegram")
  private static String botName;
  @Parameter(names = {"-t", "--token"}, required = true, description = "Bot token")
  private static String token;

  public void onUpdateReceived(Update update) {
    System.out.println(update); //Входяшее сообщение
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage message = new SendMessage()
          .setChatId(update.getMessage().getChatId())
          .setText(update.getMessage().getText());
      try {
        System.out.println(message); //Исходящее сообщение
        execute(message);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  public String getBotUsername() {
    return botName;
  }

  public String getBotToken() {
    return token;
  }
}
