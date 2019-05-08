public enum Meses {
    ENERO,
    FEBRERO,
    MARZO,
    ABRIL,
    MAYO,
    JUNIO,
    JULIO,
    AGOSTO,
    SEPTIEMBRE,
    OCTUBRE,
    NOVIEMBRE,
    DICIEMBRE;

    public String getTitulo(){
        return this.name().substring(0,1).toUpperCase()+this.name().substring(1).toLowerCase();
    }
    public int numeroMes(){
        return this.ordinal()+1;
    }
}
