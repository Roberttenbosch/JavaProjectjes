import model.Board;
import model.BoardSpaceShip;
import model.BoardTwo;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame
{
    public Application(){
        initUI();
    }

    private void initUI(){
        add(new BoardSpaceShip());
        setSize(400, 300);


        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Application app = new Application();
            app.setVisible(true);
        });
    }


}
