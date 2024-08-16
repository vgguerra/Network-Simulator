package engtelecom.poo.redes;

public class Pacote {

    /**
     * Atributo que irá representar o IP de origem do pacote
     */
    private String ipOrigem;

    /**
     * Atributo que irá representar o IP de destino do pacote
     */

    private String ipDestino;

    /**
     * Atributo que irá representar a porta origem do pacote
     */
    private int portaOrigem;

    /**
     * Atributo que irá representar a porta de destino do pacote
     */
    private int portaDestino;

    /**
     * Atributo que irá representar o macAddres de desitno do pacote
     */
    private String macAddres;

    /**
     * Atributo que irá representar o payload do pacote
     */
    private String payload;

    public Pacote(String ipOrigem, String ipDestino,int portaOrigem, int portaDestino,String macAddres,String payload) {
        this.ipOrigem = ipOrigem;
        this.ipDestino = ipDestino;
        this.portaOrigem = portaOrigem;
        this.portaDestino = portaDestino;
        this.macAddres = macAddres;
        this.payload = payload;
    }
}
