package Player;

public abstract class Player {
    protected String color;
    protected String playerType;
    protected int countPlays;
    protected int position;
    protected boolean nextMove;

    public Player(String color, int position, String playerType, boolean nextMove, int countPlays) {
        this.color = color;
        this.position = position;
        this.playerType = playerType;
        this.nextMove = true;
        this.countPlays = countPlays;
    }

    public abstract int roll();

    public void printPosition(int index){
        System.out.println("Player " + getColor() +" of index: " + index + " is at position: " + getPosition()  + "\n");
    }

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

    public boolean getNextMove(){
        return this.nextMove;
    }

    public void setNextMove(boolean nextMove){
        this.nextMove = nextMove;
    }

    public int getCountPlays(){
        return this.countPlays;
    }

    public void setCountPlays(int countPlays){
        this.countPlays = countPlays;
    }
}
