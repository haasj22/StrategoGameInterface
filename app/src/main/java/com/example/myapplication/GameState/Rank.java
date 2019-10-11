/**
 * Enum that will store a piece's rank
 *
 * @author John Haas
 */

package com.example.myapplication.GameState;

enum Rank {
    ONE {
        @Override
        public String toString() {
            return "One";
        }
    },
    TWO {
        @Override
        public String toString() {
            return "Two";
        }
    },
    THREE {
        @Override
        public String toString() {
            return "Three";
        }
    },
    FOUR {
        @Override
        public String toString() {
            return "Four";
        }
    },
    FIVE {
        @Override
        public String toString() {
            return "Five";
        }
    },
    SIX {
        @Override
        public String toString() {
            return "Six";
        }
    },
    SEVEN {
        public String toString() {
            return "Seven";
        }
    },
    EIGHT {
        @Override
        public String toString() {
            return "Eight";
        }
    },
    NINE {
        @Override
        public String toString() {
            return "Nine";
        }
    },
    SPY {
        @Override
        public String toString() {
            return "Spy";
        }
    },
    BOMB {
        @Override
        public String toString() {
            return "Bomb";
        }
    },
    FLAG {
        @Override
        public String toString() {
            return "Flag";
        }
    }
};
