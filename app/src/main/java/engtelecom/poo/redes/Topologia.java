package engtelecom.poo.redes;

public class Topologia {

    /**
     * Atributo que irá representar nosso comutador 1
     */
    private Comutador comutador1;

    /**
     * Atributo que irá representar nosso comutador 2
     */
    private Comutador comutador2;

    /**
     * Atributo que irá representar nosso roteador
     */
    private Roteador roteador;

    /**
     * Método constutor que irá instanciar todas os objetos necessário e subir a topologia conforme solicitado no exercíco
     */
    public Topologia(){
        comutador1 =  new Comutador(Ip.IpC1, MacAddress.A1);
        comutador2 = new Comutador(Ip.IpC2, MacAddress.B1);

        for(int i = 0; i < 4; i ++){
            comutador1.addDevice(i,MacAddress.getByIndex(i+1));
        }
        for (int i = 6; i  < 10 ; i++) {
            comutador2.addDevice(i-6,MacAddress.getByIndex(i));
        }

        roteador.addRota(0,Ip.IpC1,5);
        roteador.addRota(1,Ip.IpC2,5);
        roteador.addRota(2,Ip.IpF,0);

    }

    /**
     * Irá retornar o endereço MAC do dispositivo associado a porta de número x(index) do comutador 1
     * @param index
     * @return
     */
    public MacAddress comuta1(int index) {
        return comutador1.getDeviceMac(index);
    }

    /**
     * Irá retornar o endereço MAC do dispositivo associado a porta de número x(index) do comutador 2
     * @param index
     * @return
     */
    public MacAddress comuta2(int index) {
        return comutador2.getDeviceMac(index);
    }

    /**
     * Irá retornar o endereço mac do comutador 1
     * @return
     */
    public MacAddress getMacComuta1(){
        return comutador1.mac;
    }
    /**
     *
     * Irá retornar o endereço mac do comutador 2
     * @return
     */
    public MacAddress getMacComuta2(){
        return comutador2.mac;
    }

    /**
     * Irá retornar o endereço mac do roteador
     * @return
     */
    public MacAddress getMacRoteador(){
        return roteador.mac;
    }

    /**
     * Irá retornar o IP do roteador
     * @return
     */
    public Ip getIpRoteador(){
        return roteador.ip;
    }




}
