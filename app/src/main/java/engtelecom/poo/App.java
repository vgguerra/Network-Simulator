package engtelecom.poo;

import engtelecom.poo.redes.*;

public class App {

    public static void main(String[] args) throws Exception {

        Topologia topologia = new Topologia();

        for(int i = 0;i < 12;i++){
            System.out.println(topologia.comuta1(i));
        }
        System.out.println();
        for(int i = 0;i < 12;i++){
            System.out.println(topologia.comuta2(i));
        }

        System.out.println();

        System.out.println(topologia.getMacComuta1());
        System.out.println(topologia.getMacComuta2());

        Roteador roteador = new Roteador(Ip.IpR,MacAddress.R);

        roteador.addRota(0,Ip.IpC1,5);
        System.out.println(roteador.getRota(0));

        roteador.addRota(1,Ip.IpC2,5);
        System.out.println(roteador.getRota(1));

        roteador.addRota(2,Ip.IpF,0);
        System.out.println(roteador.getRota(2));

    }

}
