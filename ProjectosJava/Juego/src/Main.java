import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingresa tu nombre de jugador ");
        String name = sc.nextLine();

        Player player = new Player(name, 100);

        Room[] rooms = {
                new Salas.emptyRoom(),
                new Salas.GunRoom(new Gun("Piatola")),
                new Salas.GunRoom.RivalRoom("Zombie", 10),
                new Salas.GunRoom(new Gun("cuchilla")),
                new Salas.GunRoom.RivalRoom("Albert Wesker", 20),
                new Salas.GunRoom(new Gun("bazuka")),
                new Salas.GunRoom.RivalRoom("Tyrant T-103", 20),
                new Salas.GunRoom(new Gun("Lanzagranadas")),
                new Salas.GunRoom(new Gun("Minigun")),
                new Salas.GunRoom.RivalRoom("Nemesis", 20),
                new Salas.GunRoom(new Gun("AK47")),
                new Salas.GunRoom.RivalRoom("Alcina Dimitrescu", 30)
        };

        int roomIndex = 0;
        while (player.puntos() && roomIndex < rooms.length) {

            System.out.println("\n--- Turno " + (roomIndex + 1) + " ---");

            player.showStatus();

            System.out.println("Opciones de sala:");

            System.out.println("1. Sala 1"  + rooms[roomIndex].getClass().getSimpleName());

            if (roomIndex + 1 < rooms.length) {

                System.out.println("2. Sala 2"  + rooms[roomIndex + 1].getClass().getSimpleName());

            }

            System.out.print("Elige una sala (1 o 2): ");

            int choice = sc.nextInt();

            sc.nextLine(); // Limpiar el buffer

            if (choice == 1) {

                rooms[roomIndex].enter(player);

                roomIndex++;

            } else if (choice == 2 && roomIndex + 1 < rooms.length) {

                rooms[roomIndex + 1].enter(player);

                roomIndex += 2; // Avanza dos salas

            } else {

                System.out.println("Opción no válida. Elige nuevamente.");

            }

        }

        if (player.puntos()) {

            System.out.println("¡Has explorado todas las salas!, Obtuviste gemas del universo, llevalas con tus compañeros");

        } else {

            System.out.println("¡Has muerto! Fin del juego.");

        }

        sc.close();

    }
}