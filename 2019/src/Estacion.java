import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Estacion {
    String nombre;
    List<Periodo> listaPeriodos;


    public String getNombre() {
        return nombre;
    }


    public Estacion(String nombre) {
        this.nombre=nombre;
        this.listaPeriodos = new ArrayList<>();
    }

    public Estacion anyadePeriodo(int anyo) {
        this.listaPeriodos.add(new Periodo(anyo));
        return this;
    }

    public void grabaEnDisco(File directorioInicial) {
        File directorioEstacion=new File(directorioInicial,this.getNombre());
        directorioEstacion.mkdir();
        for (Periodo p :
                listaPeriodos) {
            p.grabaEnDisco(directorioEstacion);
        }
    }

    public void anyadeMedicion(int anyo, String mes, double v, double v1, double v2, int lluvia) {
        Periodo objetivo=null;
        for (Periodo p :
                listaPeriodos) {
            if (p.anyo == anyo) {
                objetivo=p;
                break;
            }
        }
        if(objetivo==null){
            objetivo=new Periodo(anyo);
            listaPeriodos.add(objetivo);
        }

        objetivo.anyadirMedicion(mes,v,v1,v2,lluvia);

    }
}
