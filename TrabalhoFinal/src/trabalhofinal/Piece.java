
package trabalhofinal;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Piece extends JButton{
    
    private final int level;
    private int currentPosition;
    private int quantidade;
    private ImageIcon image;
    
    public Piece(int level, int quantidade, String icon, int xCoordinate, int yCoordinate, String text){
        this.level = level;
        this.quantidade = quantidade;
        currentPosition = 0;
        image = new ImageIcon(icon);
        this.setIcon(image);
        this.setBounds(xCoordinate, yCoordinate, 60, 60);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setText(text);
    }
    
    public void setNewBounds(int xPos, int yPos){
        this.setBounds(xPos, yPos, 60, 60);
    }
    
    public ImageIcon getImage(){
        return image;
    }
    
    public void setPosition(int position){
        currentPosition = position;
    }
    
    public int getPosition(){
        return currentPosition;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void decrementaQuantidade(){
        quantidade--;
    }
}
