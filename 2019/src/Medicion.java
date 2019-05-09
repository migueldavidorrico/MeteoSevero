public class Medicion {
    private enum Comprobaciones{
        TEMPERATURA(-100,100),
        LLUVIA(0,1000),
        UVA(0,60);

        private final int min;
        private final int max;

        Comprobaciones(int i, int i1) {
            this.min=i;
            this.max=i1;
        }

        public double comprueba(double numero,String medida) {
            if(!(min<numero && numero<max)){
                throw new IllegalArgumentException("Error en la temperatura "+medida );
            }
            return (double)numero;
        }

    }

    public static int TAMANYO_REGISTRO=8+8+8+4;

    private double temperaturaMaxima;
    private double temperaturaMinima;
    private double temperaturaMedia;
    private int precipitacion;

    public Medicion(double temperaturaMaxima, double temperaturaMinima, double temperaturaMedia, int precipitacion) {
        this.temperaturaMaxima = Comprobaciones.TEMPERATURA.comprueba(temperaturaMaxima,"Máxima");
        this.temperaturaMinima = Comprobaciones.TEMPERATURA.comprueba(temperaturaMinima,"Mínima");
        this.temperaturaMedia = Comprobaciones.TEMPERATURA.comprueba(temperaturaMedia,"Media");
        this.precipitacion = (int)Comprobaciones.LLUVIA.comprueba(precipitacion,"Lluvia");

    }


    public Medicion(double temperaturaMaxima, double temperaturaMinima, double temperaturaMedia) {
        this(temperaturaMaxima,temperaturaMinima,temperaturaMedia,0);
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public int getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(int precipitacion) {
        this.precipitacion = precipitacion;
    }

    public String info(){
        String salida="";
        salida+="      Tª Máxima:"+String.format("%.2f",this.temperaturaMaxima)+"℃\n";
        salida+="      Tª Mínima:"+String.format("%.2f",this.temperaturaMinima)+"℃\n";
        salida+="       Tª Media:"+String.format("%.2f",this.temperaturaMedia)+"℃\n";
        salida+="Precipitaciones:"+this.precipitacion+" litros";
        return salida;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Medicion{");
        sb.append("temperaturaMaxima=").append(temperaturaMaxima);
        sb.append(", temperaturaMinima=").append(temperaturaMinima);
        sb.append(", temperaturaMedia=").append(temperaturaMedia);
        sb.append(", precipitacion=").append(precipitacion);
        sb.append('}');
        return sb.toString();
    }


    public static void main(String[] args) {
        Medicion una=new Medicion(32,12,20,34);
        System.out.println(una.info());
        System.out.println(una);
    }

}
