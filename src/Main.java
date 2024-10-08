import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueProgram = true;
        String input = "";
        User defaultUser = new User();

        System.out.println("[Video Game Logger Program]");
        System.out.print("Enter your username: ");
        defaultUser.setName(sc.nextLine());
        System.out.printf("Hello %s, select an option.\n", defaultUser.getName());

        while (continueProgram) {
            optionsMenu();
            System.out.print("Pick option: (enter number)");
            input = sc.nextLine();

            // Check if the input was invalid (not anything of the options)
            while (!input.equalsIgnoreCase("1") && !input.equalsIgnoreCase("2") && !input.equalsIgnoreCase("3") && !input.equalsIgnoreCase("4")&&  !input.equalsIgnoreCase("5")) {
                System.out.print("Pick option: ");
                input = sc.nextLine();
            }

            if (input.equalsIgnoreCase("1")) {
                defaultUser.listGames();
            } else if (input.equalsIgnoreCase("2")) {
                defaultUser.addGame(sc);
            } else if (input.equalsIgnoreCase("3")) {
                defaultUser.removeGame(sc);
            } else if (input.equalsIgnoreCase("4")) {
                defaultUser.changeGameStatus(sc);
            } else if (input.equalsIgnoreCase("5")) {
                System.out.println("Exiting Program...");
                continueProgram = false;
            }

        }

    }

    public static void optionsMenu() {
        System.out.println("------- Options Menu -------");
        System.out.println("| 1. Get List of Games     |");
        System.out.println("| 2. Add Game to List      |");
        System.out.println("| 3. Delete Game from List |");
        System.out.println("| 4. Change Game Status    |");
        System.out.println("| 5. Exit                  |");
        System.out.println("------- Options Menu -------");
    }

}