import java.util.Map;
import java.util.TreeMap;

public enum NotaEspañol {
    MUY_DEFICIENTE(0),
    INSUFICIENTE(4.99),
    SUFICIENTE(5.99),
    BIEN(6.99),
    NOTABLE(7.99),
    SOBRESALIENTE(9.99),
    MH(100.99);


    static{

    }

    private final double limiteSuperior;

    NotaEspañol(double limiteSuperior) {
        this.limiteSuperior=limiteSuperior;
    }

    public static NotaEspañol obtenNota(double nota){
        NotaEspañol[] notas=NotaEspañol.values();
        int i=0;
        while(nota>notas[i].limiteSuperior){
            i++;
        }
        return notas[i-1];

    }

    public static void main(String[] args) {
//        for(double d=0;d<12;d+=0.1){
//            System.out.print(String.format("%.2f",d)+" - ");
//            System.out.println(NotaEspañol.obtenNota(d));
//        }
        Map<Double,NotaEspañol> notas=new TreeMap<>();
        notas.put(0.0,MUY_DEFICIENTE);
        notas.put(4.0,INSUFICIENTE);
        notas.put(5.0,SUFICIENTE);
        notas.put(5.99,BIEN);
        notas.put(6.99,NOTABLE);
        notas.put(8.99,SOBRESALIENTE);
        notas.put(100.99,MH);


        for(double d=0;d<12;d+=0.1){
            System.out.print(String.format("%.2f",d)+" - ");
            System.out.println(((TreeMap<Double, NotaEspañol>) notas).floorEntry(d));
        }

    }

}
