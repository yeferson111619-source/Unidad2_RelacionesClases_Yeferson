Proyecto: Sistema de Contenidos Audiovisuales

Materia: Programación Orientada a Objetos (POO) — Unidad 2
Autor: Yeferson Parra
Fecha: Octubre 2025

Descripción del Proyecto

Este proyecto implementa un sistema de gestión de contenidos audiovisuales en Java, aplicando los principios de la Programación Orientada a Objetos (POO).
Permite crear, relacionar y manipular diferentes tipos de contenidos como Películas, Series, Documentales, Cortometrajes y Videos de YouTube, con sus respectivos atributos y relaciones.

El propósito es comprender e implementar los conceptos de herencia, asociación, agregación y composición, así como la reutilización de código mediante clases base y subclases.

Objetivos

Aplicar los principios fundamentales de la POO en Java.

Utilizar relaciones entre clases: asociación, agregación y composición.

Desarrollar un sistema que permita manejar diferentes tipos de contenidos audiovisuales.

Incorporar nuevas clases y subclases a partir de una base existente.

Practicar la organización modular de un proyecto en Eclipse.

Clases Incluidas
Clases Base

ContenidoAudiovisual: clase principal con atributos título, año y género.

Subclases Originales

Película

SerieDeTV

Documental

Nuevas Clases Agregadas

Actor → Relacionada con Película (agregación)

Temporada → Relacionada con SerieDeTV (composición)

Investigador → Relacionada con Documental (asociación)

Nuevas Subclases de ContenidoAudiovisual

Cortometraje → con atributos duracionMin y festival

VideoYouTube → con atributos canal, url y likes

Relaciones entre Clases
Tipo de Relación	Descripción	Ejemplo
Agregación	Una película puede tener varios actores, pero los actores existen por sí mismos.	Película — Actor
Composición	Una serie contiene temporadas que no existen sin la serie.	SerieDeTV — Temporada
Asociación	Un documental puede tener un investigador asignado.	Documental — Investigador
Herencia	Las subclases heredan de ContenidoAudiovisual.	Película, SerieDeTV, Documental, Cortometraje, VideoYouTube
Ejecución y Pruebas
Clase principal

El programa se ejecuta desde la clase:

MainPruebas.java

Salida esperada

Cuando se ejecuta correctamente, la consola muestra información como:

Película: Inception (2010) - Sci-Fi | Elenco: [Leonardo DiCaprio (EEUU), Joseph Gordon-Levitt (EEUU)]
Serie: Dark (2017) - Misterio | Temporadas: 2 | Episodios: 3
Documental: Planeta Azul (2001) - Naturaleza | Investigador: Dr. Cousteau - Oceanografía
Cortometraje: La Jetée (1962), Sci-Fi - 28 min, festival: Trieste
VideoYouTube: POO en 15 minutos (2024), Educación | canal: DevEnEspañol | likes: 2 | url: https://youtu.be/xxxxx

Instrucciones de Instalación y Uso

Clonar el repositorio desde GitHub:

git clone https://github.com/tuusuario/poo_unidad1.git


Abrir el proyecto en Eclipse:

File → Import → Existing Projects into Workspace → Seleccionar carpeta del proyecto.

Ejecutar el archivo:

src/edu.ups.u2/MainPruebas.java

Verifica la salida en la consola.

Estructura del Proyecto
poo_unidad1/
│
├── src/
│   └── edu/ups/u2/
│       ├── ContenidoAudiovisual.java
│       ├── Pelicula.java
│       ├── SerieDeTV.java
│       ├── Documental.java
│       ├── Actor.java
│       ├── Temporada.java
│       ├── Investigador.java
│       ├── Cortometraje.java
│       ├── VideoYouTube.java
│       └── MainPruebas.java
│
├── README.md
├── .project
├── .classpath

Mejoras Implementadas

Inclusión de clases nuevas con sus relaciones.

Sobrescritura del método info() en cada subclase para mostrar datos específicos.

Implementación de métodos para agregar actores, temporadas y likes.

Uso de listas genéricas (List<T>) para manejar colecciones dinámicas.

Proyecto probado y funcional en Eclipse.

Créditos

Proyecto desarrollado por Yeferson Parra, basado en el código base proporcionado por el profesor (Unidad 2 — Ejemplo 30).