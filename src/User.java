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
            System.out.printf((i + 1) + ". %-20s: COMPLETED", games[i].getName());
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
        String input = "";
        boolean repeatMethod = true;
        listGames();
        System.out.println("Which game do you want to remove? (Input a number): ");




    }

}
