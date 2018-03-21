package org.wtiger.telegram.bot;

import com.beust.jcommander.Parameter;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramWebhookBot;

/**
 * Бот на вебхуках
 */
public class MyWebHookBot extends TelegramWebhookBot {
  @Parameter(names = {"-n", "--name"}, required = true, description = "Bot username in telegram")
  private static String botName;
  @Parameter(names = {"-t", "--token"}, required = true, description = "Bot token")
  private static String token;

  @Override
  public BotApiMethod onWebhookUpdateReceived(Update update) {
    return null;
  }

  @Override
  public String getBotUsername() {
    return botName;
  }

  @Override
  public String getBotPath() {
    return "bibika";
  }

  @Override
  public String getBotToken() {
    return token;
  }
}
