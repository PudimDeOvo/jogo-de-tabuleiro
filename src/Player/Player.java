package Player;

public abstract class Player {
    protected String color;
    protected int position = 0;

    public Player(String color){
        this.color = color;
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
