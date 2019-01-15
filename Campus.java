
/*
 * Susan Hatem
 * Code help from: https://www.youtube.com/playlist?list=PLSmcJ5vtyZR7hB-mIAsJMhoiQV4DyCE9v
 * https://github.com/ProgrammerSusan/Tornado
 */

import java.util.Random;

public class Campus {
    private int[] surroundings = new int[9];
    private int state;
    Random rand = new Random();
    
    public Campus(int[] surroundings) {
        this.surroundings = surroundings;
        state = this.surroundings[4];
        boolean loop;
        
        //0 = building
        //1 = taken
        //2 = not taken
        //3 = obsticle
        
        switch(state) {
            //building
            case 0:
                state = 0;
                break;
            //taken
            case 1: 
                int index = rand.nextInt(9);
                int r = surroundings[index];
                if(r == 0) {
                    state = 2;
                }
                else if(r == 2) {
                    surroundings[index] = 1;
                    state = 2;
                }
                else {
                    state = 1;
                }
                break;
            //not taken
            case 2: 
                state = 2;
                break;
            //obsticle
            case 3:
                state = 3;
                break;
        }
        
        this.surroundings[4] = state;
    }
    
//updates cell state
public int[] returnCells() {
    return this.surroundings;
}

}
