import java.util.List;

public class Operand {
    private String name;
    private int value;

    public Operand(String name){
        this.name = name;
        this.value = 0;
    }

    public boolean existsIn(List<String> ar, String key){
        for (int i=0; i<ar.size(); ++i)
            if (ar.get(i).indexOf(key) == 0)
                return true;
        return false;
    }

    public boolean isEqual(String name){
        return name.indexOf(this.name) == 0;
    }

    public String showOperands() {
        return this.name + " * ";
    }

    public String getName() {
        return name;
    }
}
