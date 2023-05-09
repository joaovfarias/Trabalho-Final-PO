/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author John
 */
public class RandomPosition {
    
    private ArrayList<Integer> possiblePositions = new ArrayList<>();
    private Random ran = new Random();
    private int index;
    private final int[] chosenPos = new int[10];
    
    
    public int[] getRandomPosition(){
        for (int i = 15; i < 25; i++){
            possiblePositions.add(i);
        }
        
        // TODO try to protect the flag
       
        for (int i = 0; i < 10; i++){
            index = ran.nextInt(0, possiblePositions.size());
            chosenPos[i] = possiblePositions.get(index);
            possiblePositions.remove(Integer.valueOf(chosenPos[i]));            
        }
        
        return chosenPos;
    }
    
}
