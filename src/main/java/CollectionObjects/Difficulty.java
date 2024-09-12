package CollectionObjects;

public enum Difficulty {
    NORMAL,
    INSANE,
    HOPELESS;
    public static Difficulty getByString(String s){
        for (Difficulty difficulty : Difficulty.values()){
            if (String.valueOf(difficulty).equals(s)){
                return difficulty;
            }
        }
        return null;
    }
}
