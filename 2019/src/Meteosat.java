import java.io.IOException;

public class Meteosat {
    public static void main(String[] args) throws IOException {

        RedEstaciones meteosat=new RedEstaciones("/home/miguel/Escritorio/Meteosat");
        meteosat.datosEstacion("Elche",2019,"Febrero",20.0,8.0,4.8,150)
                .datosEstacion("Elche",2017,"Marzo",20.0,8.0,4.8,150)
                .datosEstacion("Helsinki",2019,"Enero",20.0,8.0,4.8,150)
                .grabaTodoEnDisco().generaHTML("/home/miguel/Escritorio/MeteosatInforme");

    }
}
