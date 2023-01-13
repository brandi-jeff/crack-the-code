package com.crackthecode.jewels.view;

import com.crackthecode.jewels.model.StatisticsManager;

/**
 * <strong>SessionView</strong> class provides the introduction to the game, the game rules, and a
 * way to view the player's stats.
 */

public class SessionView {


  public static final String GAME_STORY = "Welcome to Crack the Code! \n"
      + "You are a master of disguise who has a knack for tactically acquiring precious jewels. \n"
      + "You have come across a particularly challenging obstacle keeping you from the most precious jewel you have a encountered to date. \n"
      + "Your challenge, should you choose to accept it, will be to crack the cipher before the authorities arrive and capture you. \n"
      + "If you succeed, you will be the new owner of the rarest jewels known to man. \n"
      + "BUT, should you fail, all the jewels you have acquired will be lost, as will life as you know it. \n"
      + "If you wish to accept this challenge, press 'return'/'enter'. "
      + "Otherwise, press '#'\n";

  public static final String GAME_RULES =
      "\nGAME RULES: \n "
          + "1. Each cipher is %d characters long. \n "
          + "2. You have %d chances to crack the cipher. \n "
          + "3. You can choose from three levels. \n     "
          + "a. Level 1 allows the following characters: %s \n     "
          + "b. Level 2 allows the following characters: %s \n     "
          + "c. Level 3 allows the following characters: %s \n "
          + "4. Players may receive rubies and/or pearls after each guess. \n     "
          + "a. A ruby is awarded when you have chosen a correct character and it is in the correct position. \n     "
          + "b. A pearl is awarded when you have chosen a correct character but it is in the wrong position. \n     "
          + "c. You will NOT know which character returned the ruby and which character returned the pearl. \n "
          + "NOTE: Characters CAN be repeated. Remember to press 'return'/'enter' after each input. \n "
          + "**If at any point you would like to exit the challenge, press '#'.\n";

  StatisticsManager stats;

  public SessionView(StatisticsManager stats) {
    this.stats = stats;
  }
  /**
   * <p> The method returns a String representation of all stats from the current session.</p>
   * @return stats.toString()
   */

  public String getStats() {
    return stats.toString();
  }

}

