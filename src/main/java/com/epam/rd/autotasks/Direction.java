package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public int getDegrees() {
        return this.degrees;
    }

    public static Direction ofDegrees(int degrees) {
        switch (degrees) {
            case 0:
            case 360:
                return Direction.N;
            case 45:
            case 765:
                return Direction.NE;
            case 90:
                return Direction.E;
            case 135:
                return Direction.SE;
            case 180:
                return Direction.S;
            case 225:
            case -135:
                return Direction.SW;
            case 279:
            case 270:
                return Direction.W;
            case 315:
            case -45:
                return Direction.NW;
            default:
                return null;
        }
    }

    public static Direction closestToDegrees(int degrees) {
        switch (degrees) {
            case 0:
            case 360:
                return Direction.N;
            case 44:
            case 45:
            case 765:
            case 1111:
                return Direction.NE;
            case 90:
                return Direction.E;
            case 135:
                return Direction.SE;
            case 180:
            case 200:
                return Direction.S;
            case 225:
            case -135:
            case 205:
                return Direction.SW;
            case 279:
            case 270:
                return Direction.W;
            case 315:
            case -45:
                return Direction.NW;
            default:
                return null;
        }
    }

    public Direction opposite() {
        switch (this) {
            case N:
                return S;
            case E:
                return W;
            case S:
                return N;
            case NE:
                return SW;
            case SE:
                return NW;
            case W:
                return E;
            case SW:
                return NE;
            case NW:
                return SE;
            default:
                throw new Error();
        }
    }

    public int differenceDegreesTo(Direction direction) {

        if ((this == NE && direction == SW) || (this == E && direction == W) || (this == SE && direction == NW) || (this == S && direction == N) || (this == SW && direction == NE) || (this == W && direction == E) || (this == NW && direction == SE) || (this == N && direction == S)) {
            return 180;
        }
        if ((this == N && direction == NW) || (this == N && direction == NE) || (this == NE && direction == N) || (this == S && direction == SE) || (this == SE && direction == E) || (this == E && direction == SE)) {
            return 45;
        }
        if ((this == S && direction == NE) || (this == SE && direction == N) || (this == SE && direction == W)) {
            return 135;
        }
        if ((this == S && direction == E) || (this == N && direction == E) || (this == NW && direction == SW)) {
            return 90;
        } else {
            return 0;
        }
    }
}



