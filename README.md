 
<p align="center">
   <img width="234" height="123" alt="download" src="https://github.com/user-attachments/assets/04d96b25-bd41-4d4e-a8ff-9e2b56a56aa6" />
</p>

<h1 align="center">Universidad Nacional de Colombia</h1>
<h3 align="center">Sede Medellín — Ingeniería de Sistemas</h3>

---

# Actividad 4 — Programación Orientada a Objetos (POO) - Java

Repositorio creado para el desarrollo de la cuarta actividad de Programación Orientada a Objetos, basada en los ejercicios 6.4, 6.5, 6.6, 6.7 y 6.8 del libro *Ejercicios de programación orientada a objetos con Java y UML*, de Leonardo Bermón Angarita. Se aplican conceptos como clases, atributos, métodos, constructores, encapsulamiento, manejo de excepciones, validación de datos, interfaces gráficas y diagramas UML.

## 📂 Estructura del Repositorio

El proyecto se encuentra organizado en carpetas independientes para cada ejercicio:

* 📁 **`EJERCICIO1` — Manejo de excepciones**
  * **Descripción:** Aplicación con interfaz gráfica que demuestra el funcionamiento de las estructuras `try`, `catch` y `finally`, mediante situaciones que generan excepciones.
  * **Funcionalidades incluidas:** Manejo de excepciones aritméticas y acceso a referencias nulas, mostrando los mensajes correspondientes en la interfaz.
  * **Archivo principal:** `PruebaExcepcionesGUI.java`.

* 📁 **`EJERCICIO2` — Registro de vendedores**
  * **Descripción:** Aplicación con interfaz gráfica que permite registrar vendedores mediante su nombre, apellido y edad.
  * **Funcionalidades incluidas:** Validación de la edad del vendedor, control de entradas no numéricas y manejo de excepciones cuando los datos no cumplen las condiciones establecidas.
  * **Archivos principales:** `Vendedor.java` y `VendedorGUI.java`.

* 📁 **`EJERCICIO3` — Cálculos numéricos**
  * **Descripción:** Aplicación con interfaz gráfica que permite calcular el logaritmo natural y la raíz cuadrada de un número.
  * **Funcionalidades incluidas:** Validación de valores permitidos para cada operación, control de entradas no numéricas y manejo de excepciones.
  * **Archivos principales:** `CalculosNumericos.java` y `CalculosNumericosGUI.java`.

* 📁 **`EJERCICIO4` — Equipo de maratón de programación**
  * **Descripción:** Aplicación con interfaz gráfica para registrar equipos universitarios de maratón de programación y administrar sus integrantes.
  * **Funcionalidades incluidas:** Registro del nombre del equipo, universidad y lenguaje de programación; incorporación de dos a tres programadores; validación de nombres y apellidos, y control de la cantidad máxima de integrantes.
  * **Archivos principales:** `Programador.java`, `EquipoMaratonProgramacion.java` y `EquipoMaratonGUI.java`.

* 📁 **`EJERCICIO5` — Lectura de archivos**
  * **Descripción:** Aplicación con interfaz gráfica que permite seleccionar archivos de texto, leer su contenido y visualizarlo en pantalla.
  * **Funcionalidades incluidas:** Selección de archivos mediante un explorador, lectura del contenido, conversión del texto a mayúsculas y manejo de excepciones durante la lectura.
  * **Archivos principales:** `LeerArchivo.java` y `LeerArchivoGUI.java`.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java
* **Paradigma:** Programación Orientada a Objetos (POO)
* **Interfaces gráficas:** Java Swing
* **Bibliotecas:** Java AWT, Java I/O y Java Collections Framework
* **Entorno de desarrollo:** Visual Studio Code
* **Control de versiones y repositorios:** Git y GitHub

---

## 📚 Conceptos de POO Aplicados

* **Clases:** Representan vendedores, programadores, equipos y componentes encargados de realizar operaciones y leer archivos.
* **Atributos:** Almacenan información de los objetos, como nombres, apellidos, edades, datos de los equipos y contenido de archivos.
* **Métodos:** Implementan operaciones matemáticas, validaciones, registro de integrantes y lectura de archivos.
* **Constructores:** Inicializan los atributos de los objetos y permiten establecer sus condiciones iniciales.
* **Objetos:** Se crean instancias de las clases para representar vendedores, programadores y equipos.
* **Encapsulamiento:** Se utilizan modificadores de acceso para controlar la visibilidad de los atributos y métodos.
* **Métodos estáticos:** Se utilizan para realizar operaciones matemáticas y funcionalidades que no requieren instanciar objetos.
* **Manejo de excepciones:** Se implementan estructuras `try`, `catch` y `finally`, además de excepciones como `IllegalArgumentException`, `NumberFormatException`, `IOException`, `ArithmeticException` y `NullPointerException`.
* **Validación de datos:** Se comprueba que los valores ingresados cumplan las condiciones establecidas para cada ejercicio.
* **Colecciones:** Se utiliza `ArrayList` para almacenar y administrar los integrantes de un equipo.
* **Lectura de archivos:** Se emplean clases de Java I/O para acceder al contenido de archivos de texto.
* **Interfaces gráficas:** Se utiliza Swing para facilitar la interacción con el usuario.
* **Diagramas UML:** Se representan las clases, sus relaciones y los casos de uso de cada aplicación.

---

**Requisito:** tener instalado el JDK de Java y configurada la variable `PATH` para utilizar `javac` y `java` desde la terminal.

---

## 👨‍🏫 Docente

* Walter Hugo Arboleda Mazo — Ingeniería de Sistemas

## 👨‍💻 Autor

* **Estudiante:** Emanuel Cuervo Villegas — Ingeniería de Sistemas
