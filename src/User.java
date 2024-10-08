import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private String name;
    private Game[] games;
    private int numOfGames;

    public User() {
        this.name = "Default Name";
        this.numOfGames = 0;
        games = new Game[5];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addGame(Scanner sc) {
        boolean repeatMethod = true;
        boolean askAgain = true;
        String input = "";
        sc = new Scanner(System.in);

        while (repeatMethod) {
            if (numOfGames == games.length) {
                resizeListOfGames();
            }
            games[numOfGames] = new Game();

            System.out.print("Enter name of game: ");
            games[numOfGames].setName(sc.nextLine());
            numOfGames++;

            System.out.print("Would you like to add another game: y/n? ");
            input = sc.nextLine();

            while (askAgain) { // if user inputs something that isn't the letter Y or N then repeat the question
                if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                    System.out.print("Would you like to add another game: y/n? ");
                    input = sc.nextLine();
                } else if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                    askAgain = false;
                }
            }

            if (input.equalsIgnoreCase("y")) {
                repeatMethod = true;
            } else if (input.equalsIgnoreCase("n")) {
                repeatMethod = false;
            }

        }

    }

    public void resizeListOfGames() {
        Game[] newGames = games.clone();
        games = new Game[games.length * 2];
        for (int i = 0; i < numOfGames; i++) {
            games[i] = newGames[i];
        }
    }

    public void listGames() {
        int count = 0;
        System.out.println();
        System.out.println("List of games: ");
        for (int i = 0; i < numOfGames; i++) {
            System.out.printf((i + 1) + ". %-20s\n", games[i].getName());
            System.out.printf("Game Completion Status: " + "%-20s\n", games[i].printGameStatus());
            count++;
            if (count % 3 == 0) {
                System.out.println();
            }
        }

        if (numOfGames == 0) {
            System.out.println("You don't have any games.");
        }

        // TODO: Add option to ask user "Would you like to edit the details on a game?"
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public void removeGame(Scanner sc) {
        if (numOfGames > 0) {
            sc = new Scanner(System.in);
            int index = 0;
            boolean askAgain = true;
            this.listGames();
            System.out.println("Which game do you want to remove? (Input a number): ");

            while (askAgain) {
                try {
                    index = Integer.parseInt(sc.nextLine());
                    index--;
                    if (index >= 0 && index < numOfGames) {
                        askAgain = false;
                    } else {
                        System.out.print("Invalid number.. Please enter a valid number: ");
                    }
                } catch (Exception e) {
                    System.out.print("Invalid number.. Please enter a valid number: ");
                }
            }

            String nameOfGame = games[index].getName(); // get name of game at index before removing it.

            // TODO: add for loop that will remove the index, and shift everything down
            for (int i = index; i < numOfGames; i++) {
                if (i != numOfGames - 1) {
                    games[i] = games[i + 1];
                } else {
                    games[i] = null;
                }
            }
            numOfGames--;
            System.out.println(nameOfGame + " has been removed.");
        } else {
            System.out.println("You don't have any games. Please add a game before doing this option.");
        }

    }

    public void changeGameStatus(Scanner sc) {
        if (numOfGames > 0) {
            sc = new Scanner(System.in);
            int index = 0;
            String input = "";
            String oldStatus = "";
            boolean askAgain = true;
            this.listGames();
            System.out.println("Enter number of game to change status:");

            while (askAgain) {
                try {
                    index = Integer.parseInt(sc.nextLine());
                    index--;
                    if (index >= 0 && index < numOfGames) {
                        askAgain = false;
                    } else {
                        System.out.print("Invalid number.. Please enter a valid number: ");
                    }
                } catch (Exception e) {
                    System.out.print("Invalid number.. Please enter a valid number: ");
                }
            }

            oldStatus = games[index].printGameStatus();

            if (this.games[index].isGameBeaten()) {
                this.games[index].setGameBeaten(false);
            } else {
                this.games[index].setGameBeaten(true);
            }

            System.out.printf("%s status changed from %s to %s\n", this.games[index].getName(), oldStatus, this.games[index].printGameStatus());

        } else {
            System.out.println("You don't have any games. Please add a game before doing this option.");
        }

    }

}
