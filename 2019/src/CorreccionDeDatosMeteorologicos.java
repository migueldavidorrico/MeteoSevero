import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CorreccionDeDatosMeteorologicos {
    public static void main(String[] args) {
        File inicial=new File("/home/miguel/Escritorio/Meteosat");
        JFileChooser elegidorFichero=new JFileChooser("/home/miguel/Escritorio");
        elegidorFichero.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        elegidorFichero.showOpenDialog(null);
        if(elegidorFichero.getSelectedFile()!=null){
            inicial=elegidorFichero.getSelectedFile();
        }
        System.out.println(inicial);
        File[] estaciones=inicial.listFiles();
        String[] mostrar=new String[estaciones.length];
        for (int i = 0; i < mostrar.length; i++) {
            mostrar[i]=estaciones[i].getName();
        }
        String elegido=(String)JOptionPane.showInputDialog(null, "Elija una estación", "Estaciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                mostrar,
                mostrar[0]);
        File directorioEstacion=new File(inicial,elegido);
        File[] periodos=directorioEstacion.listFiles();
        String[] mostrarPeriodo=new String[periodos.length];
        for (int i = 0; i < mostrarPeriodo.length; i++) {
            mostrarPeriodo[i]=periodos[i].getName().substring(0,periodos[i].getName().lastIndexOf('.'));
        }
        String elegidoPeriodo=(String)JOptionPane.showInputDialog(null, "Elija un Periodo", "Periodos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                mostrarPeriodo,
                mostrarPeriodo[0]);
        System.out.println(elegidoPeriodo);
        File datosFinales=new File(directorioEstacion,elegidoPeriodo+".dat");

        Meses elegidoMes=(Meses)JOptionPane.showInputDialog(null, "Elija un Mes", "¿Mes?",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Meses.values(),
                Meses.values()[0]);

        try (RandomAccessFile raf=new RandomAccessFile(datosFinales,"r")){
            long posicionEnFichero=elegidoMes.ordinal()*Medicion.TAMANYO_REGISTRO;
            raf.seek(posicionEnFichero);
            double tmax=raf.readDouble();
            double tmin=raf.readDouble();
            double tmed=raf.readDouble();
            int lluvia=raf.readInt();
            Medicion leida=null;
            if(tmax!=Double.MIN_VALUE) {
                leida = new Medicion(tmax,tmin,tmed,lluvia);
                JOptionPane.showMessageDialog(null,leida.info());
            } else {
                JOptionPane.showMessageDialog(null,"No hay datos");
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
