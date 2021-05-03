import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        CalculaterGUI calculatorGUI = new CalculaterGUI();
    }
}
