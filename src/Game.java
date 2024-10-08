public class Game {
    private String name;
    private boolean gameBeaten = false;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String printGameStatus() {
        if (gameBeaten) {
            return "GAME BEATEN";
        } else {
            return "GAME UNFINISHED";
        }
    }
}
