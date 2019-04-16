package VideoCodeAlong;

public class Parenthesis {

    private String parenthesis, match;
    private boolean open;
    private int type;

    private static final String OPEN_PARENTHESIS ="([{";
    private static final String CLOSED_PARENTHESIS =")]}";

    public  static boolean isParenthesis(char paraChar){
        return OPEN_PARENTHESIS.indexOf(paraChar) >=0 || CLOSED_PARENTHESIS.indexOf(paraChar) >= 0;
    }

    public Parenthesis(char paraChar){
        this.parenthesis = Character.toString(paraChar);
        if (isParenthesis(paraChar)){
            if(OPEN_PARENTHESIS.indexOf(parenthesis) >= 0){
                open = true;
                type = OPEN_PARENTHESIS.indexOf(parenthesis);
                match = Character.toString(CLOSED_PARENTHESIS.charAt(type));
            } else {
                open = false;
                type = CLOSED_PARENTHESIS.indexOf(parenthesis);
                match = Character.toString(OPEN_PARENTHESIS.charAt(type));
            }

        } else {
            throw new IllegalArgumentException("Not a parenthesis");
        }
    }

    public String getParenthesis() {
        return parenthesis;
    }

    public String getMatch() {
        return match;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isClosed(){
        return !open;
    }

    public int getType() {
        return type;
    }

    public boolean isMatch(String maybe){
        return match.equalsIgnoreCase(maybe);
    }

    public boolean isMatch(Parenthesis other){
        return other.match.equalsIgnoreCase(match);
    }

    @Override
    public String toString(){
        return "Parenthesis : " + parenthesis + " Match : "  + match;
    }

}//Parenthesis
