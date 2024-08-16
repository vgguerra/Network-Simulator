package engtelecom.poo.redes;


public class Rotas {
    /**
     * Irá representar o Ip das redes conhecidas
     */
    private Ip ip;

    /**
     * Irá indicar a porta na qual o Roteador está associado em um determinado dispositivo
     */
    private int portaSaida;

    /**
     * Método construtor que irá passar o IP da rede e a porta de saída onde o roteador está associado.
     * @param ip
     * @param portaSaida
     */
    public Rotas(Ip ip, int portaSaida){
        this.ip = ip;
        this.portaSaida = portaSaida;
    }

    public int getPortaSaida(){
        return this.portaSaida;
    }

    public Ip getIp(){
        return this.ip;
    }

    @Override
    public String toString() {
        return ip+ " " + portaSaida;
    }
}
