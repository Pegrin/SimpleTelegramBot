package org.wtiger.telegram;

import com.beust.jcommander.Parameter;

/**
 * Created by SBT-khayrutdinov-mr on 21.03.2018.
 */
public class BotConfig {
  @Parameter(names = {"-n", "--name"}, required = true, description = "Bot username in telegram")
  private static String botName;
  @Parameter(names = {"-t", "--token"}, required = true, description = "Bot token")
  private static String token;
}
