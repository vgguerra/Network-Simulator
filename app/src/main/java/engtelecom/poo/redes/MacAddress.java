package engtelecom.poo.redes;

public enum MacAddress {

    A1("A1",0),A2("A2",1),A3("A3",2),A4("A4",3),B1("B1",4),B2("B2",5),B3("B3",6),B4("B4",7),R("R",8);

    public final String mac;
    public final int indice;

     MacAddress(String mac, int indice){
        this.mac = mac;
        this.indice = indice;
    }

    public static MacAddress getByIndice(int indice){
         for(MacAddress mac : MacAddress.values()){
             if(mac.indice == indice){
                 return mac;
             }
         }
         return null;
    }

}
