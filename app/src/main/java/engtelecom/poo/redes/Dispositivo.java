package engtelecom.poo.redes;

public abstract class Dispositivo {

    protected Ip ip;
    protected MacAddress mac;

    public Dispositivo (Ip ip, MacAddress mac) {
        this.ip = ip;
        this.mac = mac;
    }


    public Ip getIp() {
        return ip;
    }

    public MacAddress getMac() {
        return mac;
    }

}
