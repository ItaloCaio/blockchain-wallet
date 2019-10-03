Processo Seletivo Stefanini - Java Jr

--

#### Tecnologias Utilizadas
- Java - 1.8
- Spring Boot - 1.5.3.RELEASE
- Hibernate
- MySQL - 5.7.24
- AngularJs
- Maven 3.6.2

## Manual de Instala��o
Pre-requisitos:
- JVM
- MySQL
- Maven
- A porta 8080 deve est� dispon�vel

## Em ambiente de produ��o (Necess�rio uma IDEcomo Intellij):

- No arquivo  application.properties ( em java-jr-dasafio/src/main/resources/application.properties) configurar o mysql com o usuario e password do corretos.

- Exemplo:
spring.datasource.username=root
spring.datasource.password=root

- Feito isto, basta executar ApplicationStart.java ( em java-jrdasafio/src/main/java/app/ApplicationStart.java)
- Com o ambiente em execu��o, basta abrir o navegador em http://localhost:8080

## Execu��o fora do ambiente de produ��o:

- No arquivo application.properties ( em java-jr-dasafio/src/main/resources/application.properties) configurar o mysql com o usuario e password do corretos.

- Exemplo:
spring.datasource.username=root
spring.datasource.password=root

- Abrir o CMD (Windows) na pasta do projeto
- Dentro da pasta do projeto (java-jr-dasafio), executar o comando: mvn install -DskipTests
- Ap�s isto, entrar na pasta target (cd target) e executar o comando: java -jar demo-1.0.jar
- Com o ambiente em execu��o, basta abrir o navegador em http://localhost:8080

