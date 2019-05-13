import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelID extends JPanel {
    String id="";
    String idBuena="";

    public String getIdBuena() {
        return idBuena;
    }

    public String getId() {
        return id;
    }

    public PanelID(JDialog dialogo) {

        JButton label=new JButton("PASE LA TARJETA/LLAVERO \nPOR EL LECTOR");
        label.setFont(new Font("Arial",Font.BOLD,32));
        this.add(label);

        label.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println(e.getKeyChar());
                id+=e.getKeyChar();
                if(id.length()==10){
                    System.out.println("Identificado: " + id);
                    idBuena=id;
                    id="";
                    dialogo.setVisible(false);
                }
            }
        });
    }
}
