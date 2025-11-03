# Prueba Cysnet Aimar Huici
Este proyecto es una landing page sobre una empresa que se dedica a la venta de cursos, CiberCursos.

La landing
page tiene un header con las diferentes páginas, dos secciones informativas (cards) con la explicación de lo que ofrece la empresa,
un formulario para inscribirse con un model que enseña si se ha inscrito correctamente o ha habido algún error y un footer con
Información variada. También tiene otra página en la cual desde Firebase se obtienen los cursos disponibles y
los enseña de forma dinámica en unas cards.

## ⚙️ Configuración del proyecto
Para que el proyecto se ejecute y se pueda conectar a la base de datos, es necesario incluir estos dos
archivos en el proyecto.

## application.properties
Este archivo se encarga de definir algunos aspectos importantes del proyecto, como el nombre, puerto...
Tu application.properties debería contener al menos este contenido:

    #Nombre aplicación
    spring.application.name=xxxxxx
    
    #Configuración web
    server.port=80
    server.address=0.0.0.0

    #Conexión Firebase
    firebase.credentials.path=classpath:serviceAccountKey.json
    firebase.database.url=https://xxxx.firebaseio.com (Aquí iría tu base de datos de Firebase)

## serviceAccountKey.json
Este archivo se encarga de pasarle tus credenciales a Firebase, sin este archivo no podrás.
conectarte a Firebase.
Este archivo debería verse algo así:

    {
        "type": "service_account",
        "project_id": "xxxx",
        "private_key_id": "xxxx",
        "private_key": "-----BEGIN PRIVATE KEY-----\n xxxx \n-----END PRIVATE KEY-----\n",
        "client_email": "xxxx",
        "client_id": "xxxx",
        "auth_uri": "https://accounts.google.com/o/oauth2/auth",
        "token_uri": "https://oauth2.googleapis.com/token",
        "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
        "client_x509_cert_url": "xxxx",
        "universe_domain": "googleapis.com"
}

## Cómo ejecutarlo
1. Metemos estos dos archivos en la carpeta \resources.
2. Vamos a la clase CysnetApplication y la ejecutamos. El proyecto se ejecutará correctamente y estará conectado a la base de datos,
   aunque hay que tener en cuenta que la base de datos estará vacía. Para poder agregar cursos es necesario
   hacer peticiones POST a la API REST en el endpoint /cursos y pasar el objeto curso en formato JSON. Es importante
   recalcar que, al ser una función destinada a administradores y no a usuarios normales, es necesario pasar
   la contraseña correcta por parámetro.
3. Verificaremos por consola que todo funciona correctamente y no ha habido ningún error
4. Entramos en nuestro navegador y accederemos a uno de los dos siguientes enlaces:

   127.0.0.1:xx (xx hay que cambiarlo por el puerto que hayamos puesto en application.properties, en mi caso el 80)
   localhost:xx (De nuevo cambiamos el xx por nuestro puerto, en mi caso el 80)

## Tecnologías utilizadas
Este proyecto utiliza una gran variedad de tecnologías, desde Java a Bootstrap, que abarcan tanto el backend
como el frontend. A continuación, se detallan las principales herramientas y su función dentro del desarrollo:

- Java: Lenguaje principal en el que está programado el proyecto.
- Spring Boot: Framework que permite crear y desplegar fácilmente una API REST robusta y escalable.
- Thymeleaf: Tecnología para poder unir de forma sencilla el backend con el frontend.
- Firebase: Base de datos en la nube, sencilla de implementar y perfectamente compatible con Spring Boot.
- Bootstrap: Librería de CSS que permite diseñar interfaces responsive y modernas de forma rápida.
- JavaScript: Lenguaje empleado para agregar interactividad y dinamismo en el lado del cliente.
- HTML y CSS: Tecnologías base para el diseño de páginas web.
