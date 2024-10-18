import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private List<gameObjects> inventory;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.inventory = new ArrayList<gameObjects>();
    }

    public void takeDamage(int damage) {
        this.score -= damage;
        System.out.println(name + " Recibiste " + damage + " Daño, Tu vida es " + this.score);
    }
    public void coleccion (gameObjects objects){
        inventory.add(objects);
        System.out.println("has encontrado " + objects.getName());
    }
    public boolean puntos (){
        return score > 0;
    }
    public void showStatus (){
        System.out.println("tienes " + score + " puntos");
    }

}
