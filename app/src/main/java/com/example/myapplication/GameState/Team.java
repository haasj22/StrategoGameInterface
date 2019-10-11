/**
 * enum that will store which team each piece is on
 *
 * @author John Haas
 */

package com.example.myapplication.GameState;

enum Team {
    RED_TEAM {
        @Override
        public String toString() {
            return "Red Team";
        }
    },
    BLUE_TEAM {
        @Override
        public String toString() {
            return "Blue team";
        }
    }
};

