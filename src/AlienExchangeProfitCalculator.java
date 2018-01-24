import Controllers.AlienExchangeProfitController;

import javax.swing.*;

public class AlienExchangeProfitCalculator {
    public static void main(String[] args) {
       try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus not available, use default.
        }

        AlienExchangeProfitController controller = new AlienExchangeProfitController();
    }
}
