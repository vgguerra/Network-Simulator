```mermaid
classDiagram
    
    class MacAddress{
        <<Enumeration>>
        C1,A1,A2,A3,A4,C2,B1,B2,B3,B4,R,F
        
        - String: mac
        - int: index
        
        + getByIndex(int index) MacAddress
        + equals(String mac) boolean
    }
    
    class Ip{
        <<Enumeration>>
        IpC1,IpC2,IpR,IpF;
    }
    
    class Dispositivo{
        <<Abstract>>
        # MacAddres mac
        # Ip ip
        
        + getIp() String
        + getMac() String
    }        
    
   class Comutador{
       - MacAddress[] macs

       + addDevice(int index, MacAddress mac) void
   }
   
   class Roteador{
       - Rotas[] rotas
       
       + addRota(int index,Ip ip,int portaSaida) void
   }
   
   class Firewall{
       - ArrayList~Regras~ regras
       
       + addRule(Regras regras) void
       + deleteRule(int index) void
       + compareRules(Regras regras,int index) boolean
   }
   
   class Regras{
       - String ipOrigem
       - String ipDestino
       - int portaOrigem
       - int portaDestino
       - String acao
       
       + equals(Object obj) boolean
   }
   
   class Rotas{
       - Ip ip
       - int portaSaida
   }
   
   class Topologia{
       - Comutador comutador1
       - Comutador comutador2
       - Roteador roteador
       - Firewall firewall
       
       + createRule(String ipOrigem, String ipDestino,int portaOrigem, int portaDestino,String acao) void
       + deleteRule(int index) void
       + compareRules(Regras regras,int index) boolean
   }
   
   class App{
       - Topologia topologia
       
       + listDevicesForType() void
       + listDevicesForNetwork() void
       + listRoutes() void
       + listRules() void
       + createRule() void
       + deleteRule() void
       + simulatePacket() void
   }
   
   Dispositivo "1" *-- "1" MacAddress
   Dispositivo "1" *-- "1" Ip
   
   Dispositivo <|-- Comutador
   Dispositivo <|-- Roteador
   Dispositivo <|-- Firewall
   
   Firewall"1" *-- "1..*"Regras
   
   Rotas "1" o-- "1" Ip
   Roteador "1" *-- "1..*" Rotas
   
   Comutador "1" o-- "1..12" MacAddress
   
   Topologia "1" *-- "2" Comutador
   Topologia "1" *-- "1" Roteador
   Topologia "1" *-- "1" Firewall
   
   App "1" *-- "1" Topologia
        

```

