package engtelecom.poo.redes;

import java.util.Objects;

/**
 * Classe que irá representar as regras que o firewall tem e indicar qual será a ação
 *
 * @author Victor Guerra
 */

public class Regras {

    /**
     * Atributo que irá representar o Ip de origem de uma regra
     */
    private final String  ipOrigem;

    /**
     * Atributo que irá representar o Ip de destino de uma regra
     */
    private final String ipDestino;

    /**
     * Aributo que irá representar a ação que deve ser realizada
     */
    private final String  acao;

    /**
     * Atributo que irá representar a porta de origem de uma regra
     */
    private final int portaOrigem;

    /**
     * Atributo que irá representar a porta de destino de uma regra
     */
    private final int portaDestino;

    /**
     * Método construtor que irá setar as informações de uma regra
     * @param ipOrigem String
     * @param ipDestino String
     * @param portaOrigem int
     * @param portaDestino iint
     */
    public Regras(String ipOrigem,String ipDestino,int portaOrigem,int portaDestino,String acao) {
        this.ipOrigem = ipOrigem;
        this.ipDestino = ipDestino;
        this.portaOrigem = portaOrigem;
        this.portaDestino = portaDestino;
        this.acao = acao;
    }

    /**
     * Método toString que irá retornar as informações de uma regra
     * @return String
     */
    @Override
    public String toString() {
        return "IP de orgiem: " + this.ipOrigem + " || IP de destino: " + this.ipDestino + " || Porta de origem: " + this.portaOrigem + " || Porta de destino: " + this.portaDestino + " || Ação: " + this.acao;
    }

    /**
     * Método get da ação de uma regra
     * @return int
     */
    public String getAcao() {
        return this.acao;
    }

    /**
     * Método que irá verificar se as informações de um determinado pacote são iguais as solicitadas por uma regra
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Regras regras = (Regras) obj;
        return ipDestino.equalsIgnoreCase(regras.ipDestino) && ipOrigem.equalsIgnoreCase(regras.ipOrigem) && portaOrigem == regras.portaOrigem && portaDestino == regras.portaDestino;
    }
}
