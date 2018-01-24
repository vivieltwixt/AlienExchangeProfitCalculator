package Controllers;

import Models.AlienExchangeProfitModel;
import Views.AlienExchangeProfitView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class AlienExchangeProfitController implements java.awt.event.ActionListener {
    AlienExchangeProfitModel model;
    AlienExchangeProfitView view;

    public AlienExchangeProfitController(){
        view = new AlienExchangeProfitView(this);
        model = new AlienExchangeProfitModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(view);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                model.updateModel(file);
                view.updateView(model.getProfits());
            } else {
                return;
            }


    }
}
