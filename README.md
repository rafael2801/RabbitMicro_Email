# Email Microservice

Este projeto é um exemplo de um microserviço de email, desenvolvido para enviar emails de boas-vindas sempre que um novo usuário é criado. O microserviço não expõe nenhuma rota e utiliza **RabbitMQ** para consumir mensagens que indicam a criação de novos usuários.

## Funcionalidade

- **Envio de Email de Boas-Vindas**: Assim que um novo usuário é criado e uma mensagem é publicada no RabbitMQ, o microserviço consome essa mensagem e envia automaticamente um email de boas-vindas ao usuário.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento do microserviço.
- **Spring Boot**: Framework que simplifica o desenvolvimento de aplicações Java, especialmente microserviços.
- **RabbitMQ**: Sistema de mensagens utilizado para comunicação entre serviços.
- **JavaMailSender**: Utilizado para o envio de emails.

## Estrutura do Projeto

- **/src**: Contém o código-fonte do microserviço.
  - **/service**: Contém a lógica para o envio de emails.
  - **/config**: Contém as configurações do RabbitMQ e do serviço de email.
  - **/consumer**: Contém os consumidores que processam as mensagens recebidas do RabbitMQ.

## Pré-requisitos

- **Java 17** ou superior
- **Maven** para gerenciar dependências e build
- **RabbitMQ** instalado e configurado
- **Serviço de Email SMTP** (Gmail, SendGrid, etc.)

## Configuração

1. Clone o repositório:

    ```bash
    git clone https://github.com/rafael2801/RabbitMicro_Email.git
    cd RabbitMicro_Email
    ```

2. Configure as propriedades do RabbitMQ e do serviço de email no arquivo `application.properties` ou `application.yml`:

    ```yaml
    spring.application.name=email
    server.port=8082
    spring.datasource.url=jdbc:mysql://localhost:3306/emaildb
    spring.datasource.username=root
    spring.datasource.password=senha
    spring.rabbitmq.addresses=address
    broker.queue.email.name=default.email
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=seu-email@gmail.com
    spring.mail.password=sua-senha
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    ```

3. Execute o projeto:

    ```bash
    mvn spring-boot:run
    ```

## Funcionamento

O microserviço funciona ouvindo uma fila do RabbitMQ para mensagens que indicam a criação de novos usuários. Quando uma mensagem é recebida, o microserviço:

1. Processa a mensagem para obter as informações do usuário.
2. Gera e envia um email de boas-vindas para o endereço de email do novo usuário.

