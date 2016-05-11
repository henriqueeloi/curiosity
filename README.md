## Curiosity - Explorando Marte
Um conjunto de sondas foi enviado pela NASA à Marte e irá pousar num planalto. Esse planalto, que curiosamente é retangular, deve ser explorado pelas sondas para que suas câmera embutidas consigam ter uma visão completa da área e enviar as imagens de volta para a Terra.


## HTTP states
Os códigos de status <a href="https://github.com/for-GET/know-your-http-well/blob/master/status-codes.md">comum de resposta HTTP </a> será usado nesta API.

## Media Types
application/json

## Endpoints

### Incluir novo planeta 
> POST /planets/Marte HTTP/1.1
> Content-Type: application/json

{
    "x": 5,
    "y": 5
}

# 
  
### Retorna todos os planetas
[/planets], methods=[GET]

### Retorna um planeta
[/planets/{name}], methods=[GET]

### Inclui uma nova sonda em um planeta
[/planets/{planet}/sondas/{name}],methods=[POST]

#### Exemplo Playload
{
  "direction": "NORTH",
  "coordinate": {
    "x": 1,
    "y": 2
  }
}

### Retorna uma sonda
{[/sondas/{name}], methods=[GET]}

### Exclui uma Sonda
[/sondas/{name}], methods=[DELETE]
[/planets/{planet}/sondas/{name}], methods=[POST]

### Exclui um planeta
[/planets/{name}], methods=[DELETE]

### Enviar instrucoes
[/sondas/{name}/instructions],methods=[POST]

#### Playload de retorno
{
  "content": {
    "name": "sonda1",
    "currentPosition": {
      "direction": "NORTH",
      "coordinate": {
        "x": 1,
        "y": 3
      }
    }
  }
}

