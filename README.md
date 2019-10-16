Maven 3.6.2
https://maven.apache.org/download.cgi

https://www-us.apache.org/dist/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.zip

4bb0e0bb1fb74f1b990ba9a6493cc6345873d9188fc7613df16ab0d5bd2017de5a3917af4502792f0bad1fcc95785dcc6660f7add53548e0ec4bfb30ce4b1da7  apache-maven-3.6.2-bin.zip

Paso 1: Generar los fuentes para el cliente que se comunicara con la api externa
java -jar ./swagger-codegen-cli-2.3.1.jar generate -i ./swagger/consumo-client.yaml -l java -c ./swagger/consumo-conf.json -o art-client --ignore-file-override .\.swagger-codegen-ignore

Paso 2: Generar los fuentes de api que expone registros 

java -jar ./swagger-codegen-cli-2.3.1.jar generate -i ./swagger/expo-api.yaml -l spring -c ./swagger/expo-conf.json -o art-api --ignore-file-override .\.swagger-codegen-ignore

Paso 3: En el POM de la api generada en paso 2 le agrego una dependencia hacia el cliente generado en paso 1



Para no complicar la ejecución, se decide dejar juntos los 2 procesos en un solo artefacto:
1.- proceso que extrae registros(cada x tiempo) de api externa y los almacena en base de datos
2.- servicio que consulta en base de datos registros previamente extraídos y pagina resultados

Nora: Se recomienda utilizar 2 artefactos separados, para:
1.- Que la caída de la extracción no afecte la disponibilidad de servicio y lo contrario
2.- Asignación de recursos de forma individual a cada proceso según carga 


Para ejecutar, solo basta con ejecutar lo siguiente:

java -jar .backend-gen/art-api/target/api-algolia-1.0.0.jar


Conexión a base de datos MySQL

Reemplazar los siguientes parámetros en archivo application.properties:

spring.datasource.url=jdbc:mysql://0.0.0.0:3306/algolia?useSSL=false
spring.datasource.username=algolia
spring.datasource.password=algolia

La estructura de la tabla es la siguiente:

CREATE TABLE `articulos` (
  `id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;












