# EVALUACIÓN FINAL MÓDULO 4: DESARROLLO DE LA INTERFAZ DE USUARIO ANDROID


## Guía del Proyecto: Aplicación de Libros

**Este documento proporciona una guía completa sobre la aplicación de Libros, desarrollada en Android. Aquí encontrarás una explicación paso a paso de su estructura, funcionamiento, y los conceptos de diseño aplicados.**

## 1. Funcionamiento de la Aplicación

**La aplicación es una plataforma sencilla para visualizar un catálogo de libros. El flujo de usuario principal es el siguiente:**

* **Pantalla de inicio:** Al abrir la aplicación, se muestra una pantalla de bienvenida, con un logo centrado y botón. Al presionar el botón "Ir", el usuario es dirigido a la lista de libros (3 CardViews).
* **Lista de Libros:** En esta pantalla, se presenta un listado de libros con su título, autor y una breve descripción. Cada elemento tiene un botón para ver más detalles.
* **Detalle del Libro:** Al seleccionar un libro, se abre una nueva pantalla con información ampliada, como la sinopsis completa y una imagen más grande.
* **Barra de Navegación:** La aplicación incluye una barra de navegación inferior que permite al usuario moverse fácilmente entre las vistas de "Inicio", "Libros" y "Créditos".

## 2. Capturas de Pantalla

<p float="left">
  <img src="scrapbook/vista_main.png" alt="Pantalla inicial" width="150"/>
  <img src="scrapbook/vista_listado_libros.png" alt="Listado con los 3 libros" width="150"/>
  <img src="scrapbook/vista_detalle_libro1.png" alt="Detalle libro 1" width="150"/>
  <img src="scrapbook/vista_detalle_libro2.png" alt="Detalle libro 2" width="150"/>
  <img src="scrapbook/vista_detalle_libro3.png" alt="Detalle libro 3" width="150"/>
  <img src="scrapbook/vista_creditos.png" alt="Credito con logo y dearrollador" width="150"/>
</p>

## 2. Conceptos de Diseño y Arquitectura

**El desarrollo de esta aplicación se basó en el principio de separar la lógica de la interfaz de usuario, garantizando un código limpio, modular y fácil de mantener.**

* **Arquitectura de Componentes:** La aplicación se divide en <span class="selected">Activities</span> y <span class="selected">Fragments</span>. La <span class="selected">MainActivity</span> actúa como un contenedor para los <span class="selected">Fragments</span>, cada uno responsable de una pantalla o vista específica.
* **Navegación Segura (Android Jetpack Navigation):** Se utilizó el componente **Navigation de Android Jetpack** para gestionar las transiciones entre pantallas. Esto asegura que la navegación sea segura y que los datos se pasen correctamente entre fragmentos (<span class="selected">BookListFragment</span> a <span class="selected">BookDetailFragment</span> utilizando el objeto <span class="selected">Book</span>).
* **View Binding:** Para interactuar con los elementos de la interfaz de usuario (<span class="selected">TextViews</span>, <span class="selected">ImageViews</span>, etc.), se usó  **View Binding**. Esto elimina la necesidad de **<span class="selected">findViewById</span>**, reduciendo la posibilidad de errores y haciendo el código más conciso.
* **Flujo de Navegación Personalizado:** Se implementó una lógica de navegación manual en la <span class="selected">MainActivity</span> para controlar la pila de navegación (<span class="selected">back stack</span>). Esto permite que los botones de la barra de navegación actúen como puntos de partida, asegurando que la aplicación no se "pierda" al cambiar entre vistas.

## 3. Guía de Ejecución del Proyecto

**Para ejecutar este proyecto en tu entorno de desarrollo, sigue estos 'quick steps':**

1. **Clonar el Repo:** Clona el proyecto en tu máquina local.
2. **Abrir en Android Studio:** Abre la carpeta del proyecto con Android Studio. El IDE detectará automáticamente la configuración de Gradle.
3. **Sincronizar Gradle:** Haz clic en el botón "Sync Now" si Android Studio te lo solicita. Esto descargará todas las dependencias necesarias.
4. **Ejecutar:** Conecta un dispositivo Android físico o inicia un emulador. Luego, haz clic en el botón "Run 'app'" (el ícono de la flecha verde) para desplegar la aplicación.

**Para ejecutar este proyecto en tu celular, sigue estos 'quick steps':**

1. **Copiar la APK:** Copia la aplicación (APK) en tu celular.
2. **Instalar:** Instala la aplicación, salta los avisos de advertencia, es normal si la aplicación no ha sido productivizada la plataforma de Android.
3. **Abrir la App:** Haz doble clic en el ícono "Books2".
4. **Recorrer las opciones:** Cliquea en las opciones y podrás acceder al listado, el detalle o los créditos, regresando a cualquier punto de la app.

## 4. Estructura del Proyecto

**A continuación, se detalla la estructura principal del proyecto, con una breve descripción de cada archivo o carpeta.**

* <span class="selected">app/src/main/java/com/evalfinal/books2/</span>: Contiene la lógica principal de la aplicación.
  * <span class="selected">MainActivity.java</span>: La actividad principal que gestiona el contenedor de fragmentos y la barra de navegación.
  * <span class="selected">SplashFragment.java</span>: Lógica de la pantalla de bienvenida.
  * <span class="selected">BookListFragment.java</span>: Lógica del listado de libros.
  * <span class="selected">BookDetailFragment.java</span>: Lógica de la vista de detalles de un libro.
  * <span class="selected">CreditsFragment.java</span>: Lógica de la vista de créditos.
  * <span class="selected">Book.java</span>: Clase de modelo que define un objeto Libro.
* <span class="selected">app/src/main/res/layout/</span>: Contiene los archivos XML para las interfaces de usuario.
  * <span class="selected">activity_main.xml</span>: El diseño de la actividad principal.
  * <span class="selected">fragment_splash.xml</span>: Diseño de la pantalla de inicio.
  * <span class="selected">fragment_book_list.xml</span>: Diseño de la lista de libros.
  * <span class="selected">fragment_book_detail.xml</span>: Diseño de la pantalla de detalles.
  * <span class="selected">fragment_credits.xml</span>: Diseño de la pantalla de créditos.
* <span class="selected">app/src/main/res/navigation/</span>: Contiene el gráfico de navegación.
  * <span class="selected">nav.xml</span>: Define las transiciones y los destinos de los fragmentos.
* <span class="selected">app/src/main/res/menu/</span>: Contiene el menú para la barra de navegación.
  * <span class="selected">menu_bottom_nav.xml</span>: Define los íconos y títulos de la barra de navegación inferior.
