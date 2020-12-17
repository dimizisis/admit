import java.util.List;

public class ProductEquation extends Equation{

    public ProductEquation(String id) {
        super(id);
    }

    @Override
    public String showEquation() {
        String str = "";
        for(Operand o : operands)
            str += " " + o.showOperands();
        str = str.replace("", "-2");
        return str;
    }

    @Override
    public String getType() { return "product"; }

    @Override
    public int computeEquation(String name, String sign) {
        int finalCost = 1;
        String[] listOfParameters = new String[0];
        for (Operand o : operands){
            String composite = "no";
            String newName = o.getName().replace("(", "")
                    .replace(")", "");
            if (newName.indexOf("\\+") > 0){
                listOfParameters = newName.split("\\+");
                composite = "add";
            }
            else if (newName.indexOf("\\*") > 0){
                listOfParameters = newName.split("\\*");
                composite = "multi";
            }
            else if (newName.indexOf("/") > 0){
                listOfParameters = newName.split("/");
                composite = "div";
            }
            else if (newName.indexOf("-") > 0) {
                listOfParameters = newName.split("-");
                composite = "sub";
            }

            if (composite.indexOf("no") == 0){
                for (String key : $_GET) {
                    key = key.replace("_", "");
                    if (key.indexOf(o.getName()) == 0){
                        finalCost *= value;
                        break;
                    }
                }
            }
            else{
                int temp=0;
                for (String key : $_GET) {
                    key = key.replace("_", "");
                    if (key.indexOf(listOfParameters[0]) == 0){
                        temp = value;
                        break;
                    }
                }
                for (int i=1; i<listOfParameters.length; ++i){
                    for (String key : $_GET) {
                        key = key.replace("_", "");
                        if (key.trim().indexOf(listOfParameters[i].trim()) == 0){
                            if (composite.indexOf("multi") == 0)
                                temp *= value;

                            if (composite.indexOf("add") == 0)
                                temp += value;

                            if (composite.indexOf("sub") == 0)
                                temp -= value;

                            if (composite.indexOf("div") == 0)
                                temp /= value;
                            break;
                        }
                    }
                }
                finalCost *= temp;
            }
        }
        return finalCost;
    }

    @Override
    public int tuneEquation(String name, String sign, int currentVal, List<Parameter> parameters) {
        int finalCost = 1;
        String[] listOfParameters = new String[0];
        for (Operand o : operands){
            String composite = "no";
            String newName = o.getName().replace("(", "")
                    .replace(")", "");
            if (newName.indexOf("\\+") > 0){
                listOfParameters = newName.split("\\+");
                composite = "add";
            }
            else if (newName.indexOf("\\*") > 0){
                listOfParameters = newName.split("\\*");
                composite = "multi";
            }
            else if (newName.indexOf("/") > 0){
                listOfParameters = newName.split("/");
                composite = "div";
            }
            else if (newName.indexOf("-") > 0) {
                listOfParameters = newName.split("-");
                composite = "sub";
            }

            if (composite.indexOf("no") == 0){
                for (String key : $_GET) {
                    key = key.replace("_", "");
                    if (key.indexOf(o.getName()) == 0){
                        if (key.trim().indexOf(parameters.trim()) == 0)
                            finalCost *= currentVal;
                        else
                            finalCost *= value;
                        break;
                    }
                }
            }
            else{
                int temp;
                for (String key : $_GET) {
                    key = key.replace("_", "");
                    if (key.indexOf(listOfParameters[0]) == 0){
                        if (key.trim().indexOf(parameters.trim()) == 0){
                            temp = currentVal;
                        }
                        else
                            temp = value;
                        break;
                    }
                }
                for (int i=1; i<listOfParameters.length; ++i){
                    for (String key : $_GET) {
                        key = key.replace("_", "");
                        if (key.trim().indexOf(listOfParameters[i].trim()) == 0){
                            if (composite.indexOf("multi") == 0){
                                if (key.trim().indexOf(parameters.trim()) == 0)
                                    temp *= currentVal;
                                else
                                    temp *= value;
                            }
                            if (composite.indexOf("add") == 0){
                                if (key.trim().indexOf(parameters.trim()) == 0)
                                    temp += currentVal;
                                else
                                    temp += value;
                            }
                            if (composite.indexOf("sub") == 0){
                                if (key.trim().indexOf(parameters.trim()) == 0)
                                    temp -= currentVal;
                                else
                                    temp -= value;
                            }
                            if (composite.indexOf("div") == 0){
                                if (key.trim().indexOf(parameters.trim()) == 0)
                                    temp /= currentVal;
                                else
                                    temp /= value;
                            }
                            break;
                        }
                    }
                }
                finalCost *= temp;
            }
        }
        return finalCost;
    }

    @Override
    public int tuneEquation(String name, String sign, int currentVal, String parameter) {
        int finalCost = 1;
        String[] listOfParameters = new String[0];
        for (Operand o : operands){
            String composite = "no";
            String newName = o.getName().replace("(", "")
                    .replace(")", "");
            if (newName.indexOf("\\+") > 0){
                listOfParameters = newName.split("\\+");
                composite = "add";
            }
            else if (newName.indexOf("\\*") > 0){
                listOfParameters = newName.split("\\*");
                composite = "multi";
            }
            else if (newName.indexOf("/") > 0){
                listOfParameters = newName.split("/");
                composite = "div";
            }
            else if (newName.indexOf("-") > 0) {
                listOfParameters = newName.split("-");
                composite = "sub";
            }

            if (composite.indexOf("no") == 0){
                for (String key : $_GET) {
                    key = key.replace("_", "");
                    if (key.indexOf(o.getName()) == 0){
                        if (key.trim().indexOf(parameter.trim()) == 0)
                            finalCost *= currentVal;
                        else
                            finalCost *= value;
                        break;
                    }
                }
            }
            else{
                int temp=0;
                for (String key : $_GET) {
                    key = key.replace("_", "");
                    if (key.indexOf(listOfParameters[0]) == 0){
                        if (key.trim().indexOf(parameter.trim()) == 0){
                            temp = currentVal;
                        }
                        else
                            temp = value;
                        break;
                    }
                }
                for (int i=1; i<listOfParameters.length; ++i){
                    for (String key : $_GET) {
                        key = key.replace("_", "");
                        if (key.trim().indexOf(listOfParameters[i].trim()) == 0){
                            if (composite.indexOf("multi") == 0){
                                if (key.trim().indexOf(parameter.trim()) == 0)
                                    temp *= currentVal;
                                else
                                    temp *= value;
                            }
                            if (composite.indexOf("add") == 0){
                                if (key.trim().indexOf(parameter.trim()) == 0)
                                    temp += currentVal;
                                else
                                    temp += value;
                            }
                            if (composite.indexOf("sub") == 0){
                                if (key.trim().indexOf(parameter.trim()) == 0)
                                    temp -= currentVal;
                                else
                                    temp -= value;
                            }
                            if (composite.indexOf("div") == 0){
                                if (key.trim().indexOf(parameter.trim()) == 0)
                                    temp /= currentVal;
                                else
                                    temp /= value;
                            }
                            break;
                        }
                    }
                }
                finalCost *= temp;
            }
        }
        return finalCost;
    }
}
