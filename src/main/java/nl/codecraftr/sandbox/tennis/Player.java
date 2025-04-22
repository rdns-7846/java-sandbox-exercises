package nl.codecraftr.sandbox.tennis;

public class Player {

    private Point point;
    private String name;

    public Player(String name) {
        point = Point.LOVE;
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public void winPoint(Point opponentPoint) {
        switch (this.point) {
            case LOVE:
                this.point = Point.FIFTEEN;
                break;
            case FIFTEEN:
                this.point = Point.THIRTY;
                break;
            case THIRTY:
                if (opponentPoint.equals(Point.FORTY)) {
                    this.point = Point.DEUCE;
                    break;
                } else {
                    this.point = Point.FORTY;
                    break;
                }
            case FORTY:
                if (!opponentPoint.equals(Point.ADVANTAGE)) {
                    this.point = Point.WIN;
                    break;
                } else {
                    this.point = Point.DEUCE;
                    break;
                }
            case DEUCE:
                this.point = Point.ADVANTAGE;
                break;
            case ADVANTAGE:
                this.point = Point.WIN;
                break;
            default:
                this.point = Point.WIN;
        }
    }

    public void losePoint(Point opponentPoint) {
        if (this.point.equals(Point.DEUCE)) {
            this.point = Point.FORTY;
        } else if (this.point.equals(Point.ADVANTAGE)) {
            this.point = Point.DEUCE;
        } else if (opponentPoint.equals(Point.THIRTY) && this.point.equals(Point.FORTY)) {
            this.point = Point.DEUCE;
        }
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public boolean hasWon() {
        return point.equals(Point.WIN);
    }
}
