# Etapa de construcción (Build stage)
FROM maven:3.8.7-eclipse-temurin-17 AS builder

# Metadatos de la imagen
LABEL version="1.0"
LABEL project="spring-boot-funcionalidades-extra"
LABEL maintainer="dtorrescb@alumnos.unex.es"
LABEL description="Imagen de Docker para la aplicación Spring Boot Funcionalidades Extra"
LABEL date="14/12/2024"

# Definir el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos de configuración y el código fuente
COPY pom.xml ./
COPY src ./src

# Empaquetar la aplicación sin ejecutar las pruebas
RUN mvn clean package -DskipTests

# Etapa de ejecución (Run stage)
FROM openjdk:17-jdk-slim

# Configurar las variables de entorno para la JVM (Java Virtual Machine)
# Establecer el tamaño inicial y máximo de la memoria
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Definir el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado en la etapa de construcción
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto 8080 para acceder a la aplicación
EXPOSE 8080

# Establecer el comando de entrada (ENTRYPOINT) para ejecutar la aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]