# Proyecto Final

## 📱🍕 Intents y Bases de Datos

**Equipo:**

- Arroyo Martínez Erick Daniel
- Bonilla Reyes Dafne
- Hernández Montoya Ricardo

---

## 📲 Uso de Pizza Planet

- **Pantalla de Inicio:** Al iniciar la aplicación, la primera pantalla que se mostrará será la pantalla de inicio. En esta pantalla encontraremos 2 cosas: Un menú drawer y una action bar. Para acceder al menú drawer, es necesario deslizar de izquierda a derecha desde el lateral izquiero de la pantalla. Una vez hecho esto, tendremos un menpu con una sola opción, que será `About Us`. Desafortunadamente, tras varios intentos y cambios en el código, no logramos hacer que la action bar y el menú drawer convivieran en la misma activiy, por lo que el menú drawer no reconoce los botones. Sin embargo, toda la implementación de este botón se dejó en el proyecto. Por otro lado, en el action bar encontraremos 4 opciones. Primero, tendremos 2 íconos que nos indican que podemos hacer dos cosas: Iniciar sesión o registrarse, y al final del action bar, indicado con un ícono de 3 puntos, tendremos un mini menú con las opciones de ver el menú de pizzas o leer las políticas de privacidad.

- **Inicio de Sesión:**
  
- **Registro:**
  
- **Menú:** El menú de Pizza Planet consta únicamente de 3 pizzas: Pizza Italiana, Pizza Salami y Pizza Vegetariana. Cada pizza contiene un spinner y un precio. El spinner nos ayuda a indicar la cantidad de pizzas de ese sabor en particular que queremos. Es importante mencionar que aquí el usuario juega un papel importante desde la perpectiva del modelo, ya que si no se inició sesión o se registro un usuario que está realizando esa orden, entonces no se puede continuar, esto para darle más realismo a la aplicación. Por otro lado, al ordenar se mostrará un toast que nos dice cuál será el total a pagar, y una vez hecho esto, pasaremos a la pantalla de confirmación. 
  
- **Confirmación:**

---

## ❓ Implementación

Para este proyecto usamos MVC, ...

En la pantalla de inicio tendremos un navigation view implementado en la `activity_menu_drawer`, que llama a la `MainActivityDrawer` en donde al seleccionar el botón de `About Us` se pretende se cargue la `activity_about_us`. Esta es toda la funcionalidad del menú drawer. Por otro lado, el action bar será implementado por un drawer en la `drawer` activity. En este layout tenemos varios items con íconos y texto que nos indican las acciones que podemos realizar. Este menú es cargado por la `ActionBarTest`, en donde se implementan los métodos que cargan a la action bar en la pantalla de inicio y que cargan según la acción, una respectiva pantalla.

Para la parte del menú tenemos al layout `activity_menu`, en este encontraremos toda la interfaz de las pizzas, imagenes, spinner, contenedores y text view. Esta activity llama a la `MainActivity` que a su vez carga a `Comanda`, en donde tendremos solo la implementación del botón para ordenar y el registro de los spinners que nos indicarán las cantidad total a pagar. `Comanda` además atrapa un usuario y en caso de no recibirlo, no procesa la orden.
