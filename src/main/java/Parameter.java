public class Parameter {
    private String name;
    private double weight;
    private int value;

    public Parameter(String name, double weight){
        this.name = name;
        this.weight = weight;
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public boolean existsIn(String[] ar, String key){
        for (int i=0; i<ar.length; ++i)
            if (ar[i].indexOf(key) == 0)
                return true;
        return false;
    }

//    public void printParametersInSelect(){
//        int finalValue = -1;
//        String composite = "no";
//        String newName = getName().replace("(", "");
//        newName = getName().replace(")", "");
//        String[] listOfParameters = new String[0];
//
//        if (newName.indexOf("\\+") > 0){
//            listOfParameters = newName.split("\\+");
//            composite = "add";
//        }
//        else if (newName.indexOf("\\*") > 0){
//            listOfParameters = newName.split("\\*");
//            composite = "multi";
//        }
//        else if (newName.indexOf("/") > 0){
//            listOfParameters = newName.split("/");
//            composite = "div";
//        }
//        else if (newName.indexOf("-") > 0) {
//            listOfParameters = newName.split("-");
//            composite = "sub";
//        }
//
//        if (composite.indexOf("no") == 0){
//            for (String key : $_GET) {
//                key = key.replace("_", "");
//                if (key.indexOf(getName()) == 0){
//                    finalValue = value;
//                    System.out.println(getName() + "_" + finalValue);
//                    break;
//                }
//            }
//        }
//        else{
//            for (int i=0; i< listOfParameters.length; ++i){
//                for (String key : $_GET){
//                    key = key.replace("_", "");
//                    if (key.trim().indexOf(listOfParameters[i]) == 0){
//                        if (composite.indexOf("multi") == 0)
//                            finalValue = value;
//                        if (composite.indexOf("add") == 0)
//                            finalValue = value;
//                        if (composite.indexOf("sub") == 0)
//                            finalValue = value;
//                        if (composite.indexOf("div") == 0)
//                            finalValue = value;
//                        System.out.println(listOfParameters[i] + "_" + finalValue);
//                        break;
//                    }
//                }
//            }
//        }
//    }

    public boolean isEqual(String name) {
        return name.indexOf(this.name) == 0;
    }

    public String showParameter(String s) {
        if (weight < 0)
            return weight + " * " + name;
        else {
            if (s.isEmpty()) {
                if (weight == 1)
                    return name;
                else
                    return weight + " * " + name;
            } else {
                if (weight == 1)
                    return " + " + name;
                else
                    return " + " + weight + " * " + name;
            }
        }
    }
}
