import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







public class RDIFMain {
    public static void main(String[] args) {
        JDialog dialogo=new JDialog();
        PanelID panelid=new PanelID(dialogo);

        dialogo.add(panelid);
        //dialogo.setBounds(20,20,300,300);
        dialogo.pack();
        dialogo.setModal(true);
        dialogo.setLocationRelativeTo(null);

        while(true) {
            dialogo.setVisible(





                    true);
            if (panelid.getIdBuena().equals("0168021747")) {
                JOptionPane.showMessageDialog(null, "Esa es la tarjeta correcta. Hola, Ana");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No te reconozco. Otra vez");
            }
        }

    }
}


