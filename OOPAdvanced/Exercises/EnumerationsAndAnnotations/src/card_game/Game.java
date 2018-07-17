package card_game;

public class Game {

    private Player firstPlayer;

    private Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player getWinner() {
        return this.firstPlayer.getPowerfulCard()
                .compareTo(this.secondPlayer.getPowerfulCard()) > 0 ?
                this.firstPlayer : this.secondPlayer;
    }
}
