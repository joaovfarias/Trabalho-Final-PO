package trabalhofinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grade extends JFrame{

    private final JButton[] buttons = new JButton[25];
    private final JLabel[] piecesLabel = new JLabel[6];
    private final JFrame frame = new JFrame();
    private final ArrayList<String> clickedPieces = new ArrayList<>();
    private int placedPieces;
    private final JButton exitButton = new JButton("Jogar");
    private final int[] positions = new int[10];
    private final JPanel grid = new JPanel();
    private int lakePos;
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
        createGrid();
        createButtons(frame, buttons, grid, true);
        createPieces(frame, true);
        createPiecesLabel(frame);
        piecesCoordinate();
        buttonsCoordinate();
        exitButton();        
    }
    
    public void createGrid(){
        
        exitButton.setBounds(190, 5, 150, 50);
        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(0xADD8E6)); 
        frame.add(exitButton);
        exitButton.setVisible(false);
        
        placedPieces = 0;
        
        frame.setResizable(false);
        frame.setSize(550, 700);
        frame.getContentPane().setBackground(new Color(232, 243, 230));       
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void createPieces(JFrame window, boolean activaded){
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
        
        marshal.setEnabled(activaded);
        disarmer.setEnabled(activaded);
        disarmer2.setEnabled(activaded);
        soldier.setEnabled(activaded);
        soldier2.setEnabled(activaded);
        soldier3.setEnabled(activaded);
        spy.setEnabled(activaded);
        bomb.setEnabled(activaded);
        bomb2.setEnabled(activaded);
        flag.setEnabled(activaded);
        
        
        window.add(marshal);
        window.add(disarmer);
        window.add(soldier);
        window.add(spy);
        window.add(bomb);
        window.add(flag);
        
        
    }

    public void changePiecesLabel(int pieceCod, Piece piece){
        if (piece.getQuantidade() != 0){
            piecesLabel[pieceCod].setText("x" + (piece.getQuantidade() - 1));
        }
    }
    
    public void createPiecesLabel(JFrame window){
        int tmpPos = 480;
        piecesLabel[0] = new JLabel();
        piecesLabel[0].setText("x" + 1);
        piecesLabel[0].setBounds(tmpPos, 600, 50, 50);
        piecesLabel[0].setFont(new Font("comic sans", Font.BOLD, 20));
        tmpPos -= 90;

        piecesLabel[1] = new JLabel();
        piecesLabel[1].setText("x" + 2);
        piecesLabel[1].setBounds(tmpPos, 600, 50, 50);
        piecesLabel[1].setFont(new Font("comic sans", Font.BOLD, 20));
        tmpPos -= 90;

        piecesLabel[2] = new JLabel();
        piecesLabel[2].setText("x" + 3);
        piecesLabel[2].setBounds(tmpPos, 600, 50, 50);
        piecesLabel[2].setFont(new Font("comic sans", Font.BOLD, 20));
        tmpPos -= 90;

        piecesLabel[3] = new JLabel();
        piecesLabel[3].setText("x" + 1);
        piecesLabel[3].setBounds(tmpPos, 600, 50, 50);
        piecesLabel[3].setFont(new Font("comic sans", Font.BOLD, 20));
        tmpPos -= 90;

        piecesLabel[4] = new JLabel();
        piecesLabel[4].setText("x" + 2);
        piecesLabel[4].setBounds(tmpPos, 600, 50, 50);
        piecesLabel[4].setFont(new Font("comic sans", Font.BOLD, 20));
        tmpPos -= 90;

        piecesLabel[5] = new JLabel();
        piecesLabel[5].setText("x" + 1);
        piecesLabel[5].setBounds(tmpPos, 600, 50, 50);
        piecesLabel[5].setFont(new Font("comic sans", Font.BOLD, 20));

        for (int i = 0; i < 6; i++){
            window.add(piecesLabel[i]);
        }
    }
    

    public void createButtons(JFrame window, JButton[] button, JPanel buttonGrid, boolean activaded){
               
        buttonGrid.setBounds(38, 60, 450, 450);
        buttonGrid.setLayout(new GridLayout(5, 5));
        Random ran = new Random();
        lakePos = ran.nextInt(10, 14);
        
        for (int i = 0; i < 25; i++){
            button[i] = new JButton("" + i);
            button[i].setFocusable(false);
            if (i == lakePos){
                button[i].setBackground(Color.GRAY);
                buttonGrid.add(button[i]);
                button[i].setEnabled(activaded);
            }
            else{
                button[i].setBackground(new Color(0x90EE90));  
                buttonGrid.add(button[i]);
                button[i].setEnabled(activaded);

            }
        }      
        window.add(buttonGrid);
    }

    public void buttonsCoordinate(){
        
        ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                if (clickedPieces.size() > 0){
                    String text = ((JButton) e.getSource()).getText();
                    if (Integer.parseInt(text) > 14){
                        int tmpSize = clickedPieces.size();
                        String lastClicked = clickedPieces.get(tmpSize-1);
                        System.out.println(lastClicked);
                        placePiece(lastClicked, text);
                        
                    }
                }
                
            }
        }
        
    };
        for (int i = 0; i < 25; i++){
            buttons[i].addActionListener(listener);
        }
    }
    
    public void placePiece(String pieceCod, String cellPos){
        
        // text->index: 10->Marshal, 3->Disarmer, 2->Soldier, 1->Spy, 999->Bomb, 0->Flag
        switch (pieceCod) {
            case "10":
                placedPieces++;
                marshal.decrementaQuantidade();
                piecesLabel[0].setText("x"+marshal.getQuantidade());
                marshal.setPosition(Integer.parseInt(cellPos));
                marshal.setEnabled(false);
                buttons[Integer.parseInt(cellPos)].setEnabled(false);
                clickedPieces.add("-1"); // No piece selected
                   break;

            case "3":
                placedPieces++;
                if (disarmer.getQuantidade() == 1){
                    disarmer2.setPosition(Integer.parseInt(cellPos));
                }
                else{
                    disarmer.setPosition(Integer.parseInt(cellPos));
                }
                buttons[Integer.parseInt(cellPos)].setEnabled(false);
                disarmer.decrementaQuantidade();    
                piecesLabel[1].setText("x" + disarmer.getQuantidade());
                if (disarmer.getQuantidade() == 0){
                    disarmer.setEnabled(false);
                }
                clickedPieces.add("-1");
                   break;
        
             
            case "1":
                placedPieces++;
                spy.decrementaQuantidade();
                piecesLabel[3].setText("x" + spy.getQuantidade());
                spy.setPosition(Integer.parseInt(cellPos));
                spy.setEnabled(false);
                buttons[Integer.parseInt(cellPos)].setEnabled(false);
                clickedPieces.add("-1"); // No piece selected
                break;
                
            case "2":
                placedPieces++;
                if (soldier.getQuantidade() == 2){
                    soldier2.setPosition(Integer.parseInt(cellPos));
                }
                else if (soldier.getQuantidade() == 1){
                    soldier3.setPosition(Integer.parseInt(cellPos));
                }
                else{
                    soldier.setPosition(Integer.parseInt(cellPos));
                }
                buttons[Integer.parseInt(cellPos)].setEnabled(false);
                soldier.decrementaQuantidade();
                piecesLabel[2].setText("x" + soldier.getQuantidade());
                if (soldier.getQuantidade() == 0){
                    soldier.setEnabled(false);
                }
                clickedPieces.add("-1");
                break;
                
                
            case "0":
                placedPieces++;
                flag.decrementaQuantidade();
                piecesLabel[5].setText("x" + flag.getQuantidade());
                flag.setPosition(Integer.parseInt(cellPos));
                flag.setEnabled(false);
                buttons[Integer.parseInt(cellPos)].setEnabled(false);
                clickedPieces.add("-1"); // No piece selected
                break;
                
                
            case "999":
                placedPieces++;
                if (bomb.getQuantidade() == 1){
                    bomb2.setPosition(Integer.parseInt(cellPos));
                }
                else{
                    bomb.setPosition(Integer.parseInt(cellPos));
                }
                buttons[Integer.parseInt(cellPos)].setEnabled(false);
                bomb.decrementaQuantidade();    
                piecesLabel[4].setText("x" + bomb.getQuantidade());
                if (bomb.getQuantidade() == 0){
                    bomb.setEnabled(false);
                }
                clickedPieces.add("-1");
                break;
            default:
                break;
        }
        
        if (placedPieces == 10){
            exitButton.setVisible(true);
        }
        
    }
    
    public void piecesCoordinate(){
        
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
        bomb.addActionListener(listener);
        bomb2.addActionListener(listener);
        flag.addActionListener(listener);
    }
    
    public void exitButton(){
        ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                frame.dispose();
                MainGame app = new MainGame();
                app.createWindow();
            }
        }
        };
        
        exitButton.addActionListener(listener);
    }
    
    public int[] getUserPositions(){
        return positions;
    }
}
    

