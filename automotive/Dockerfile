# Etapa de construção
FROM maven:3.8.6-amazoncorretto-17 AS build
WORKDIR /usr/src/app
COPY . /usr/src/app

# Construa o projeto e gere o arquivo WAR
RUN mvn clean package -DskipTests

# Verificar se o arquivo WAR foi gerado
RUN ls -l /usr/src/app/target

# Etapa de execução
FROM eclipse-temurin:17-jdk
WORKDIR /usr/src/app

# Copiar o arquivo WAR
COPY --from=build /usr/src/app/target/fpa-0.0.1-SNAPSHOT.war app.war

# Copiar o arquivo OpenTelemetry Agent
COPY opentelemetry/opentelemetry-javaagent.jar /usr/src/app/opentelemetry-javaagent.jar

# Comandos de depuração
RUN ls -l /usr/src/app
RUN java -version

CMD ["java", "-javaagent:/usr/src/app/opentelemetry-javaagent.jar", "-jar", "app.war"]

# Expor a porta 8080
EXPOSE 8080