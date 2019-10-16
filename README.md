# Generador Datos Desafio

Este proyecto expone un API REST que entrega la siguiente información:

*id*: identificador obtenido de API REST Periodos
*fechaCreacion*: Fecha de inicio de la secuencia obtenida de API REST Periodos
*fechaFin*: Fecha de fin de la secuencia obtenida de API REST Periodos
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin” obtenidas de API REST Periodos
*fechasFaltantes*: Lista de rangos que considera los 1º de cada mes entre fechas de i e i+1 para cada i entre 0 y n - 1 elementos de lista *fechas*, por cada iteracion sólo se consideran los meses entre fechas i e i+1 ambos no inclusive.
Ejemplo.
```json
{
    "id": 1,
    "fechaCreacion": "1998-10-01",
    "fechaFin": "1999-08-01",
    "fechas": [
      "1998-11-01",
      "1999-03-01",
      "1999-07-01",
      "1999-08-01",],
    "fechasFaltantes": [
      "1998-12-01",
      "1999-01-01",
      "1999-02-01",
      "1999-04-01",
      "1999-05-01",
      "1999-06-01",
    ]
}
```
*Nota*:
El formato de las fechas es yyyy-MM-dd
El servicio entrega 1 periodos, el periodo contiene una fecha inicial una fecha final, una lista fechas, y una lista de fechas que se encuentra en el rango cada 2 fechas de la lista.

# Detalle de los sistemas

Swagger Codegen 2.3.1 (OpenApi 2.0)
Java 8
Spring-Boot 1.5.11.RELEASE
Maven 3

# Se requiere que la API Generador de datos GDD se este ejecutando en puerto 8050

Una versión del GDD se encuentra en este repositorio en GitHub: https://github.com/previred/Generador_Datos_Desafio_Uno

# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *ApiPeriodos* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar ./target/api-periodos-faltantes-1.0.0.jar
```
*Nota*:
Debe estar disponible el puerto *8060* en el PC donde se ejecute esta API

# Visualizar Documentación y consumir la API

La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://127.0.0.1:8060/periodosFaltantes/swagger-ui.html#!/

Para consumir el servicio se debe invocar la siguiente URL

```bash
curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8060/periodos/api'
```

# Regenerar API a partir de yaml

Las siguientes instrucciones solo son para re-escribir el API si es necesario agregar una nueva funcionalidad a partir del *YAML*.

Bajar SwaggerCodeGen 2.3.1 en la raíz del proyecto, ejecutando el siguiente comando por consola.

```bash
wget http://oss.sonatype.org/content/repositories/releases/io/swagger/swagger-codegen-cli/2.3.1/swagger-codegen-cli-2.3.1.jar -O swagger-codegen-cli.jar
```

Para re-crear el código a partir de la definición del *YAML* de swagger ejecutar el siguiente comando

API
```bash
java -jar ./swagger-codegen-cli-2.3.1.jar generate -i ./swagger/periodos-api.yaml -l spring -c ./swagger/config-api.json -o ApiPeriodos --ignore-file-override .\.swagger-codegen-ignore
```

Cliente (genera algunas definiciones y tests que pueden ser eliminados)
```bash
java -jar ./swagger-codegen-cli-2.3.1.jar generate -i ./swagger/periodos-client.yaml -l java -c ./swagger/config-client.json -o ApiPeriodos --ignore-file-override .\.swagger-codegen-ignore
```

*Nota*:
Esto creara toda la estructura de swagger y re-escribirá todas las clases que no estén declaradas en el archivo *.swagger-codegen-ignore*