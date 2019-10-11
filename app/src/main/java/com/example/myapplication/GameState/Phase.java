/**
 * enum that will store the current phase of the game
 *
 * @author John Haas
 */

package com.example.myapplication.GameState;

enum Phase {
    SETUP_PHASE {
        @Override
        public String toString() {
            return "Set Up Phase";
        }
    },
    PLAY_PHASE {
        @Override
        public String toString() {
            return "Play Phase";
        }
    }
};
