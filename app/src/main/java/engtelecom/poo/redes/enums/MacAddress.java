package engtelecom.poo.redes.enums;

/**
 * Enum utilizada para representar os MacAddress dos dispositivos em nossa topologia
 *
 * @author Victor Guerra
 */
public enum MacAddress {

    /**
     * Instancias que representam os os MacAddres dos comutadores(A1 e B1), do roteador(R) e do firewall(F)
     */
    C1("C1",0),A1("A1",1),A2("A2",2),A3("A3",3),A4("A4",4),C2("C2",5),B1("B1",6),B2("B2",7),B3("B3",8),B4("B4",9),R("R1",10),F("F1",11);

    /**
     * Atributo que irá indicar o endereço mac do dispositivo
     */
    private final String mac;
    private final int index;

    /**
     * Método construtor da nossa enum de Mac
     * @param mac String
     * @param index int
     */
    MacAddress(String mac, int index){
        this.mac = mac;
        this.index = index;
    }

    /**
     * Método que irá acessar um mac na enum pelo seu índice
     * @param index int
     * @return MacAddres
     */
    public static MacAddress getByIndex(int index){
        for(MacAddress mac : MacAddress.values()){
            if(mac.index == index){
                return mac;
            }
        }
        return null;
    }

    /**
     * Método que irá comparar se uma string equivalente a um mac é igual ao mac instanciado
     * @param mac String
     * @return boolean
     */
    public boolean equals(String mac){
        return this.mac.equalsIgnoreCase(mac);
    }

    /**
     * Método toString que irá retornar o mac do dispositivo
     * @return String
     */
    @Override
    public String toString(){
         return mac;
    }


}
