import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                // instantiate loading bar gui and set it's visible property to true
                new LoadingBarGUI().setVisible(true);
            }
        });
    }
}
