# Proyecto Pokémon - Taller 2

Sistema desarrollado en Java que simula una aventura Pokémon basada en captura, combate y progresión mediante gimnasios y Alto Mando.

---

# Descripción del Proyecto

El programa permite al jugador:

- Crear o cargar una partida.
- Explorar distintos hábitats para capturar Pokémon.
- Gestionar su equipo principal y almacenamiento PC.
- Retar gimnasios en orden progresivo.
- Combatir utilizando estadísticas y efectividad de tipos.
- Desafiar al Alto Mando.
- Guardar y cargar progreso mediante archivos.

El proyecto fue desarrollado utilizando Programación Orientada a Objetos, colecciones dinámicas (`ArrayList`) y persistencia de datos mediante archivos.

---

# Integrantes

## Sebastián Andres Gonzalez Rossi
- RUT: 21.186.016-2
- GitHub: Sutrostian

## Javier Ignacio Ossandon Calderon
- RUT: 21.979.689-2
- GitHub: javierossand / itsvoiiid

---

# Estructura del Proyecto

## Paquete Principal: `Default`

### Clases Principales

### `App`
Clase principal del programa.
- Maneja menús.
- Carga archivos.
- Guarda partidas.
- Controla el flujo general del juego.

### `Partida`
Representa la partida actual del jugador.
- Equipo Pokémon.
- Combates.
- Curación.
- Gestión del PC.
- Medallas.

### `Pokemon`
Representa un Pokémon individual.
- Estadísticas.
- Tipo.
- Estado.
- Probabilidad de aparición.

### `Habitat`
Representa una zona de exploración.
- Contiene Pokémon disponibles.
- Genera apariciones aleatorias.

### `Gimnasio`
Representa un gimnasio o miembro del Alto Mando.
- Líder.
- Equipo enemigo.
- Estado de derrota.

### `TablaTipos`
Implementa la tabla de efectividad Pokémon usando una matriz bidimensional (`double[][]`).

---

# Archivos Utilizados

## `Pokedex.txt`
Contiene todos los Pokémon del juego.

## `Habitats.txt`
Contiene los biomas disponibles.

## `Gimnasios.txt`
Contiene líderes y equipos de gimnasios.

## `Alto Mando.txt`
Contiene los miembros del Alto Mando.

## `Registros.txt`
Archivo de guardado de partida.

---

# Funcionalidades Implementadas

- Captura aleatoria con probabilidades.
- Combate con efectividad de tipos.
- Cambio de Pokémon durante combate.
- Estados "Vivo" y "Debilitado".
- Curación completa del equipo.
- Persistencia de datos.
- Validación de entradas.
- Restricción progresiva de gimnasios.
- Combates consecutivos en Alto Mando.

---

# Instrucciones de Ejecución

## Requisitos
- Java JDK 17 o superior.
- Eclipse IDE (recomendado).

## Ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/Sutrostian/Taller2_SebastianGonzalez_JavierOssandon.git
```

2. Abrir el proyecto en Eclipse.

3. Verificar que los archivos `.txt` estén en la raíz del proyecto:

- Pokedex.txt
- Habitats.txt
- Gimnasios.txt
- Alto Mando.txt
- Registros.txt

4. Ejecutar la clase:

```bash
App.java
```

---

# Conceptos Utilizados

- Programación Orientada a Objetos.
- Encapsulamiento.
- Constructores.
- Arreglos y ArrayList.
- Persistencia de archivos.
- Matrices bidimensionales.
- Validación de errores con try-catch.
- Relaciones entre clases.

---

# Estado del Proyecto

Versión actual:
## v0.7.0

Incluye:

- Sistema completo de combate.
- Corrección de errores de duplicación.
- Validaciones robustas.
- Sistema de guardado funcional.
- Gestión de equipo y PC.
