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
        System.out.println("Tabela de rotas do roteador: \n");
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
    public void createRule(){
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

        topologia.createRule(ipOrigem, ipDestino, portaOrigem, portaDestino, acao);
    }

    /**
     * Método que irá apagar uma regra do firewall
     */
    public void deleteRule(){
        System.out.print("Digite qual a regra que você deseja apagar: ");
        listRules();
        try{
            int index = sc.nextInt() - 1;
            sc.nextLine();
            topologia.deleteRule(index);
            System.out.println("Regra deletada");
        } catch (IndexOutOfBoundsException e){
            System.err.println("A regra selecionada não existe!");
        }
    }

    public void simulatePacket(){
        System.out.print("Digite o IP de origem do seu pacote: ");
        String ipOrigem = sc.nextLine();

        System.out.print("Digite o IP de destino do seu pacote: ");
        String ipDestino = sc.nextLine();

        System.out.print("Digite o porta origem do seu pacote: ");
        int portaOrigem = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o porta destino do seu pacote: ");
        int portaDestino = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite qual o endereço MAC de destino do seu pacote: ");
        String macAddressDestino = sc.nextLine();

        System.out.print("Digite qual o payload(conteúdo) de seu pacote: ");
        String payload = sc.nextLine();

        for (int i = 0; i < 3; i++) {
            switch (i){
                case 0: for(int j = 0;j < 2;j++){
                    System.out.println("\nComutador " + (j + 1) + ":");
                    if(j == 0) {
                        for(int k = 0;k < 5;k++){
                            if(topologia.getMacDeviceComuta1(k).equals(macAddressDestino)){
                                System.out.println("Encaminhando o pacote com conteúdo " + payload + " para o dispositivo na porta " + (k + 1) + " do comutador.");
                                break;
                            } if (k == 4) {
                                System.out.println("Encaminhando o com conteúdo \"" + payload + "\" pacote para todas as portas do comutador.");
                            }
                        }
                    } else{
                        for(int k = 0;k < 5;k++){
                            if(topologia.getMacDeviceComuta2(k).equals(macAddressDestino)){
                                System.out.println("Encaminhando o pacote com conteúdo \"" + payload + "\" para o dispositivo na porta " + (k + 1) + " do comutador.");
                                break;
                            } else if (k == 4) {
                                System.out.println("Encaminhando o com conteúdo " + payload + " pacote para todas as portas do comutador.");
                            }
                        }
                    }
                }
                System.out.println("---------");
                break;
                case 1:
                    System.out.println("Roteador:");
                    for(int j = 0;j < 3;j++){
                        char aux1 = topologia.getIpRota(j).charAt(0);
                        char aux2 = ipDestino.charAt(0);
                        if(aux1 == aux2){
                            System.out.println("Encaminhando o pacote com conteúdo \"" + payload + "\" para a rota de IP " + topologia.getIpRota(j) + " do roteador.");
                            break;
                        } else if (j == 2) {
                            System.out.println("Encaminhando o pacote para o firewall.");
                        }
                    }
                    System.out.println("---------");
                break;
                case 2:
                    System.out.println("Firewall:");
                    for(int j = 0;j < topologia.getNumRules();j++){
                        if(topologia.compareRules(new Regras(ipOrigem,ipDestino,portaOrigem,portaDestino,null),j)){
                            if(topologia.getAction(j).equalsIgnoreCase("Encaminhar")){
                                System.out.println("Encaminhando seu pacote com contéudo \" " + payload + "\"4. A regra satisfeita foi a regra " + (j + 1) + ": " + topologia.getRules(j));
                            } else {
                                System.out.println("Descartando o seu pacote com conteúdo \""+ payload + "\". A regra satisfeita foi a regra " + (j+1) + ": " + topologia.getRules(j));
                            }
                            break;
                        } if(j == topologia.getNumRules()-1){
                            System.out.println("Descartando o pacote com conteúdo \"" + payload + "\" pois nenhuma regra foi satisfeita!");
                        }
                    }
            }
        }


    }

    public static void main(String[] args) {
        App app = new App();
        int opc = -1;
        System.out.println("Bem-vindo ao simulador de redes!\n");

        while(opc != 0){
            System.out.println("Por favor, digite a opção desejada:\n\n1 - Listar dispositivos por tipo\n2 - Listar dispositivos por rede\n3 - Listar rotas do roteador\n4 - Listar regras de filtragem\n5 - Criar regra de filtragem\n6 - Apagar regra de filtragem\n7 - Simular processamento de pacote\n0 - Sair");
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
                    System.out.println("------------------------------------");
                    app.createRule();
                    System.out.println("------------------------------------");
                    break;

                case 6:
                    System.out.println("------------------------------------");
                    app.deleteRule();
                    System.out.println("------------------------------------");
                    break;

                case 7:
                    System.out.println("-----------------------------------");
                    app.simulatePacket();
                    System.out.println("------------------------------------");
            }
        }
    }



}
