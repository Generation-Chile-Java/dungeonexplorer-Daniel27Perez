public class Gun implements gameObjects{
    private String name;

    public Gun(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
