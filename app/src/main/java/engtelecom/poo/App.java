package engtelecom.poo;

import engtelecom.poo.redes.*;

import java.util.Scanner;

public class App {

    /**
     * Atributo da classe App que irá ser utilizado para criação de todos os métodos necessários para o programa
     */
    private Topologia topologia;

    /**
     * Atributo que irá ler as entradas do usuario pelo teclado
     */
    private static Scanner sc = new Scanner(System.in);


    /**
     * Méotodo constutor da classe app
     */
    public App(){
        this.topologia = new Topologia();
    }

    /**
     * Méotoodo que irá listar todos os dispositivos por tipo que tem em nossa topologia
     */
    public void listDevicesForType(){
        App app = new App();

        System.out.println("Comutadores: \n" + "Comutador 1: MAC - " + topologia.getMacComuta1() + " ; IP: " + topologia.getIpComuta1() + "\nComutadores 2: MAC - " + topologia.getMacComuta2() + " ; IP: " + topologia.getIpComuta2()
        + "\n\nRoteador: MAC - " + topologia.getMacRoteador() + " ; IP: " + topologia.getIpRoteador()
        + "\n\nFirewall: MAC - " + topologia.getIpFirewall() + " ; IP: " + topologia.getIpFirewall());

    }

    /**
     * Méotodo que irá listar todos os dispositivos em cada rede
     */
    public void listDevicesForNetwork(){
        App app = new App();

        System.out.println("REDE 1:\n\nComutador 1: MAC - "  + topologia.getMacComuta1() + " ; IP: " + topologia.getIpComuta1());
        for(int i = 0;i < 4;i++){
            System.out.println("Computador " + (i+1)  + ": MAC -  " + topologia.getMacDeviceComuta1(i));
        }
        System.out.println("Roteador: MAC - " + topologia.getMacRoteador() + "; IP: " + topologia.getIpRoteador());

        System.out.println("\nRede 2:\n\nComutador 2: MAC - " + topologia.getMacComuta2() + "; IP: " + topologia.getIpComuta2());
        for(int i = 0;i < 4;i++){
            System.out.println("Computador " + (i+1)  + ": MAC - " + topologia.getMacDeviceComuta2(i));
        }
        System.out.println("Roteador: MAC - " + topologia.getMacRoteador() + "; IP: " + topologia.getIpRoteador());

        System.out.println("\nRede 3:\n\nRoteador: Mac - " + topologia.getMacRoteador() + "; IP: " + topologia.getIpRoteador() + "\nFirewall: MAC - " + topologia.getMacFirewall() + "; IP: " + topologia.getIpFirewall());
    }

    /**
     * Método que irá listar a tabela de rotas do roteador
     */
    public void listRoutes(){
        System.out.println("Tabela de rotas: \n");
        for (int i = 0; i < 3; i++) {
            System.out.println(topologia.getRotas(i));
        }
    }

    /**
     * Método que irá listar todas as regras dentro do firewall
     */
    public void listRules(){
        System.out.println("Lista de regras: ");
        for(int i = 0; i < topologia.getNumRules(); i++){
            System.out.println("Regra " + (i+1) + ": " + topologia.getRules(i));
        }
    }

    /**
     * Método que irá criar uma regra nova para o firewall
     */
    public void createRule(String ipOrigem, String ipDestino,int portaOrigem, int portaDestino,String acao){
       topologia.createRule(ipOrigem, ipDestino, portaOrigem, portaDestino, acao);
    }

    /**
     * Método que irá apagar uma regra do firewall
     * @param index
     */
    public void deleteRule(int index){
        topologia.deleteRule(index);
    }

    public void simulatePacket(String ipOrigem, String ipDestino,int portaOrigem, int portaDestino,String macAddres,String payload){

    }

    public static void main(String[] args) {
        App app = new App();
        int opc = -1;
        System.out.println("Bem-vindo ao simulador de redes!\n");

        while(opc != 0){
            System.out.println("Por favor, digite a opção desejada:\n\n1 - Listar dispositivos por tipo\n2 - Listar dispositivos por rede\n3 - Listar rotas\n4 - Listar regras de filtragem\n5 - Criar regra de filtragem\n6 - Apagar regra de filtragem\n7 - Simular processamento de pacote\n0 - Sair");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1:
                    System.out.println("------------------------------------");
                    app.listDevicesForType();
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    System.out.println("------------------------------------");
                    app.listDevicesForNetwork();
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    System.out.println("------------------------------------");
                    app.listRoutes();
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    System.out.println("------------------------------------");
                    app.listRules();
                    System.out.println("------------------------------------");
                    break;
                case 5:
                    System.out.print("Digite qual o IP de origem da regra nova: ");
                    String ipOrigem = sc.nextLine();

                    System.out.print("Digte qual o IP de destino da regra nova: ");
                    String ipDestino = sc.nextLine();

                    System.out.print("Digite qual o porta origem da regra nova: ");
                    int portaOrigem = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite qual o porta destino da regra nova: ");
                    int portaDestino = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite qual a ação da regra nova: ");
                    String acao = sc.nextLine();
                    app.createRule(ipOrigem,ipDestino,portaOrigem,portaDestino,acao);
                    break;

                case 6:
                    System.out.println("------------------------------------");
                    System.out.print("Digite qual a regra que você deseja apagar: ");
                    app.listRules();
                    try{
                        int index = sc.nextInt() - 1;
                        sc.nextLine();
                        app.deleteRule(index);
                        System.out.println("Regra deletada");
                    } catch (IndexOutOfBoundsException e){
                        System.err.println("A regra selecionada não existe!");
                    }
                    System.out.println("------------------------------------");
            }
        }
    }



}
