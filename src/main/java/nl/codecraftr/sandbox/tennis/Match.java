package nl.codecraftr.sandbox.tennis;

import java.util.List;
import java.util.Optional;

public class Match {

    private List<Player> players;

    public Match(Player p1, Player p2) {
        players = List.of(p1, p2);
    }

    public List<Point> getScore() {
        return players.stream().map(Player::getPoint).toList();
    }

    public Player getPlayer(String playerString) {
        for (Player p : players) {
            if (p.getName().equals(playerString)) {
                return p;
            }
        }
        return null;
    }

    public Optional<Player> getMaybePlayer(String playerString) {
        for (Player p : players) {
            if (p.getName().equals(playerString)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    // Optional<Player>
    public Player getOpponentOf(String playerString) {
        for (Player p : players) {
            if (!p.getName().equals(playerString)) {
                return p;
            }
        }
        return null;
    }

    public Optional<Player> getMaybeOpponentOf(String playerString) {
        for (Player p : players) {
            if (!p.getName().equals(playerString)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public boolean hasEnded() {
        return players.stream().map(Player::hasWon).toList().contains(true);
    }

    public Player getWinner() {
        return players.stream().filter(Player::hasWon).toList().getFirst();
    }
}
