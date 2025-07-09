# Etapa 1: Build do projeto com Maven Wrapper
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

RUN apt-get update && apt-get install -y dos2unix

COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .
COPY src/ ./src/

RUN dos2unix mvnw && chmod +x mvnw && ./mvnw -DskipTests clean package

# Etapa 2: Executa o .jar gerado
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=builder /app/target/dslist-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]