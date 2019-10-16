
## DESARROLLO

Descargar articulos desde https://hn.algolia.com/api/v1/search_by_date?query=nodejs&hitsPerPage=100 hacia base de datos y luego exponer api para desplegarlos

Para no complicar la ejecución, se decide dejar juntos los 2 procesos en un solo artefacto:
1.- proceso que extrae registros(cada x tiempo) de api externa y los almacena en base de datos
2.- servicio que consulta en base de datos registros previamente extraídos y pagina resultados

Nora: Se recomienda utilizar 2 artefactos separados, para:
1.- Que la caída de la extracción no afecte la disponibilidad de servicio y lo contrario
2.- Asignación de recursos de forma individual a cada proceso según carga 


Conexión a base de datos MySQL

Reemplazar los siguientes parámetros en archivo application.properties:

spring.datasource.url=jdbc:mysql://0.0.0.0:3306/algolia?useSSL=false
spring.datasource.username=algolia
spring.datasource.password=algolia

Crear un usuario "algolia" con password "algolia"

Crear base de datos algolia:
```
CREATE DATABASE algolia;
```
La estructura de la tabla es la siguiente:
```
CREATE TABLE `articulos` (
  `id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```


Maven 3.6.2
https://maven.apache.org/download.cgi

https://www-us.apache.org/dist/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.zip
```
4bb0e0bb1fb74f1b990ba9a6493cc6345873d9188fc7613df16ab0d5bd2017de5a3917af4502792f0bad1fcc95785dcc6660f7add53548e0ec4bfb30ce4b1da7  apache-maven-3.6.2-bin.zip
```

Paso 1: Generar los fuentes para el cliente que se comunicará con la api externa
```
java -jar ./swagger-codegen-cli-2.3.1.jar generate -i ./swagger/consumo-client.yaml -l java -c ./swagger/consumo-conf.json -o art-client --ignore-file-override .\.swagger-codegen-ignore
```

Paso 2: Generar los fuentes de api que expone registros 
```
java -jar ./swagger-codegen-cli-2.3.1.jar generate -i ./swagger/expo-api.yaml -l spring -c ./swagger/expo-conf.json -o art-api --ignore-file-override .\.swagger-codegen-ignore
```

Paso 3: En el POM de la api generada en paso 2 le agrego una dependencia hacia el cliente generado en paso 1

Paso 4: Si es necesario realizar algun cambio en la configuracion de "art-api", se debe volver a compilar y generar artefacto de "art-client" y luego "art-api" en ambos casos con:

```
mvn clean install package
```

## PRUEBA

Para probar, es necesario tener configurada la base de datos y ejecutar java -jar junto a la ubicacion del jar "api-algolia-1.0.0.jar"
```
java -jar .Algolia/art-api/target/api-algolia-1.0.0.jar
```

Una vez en ejecucion por consola se verá algo similar a esto:
```
2019-10-16 12:36:20.818  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 100
2019-10-16 12:36:20.834  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : vially
2019-10-16 12:36:20.834  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21271381
2019-10-16 12:36:20.863  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : joncrane
2019-10-16 12:36:20.863  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21270186
2019-10-16 12:36:20.899  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : codeforgeek
2019-10-16 12:36:20.899  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21270118
2019-10-16 12:36:21.005  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : gumby
2019-10-16 12:36:21.005  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21269408
2019-10-16 12:36:21.059  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : praveenscience
2019-10-16 12:36:21.059  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21268700
2019-10-16 12:36:21.086  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : WA
2019-10-16 12:36:21.086  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21268035
2019-10-16 12:36:21.112  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : input_sh
2019-10-16 12:36:21.112  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21267949
2019-10-16 12:36:21.144  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : robert_foss
2019-10-16 12:36:21.144  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21267906
2019-10-16 12:36:21.173  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : kriro
2019-10-16 12:36:21.173  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21267716
2019-10-16 12:36:21.204  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : Aeolun
2019-10-16 12:36:21.204  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21266870
2019-10-16 12:36:21.238  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : bureaucrat
2019-10-16 12:36:21.238  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21266474
2019-10-16 12:36:21.289  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : codesushi42
2019-10-16 12:36:21.289  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21266095
2019-10-16 12:36:21.320  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : LMYahooTFY
2019-10-16 12:36:21.320  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21265785
2019-10-16 12:36:21.343  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : schoen
2019-10-16 12:36:21.343  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21264896
2019-10-16 12:36:21.371  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : schoen
2019-10-16 12:36:21.371  INFO 48532 --- [pool-2-thread-1] c.i.a.algolia.swagger.scheduling.Tasks   : 21264744
```

Para consumir la api que despliega los registros obtenidos, se debe ejecutar lo siguiente: 

```
curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8010/api/v1/articulos?query=test&page=0'
```
```
{
  "articulos": [
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21271381,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21270186,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21270118,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21269408,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21268700,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21268035,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21267949,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21267906,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21267716,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21266870,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21266474,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21266095,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21265785,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21264896,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21264744,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21264699,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21260769,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21253355,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21251002,
      "comment_text": null
    },
    {
      "created_at": null,
      "title": null,
      "url": null,
      "author": null,
      "points": null,
      "objectID": 21245529,
      "comment_text": null
    }
  ],
  "hitsPerPage": null,
  "nbHits": null,
  "nbPages": null,
  "page": null,
  "params": null,
  "processingTimeMS": null,
  "query": "test"
}
```
