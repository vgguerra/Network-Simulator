package engtelecom.poo.redes;

public abstract class Dispositivo {

    private Ip ip;
    private MacAddress mac;

    public Dispositivo (Ip ip, MacAddress mac) {
        this.ip = ip;
        this.mac = mac;
    }


}
