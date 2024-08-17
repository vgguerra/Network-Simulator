package engtelecom.poo.redes.enums;

/**
 * Enum utilizada para representar os IP's dos dispositivos em nossa topologia
 *
 * @author Victor Guerra
 */
public enum Ip {
    /**
     * Instancias que representam os Ips dos comutadores(C2 e C1), do roteador(R) e do firewall(F)
     */
    IpC1("1230"),IpC2("2240"),IpR("3320"),IpF("4020");

    /**
     * Atributos que representam
     */
    private String ip;

    /**
     * Método construtor da nossa enum de IP's
     * @param ip String
     */
    Ip(String ip){
        this.ip = ip;
    }

    /**
     * Método toString que retorna o Ip do dispositivo em questão
     * @return String
     */
    @Override
    public String toString() {
        return ip;
    }
}
