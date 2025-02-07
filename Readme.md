# Guía: Desarrollo y Despliegue de una Aplicación Java Web con Servlets, Maven y Tomcat en Windows

Esta guía detalla los pasos para instalar y configurar Java, Maven y Tomcat, y para desarrollar y desplegar una aplicación web con Servlets en Windows.

## **1. Instalación de Requisitos Previos**

### **1.1 Instalar Java Development Kit (JDK)**
- Descarga la última versión del JDK desde [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (Yo te recomiendo la version 21, pero la 23 podría funcionar muy bien)
- Instala el JDK y configúra las variables de entorno:
  1. Abre el "Panel de Control" > "Sistema y Seguridad" > "Sistema" > "Configuración avanzada del sistema".
  2. Haz clic en "Variables de entorno".
  3. Agrega una nueva variable `JAVA_HOME` con la ruta del JDK (Ejemplo: `C:\Program Files\Java\jdk-21`).
  4. Asegúrate de agregar `%JAVA_HOME%\bin` a la variable `Path`.
  5. Verifica la instalacion ejecutando:
  ```sh
     java -version
    ```

### **1.2 Instalar Apache Maven**
- Descarga la última versión desde [Apache Maven](https://maven.apache.org/download.cgi).
- Extrae los archivos en `C:\apache-maven` y configura las variables de entorno:
  1. Crea una nueva variable `MAVEN_HOME` con el valor `C:\apache-maven`.
  2. Agrega `%MAVEN_HOME%\bin` a la variable `Path`.
  3. Verifica la instalación ejecutando:
     ```sh
     mvn -version
     ```

### **1.3 Instalar Apache Tomcat**
- Descarga [Apache Tomcat 10.x](https://tomcat.apache.org/download-10.cgi).
- Extrae los archivos en `C:\apache-tomcat`.
- Opcional: Configura la variable de entorno `CATALINA_HOME` con `C:\apache-tomcat`.

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
1. Copia `target/HolaMundoWeb.war` en `C:\apache-tomcat\webapps`.
2. Inicia Tomcat ejecutando `startup.bat` en `C:\apache-tomcat\bin`.
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
shutdown.bat
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

Con esta guía, puedes desarrollar y desplegar aplicaciones Java Web con Servlets en Apache Tomcat. 🚀

Te dejo el siguiente Video donde Hago este mismo proceso por si tienes alguna duda:

