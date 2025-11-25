README.md — Unidad 4: Programación Limpia y Manejo de Contenido Audiovisual
🎯 Descripción del Proyecto

Este proyecto corresponde a la Unidad 4 – Programación Limpia, donde se desarrolla un sistema completo de gestión de Contenido Audiovisual, aplicando:

Manejo de archivos CSV

Código limpio y refactorización

Principios SOLID

Patrón MVC (Modelo–Vista–Controlador)

Pruebas unitarias con JUnit

Basado en las instrucciones de la actividad "Código Limpio a Contenido Audiovisual".

🧩 Estructura del Proyecto (Modelo)

El modelo contiene las clases principales del dominio:

ContenidoAudiovisual

Pelicula

SerieDeTV

Temporada

Documental

Investigador

Actor

Cortometraje

VideoYouTube

Cada clase sigue el Principio de Responsabilidad Única (SRP), como solicita la etapa SOLID.

📂 Manejo de Archivos (Etapa 1)

Se implementa lectura y escritura desde/hacia archivos CSV para:

Películas

Series de TV

Documentales

Actores

Temporadas

Investigadores

Incluye manejo de excepciones y validación de datos.

🔧 Refactorización y Código Limpio (Etapa 2)

Según lo indicado en el documento:

Se renombraron clases, métodos y variables para mayor claridad.

Se dividieron métodos largos en métodos pequeños.

Se eliminó código duplicado creando métodos reutilizables.

Se depuraron comentarios innecesarios.

🧱 Aplicación de Principios SOLID (Etapa 3)

Se aplicaron los 5 principios:

SRP: Cada clase tiene una única responsabilidad.

OCP: El sistema permite extender funcionalidades sin modificar las existentes.

LSP: Las subclases pueden reemplazar a la clase base sin romper el sistema.

ISP: Se separaron interfaces grandes en interfaces más específicas.

DIP: Se usan dependencias en abstracciones, no implementaciones concretas.

🧰 Implementación del Patrón MVC (Etapa 4)

El proyecto separa claramente:

✔ Modelo

Clases del dominio audiovisual.

✔ Vista

Menú interactivo por consola para mostrar contenido al usuario.

✔ Controlador

Maneja todas las operaciones que conectan la vista con los métodos del modelo y los repositorios CSV.

🧪 Pruebas Unitarias con JUnit (Etapa 5)

Corresponde a:

Crear la carpeta test/

Incluir pruebas para todas las clases principales

Probar casos normales y casos límite

Asegurar cobertura adecuada

📥 Cómo clonar el proyecto
git clone https://github.com/yeferson111619-source/Unidad2_RelacionesClases_Yeferson.git


Entra al proyecto:

cd Unidad2_RelacionesClases_Yeferson

▶️ Cómo ejecutar el proyecto

Abrir NetBeans / IntelliJ / VSCode.

Importar como proyecto Maven o Java normal.

Ejecutar la clase:

src/main/java/edu/ups/u2/MainPruebas.java

🧪 Cómo ejecutar las pruebas unitarias

Desde NetBeans:

Clic derecho → Test
o

Desde consola:

java -jar lib/junit-platform-console-standalone.jar --class-path bin/test --scan-class-path

📄 Diagrama UML

El diagrama de clases actualizado se encuentra en:

/diagramas/diagrama_clases.png

🔗 Enlace al repositorio

Incluye código, pruebas, diagramas y README:

👉 https://github.com/yeferson111619-source/Unidad2_RelacionesClases_Yeferson
