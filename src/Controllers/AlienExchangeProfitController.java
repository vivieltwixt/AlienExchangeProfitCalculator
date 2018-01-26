package Controllers;

import Models.AlienExchangeProfitModel;
import Views.AlienExchangeProfitView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;


/* Controller responsible for interactions between AlienExchangeProfitModel and AlienExchangeProfitView*/
public class AlienExchangeProfitController implements java.awt.event.ActionListener {
    AlienExchangeProfitModel model;
    AlienExchangeProfitView view;

    public AlienExchangeProfitController(){
        view = new AlienExchangeProfitView(this);
        model = new AlienExchangeProfitModel();
    }

    @Override
    // Updates model with file chosen by the user and updates view with resulting model
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
