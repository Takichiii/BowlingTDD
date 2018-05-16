/**
 * Created by jihane on 01/05/2018.
 *  Bowling de 10 rolls de 2 rolls chacune sauf la dernière qui peut admettre 3 rolls.
 *  Si la dernière frame est un Spare, elle admettra 1 lancé de plus.
 *  Si la dernière frame est un Strike, elle admettra 2 lancés de plus.
 */

public class Bowling {

    private int[] frameScores;
    private int maximumFrames = 10;
    private int[][] rolls; //stocke le nombre des pins renversés
    private int counterRolls = 0; //numéro du roll dans la partie (0 à 19 ou 21 si bonus)
    private int counterFrame = 0; //numéro du frame (jusqu'à 9)
    private int score = 0;
    private int[] bonusRolls;//size 1 if last frame is a Spare, size 2 if last frame is a Strike


    public Bowling() {
        this.rolls = new int[maximumFrames][2];
        this.bonusRolls = new int[2];
        this.frameScores = new int[maximumFrames];
    }

    //stocke les valeurs des pins renversés pendant chaque roll
    public void roll(int pinsShooted) {
        if (counterRolls > 19) {
            bonusRolls[(counterRolls) % 2] = pinsShooted;
        } else {
            rolls[counterFrame][counterRolls % 2] = pinsShooted;
            if (counterRolls % 2 == 1 && counterFrame < 9) {
                counterFrame++;
            }
        }
        counterRolls++;
    }

    //Si la somme des éléments d’un tuple est 10 :
    // on ajoute à la valeur de ce tuple la valeur du premier élément du tuple suivant.
    //Si le premier élément d’un tuple vaut 10 : on ajoute à la valeur du tuple les deux prochaines valeurs

    private boolean isaSpare(int[] frame) {
        return frame[0] + frame[1] == 10;
    }

    public int score() {
        frameScores();
        return score;
    }


    private void frameScores() {
        int size = frameScores.length - 1;
        for (int i = 0; i < size; i++) {
            if ( isaSpare(rolls[i]) ){
                frameScores[i] = 10 + rolls[i+1][0];
            }
            else {
                frameScores[i] = rolls[i][0] + rolls[i][1];
            }
            score += frameScores[i];
        }
        //dernier frame
        if (isaSpare(rolls[size])){
            frameScores[size] = 10 + bonusRolls[0];
        }else {
            frameScores[size] = rolls[size][0] + rolls[size][1];
        }
        score +=frameScores[size];

    }

}
