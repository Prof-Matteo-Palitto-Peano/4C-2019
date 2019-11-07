/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframeinheritance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;  
import javax.swing.JButton;  
import java.time.LocalTime; // import the LocalDate class
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Prof Matteo Palitto
 * Una finestra con un bottone che e' usato per mostrare l'ora
 */

class JFrameInheritance extends JFrame implements ActionListener {//inheriting JFrame  
    JButton b = new JButton("I am a button");//create button  
    static boolean run = true;

    JFrameInheritance(String windowName){  
        super(windowName); //call super-class constructor
        setSize(400,500);  //set Frame size
        setLayout(null);  
        setVisible(true);  //make Frame visible
       
        //set button
        b.setBounds(130, 100, 110, 50); //set button size              
        add(b);//adding button on frame  
        b.addActionListener(this); // add a Listener to the button state
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //exit from program when the X button is pressed
    }  

    // action to be performed when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        run = false;
        this.dispose(); // close Frame
    }
        
    void setTime() {
        LocalTime time = LocalTime.now();
        b.setText(time.toString());
    }
    
}  

public class DigitalClock extends JFrameInheritance {

    public DigitalClock(String windowName) {
        super(windowName);
    }
    public static void main(String[] args) throws InterruptedException {  
        DigitalClock digitalClock = new DigitalClock("my Digital Clock");
        
        while(JFrameInheritance.run) {
            digitalClock.setTime();
            TimeUnit.SECONDS.sleep(1);
        }

        
    }


    
}
