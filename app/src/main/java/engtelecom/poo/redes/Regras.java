package engtelecom.poo.redes;

/**
 * Classe que irá representar as regras que o firewall tem e indicar qual será a ação
 *
 * @author Victor Guerra
 */

public class Regras {

    /**
     * Atributo que irá representar o Ip de origem de uma regra
     */
    private String  ipOrigem;

    /**
     * Atributo que irá representar o Ip de destino de uma regra
     */
    private String  ipDestino;

    /**
     * Aributo que irá representar a ação que deve ser realizada
     */
    private String  acao;

    /**
     * Atributo que irá representar a porta de origem de uma regra
     */
    private int portaOrigem;

    /**
     * Atributo que irá representar a porta de destino de uma regra
     */
    private int portaDestino;

    /**
     * Método construtor que irá setar as informações de uma regra
     * @param ipOrigem
     * @param ipDestino
     * @param portaOrigem
     * @param portaDestino
     */
    public Regras(String ipOrigem,String ipDestino,int portaOrigem,int portaDestino,String acao) {
        this.ipOrigem = ipOrigem;
        this.ipDestino = ipDestino;
        this.portaOrigem = portaOrigem;
        this.portaDestino = portaDestino;
        this.acao = acao;
    }

    @Override
    public String toString() {
        return "IP de orgiem: " + this.ipOrigem + " || IP de destino: " + this.ipDestino + " || Porta de origem: " + this.portaOrigem + " || Porta de destino: " + this.portaDestino + " || Ação: " + this.acao;
    }

    /**
     * Métodos get do Ip de origem
     * @return String
     */
    public String getIpOrigem() {
        return ipOrigem;
    }

    /**
     * Métodos get do Ip de destino
     * @return String
     */
    public String getIpDestino() {
        return ipDestino;
    }

    /**
     * Métodos get da porta de Origem
     * @return int
     */
    public int getPortaOrigem() {
        return portaOrigem;
    }

    /**
     * Métodos get da porta de destino
     * @return int
     */
    public int getPortaDestino() {
        return portaDestino;
    }

}
