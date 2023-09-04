
<div align="center">
  <h1>Diagnostic test </h1>
  

  <a href="https://www.oracle.com/java/technologies/javase/20-0-2-relnotes.html">
    <img src="https://img.shields.io/badge/java-information.svg?style=for-the-badge&logo=intellij-idea&color=f9e2af&logoColor=cdd6f4&labelColor=1e1e2e" />
  </a>
  <a href="#File-Manager">
    <img src="https://img.shields.io/github/repo-size/vorosdev/File-Manager?style=for-the-badge&logo=gitbook&color=f2cdcd&logoColor=cdd6f4&labelColor=1e1e2e" />
  </a>
</div>

  ---
  | Programs      | Using             |
  | ------------- | ----------------- |
  | OS            | arch linux        |
  | Editor        | IntelliJ IDEA     |
  | JDK           | JDK 20.0.2        |

#### Descarga:
```
git clone https://github.com/vorosdev/File-Manager.git
```

---
# FileManager

Este programa es una utilidad de línea de comandos escrita en Java que permite al usuario realizar varias operaciones relacionadas con archivos, como guardar, generar y revisar archivos en una ubicación predeterminada o cambiar esa ubicación predeterminada.

## Uso

Ejecute el programa y siga las instrucciones en el menú para realizar las siguientes operaciones:

- **Guardar archivo**: Le permite guardar un archivo en la ubicación predeterminada o cambiar el contenido de un archivo existente en esa ubicación.
- **Generar archivo**: Puede generar un nuevo archivo en la ubicación predeterminada con un nombre proporcionado por el usuario.
- **Revisar archivo**: Permite al usuario revisar el contenido de los archivos en la ubicación predeterminada y seleccionar uno para ver su contenido.
- **Cambiar ruta de archivo**: Puede cambiar la ubicación predeterminada para operaciones de archivo seleccionando una de dos rutas predefinidas.
- **Salir**: Termina el programa con un mensaje de despedida.

## Funciones

El programa consta de las siguientes funciones principales:

### `guardarArchivo(Path filePath)`

Esta función permite al usuario guardar un archivo en la ubicación predeterminada o cambiar el contenido de un archivo existente en esa ubicación.

### `generarArchivo(Path filePath)`

Permite al usuario generar un nuevo archivo en la ubicación predeterminada con un nombre proporcionado por el usuario.

### `revisarArchivo(Path directoryPath)`

Permite al usuario revisar el contenido de los archivos en la ubicación predeterminada y seleccionar uno para ver su contenido.

### `cambiarRuta(Path defaultPath)`

Permite al usuario cambiar la ubicación predeterminada para operaciones de archivo seleccionando una de dos rutas predefinidas.

## Ejecución

Para ejecutar el programa, compile el archivo Java y ejecute el programa resultante.

```
java FileManager
```
---
<p align="center">
  <a href="https://github.com/vorosdev/qtile/blob/main/LICENSE">
    <img src="https://img.shields.io/static/v1.svg?style=for-the-badge&label=License&message=GPL-3.0&colorA=1e1e2e&colorB=b4befe"/>
  </a>
</p>
