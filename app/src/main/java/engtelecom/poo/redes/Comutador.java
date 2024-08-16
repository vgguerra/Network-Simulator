package engtelecom.poo.redes;

import java.util.ArrayList;

public class Comutador extends Dispositivo {

    /**
     * Tabela de endereços macs onde cada dispositivo esta associado
     */
    private MacAddress[] macs;

    /**
     * Método construtor que irá instanciar o vetor de tamanho 12(número de portas) do comutador e indicar o IP e mac do comutador.
     * @param ip
     * @param mac
     */
    public Comutador(Ip ip, MacAddress mac) {
        super(ip, mac);
        macs = new MacAddress[12];
    }

    /**
     * Método que adiciona um dispositivo no comutador
     * @param index
     * @param mac
     */
    public void addDevice(int index, MacAddress mac) {
            macs[index] = mac;

    }

    /**
     * Método que irá retornar o dispositivo conectado em um porta x(index)
     * @param index
     * @return
     */
    public MacAddress getDeviceMac(int index) {
            return macs[index];

    }

}
