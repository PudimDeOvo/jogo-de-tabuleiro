package Player;

public abstract class Player {
    protected String color;
    protected int position;

    public Player(String color, int position){
        this.color = color;
        this.position = position;
    }

    public abstract int roll();

    public String getColor(){
        return this.color;
    }

    public Integer getPosition(){
        return position;
    }

    public void setPosition(int new_position){
        this.position = new_position;
    }
}
