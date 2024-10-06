public class Game {
    private String name;
    private String platform;
    private int yearReleased;
    private boolean gameBeaten = false;

    public void setName(String name) {
        this.name = name;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public String printGameStatus() {
        if (gameBeaten) {
            return "GAME BEATEN";
        } else {
            return "GAME UNFINISHED";
        }
    }
}
