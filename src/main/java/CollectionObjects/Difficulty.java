package CollectionObjects;

import java.util.EnumSet;
import java.util.stream.Collectors;

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

    public static String concat(String delimiter) {
        return EnumSet.allOf(Difficulty.class)
                .stream()
                .map(Enum::toString)
                .collect(Collectors.joining(delimiter));
    }
}
