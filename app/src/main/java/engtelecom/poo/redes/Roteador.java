package engtelecom.poo.redes;

public class Roteador extends Dispositivo{

    /**
     * Atributo que irá guardar as rotas com as redes conhecidas e a porta de saída associada
     */
    private Rotas[] rotas;

    /**
     * Método construtor da classe, onde será indicado o IP e o MAC do dispositivo e instanciado uma tabela de rotas, de tamanho estático 3, que é o número de redes conhecidas
     * @param ip
     * @param mac
     */
    public Roteador(Ip ip, MacAddress mac) {
        super(ip, mac);
        rotas = new Rotas[3];
    }

    /**
     * Método que adiciona uma rota ao vetor de rotas de nosso roteador
     * @param index
     * @param ip
     * @param portaSaida
     */
    public void addRota(int index,Ip ip,int portaSaida){
        rotas[index] = new Rotas(ip,portaSaida);
    }

    /**
     * Irá retornar a rede e a porta de saída associado na posição index do vetor de rotas de nosso roteador
     * @param index
     * @return
     */
    public Rotas getRota(int index){
        return rotas[index];
    }

}
