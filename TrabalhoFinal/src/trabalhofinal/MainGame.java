package trabalhofinal;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGame extends JFrame{
    
    // Positions: 0-Marshal, 1-2 Disarmer, 3-4-5 Soldier, 6- Spy, 7-8 Bomb, 9-Flag
    // Positions == 0 when getting from user, random working.
    
    MenuFrame menu = new MenuFrame();
    RandomPosition ran = new RandomPosition();
    Grade grade = new Grade();
    private final JButton[] buttons = new JButton[25];
    private final JFrame frame = new JFrame();
    private int[] userPositions = new int[10];
    private final JPanel playingGrid = new JPanel();    
    private final ArrayList<String> clickedPieces = new ArrayList<>();
    private Point point = new Point();
    
    private Marshal marshal;
    private Disarmer disarmer;
    private Disarmer disarmer2;
    private Soldier soldier;
    private Soldier soldier2;
    private Soldier soldier3;
    private Spy spy;
    private Bomb bomb;
    private Bomb bomb2;
    private Flag flag;
    
    public void createWindow(){
        
        this.setResizable(false);
        this.setSize(550, 700);
        this.getContentPane().setBackground(new Color(232, 243, 230));       
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        createPlayingPieces();
        userPositions = ran.getRandomPosition();

        grade.createPiecesLabel(this);
        grade.createPieces(this, false);
        grade.createButtons(this, buttons, playingGrid, false);
        setInitialPositions();  

        piecesListener();
        cellListener();
    }
   
    public void createPlayingPieces(){
        marshal = new Marshal(10, 1, "peca10.png", 460, 550,  ""+10);
        disarmer = new Disarmer(3, 2, "peca3.png", 370, 550, ""+3);
        disarmer2 = new Disarmer(3, 2, "peca3.png", 0, 0, ""+32);
        soldier = new Soldier(2, 3, "peca2.png", 280, 550, ""+2);
        soldier2 = new Soldier(2, 3, "peca2.png", 0, 0, ""+22);
        soldier3 = new Soldier(2, 3, "peca2.png", 0, 0, ""+23);
        spy = new Spy(1, 1, "peca1.png", 190, 550, ""+1);
        bomb = new Bomb(999, 2, "bomb.png", 100, 550, ""+999);
        bomb2 = new Bomb(999, 2, "bomb.png", 0, 0, ""+9992);
        flag = new Flag(0, 1, "flag.png", 10, 550, ""+0);
    }
    
    public void setInitialPositions(){
        marshal.setPosition(userPositions[0]);
        disarmer.setPosition(userPositions[1]);
        disarmer2.setPosition(userPositions[2]);
        soldier.setPosition(userPositions[3]);
        soldier2.setPosition(userPositions[4]);
        soldier3.setPosition(userPositions[5]);
        spy.setPosition(userPositions[6]);
        bomb.setPosition(userPositions[7]);
        bomb2.setPosition(userPositions[8]);
        flag.setPosition(userPositions[9]);
        
        Point base = buttons[0].getLocationOnScreen();
        // remainder of division by 5, add to x-axis * 90
        // integer result of division, add to y-axis * 90
        
        int[] remainder = new int[10];
        int[] result = new int[10];
        for (int i = 0; i < 10; i++){
            remainder[i] = userPositions[i] % 5;
            result[i] = userPositions[i] / 5;
        }
            
        // CANNOT PLACE MORE THAN 1 COMPONENT WHY KKKKKKKKKKKKKKKKKKKKKKK VTMNC
        
        /*marshal.setNewBounds((base.x + 10) + remainder[0] * 90, (base.y - 15) + result[0] * 90);
        disarmer.setNewBounds((base.x + 10) + remainder[1] * 90, (base.y - 15) + result[1] * 90);
        System.out.println(remainder[0]);
        System.out.println(result[0]);
        System.out.println(remainder[1]);
        System.out.println(result[1]);

        this.add(disarmer);
        this.add(marshal);
        */
        
        marshal.setNewBounds(360, 300);
        disarmer.setNewBounds(370, 450);
        this.add(marshal);
        this.add(disarmer);
    }
    
    public void piecesListener(){
        
        ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String text = ((JButton) e.getSource()).getText();
                clickedPieces.add(text);
            }
        }
    };
        marshal.addActionListener(listener);
        disarmer.addActionListener(listener);
        disarmer2.addActionListener(listener);
        soldier.addActionListener(listener);
        soldier2.addActionListener(listener);
        soldier3.addActionListener(listener);
        spy.addActionListener(listener);
    }
    
    
    public void cellListener(){
        
        ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                if (clickedPieces.size() > 0){
                    String text = ((JButton) e.getSource()).getText();
                    Point point = ((JButton) e.getSource()).getLocationOnScreen();
                    System.out.println(point);
                    System.out.println(point);
                    int tmpSize = clickedPieces.size();
                    String lastClicked = clickedPieces.get(tmpSize-1);
                    movePiece(lastClicked, text, point);
                }
            }
        }
    };
        for (int i = 0; i < 25; i++){
            buttons[i].addActionListener(listener);
        }
    }
    
    public void movePiece(String pieceCod, String cellPos, Point destination){
        
        int pPos;
        int cPos = Integer.parseInt(cellPos);
        
        if ("10".equals(pieceCod)){
               pPos = marshal.getPosition();
               if (cPos == (pPos + 5) || cPos == (pPos - 5) || cPos == (pPos + 1) || cPos == (pPos - 1)){
                   marshal.setNewBounds(destination.x+10, destination.y-15);
                   marshal.setPosition(cPos);
               }
        }
        
        
    }
    
}
