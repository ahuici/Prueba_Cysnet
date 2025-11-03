# Prueba Cysnet Aimar Huici
Este proyecto es una landing page sobre una empresa que se dedica a la venta de cursos, CiberCursos. La landing
page tiene un header con las diferentes paginas, dos cards con la explicacion de lo que ofrece la empresa,
un formulario para inscribirse y un footer con 
informacion variada. Tambien tiene otra pagina en la cual desde firebase se obtienen los cursos disponibles y 
los enseña de forma dinamica en unas cards.

Para que el proyecto se ejecute y se pueda conectar a la base de datos, es necesario incluir estos dos 
archivos en el proyecto.

## aplication.properties
Este archivo se encarga de definer algunos aspectos importantes del proyecto, como el nombre, puerto... 
Tu aplication.properties deberia contener al menos este contenido:

    #Nombre aplicacion
    spring.application.name=xxxxxx
    
    #Configuracion web
    server.port=80
    server.address=0.0.0.0

    #Conexión Firebase
    firebase.credentials.path=classpath:serviceAccountKey.json
    firebase.database.url=https://xxxx.firebaseio.com (Aqui iria tu base de datos de firebase)

## serviceAccountKey.json
Este archivo se encarga de pasarle tus credenciales a Firebase, sin este archivo no podras 
conectarte a Firebase.
Este archivo deberia verse algo asi:
    
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

## Como ejecutarlo
Una vez tengamos estos archivos en la carpeta \resources, no hay mas que ir a la clase CysnetApplication 
y ejecutarla. El proyecto se ejecutara correctamente y estara conectada a la base de datos,
aunque hay que tener en cuenta que la base de datos estara vacia. Para poder agregar cursos es necesario
hacer peticiones POST a la API REST en el endpoint /cursos y pasar el objeto curso en formato JSON. Es importante
recalcar que al ser una funcion destiada a administradores y no a usuarios normales, es necesario pasar 
la contraseña correcta por parametro. Al ejecutar la clase CysnetApplication, verificaremos por consola que todo funciona, iremos a nuestro navegador y 
accederemos a uno de los dos siguientes enlaces:

    127.0.0.1:xx (xx hay que cambiarlo por el puerto que hayamos puesto en application.properties, en mi caso el 80)
    localhost:xx (De nuevo cambiamos el xx por nuestro puerto, en mi caso el 80)

## Tecnologias utilizadas
Este proyecto utiliza una gran variedad de tecnologias, desde Java a Bootstrap, que abarcan tanto el backend
como el frontend. A continuación, se detallan las principales herramientas y su función dentro del desarrollo:

- Java: Lenguaje principal en el que esta programado el proyecto. 
- Spring boot: Framework que permite crear y desplegar fácilmente una API REST robusta y escalable.
- Thymleaf: Tecnologia para poder unir de forma sencilla el backend con el frontend.
- Firebase: Base de datos en la nube, sencilla de implementar y perfectamente compatible con Spring Boot.
- Bootstrap: Librería de CSS que permite diseñar interfaces responsive y modernas de forma rápida.
- Javascript: Lenguaje empleado para agregar interactividad y dinamismo en el lado del cliente.
- HTML y CSS: Tecnologias base para el diseño de paginas web.

