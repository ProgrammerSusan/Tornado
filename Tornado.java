/*
 * Susan Hatem
 * https://github.com/ProgrammerSusan/Tornado
 */



import javax.swing.*;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;

public final class Tornado extends javax.swing.JFrame {
    
    private static int x = 1000, y = 1000; //size of grid
    private static int xCell = (x/5), yCell = (y/5); //cells
    private int[][] emu; //grid
    private Random r = new Random();
    private int[] temp = new int[9]; //used for updating cell state
    private int[] update = new int[9]; //updates cell state
    /**
     * Creates new form Tornado
     */
    public Tornado() {
        super("Tornado Simuation");
        super.frameInit();
        drawCells(x, y);
        setLayout(null);
        setContentPane(new Eastern(x, y, emu));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        
        setVisible(true);
        setResizable(false);
        setSize(x,y+22);
    }
    
    //goes through cells in the board 
    //creates 5x5 cells
    public void makeCells() {
        for(int i = 0; i < xCell; i++) {
             for(int j = 0; j < yCell; j++) {
                 int tempNum = 0;
                 
                 for(int m = -1; m <= 1; m++) {
                     for(int n = -1; n <= 1; n++) {
                         int xVal = i + m;
                         int yVal = j + n;
                         if(xVal == -1) {
                             xVal = xCell - 1;
                         }
                         else if(xVal == xCell) {
                             xVal = 0; 
                         }
                         if(yVal == -1){
                             yVal = yCell - 1;
                         }
                         else if(yVal == yCell) {
                             yVal = 0;
                         }
                          
                         temp[tempNum] = emu[xVal][yVal];
                         tempNum++;
                     }
                 }
                 //updates cells by passing into Campus class
                 Campus cells = new Campus(temp);
                 update = cells.returnCells();
                 
                 for(int l = -1; l <=1; l++) {
                     for(int p = -1; p <= 1; p++) {
                         int xVal = i + l;
                         int yVal = j + p;
                         if(xVal == -1) {
                             xVal = 0;
                         }
                         else if(xVal == xCell) {
                             xVal--;
                         }
                         if(yVal == -1){
                             yVal = 0;
                         }
                         else if(yVal == yCell) {
                             yVal = 0;
                         }
                         
                         emu[xVal][yVal] = update[(l + 1) * 3 + (p + 1)];
                     }
                 }
                 
             }
        }
    }
    
    /* Runs simulation for roughly one minute */
    public void simulationTime(int duration) {
        Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(new TimerTask() 
        {
            long clock = System.currentTimeMillis();
            @Override
            public void run() {  
                makeCells();
                if(System.currentTimeMillis() - clock > 60000) {
                   timer.cancel();
                   dispose();
                   CountAlive cnt = new CountAlive(countTaken());
                }
            }  
                 
        }, 0, duration); 
    }
    
    /* Draws out initial map */
    public void drawCells(int xArr, int yArr) {
        int tempx = xArr/5; //creates squares
        int tempy = yArr/5;
        
        emu = new int[tempx][tempy];
        for(int i = 0; i < tempx; i++){ //initially sets all squares to not taken
            for(int j = 0; j < tempy; j++){
                emu[i][j] = 2;
            }
        }
        
        /* Buildings */ 
        
        //halle
        for(int m = 20; m < 50; m++) {
           for(int n = 2; n < 30; n++) {
               emu[m][n] = 0;
           }
        }
        //apartments
        for(int m = 20; m < 45; m++) {
           for(int n = 50; n < 70; n++) {
               emu[m][n] = 0;
           }
        }
        //Strong
        for(int m = 85; m < 95; m++) {
           for(int n = 50; n < 75; n++) {
               emu[m][n] = 0;
           }
        }
        //Science complex
        for(int m = 97; m < 125; m++) {
           for(int n = 50; n < 70; n++) {
               emu[m][n] = 0;
           }
        }
        //Porter
        for(int m = 20; m < 35; m++) {
           for(int n = 110; n < 140; n++) {
               emu[m][n] = 0;
           }
        }
        //Marshall
        for(int m = 60; m < 80; m++) {
           for(int n = 105; n < 120; n++) {
               emu[m][n] = 0;
           }
        }
        //Pray
        for(int m = 0; m < 18; m++) {
           for(int n = 150; n < 185; n++) {
               emu[m][n] = 0;
           }
        }
        //McKenny
        for(int m = 140; m < 160; m++) {
           for(int n = 60; n < 100; n++) {
               emu[m][n] = 0;
           }
        }
        //McKenny doors
            emu[140][90] = 4;
            emu[140][91] = 4;
            emu[140][92] = 4;
        //welch
        for(int m = 159; m < 180; m++) {
           for(int n = 110; n < 133; n++) {
               emu[m][n] = 0;
           }
        }
        //welch doors
        for(int d = 120; d <= 123; d++) {
            emu[159][d] = 4;
        }
        //roosevelt 
        for(int m = 65; m < 95; m++) {
           for(int n = 158; n < 173; n++) {
               emu[m][n] = 0;
           }
        }
        //obsticles
        for(int m = 120; m < 125; m++) {
           for(int n = 95; n < 105; n++) {
               emu[m][n] = 3;
           }
        }
        for(int m = 90; m < 97; m++) {
           for(int n = 93; n < 98; n++) {
               emu[m][n] = 3;
           }
        }
        for(int m = 25; m < 35; m++) {
           for(int n = 75; n < 85; n++) {
               emu[m][n] = 3;
           }
        }
        for(int m = 0; m < 13; m++) {
           for(int n = 2; n < 30; n++) {
               emu[m][n] = 3;
           }
        }
        for(int m = 190; m < 200; m++) {
           for(int n = 160; n < 185; n++) {
               emu[m][n] = 3;
           }
        }
        //people
        for(int i = 0; i < 200; i++) { //begin with 200
            int randx = r.nextInt(xCell);
            int randy = r.nextInt(yCell);
            if(emu[randx][randy] == 2) {
                emu[randx][randy] = 1;
            }
            else {
                i--;
            }
        }
    }
    
    public int countTaken() {
        int count = 0;
        for(int i = 0; i < xCell; i++) {
            for(int j = 0; j < yCell; j++) {
                if(emu[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /* check cell values for debugging purposes */
    public void printCells(int[][] myArray) {
	for (int[] array1D : myArray) {
		System.out.println();
		for (int i : array1D) {
			System.out.print(i + " ");
		}
            }
	}

    
   
               
}
