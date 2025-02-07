# Guía: Desarrollo y Despliegue de una Aplicación Java Web con Servlets, Maven y Tomcat en macOS

Esta guía detalla los pasos para instalar y configurar Java, Maven y Tomcat, y para desarrollar y desplegar una aplicación web con Servlets en macOS.

## **1. Instalación de Requisitos Previos**

### **1.1 Instalar Java Development Kit (JDK)**
- Verifica si tienes Java instalado ejecutando en la terminal:
  ```sh
  java -version
  ```
- Si no tienes Java instalado, descárgalo desde [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) o [OpenJDK](https://jdk.java.net/).
- Instala el JDK y configúra las variables de entorno:
  ```sh
  export JAVA_HOME=$(/usr/libexec/java_home)
  export PATH=$JAVA_HOME/bin:$PATH
  ```
  Agrega estas líneas a tu archivo `~/.zshrc` o `~/.bash_profile` para que la configuración sea persistente.

### **1.2 Instalar Apache Maven**
- Instala Maven usando Homebrew:
  ```sh
  brew install maven
  ```
- Verifica la instalación:
  ```sh
  mvn -version
  ```

### **1.3 Instalar Apache Tomcat**
- Descarga la última versión estable desde [Apache Tomcat](https://tomcat.apache.org/download-10.cgi).
- Extrae el archivo descargado:
  ```sh
  tar -xzvf apache-tomcat-10.x.x.tar.gz
  ```
- Mueve la carpeta extraída a `/usr/local/`:
  ```sh
  sudo mv apache-tomcat-10.x.x /usr/local/tomcat
  ```
- Otorga permisos de ejecución a los scripts:
  ```sh
  cd /usr/local/tomcat/bin
  chmod +x *.sh
  ```

## **2. Crear un Proyecto Maven**
Ejecuta el siguiente comando para crear un nuevo proyecto web:
```sh
mvn archetype:generate -DgroupId=com.example -DartifactId=HolaMundoWeb \
    -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```
Esto creará la carpeta `HolaMundoWeb/` con la estructura básica de un proyecto web.

## **3. Configurar el Proyecto**
Abre el archivo `pom.xml` y añade la dependencia de Jakarta Servlets:
```xml
<dependencies>
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>5.0.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## **4. Crear un Servlet**
Crea una clase `HolaMundoServlet.java` en `src/main/java/com/example/` con el siguiente contenido:
```java
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hola")
public class HolaMundoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hola Mundo desde un Servlet!</h1>");
        out.println("</body></html>");
    }
}
```

## **5. Compilar y Empaquetar la Aplicación**
Ejecuta el siguiente comando dentro del directorio del proyecto:
```sh
mvn clean package
```
Esto generará un archivo `HolaMundoWeb.war` en la carpeta `target/`.

## **6. Desplegar en Apache Tomcat**
1. Copia `target/HolaMundoWeb.war` en `/usr/local/tomcat/webapps`:
   ```sh
   cp target/HolaMundoWeb.war /usr/local/tomcat/webapps/
   ```
2. Inicia Tomcat:
   ```sh
   cd /usr/local/tomcat/bin
   ./startup.sh
   ```
3. Accede a la aplicación en [http://localhost:8080/HolaMundoWeb/hola](http://localhost:8080/HolaMundoWeb/hola).

## **7. Agregar una Página JSP**
Crea un archivo `home.jsp` en `src/main/webapp/` con el siguiente contenido:
```jsp
<html>
<body>
    <h2>Bienvenido a la página de inicio!</h2>
</body>
</html>
```

Ahora puedes acceder a [http://localhost:8080/HolaMundoWeb/home.jsp](http://localhost:8080/HolaMundoWeb/home.jsp).

## **8. Crear un Servlet para /home**
Crea la clase `HomeServlet.java` en `src/main/java/com/example/`:
```java
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Bienvenido a la página de inicio!</h1>");
        out.println("</body></html>");
    }
}
```

Compila nuevamente con:
```sh
mvn clean package
```
Despliega la aplicación y accede a [http://localhost:8080/HolaMundoWeb/home](http://localhost:8080/HolaMundoWeb/home).

## **9. Detener Apache Tomcat**
Para detener Tomcat, ejecuta:
```sh
cd /usr/local/tomcat/bin
./shutdown.sh
```

## **Resumen**
1. Instalar JDK, Maven y Tomcat.
2. Crear un proyecto Maven con `maven-archetype-webapp`.
3. Agregar dependencias en `pom.xml`.
4. Crear y configurar un Servlet (`HolaMundoServlet`).
5. Compilar y generar el WAR con `mvn clean package`.
6. Desplegar en Tomcat y acceder a `/hola`.
7. Agregar un JSP (`home.jsp`).
8. Crear un segundo Servlet (`HomeServlet`) para `/home`.
9. Detener Tomcat cuando sea necesario.

Con esta guía, puedes desarrollar y desplegar aplicaciones Java Web con Servlets en Apache Tomcat en macOS. 🚀
