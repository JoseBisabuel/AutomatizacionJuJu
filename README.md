
Readme:

El proyecto esta montado sobre Selenium, Java, Cucumber y Maven, por lo que para el correcto funcionamiento, deben estar configuradas las variables de entorno de Maven y Java.

Los datos mas relevantes los encontrara en las siguientes rutas:
C:\Users\Public\AutomatizacionJuJu\src\test\java
Aqua encontrara la carpeta Funtions que contiene las clases de la configuracian del CreateDriver - SeleniumFunctions - WebDriverFactory
La Carpeta Sofware que contiene los drivers de cada navegador
La carpeta StepDefinitions que contiene las clases hooks - StepDefinictions - TestRunner

En:
C:\Users\Public\AutomatizacionJuJu\src\test\resources
La carpeta Data.Screenshots que guarda el Step Tomar Captura de Pantalla
La carpeta Documento que guarda el documento csv
La carpeta Feature que contienen los scenarios .feature
La carpeta Foto que contiene la foto que se va a cargar en uno de los scenarios
La carpeta Pages que contiene los documentos .json
Y el documento test.properties que contiene los parametros y configuraciones reutilizables en el proyecto

Importante:
en la ruta C:\Users\Public\AutomatizacionJuJu\src\test\java\Software\windows debe guardarse el driver de cada uno de los navegadores, dependiendo de la version que tenga cada uno

en el documento test.properties dependiendo de donde guarden y abran el proyecto, deben configurarse las rutas de:
browser= el nombre del navegador que van a utilizar
os= el sistema operativo
FileUpload= donde se guarda el documento a cargar
FileUploadFoto= donde se guarda la foto a cargar
download.directory= (esta es la direccion de la carpeta donde se hacen las descargas automaticas)
download.fileName= el nombre con la extension de la descarga de la imagen

Dentro de cada scenario hay un step llamado Tomar captura de pantalla, este se puede poner donde quiera generar y guardar en el local una imagen para los reportes y/o documentacion.

Hay tambien un step llamado Adjunto captura de pantalla, este paso se puede poner donde quiera que se genere una imagen que va a ser visible en el reporte que se genera con Allure.

En el testrunner ya esta la configuracion para que ejecute todos los scenarios, para ejecutarlo, desde la consola de Intellij ejecute los siguientes comandos en este orden
 mvn clean
 mvn compile
 mvn test
Al terminar de ejecutar las pruebas se generara automaticamente el reporte.

El step llamado espere x segundos lo uso muchas veces porque mi pc es un poco lento y eso me permite darle espera para que cargue bien la pagina, si quieren pueden comentarlo, aunque aan con esos segundos la prueba se genera en muy corto tiempo, 4 minutos aproximadamente.

Adjunto un video con la prueba realizada por mi parte y la visualizacion del reporte generado con Allure.
