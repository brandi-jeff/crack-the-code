package com.crackthecode.jewels.controller;

import com.crackthecode.jewels.model.Cipher;
import com.crackthecode.jewels.model.Game;
import com.crackthecode.jewels.model.Guess;
import com.crackthecode.jewels.model.exceptions.DuplicateGuessException;
import com.crackthecode.jewels.model.exceptions.InvalidGuessException;
import com.crackthecode.jewels.view.GameView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * <strong>GameController</strong> class controls the game and user input.
 */

public class GameController {

  private final Game game;
  private final Guess guess;

  private final Cipher cipher;
  private final GameView view;
  private final PrintStream output;
  private final BufferedReader input;


  public GameController(Game game, Guess guess, Cipher cipher, GameView view, PrintStream output,
      BufferedReader input) {
    this.game = game;
    this.guess = guess;
    this.cipher = cipher;
    this.view = view;
    this.output = output;
    this.input = input;
  }

  /**
   * <p> This method starts game play, handles user input, and handles potential exceptions that
   * could occur in the game. </p>
   * @throws IOException Unable to read user input; unable to continue
   */

  public void playGame() throws IOException {
    do {
      output.print("\nEnter Guess: ");
      String input = null;
      try {
        input = this.input.readLine().strip();
        if (input.equals("#")) {
          output.print("\nIf you are sure you want to exit this challenge, type 'exit'.\n"
              + "If you want to continue with this challenge, please enter your guess.\n");
          input = this.input.readLine().toLowerCase();
          if (input.isEmpty() || input.equals("exit")) {
            output.print(
                "\nYour choice to stop playing means you have given up your life of crime. Good luck! \n"
                    + "If you change your mind, come back and play Crack the Code!\n");
            System.exit(0);
          }
        }
        guess.setCurrentGuess(input);
        game.checkGuess(guess);
        output.print(view.getGameBoard(guess, game, cipher));
      } catch (InvalidGuessException e) {
        output.printf(
            "Invalid Input: %s%n Guess must be %d characters long and may only contain the following characters: %s \n ",
            input, Guess.GUESS_LENGTH,
            cipher.getPool());
      } catch (DuplicateGuessException e) {
        output.printf(
            " Invalid Input: %s%n You already tried this guess in this game. Guess something different. \n ",
            input);
      }
    } while (!game.isCompleted());
  }
}