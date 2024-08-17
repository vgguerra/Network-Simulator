package engtelecom.poo.redes.dispositivos;

import engtelecom.poo.redes.enums.Ip;
import engtelecom.poo.redes.enums.MacAddress;

/**
 * Classe Dispositivo, a mais genérica de nossa aplicação, pois todos os dispositivos possuem um IP e um MacAddress
 *
 * @author Victor Guerra
 */
public abstract class Dispositivo {

    protected Ip ip;
    protected MacAddress mac;

    public Dispositivo (Ip ip, MacAddress mac) {
        this.ip = ip;
        this.mac = mac;
    }


    public String getIp() {
        return ip.toString();
    }

    public String getMac() {
        return mac.toString();
    }

}
