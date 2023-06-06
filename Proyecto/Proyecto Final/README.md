# Proyecto Final

## 📱🍕 Intents y Bases de Datos

**Equipo:**

- Arroyo Martínez Erick Daniel
- Bonilla Reyes Dafne
- Hernández Montoya Ricardo

---

## 📲 Uso de Pizza Planet

- **Pantalla de Inicio:** Al iniciar la aplicación, la primera pantalla que se mostrará será la pantalla de inicio. En esta pantalla encontraremos 2 cosas: Un menú drawer y una action bar. Para acceder al menú drawer, es necesario deslizar de izquierda a derecha desde el lateral izquiero de la pantalla. Una vez hecho esto, tendremos un menú con una sola opción, que será `About Us`. Desafortunadamente, tras varios intentos y cambios en el código, no logramos hacer que la action bar y el menú drawer convivieran en la misma activiy, por lo que el menú drawer no reconoce los botones. Sin embargo, toda la implementación de este botón se dejó en el proyecto. Por otro lado, en el action bar encontraremos 4 opciones. Primero, tendremos 2 íconos que nos indican que podemos hacer dos cosas: Iniciar sesión o registrarse, y al final del action bar, indicado con un ícono de 3 puntos, tendremos un mini menú con las opciones de ver el menú de pizzas o leer las políticas de privacidad.

- **Inicio de Sesión:** Esta actividad le permite al usuario iniciar sesión en la aplicación. La actividad espera recibir dos cosas: *Correo Electrónico* y *Contraseña*. La actividad controla el formato de las entradas, es decir, antes de realizar la consulta a la base de datos, se verifica el formato del correo, de tal forma que los únicos dominios válidos son `@gmail.com` y `@ciencias.unam.mx`. Así como la longitud de la contraseña, tal que debe ser mayor a siete caracteres.
Por otro lado, la actividad presenta un botón *Registrate* que redirecciona a la actividad de `Registro`.  
  
- **Registro:** Esta actividad le permite a los usuarios crear una cuenta. Esta misma, le solicita al usuario tres cosas: el *Nombre de Usuario*, el *Correo Electrónico* y la *Contraseña*. Análogo a la actividad anterior **(Inicio Sesión)**, la lógica de la aplicación verifica la información ingresada en el correo y contraseña. Por último, contiene un botón *Iniciar Sesión* que redirecciona a la actividad anterior.
  
- **Menú:** El menú de Pizza Planet consta únicamente de 3 pizzas: Pizza Italiana, Pizza Salami y Pizza Vegetariana. Cada pizza contiene un spinner y un precio. El spinner nos ayuda a indicar la cantidad de pizzas de ese sabor en particular que queremos. Es importante mencionar que aquí el usuario juega un papel importante desde la perpectiva del modelo, ya que si no se inició sesión o se registro un usuario que está realizando esa orden, entonces no se puede continuar, esto para darle más realismo a la aplicación. Por otro lado, al ordenar se mostrará un toast que nos dice cuál será el total a pagar, y una vez hecho esto, pasaremos a la pantalla de confirmación. 
  
- **Confirmación:**

---

## ❓ Implementación

Para este proyecto usamos MVC, ...

En la pantalla de inicio tendremos un navigation view implementado en la `activity_menu_drawer`, que llama a la `MainActivityDrawer` en donde al seleccionar el botón de `About Us` se pretende se cargue la `activity_about_us`. Esta es toda la funcionalidad del menú drawer. Por otro lado, el action bar será implementado por un drawer en la `drawer` activity. En este layout tenemos varios items con íconos y texto que nos indican las acciones que podemos realizar. Este menú es cargado por la `ActionBarTest`, en donde se implementan los métodos que cargan a la action bar en la pantalla de inicio y que cargan según la acción, una respectiva pantalla.

Para la parte del menú tenemos al layout `activity_menu`, en este encontraremos toda la interfaz de las pizzas, imagenes, spinner, contenedores y text view. Esta activity llama a la `MainActivity` que a su vez carga a `Comanda`, en donde tendremos solo la implementación del botón para ordenar y el registro de los spinners que nos indicarán las cantidad total a pagar. `Comanda` además atrapa un usuario y en caso de no recibirlo, no procesa la orden.

Dado que la implementación de las actividades de `Iniciar Sesión` y `Registrarse` son bastante intuitivas, entonces haremos enfasis en la lógica. Por un lado, se implemento la clase *Usuario* de tal forma que esta permite modelar y representar el estado de los usuarios. 

Por otro lado, se creo la clase `AdminSQL` que extiende de *SQLiteOpenHelper*, esta clase nos permite crear la base de datos. Cómo se puede observar solo se implemento el método `onCreate()` puesto que no se requirió el método `onUpgrade()`.

Por último, se implemento la clase `ModeloUsuario` tal que esta clase nos permite conectarnos con la base de datos por medio de los objetos `SQLiteDatabase` y `AdminSQL`. Esta clase tiene implementados algunos método, entre ellos su contructor, tal que, este solo recibe el contexto de aplicación. Esto permite conectarse con la base de datos desde cualquier parte de la aplicación. A su vez, se implementaron los métodos necesarios para representar las operaciones básicas de una base de datos, es decir: **Crear**, **Leer**, **Actualizar** y **Eliminar** *(CRUD)*. Además se incluyen métodos adicionales como: `drop_from()` que limpia la tabla `Usuario` de la base de datos, esto es importante para hacer pruebas. Cabe mencionar que el código ya se encuentra documentado, por lo que para entender más a detaller la implementación, le recomendamos leerla.

**NOTA:** Cómo puede observar la conexión a la base de datos no se cierra después de cada operación. Pues dado que,
se puede establecer contacto con la base de datos desde cualquier punto de la aplicación, sí en un contexto se cerrara la conexión, entonces seguramente al intentar realizar una operación cualquiera `(CRUD)`, la misma arrojaría una excepción. 

Por tanto, dado el alcance del proyecto, se opto por eliminar la clausura de la conexión. Somos concientes de las implicaciones de esta decisión. Sin embargo, se consultó con los ayudantes, cuya opinión secundo nuestra implementación. 

La excepción que se arroja al cerrar la conexción es : 
`java.lang.IllegalStateException: Cannot perform this operation because the connection pool has been closed`.
