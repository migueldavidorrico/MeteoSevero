import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RedEstaciones {
    private static final String CABECERA_HTML = "<!DOCTYPE html5><head><link href=\"colorines.css\" rel=\"stylesheet\"" +
            "<title>SUPER ESTACIONES</title></head><body><h1>Estaciones</h1>";
    private static final String FINAL_HTML = "</body></html>";
    List<Estacion> lista;
    File directorioInicial;

    public RedEstaciones(String s) {
        directorioInicial=new File(s);
        if(!directorioInicial.isDirectory()){
            throw new IllegalArgumentException("Se debe elgir un directorio");
        }
        this.lista = new ArrayList<>();
    }

    public RedEstaciones anyadeEstacion(String nombre) {
        lista.add(new Estacion(nombre));
        return this;
    }

    public RedEstaciones grabaTodoEnDisco() {
        for (Estacion e :
                lista) {
            e.grabaEnDisco(directorioInicial);

        }

        return this;
    }

    public RedEstaciones datosEstacion(String nombreEstacion, int anyo, String enero, double v, double v1, double v2, int i1) {
        Estacion objetivo=null;
        for (Estacion e :
                lista) {
            if (e.getNombre().toUpperCase().equals(nombreEstacion.toUpperCase())) {
                objetivo=e;
                break;
            }
        }
        if(objetivo==null){
            objetivo=new Estacion(nombreEstacion);
            lista.add(objetivo);
        }
        //objetivo es la estacion
        objetivo.anyadeMedicion(anyo,enero, v, v1, v2,i1);
        return this;
    }

    public void generaHTML(String s) throws IOException {
        CreaCSS(s);
        File f=new File(s);
        f.mkdir();
        List<String> contenidoFichero=new ArrayList<>();
        contenidoFichero.add(CABECERA_HTML);
        for (Estacion e :
                lista) {
            contenidoFichero.add("<h2>" + e.getNombre() + "</h2>");
            for (Periodo p :
                    e.listaPeriodos) {
                contenidoFichero.add("<h3>" + p.anyo + "</h3><ul>");
                for (int i = 0; i < p.mediciones.length; i++) {
                    contenidoFichero.add("<li><a>"+Meses.values()[i]);
                    if(p.mediciones[i]!=null){
                        contenidoFichero.add(""+p.mediciones[i].info()+"</a></li>");
                    } else {
                        contenidoFichero.add("No se tienen datos</a></li>");
                    }
                }

                contenidoFichero.add("</ul>");
            }
        }
        contenidoFichero.add(FINAL_HTML);
        Files.write(Paths.get(s,"index.html"),contenidoFichero);
    }

    private void CreaCSS(String s) throws IOException {
        List<String> css=new ArrayList<>();
        css.add("body{" +
                "background-color:#336;" +
                "color:silver;}" +
                "" +
                "ul { \n" +
                "    list-style:none; \n" +
                "}\n" +
                "\n" +
                "ul li { \n" +
                "    font-family:Georgia,serif,Times; \n" +
                "    font-size:18px; \n" +
                "}\n" +
                "\n" +
                "ul li a { \n" +
                "    display:block; \n" +
                "    height:28px; \n" +
                "    background-color:#333; \n" +
                "    border-left:5px solid #222; \n" +
                "    border-right:5px solid #222; \n" +
                "    padding-left:10px;\n" +
                "    text-decoration:none; \n" +
                "    color:#bfe1f1; \n" +
                "}\n" +
                "\n" +
                "ul li a:hover { \n" +
                "    -moz-transform:rotate(-5deg); \n" +
                "    -moz-box-shadow:10px 10px 20px #000000;\n" +
                "    -webkit-transform:rotate(-5deg); \n" +
                "    background-color:#33F; \n" +
                "    -webkit-box-shadow:10px 10px 20px #000000;\n" +
                "    transform:rotate(4deg); box-shadow:10px 10px 20px #000000; \n" +
                "    margin-left: 10px;\n" +
                "}");
        Files.write(Paths.get(s,"colorines.css"),css);
    }
}
