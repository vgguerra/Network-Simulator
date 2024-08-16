package engtelecom.poo.redes;

public enum Ip {

    IpC1("1230",0),IpC2("2240",1),IpR("3320",2),IpF("4020",3);

    private String ip;
    private int index;

    Ip(String ip, int indice){
        this.ip = ip;
        this.index = indice;
    }

    public Ip getIpByIndex(int index){
        if(index < 12 && index >= 0){
            for (Ip a : Ip.values()){
                if(index == a.index){
                    return a;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return ip;
    }
}
