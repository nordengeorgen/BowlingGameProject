package Game;

public class Game {

    private int currRoll = 0;
    private final int[] rolls = new int[25];// max amount of rolls
    int score = 0;

    public int getScore(){ // wynik
        int cursor = 0;
        for (int frame = 0; frame < 10 ; frame++) {
            if (isStrike(cursor)) {
                if( frame == 9 && rolls[cursor+2] != 10){
                    score +=10 + (rolls[cursor+2]*2);
                    cursor +=2;
                } else if(rolls[cursor+2] == 10){
                    score +=10 + rolls[cursor+2] + rolls[cursor+4] ;
                    cursor +=2;
                } else {

                    score += 10 + rolls[cursor + 2] + rolls[cursor + 3];
                    cursor += 2;
                }

            } else if(isSpare(cursor)){
                if(frame == 9){
                    score += 10 + (rolls[cursor+2]*2);
                } else {
                    score += 10 + rolls[cursor + 2];
                    cursor += 2;
                }

            } else {
                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }

    public void roll(int...rolls) {
        for (int downs : rolls) {
            roll(downs);
        }
    }
    public void roll(int down){ // ile kręgli spadło
        rolls[currRoll] = down;
        currRoll++;
    }

}
