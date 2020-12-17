public class Constant {

    private String name;
    private int value;

    public Constant(String name, int value){
        this.name = name;
        this.value = value;
    }

    public void printIntR(){
        if (value > 0){
            System.out.println(name);
            System.out.println(value + " name=" + name + " id=" + name);
        }
    }

    public void editInTR(int i){
        System.out.println(name + " name=" + i + " id=" + i);
        System.out.println(value + " name=" + (i+1) + " id=" + (i+1));
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getInsertQuery(int id){
        return "insert into parameters values(" + id + ",'" + name + "',-1," + value + ",'constant');";
    }

}
