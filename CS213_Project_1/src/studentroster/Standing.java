package studentroster;

/**
 The Standing Enum class stores each standing and
 the value that represents it.
 @author Dylan Turner, Noor Hasan
 */

public enum Standing {
    FRESHMAN (1),
    SOPHOMORE (2),
    JUNIOR (3),
    SENIOR (4);

    private final int value;

    /**
       Creates the standing constant
       @param value the corresponding value.
     */
    Standing(int value){
        this.value = value;
    }

    /**
       Getter method for the standings.
       @return the value of the specified standing.
     */
    public int getValue(){
        return this.value;
    }
}

