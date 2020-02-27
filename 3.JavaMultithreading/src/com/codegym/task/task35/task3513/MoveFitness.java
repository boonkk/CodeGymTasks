package com.codegym.task.task35.task3513;

public class MoveFitness implements Comparable<MoveFitness> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public Move getMove() {
        return move;
    }

    public MoveFitness(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    @Override
    public int compareTo(MoveFitness o) {
        if(this.numberOfEmptyTiles == o.numberOfEmptyTiles){
            return Integer.compare(this.score, o.score);
        }
        return Integer.compare(this.numberOfEmptyTiles, o.numberOfEmptyTiles);
    }
//            if( this.numberOfEmptyTiles >  ((MoveFitness) o).numberOfEmptyTiles )
//                return 1;
//            else if(this.numberOfEmptyTiles <  ((MoveFitness) o).numberOfEmptyTiles)
//                return -1;
//            else if(this.score > ((MoveFitness) o).score)
//                return 1;
//            else if (this.score < ((MoveFitness) o).score)
//                return -1;
//            else return 0;
    }



