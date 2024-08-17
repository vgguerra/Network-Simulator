package engtelecom.poo.redes.dispositivos;

import engtelecom.poo.redes.enums.Ip;
import engtelecom.poo.redes.enums.MacAddress;

/**
 * Classe que irá representar um comutador dentro de nossa topologia
 *
 * @author Victor Guerra
 */
public class Comutador extends Dispositivo {

    /**
     * Tabela de endereços macs onde cada dispositivo esta associado
     */
    private final MacAddress[] macs;

    /**
     * Método construtor que irá instanciar o vetor de tamanho 12(número de portas) do comutador e indicar o IP e mac do comutador.
     * @param ip Ip
     * @param mac MacAddress
     */
    public Comutador(Ip ip, MacAddress mac) {
        super(ip, mac);
        macs = new MacAddress[12];
    }

    /**
     * Método que adiciona um dispositivo no comutador
     * @param index int
     * @param mac MacAddres
     */
    public void addDevice(int index, MacAddress mac) {
            macs[index] = mac;

    }

    /**
     * Método que irá retornar o dispositivo conectado em um porta x(index)
     * @param index int
     * @return MacAddress
     */
    public MacAddress getDeviceMac(int index) {
            return macs[index];

    }

}
