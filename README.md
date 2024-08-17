# Projeto 2 POO JAVA - Simulador de redes

## Objetivo do projeto
Neste projeto, nosso objetivo foi o de criar uma toplogia de rede estática definada nos requisitos do projeto e que fosse possível realizar as seguintes funcionalidades:

- Listar dispositivos por tipo
- Listar dispositivos por rede
- Listar rotas
- Listar regras de filtragem
- Criar regra de filtragem
- Apagar regra de filtragem
- Simular processamento de pacote

## Instruções do programa

### Como criar uma nova regra de filtragem
Para criar uma nova regra de filtragem, durante a execução do programa, selecione a opção 5 e digite o IP de origem, o IP de destino, a porta de origem, a porta de destino e a ação a se realizar caso a regra seja satisfeita.

### Criação de um pacote IP e simulação de processamento
A criação de um pacote IP ocorre durante a simulação de um pacote, selecionando a opção 7 durante a execução do programa. No meu ver a criação de uma classe "Pacote" neste caso não seria necessária, tendo em vista que este pacote seria utilizado apenas durante a execução da simulação de processamento do pacote. Após passar as informações do pacote, irá ser simulado o processamento do pacote em cada um dos dispositivos da topologia (Comutadores,roteador e firewall).

## Funcionalidade implementadas
Em minha aplicação, foi possível realizar a implementação de todas as funcionalidades solicitadas pelo projeto, funcionalidades essas informadas no [Objetivo do projeto](#objetivo-do-projeto)

## Diagrama de classes UML
Abaixo segue o diagrama de classes UML, indicando os principais atributos e os principais métodos de cada classe do programa

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

