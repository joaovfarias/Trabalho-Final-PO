
package trabalhofinal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuFrame extends JFrame{
    
    private JButton botao1, botao2;
    private int pressedButton;
    private int[] positions = new int[10];
    
    public void criarFrame(){
        JLabel menuText = new JLabel("Bem-vindo ao jogo Combate!");
        menuText.setFont(new Font("comic sans", Font.BOLD, 30));
        menuText.setForeground(Color.black);
        menuText.setBounds(65, 0, 440, 440);
        
        botao1 = new JButton("Posição Aleatória");
        botao2 = new JButton("Definir Posição");
        
        botao1.setBounds(55, 300, 150, 80);
        botao1.setFocusable(false);
        botao1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pressedButton = 1;
                    criarGradeFrame();
                    
                }
            }
        );
        botao2.setBounds(325, 300, 150, 80);
        botao2.setFocusable(false);
        botao2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pressedButton = 2;
                    criarGradeFrame();
                }
            }
        );
        
        setLayout(null);
        setSize(560, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(232, 243, 230));
        getContentPane().add(menuText);
        add(botao1);
        add(botao2);
        setVisible(true);
    }
    
    public void criarGradeFrame(){
        if (pressedButton == 2){
            dispose();
            Grade grade = new Grade();
            grade.createWindow();
        }
        else{
            RandomPosition random = new RandomPosition();
            dispose();
            MainGame app = new MainGame();
            app.createWindow();
            
        }
    }
   
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        
        @Override
        public void run() {
            MenuFrame jogo = new MenuFrame();
            jogo.criarFrame();
            }
        });
    }
}

