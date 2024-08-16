package engtelecom.poo.redes;

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
     * @param ip
     * @param mac
     */
    public Firewall(Ip ip, MacAddress mac) {
        super(ip, mac);
        this.regras = new ArrayList<>();
    }

    /**
     * Método que irá adicionar uma nova regra a tabela de regras
     * @param regras Regras
     */
    public void addRegras(Regras regras) {
        this.regras.add(regras);
    }

    /**
     * Método que irá retornar uma determinada regra
     * @param index
     * @return Regras
     */
    public Regras getRegras(int index) {
        return this.regras.get(index);
    }

    /**
     * Método que irá
     * @return int
     */
    public int getNumRegras() {
        return this.regras.size();
    }



}
