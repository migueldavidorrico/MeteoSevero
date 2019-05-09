import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FicheroPeriodo {
    Periodo periodo;
    File fichero;
    File directorio;

    public FicheroPeriodo(int anyo) throws IOException {
        if(anyo<1900 && anyo>2800){
            throw new IllegalArgumentException("Año incorrecto");
        }
        this.periodo = new Periodo(anyo);
        this.directorio=new File(".");
        this.fichero=new File(directorio, anyo+".dat");
        fichero.createNewFile();
        try(RandomAccessFile raf=new RandomAccessFile(fichero,"rw")){
            for (Medicion m :
                    periodo.mediciones) {
                if(m==null){
                    raf.writeDouble(Double.MIN_VALUE);
                    raf.writeDouble(0);
                    raf.writeDouble(0);
                    raf.writeInt(0);
                } else {
                    raf.writeDouble(m.getTemperaturaMaxima());
                    raf.writeDouble(m.getTemperaturaMinima());
                    raf.writeDouble(m.getTemperaturaMedia());
                    raf.writeInt(m.getPrecipitacion());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FicheroPeriodo f=new FicheroPeriodo(2019);

    }
}
