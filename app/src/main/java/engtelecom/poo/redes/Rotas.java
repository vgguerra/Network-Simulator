package engtelecom.poo.redes;


import engtelecom.poo.redes.enums.Ip;

/**
 * Classe que irá representar uma rota de um roteador
 *
 * @author Victor Guerra
 */
public class Rotas {
    /**
     * Irá representar o Ip das redes conhecidas
     */
    private final Ip ip;

    /**
     * Irá indicar a porta na qual o Roteador está associado em um determinado dispositivo
     */
    private final int portaSaida;

    /**
     * Método construtor que irá passar o IP da rede e a porta de saída onde o roteador está associado.
     * @param ip Ip
     * @param portaSaida int
     */
    public Rotas(Ip ip, int portaSaida){
        this.ip = ip;
        this.portaSaida = portaSaida;
    }

    /**
     * Método que irá retornar o Ip  de uma determinado rota
     * @return String
     */
    public String getIp(){
        return this.ip.toString();
    }

    /**
     * Método toString que irá retornar o Ip e a porta de saída associado.
     * @return String
     */
    @Override
    public String toString() {
        return "IP: "+ ip + " - Porta de saída associada: " + portaSaida;
    }
}
