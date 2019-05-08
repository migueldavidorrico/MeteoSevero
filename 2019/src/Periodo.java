public class Periodo {
    int anyo;
    Medicion[] mediciones;

    public Periodo(int anyo) {
        this.anyo = anyo;
        this.mediciones=new Medicion[12];
    }

    public Periodo anyadirMedicion(String mes,double tmax,double tmin,double tmed,int lluvia){
        int numeroMes;
        try {
             numeroMes = Meses.valueOf(mes.toUpperCase()).ordinal();
        } catch (IllegalArgumentException iae){
            throw new IllegalArgumentException("El mes "+mes+" no es correcto");
        }
        this.mediciones[numeroMes]=new Medicion(tmax,tmin,tmed,lluvia);
        return this;
    }


    public String info(){
        String salida="          AÑO: "+anyo+"\n";
        for (int i = 0; i < mediciones.length; i++) {
            salida+="MES: "+Meses.values()[i].getTitulo()+"\n";
            if(mediciones[i]==null){
                salida+="---> Sin datos\n";
            } else {
                salida += mediciones[i].info()+"\n";
            }
        }
        return salida;
    }

    public static void main(String[] args) {
        Periodo p=new Periodo(2019);
        System.out.println(p.info());
        System.out.println("----------------------------------");
        System.out.println(p.anyadirMedicion("Enero", 56, 34, 23, 98)
                .anyadirMedicion("Febrero", 34, 54, 65, 75)
                .anyadirMedicion("Marzo", 34, 54, 65, 75)
                .anyadirMedicion("Mayo", 34, 54, 65, 75)
                .anyadirMedicion("Julio", 34, 54, 65, 75).info());
        System.out.println(p.info());
    }
}
