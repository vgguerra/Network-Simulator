package engtelecom.poo.redes;

public abstract class Ip {

    private String ip;

    public Ip(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }
}
