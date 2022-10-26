
# Poke Api Challenge
## Aplicacion Rest utilizando Springboot y metodos get, para la generacion de json con informacion acerca de POKEMONES

Poke Api es una aplicacion habilitada para dispositivos moviles y de escritorio. el desarrollo del backend se realizo con las siguientes tecnologias

## Requisitos de Entorno
se agregan las versiones para evitar  tener  cambios en los path durante la ejecucion del  backend, especialmente la versión de java.

- Postgress Sql v.14
- Java Development Kit (JDK). v18
- Maven Builder
- Springboot v 2.7.5
- Servidor de aplicaciones a su elección ej: (Apache Tomcat)

## Base de Datos
Respecto a la construccion de la base de datos nos hemos puesto un limite para no importar todos los Pokemon ya que se solicitaba solo 10 y no se vio acorde completar el llenado de los Pokemon. Se tiene actualmente almacenado 12 pokemones por temas de control.

### Nombre de la base de datos "pkapi"
### Tabla  Principal  es  pokemon

CREATE TABLE IF NOT EXISTS public.pokemon
(
    id integer NOT NULL,
    pokemon_altura character varying(15) COLLATE pg_catalog."default",
    pokemon_name character varying(50) COLLATE pg_catalog."default",
    pokemon_peso character varying(15) COLLATE pg_catalog."default",
    descripcion character(800) COLLATE pg_catalog."default",
    cod_categoria integer,
    logo text COLLATE pg_catalog."default",
    evolucion character(40) COLLATE pg_catalog."default",
    CONSTRAINT pokemon_pkey PRIMARY KEY (id),
    CONSTRAINT "fkCategoria" FOREIGN KEY (cod_categoria)
        REFERENCES public.categoria (id_cat) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
Se tenia agregado un campo de tipo text en logo, este es el campo utilizado para almacenar las URL, de las cuales se extrajo las imagenes de los pokemon. colocamos tipo texto porque la idea inicial fue cargar mis propias imágenes en base 64.

la clave Foranea de fkCategoria, sirve para declarar tener una relacion uno a varios ya que una misma categoria de pokemon puede tener algunos pokemones de la tabla pokemon
### Tabla Categoria
CREATE TABLE IF NOT EXISTS public.categoria
(
    id_cat integer NOT NULL,
    n_categoria character(80) COLLATE pg_catalog."default",
    CONSTRAINT "Categoria_pkey" PRIMARY KEY (id_cat)
)
esta tabla si se poblo con todas las posibilidades de categorias de pokemon existentes si luego se desea agregar mas pokemones en la tabla "pokemon"

### Tablas tipo y tipoPokemon
CREATE TABLE IF NOT EXISTS public."tipoPokemon"
(
    id integer NOT NULL,
    tipo_id integer NOT NULL,
    CONSTRAINT tipopokemon_pkey PRIMARY KEY (id, tipo_id),
    CONSTRAINT tipopokemon_id_fkey FOREIGN KEY (id)
        REFERENCES public.pokemon (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT tipopokemon_tipo_id_fkey FOREIGN KEY (tipo_id)
        REFERENCES public.tipo (tipo_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE IF NOT EXISTS public.tipo
(
    tipo_id integer NOT NULL,
    tipo character(50) COLLATE pg_catalog."default",
    CONSTRAINT tipos_pkey PRIMARY KEY (tipo_id)
)

Estas dos tablas se crearon para solventar la necesidad de que en los pokemon un pokemon puede tener varios tipos por ejemplo puede ser de tierra y veneno al mismo tiempo por el motivo de la existencia relacional de muchos a muchos se creo la tabla intermedia tipo para poder relacionar las Tablas pokemon y tipoPokemon
de este tipo de relacion se analizo y se podia dar en otras tablas si se desea incrementar por ejemplo los escudos, las debilidades, etc.

## Construcción del Backend
En este proceso se tomo como punto inicial los siguientes paquetes
#### Package com.api.pokemonx.model
En este paquete se indican todos los componentes relacionales entre la base de datos y las clases java para empezar a realizar la conexion
la conexión a la base de datos esta dada en el archivo
    aplication,properties
    spring.jpa.database=POSTGRESQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/pkapi
    spring.datasource.username=Program1
    spring.datasource.password=adanc1gy
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
#### Package com.api.pokemonx.repository

En los repositorios que son de tipo interfases es donde realizaremos el llamado a metodos ya heredados del repositorio o metodos en los cuales colocaremos insercion de @Query para la obtencion de Datos.
Por ejemplo:

> @Query(value="select * from pokemon p inner join categoria c ON c.id_cat = p.cod_categoria where p.pokemon_name ilike %:name%",

#### Package com.api.pokemonx.controller
En el controller realizamos el mapeo de la aplicacion y como se llamarian los métodos para ser llamados en el Frontend
Por Ejemplo:
>   @GetMapping("/buscarpokemon/{name}")
    public List<Pok> findByNamePoks(@PathVariable("name") String name) {
        return repository.findByname(name);
    }

en esta aplicacion solo tenemos Metodos de Tipo Get, pero no obstante Springboot tambien puede trabajar con los metodos Post  que serian parte de una actualización.

## Swagger
Esta herramienta se utilizo para la documentacion y verificacion del funcionamiento de los metodos. Con esta herramienta ademas de documentar dejariamos de lado la opcion de utilizar la herramienta Postman.
se ha dejado por temas de accesibilidad las mismas rutas por defecto para el ingreso
> http://localhost:8080/swagger-ui/index.html , se ha trabajado todo el proyecto en modo  local  por eso el uso  de la dirección "localhost"
 

## License

X@NDER06
**Free Software, Yeah!**

