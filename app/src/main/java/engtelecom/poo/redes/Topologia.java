package engtelecom.poo.redes;

/**
 * Classe que irá iniciar nossa topologia
 *
 * @author Victor Guerra
 */
public class Topologia {

    /**
     * Atributo que irá representar o comutador 1 dentro da topologia
     */
    private Comutador comutador1;

    /**
     * Atributo que irá representar o comutador 2 dentro da topologia
     */
    private Comutador comutador2;

    /**
     * Atributo que irá representar o roteador dentro da topologia
     */
    private Roteador roteador;

    /**
     * Atributo que irá representar o firewall dentro da topologia
     */
    private Firewall firewall;


    /**
     * Método constutor que irá instanciar todas os objetos necessário e subir a topologia conforme solicitado no exercíco
     */
    public Topologia(){
        this.comutador1 =  new Comutador(Ip.IpC1, MacAddress.A1);
        this.comutador2 = new Comutador(Ip.IpC2, MacAddress.B1);
        this.roteador = new Roteador(Ip.IpR,MacAddress.R);
        this.firewall = new Firewall(Ip.IpF,MacAddress.F);

        for(int i = 0; i < 4; i ++){
            comutador1.addDevice(i,MacAddress.getByIndex(i+1));
        }
        for (int i = 6; i  < 10 ; i++) {
            comutador2.addDevice(i-6,MacAddress.getByIndex(i));
        }


        this.roteador.addRota(0,Ip.IpC1,5);
        this.roteador.addRota(1,Ip.IpC2,5);
        this.roteador.addRota(2,Ip.IpF,0);

        this.firewall.addRule(new Regras("5234","A2",80,8080,"Encaminhar"));

    }

    /**
     * Irá retornar o endereço MAC do dispositivo associado a porta de número x(index) do comutador 1
     * @param index int
     * @return MacAddres
     */
    public MacAddress getMacDeviceComuta1(int index) {
        return comutador1.getDeviceMac(index);
    }

    /**
     * Irá retornar o endereço MAC do dispositivo associado a porta de número x(index) do comutador 2
     * @param index int
     * @return MacAddres
     */
    public MacAddress getMacDeviceComuta2(int index) {
        return comutador2.getDeviceMac(index);
    }

    /**
     * Irá retornar o endereço MAC do comutador 1
     * @return MacAddress
     */
    public MacAddress getMacComuta1() {
        return comutador1.getMac();
    }

    /**
     * Irá retornar o endereço MAC do comutador 2
     * @return MacAddress
     */
    public MacAddress getMacComuta2() {
        return comutador2.getMac();
    }


    /**
     * Irá retornar o endereço mac do roteador
     * @return MacAddres
     */
    public MacAddress getMacRoteador(){
        return roteador.mac;
    }

    /**
     * Irá retornar o endereço mac do firewall
     * @return MacAddres
     */
    public MacAddress getMacFirewall(){
        return firewall.mac;
    }

    /**
     * Irá retornar o Ip do comutador 1
     * @return Ip
     */
    public Ip getIpComuta1() {
        return comutador1.getIp();
    }

    /**
     * Irá retornar o Ip do comutador 2
     * @return Ip
     */
    public Ip getIpComuta2() {
        return comutador2.getIp();
    }

    /**
     * Irá retornar o IP do roteador
     * @return Ip
     */
    public Ip getIpRoteador(){
        return roteador.ip;
    }

    /**
     * Irá retornar o IP do firewall
     * @return Ip
     */
    public Ip getIpFirewall(){
        return firewall.ip;
    }

    /**
     * Método que irá retornar uma rota do roteador
     * @param index int
     * @return Rotas
     */
    public Rotas getRotas(int index){
        return roteador.getRota(index);
    }

    /**
     * Método que irá retornar uma regra, em determinada posição(index), de nosso firewall
     * @param index int
     * @return Regras
     */
    public Regras getRules(int index){
        return firewall.getRule(index);
    }

    /**
     * Método que irá retornar o número de regras que já tem adicionadas no firewall
     * @return int
     */
    public int getNumRules(){
        return this.firewall.getNumRules();
    }

    /**
     * Método que irá criar uma nova regra do firewall
     * @param ipOrigem String
     * @param ipDestino String
     * @param portaOrigem int
     * @param portaDestino int
     * @param acao String
     */
    public void createRule(String ipOrigem, String ipDestino,int portaOrigem, int portaDestino,String acao){
        firewall.addRule(new Regras(ipOrigem,ipDestino,portaOrigem,portaDestino,acao));
    }

    /**
     * Método que irá deletear uma regra do firewall
     * @param index int
     */
    public void deleteRule(int index){
        this.firewall.deleteRule(index);
    }

}
