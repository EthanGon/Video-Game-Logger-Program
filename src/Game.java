public class Game {
    private String name;
    private boolean gameBeaten = false;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean isGameBeaten() {
        return gameBeaten;
    }

    public void setGameBeaten(boolean gameBeaten) {
        this.gameBeaten = gameBeaten;
    }

    public String printGameStatus() {
        if (gameBeaten) {
            return "GAME BEATEN";
        } else {
            return "GAME UNFINISHED";
        }
    }


}
