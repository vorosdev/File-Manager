import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path defaultFolderPath = Paths.get(""); // Ruta de archivo por defecto

        while (true) { // Bucle infinito para mostrar el menú de forma continua
            System.out.println("\n:: Menú:\n");
            System.out.println("\t[1] Guardar archivo (por defecto: archivo.txt)");
            System.out.println("\t[2] Generar archivo");
            System.out.println("\t[3] Revisar archivo");
            System.out.println("\t[4] Cambiar ruta de archivo");
            System.out.println("\t[5] Salir");
            System.out.print("\n[+] Seleccione una opción: ");

            int option = scanner.nextInt(); // Lee la opción seleccionada por el usuario

            switch (option) {
                case 1 -> guardarArchivo(defaultFolderPath);
                case 2 -> generarArchivo(defaultFolderPath);
                case 3 -> revisarArchivo(defaultFolderPath);
                case 4 -> defaultFolderPath = cambiarRuta(defaultFolderPath);
                case 5 -> {
                    System.out.println(":: ¡Hasta luego!");
                    System.exit(0); // Sale del programa
                }
                default -> System.out.println("[!] Opción inválida");
            }
        }
    }

    // Función para guardar un archivo
    private static void guardarArchivo(Path filePath) {
        if (filePath.toString().isEmpty()) {
            System.out.println("[!] No hay una ruta configurada");
            return;
        }

        String defaultFileName = "archivo.txt";
        Path defaultFilePath = filePath.resolve(defaultFileName); // Ruta completa del archivo

        File file = defaultFilePath.toFile(); // Convierte la ruta en un objeto File

        if (!file.exists()) { // Si el archivo no existe, intenta crearlo
            try {
                if (file.createNewFile()) {
                    System.out.println("[+] Archivo creado: " + defaultFilePath);
                } else {
                    System.out.println("[!] El archivo ya existe");
                }
            } catch (IOException e) {
                System.out.println("[x] Ocurrió un error");
                e.printStackTrace();
            }
        }

        if (file.exists() && file.isFile() && defaultFileName.toLowerCase().endsWith(".txt")) {
            try {
                System.out.println("[!] El archivo por defecto ya existe");
                System.out.print("[?] ¿Desea sobrescribirlo? (s/n): ");
                Scanner scanner = new Scanner(System.in);
                String reply = scanner.nextLine().trim().toLowerCase();

                if (reply.equals("s")) {
                    System.out.print("[+] Ingrese el contenido a guardar en el archivo: ");
                    String content = scanner.nextLine();

                    FileWriter writer = new FileWriter(file); // Abre un FileWriter para escribir en el archivo
                    writer.write(content); // Escribe el contenido en el archivo
                    writer.close(); // Cierra el FileWriter
                    System.out.println("[+] Archivo guardado con éxito");
                } else {
                    System.out.println("[+] No se realizó ninguna acción");
                }
            } catch (IOException e) {
                System.out.println("[x] Error al guardar el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("[!] El archivo no existe o no es un archivo .txt");
        }
    }

    // Función para generar un archivo
    private static void generarArchivo(Path filePath) {
        if (filePath.toString().isEmpty()) {
            System.out.println("[!] No hay una ruta configurada");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("[+] Ingrese el nombre del nuevo archivo (.txt): ");
        String newFilename = scanner.nextLine().trim();

        if (!newFilename.toLowerCase().endsWith(".txt")) {
            System.out.println("[!] El archivo debe tener extensión .txt");
            return;
        }

        Path newFilePath = filePath.resolve(newFilename); // Combinar la ruta con el nombre del archivo

        File newFile = newFilePath.toFile();
        String decorators = "----------------------------------------------------------------";

        if (newFile.exists()) {
            System.out.println("[!] Ya existe un archivo con el mismo nombre: " + newFilePath);
        } else {
            try {
                FileWriter writer = new FileWriter(newFilePath.toFile());
                writer.write(decorators + "\nEste es un archivo de prueba generado utilizando File Manager\n\t\t\t\t\t Por vorosdev\n" + decorators);
                writer.close();
                System.out.println("[+] Archivo generado con éxito en la ruta: " + newFilePath);
            } catch (IOException e) {
                System.out.println("[x] Error al guardar el archivo");
                e.printStackTrace();
            }
        }
    }

    // Función para revisar un archivo en un directorio
    private static void revisarArchivo(Path directoryPath) {
        if (directoryPath.toString().isEmpty()) {
            System.out.println("[!] No hay una ruta configurada");
            return;
        }

        File directory = directoryPath.toFile();

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("[!] Este directorio no es válido");
            return;
        }

        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory == null || filesInDirectory.length == 0) {
            System.out.println("[!] Este directorio está vacío.");
            return;
        }

        System.out.println("\n:: Archivos: ");
        for (int i = 0; i < filesInDirectory.length; i++) {
            System.out.println("\t[" + (i + 1) + "] " + filesInDirectory[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n[?] ¿Cuál es el archivo para revisar?: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > filesInDirectory.length) {
            System.out.println("[!] Opción inválida");
            return;
        }

        File selectedFile = filesInDirectory[choice - 1];

        try {
            Scanner line = new Scanner(selectedFile);
            System.out.println("\n :: Contenido del archivo " + selectedFile.getName() + ":");
            while (line.hasNextLine()) {
                String data = line.nextLine();
                System.out.println(data);
            }
            line.close();
        } catch (IOException e) {
            System.out.println("[x] Se ha producido un error al revisar el archivo");
            e.printStackTrace();
        }
    }

    // Función para cambiar la ruta predeterminada
    private static Path cambiarRuta(Path defaultPath) {
        System.out.println("\n:: Rutas existentes: \n");
        System.out.println("\t[1] $HOME/Carpeta-1/");
        System.out.println("\t[2] $HOME/Carpeta-2/");
        System.out.print("\n[?] ¿Qué ruta desea utilizar? (1/2): ");

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();

        String subfolderPath = "";

        switch (select) {
            case 1 -> subfolderPath = "Carpeta-1";
            case 2 -> subfolderPath = "Carpeta-2";
            default -> {
                System.out.println("[!] Opción inválida");
                return defaultPath;
            }
        }

        Path newFolderPath = Paths.get(System.getProperty("user.home"), subfolderPath);

        try {
            Files.createDirectories(newFolderPath);
            System.out.println("[+] Cambiando la ruta por defecto a: " + newFolderPath.toAbsolutePath());
            return newFolderPath;
        } catch (IOException e) {
            System.out.println("[x] Error al cambiar la ruta");
            e.printStackTrace();
            return defaultPath;
        }
    }
}
