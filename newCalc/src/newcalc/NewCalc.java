/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newcalc;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import views.mainView;

/**
 *
 * @author louis
 */
public class NewCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int borderRadius = 20;
        try {
           // This is the only line you need for the theme
           UIManager.put("Button.arc", borderRadius);
           UIManager.put("Component.arc", borderRadius);       // Controls TextFields, ComboBoxes, Spinne
           UIManager.put("CheckBox.arc", borderRadius);// Subtle rounding for checkboxes
           UIManager.put("TextComponentarc", borderRadius);
           UIManager.put("ScrollPane",borderRadius);
           UIManager.put("Popup.dropShadowBorder", true);
           FlatDarkLaf.setup();
           } catch( Exception ex ) {
           System.err.println( "Failed to initialize LaF" );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
           new mainView().setVisible(true);
        });
    }
    
}
