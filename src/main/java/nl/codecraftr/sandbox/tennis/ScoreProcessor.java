package nl.codecraftr.sandbox.tennis;

public class ScoreProcessor {

    public static void processOutcome(Match match, String winnerString) {
        if (!match.hasEnded()) {
            Player winner = match.getPlayer(winnerString);
            Player loser = match.getOpponentOf(winnerString);

            Point pointWinner = winner.getPoint();
            Point pointLoser = loser.getPoint();

            winner.winPoint(pointLoser);
            loser.losePoint(pointWinner);
        }
    }
}
//
//    public static String processOutcome(int p1Score, int p2Score) {
//        if (!match.hasEnded()) {
//            Player winner = match.getPlayer(winnerString);
//            Player loser = match.getOpponentOf(winnerString);
//
//            Point pointWinner = winner.getPoint();
//            Point pointLoser = loser.getPoint();
//
//            winner.winPoint(pointLoser);
//            loser.losePoint(pointWinner);
//        }
//    }
//}


/// in match een lijst met scores bijhouden, en dan van punten een score maken (6-5) is advantage


/// / veel private maken -> en optional als een speler niet gevonden is. bij een optional kan je map toepassen zodat het automatisch gefilterd wordt..
///  dingen hoeven niet allemaal public te zijn -> alleen de public entry (als een soort api toegang.)
///

