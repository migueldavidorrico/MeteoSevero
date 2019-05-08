import java.io.File;
import java.io.IOException;

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
    }

    public static void main(String[] args) throws IOException {
        FicheroPeriodo f=new FicheroPeriodo(2019);
    }
}
