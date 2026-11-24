/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;
import javax.swing.JTextField;  
import java.awt.Color;
import java.awt.Font;  

public class HintText {
    JTextField textbox;
    
    public HintText(JTextField textbox){
        this.textbox = textbox;
    }
    
    public void onFocus(String hint){
        if(textbox.getText().equals(hint)){
            textbox.setText("");
            textbox.setFont(new Font("Tahoma", Font.PLAIN, 11));
            textbox.setForeground(Color.BLACK);
        }
        
    }
    
    public void unFocus(String hint){
        if(textbox.getText().equals("")){
            textbox.setText(hint);
            textbox.setFont(new Font("Tahoma", Font.ITALIC, 11));
            textbox.setForeground(Color.GRAY);
        }
    }
}
