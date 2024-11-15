### Desafio Backend : Luís Antônio 

Para o desafio foi utilizando as stack : Java 21 / Springboot 3.3 / Postgres/ Docker e Rabbit MQ

\*\*
**Para rodar a aplicação basta apenas utilizar o docker compose**

>  bash : 'docker-compose up ' 
> 
 ##### subir a aplicação na pasta do projeto
--- 
 
 Para o Projeto foi desenvolvido um sistema de votação
 onde é cadastrado a pauta e aberto a sessão.

 A sessão fica aberta durante um periodo pré estipulado ou default de 1 minuto
 ao finalizar a votação e enviado para o sistema de mensageria o resultado


 : para performace foi criado o cadastro de votos por fila 
`
POST
``` 
    /votos/votar-pauta 
    &
    /votos/votar-pauta-queue
```

: para integração e validar o associado a votacao da pauta o  endpoint 

GET 
```
/votos/check-eligibilidade-voto
```
 




*swagger* 
==
http://localhost:8080/swagger-ui/index.html
