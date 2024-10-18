public class Salas {
    public static class emptyRoom implements Room {
        @Override
        public void enter (Player player) {
            System.out.println();
        }
    }
    public static class GunRoom implements Room {
        private gameObjects gun;

        public GunRoom(gameObjects guns) {
            this.gun = guns;
        }

        @Override
        public void enter (Player player) {
            System.out.println("Encontraste un arma " + gun.getName());
            player.coleccion(gun);
        }
        public static class RivalRoom implements Room {
            private String enemigo;
            private int damage;

            public RivalRoom(String enemigo, int damage) {

                this.enemigo = enemigo;
                this.damage = damage;
            }
            @Override
            public void enter (Player player) {
                System.out.println("Encontraste a " + enemigo + " se enfrentan, pero te daño");
                player.takeDamage(damage);
            }
        }

        }
    }

