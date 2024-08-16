package engtelecom.poo.redes;

public enum MacAddress {

    A1("A1",0),A2("A2",1),A3("A3",2),A4("A4",3),A5("A5",4),B1("B1",5),B2("B2",6),B3("B3",7),B4("B4",8),B5("B5",9),R("R",10),F("F",11);

    public final String mac;
    public final int index;

     MacAddress(String mac, int index){
        this.mac = mac;
        this.index = index;
    }

    public static MacAddress getByIndex(int index){
         for(MacAddress mac : MacAddress.values()){
             if(mac.index == index){
                 return mac;
             }
         }
         return null;
    }

    @Override
    public String toString(){
         return mac;
    }


}
