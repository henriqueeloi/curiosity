
## Curiosity - Explorando Marte
Um conjunto de sondas foi enviado pela NASA à Marte e irá pousar num planalto. Esse planalto, que curiosamente é retangular, deve ser explorado pelas sondas para que suas câmera embutidas consigam ter uma visão completa da área e enviar as imagens de volta para a Terra.

## Como executar

Usando o mavem utilize os comandos abaixo:   
mvn spring-boot:run  
ou  
mvn clean package  
java -jar target/curiosity-0.0.1-SNAPSHOT.jar

## HTTP states
Os códigos de status <a href="https://github.com/for-GET/know-your-http-well/blob/master/status-codes.md">comum de resposta HTTP </a> será usado nesta API.

## Media Types
application/json

## Endpoints
Link Postman: 
<a href="https://www.getpostman.com/collections/29bcc68f37c37b9f6cf0"> https://www.getpostman.com/collections/29bcc68f37c37b9f6cf0
</a>

### Incluir novo planeta 
POST /planets/{name} HTTP/1.1  
Host: localhost:8080  
Content-Type: application/json

{  
   "x": 5,  
   "y": 5  
}
   
### Retorna todos os planetas
GET /planets/ HTTP/1.1  
Host: localhost:8080  

### Retorna um planeta
GET /planets/{name}
Host: localhost:8080  

### Inclui uma nova sonda em um planeta
POST /planets/Marte/sondas/sonda1 HTTP/1.1  
Host: localhost:8080  
Content-Type: application/json  

{  
  "direction": "NORTH",  
  "coordinate": {  
    "x": 1,  
    "y": 2  
  }  
}

### Retorna uma sonda
GET /sondas/sonda1 HTTP/1.1  
Host: localhost:8080  

### Exclui uma Sonda
DELETE /sondas/{name} HTTP/1.1  
Host: localhost:8080  

### Exclui um planeta
DELETE /planets/{name}  
Host: localhost:8080  

### Enviar instrucoes
POST /sondas/sonda1/instructions HTTP/1.1  
Host: localhost:8080  
Content-Type: application/json  

[  
  "LEFT",  
  "MOVE",  
  "LEFT",  
  "MOVE",  
  "LEFT",  
  "MOVE",  
  "LEFT",  
  "MOVE",  
  "MOVE"  
]
