package engtelecom.poo.redes;

import java.util.ArrayList;

public class Comutador extends Dispositivo {

    private MacAddress[] macAddresses;

    public Comutador(MacAddress mac, Ip ip){
        super(ip, mac);
        this.macAddresses = new MacAddress[12];
    }

    public void add(int indice){

    }

}
