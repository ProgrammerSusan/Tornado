
/*
 * Susan Hatem
 * https://github.com/ProgrammerSusan/Tornado
 */

import javax.swing.JPanel;
import java.awt.*;

public class Eastern extends JPanel {
    
    private int x, y;
    private int[][] campus;
    
    public Eastern(int x, int y, int[][] campus) {
        this.campus = campus; 
        this.x = x/5;
        this.y = y/5;
        
        JPanel college = new JPanel();
        college.setLayout(null);
        college.setPreferredSize(new Dimension(x,y));
    }
    
    //sets colors based on state in the grid
    public void paint(Graphics e) {
        for(int i = 0; i < this.x; i++) {
            for(int j = 0; j < this.y; j++) {
                if(campus[i][j] == 0) {
                    e.setColor(Color.gray);
                }
                if(campus[i][j] == 1) {
                    e.setColor(Color.blue);
                }
                if(campus[i][j] == 2) {
                    e.setColor(Color.yellow);
                }
                if(campus[i][j] == 3) {
                    e.setColor(Color.red);
                }
                
                e.fill3DRect(j * 5, i * 5, 5, 5, true);
            }
        }
        
        repaint();
    }
    
}
 