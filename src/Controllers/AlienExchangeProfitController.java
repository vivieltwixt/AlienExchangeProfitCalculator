package Controllers;

import Views.AlienExchangeProfitView;

import javax.swing.*;

public class AlienExchangeProfitController {
    public static void main(String[] args) {
      try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        JFrame frame = new JFrame("AlienExchangeProfitCalculator");
        frame.setContentPane(new AlienExchangeProfitView().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
