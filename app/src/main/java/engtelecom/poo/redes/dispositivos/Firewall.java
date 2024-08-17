package engtelecom.poo.redes.dispositivos;

import engtelecom.poo.redes.enums.Ip;
import engtelecom.poo.redes.enums.MacAddress;
import engtelecom.poo.redes.Regras;

import java.util.ArrayList;

/**
 *Classe que irá representar um firewall dentro de nossa topologia
 *
 * @author Victor Guerra
 */
public class Firewall extends Dispositivo {

    /**
     * ArraayLista que irá guardar todas as regras do firewall
     */
    private ArrayList<Regras> regras;

    /**
     * Método construtor onde será indicado o IP e o MAC do dispositivo e instanciado uma tabela de regras
     * @param ip Ip
     * @param mac MacAddress
     */
    public Firewall(Ip ip, MacAddress mac) {
        super(ip, mac);
        this.regras = new ArrayList<>();
    }

    /**
     * Método que irá adicionar uma nova regra a tabela de regras
     * @param regras Regras
     */
    public void addRule(Regras regras) {
        this.regras.add(regras);
    }

    /**
     * Método que irá apagar uma regra da lista de regras do firewall
     * @param index int
     */
    public void deleteRule(int index){
        this.regras.remove(index);
    }

    /**
     * Método que irá retornar uma determinada regra
     * @param index int
     * @return Regras
     */
    public Regras getRule(int index) {
        return this.regras.get(index);
    }

    /**
     * Método que irá
     * @return int
     */
    public int getNumRules() {
        return this.regras.size();
    }

    /**
     * Método que irá comparar se uma regra e um pacote são iguais
     * @param regras Regras
     * @param index int
     * @return boolean
     */
    public boolean compareRules(Regras regras,int index) {
        return getRule(index).equals(regras);
    }


}
