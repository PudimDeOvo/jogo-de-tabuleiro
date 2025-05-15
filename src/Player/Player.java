package Player;

public abstract class Player {
    protected String color;
    protected int position;
    protected String playerType;

    public Player(String color, int position, String playerType){
        this.color = color;
        this.position = position;
        this.playerType = playerType;
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

    public String getPlayerType(){
        return this.playerType;
    }
}
