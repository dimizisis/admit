import java.util.List;

public class LinearEquation extends Equation{

    public LinearEquation(String id){
        super(id);
    }

    @Override
    public String showEquation() {
        Constant c = this.constant;
        String str = c.getValue() != 0 ? c.getName() : "";

        for (Parameter p : parameters)
            str += " " + p.showParameter(str);

        return str;
    }

    @Override
    public String getType() { return "linear"; }

    @Override
    public int computeEquation(String name, String sign) {
        int finalCost = constant.getValue();
        String[] listOfParameters = new String[0];
        for (Parameter p : parameters){
            String composite = "no";
            String newName = p.getName().replace("(", "")
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
                    if (key.indexOf(p.getName()) == 0){
                        finalCost += (p.getWeight() * value);
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
                finalCost += (p.getWeight() * temp);
            }
        }
        return finalCost;
    }

    @Override
    public int tuneEquation(String name, String sign, int currentVal, List<Parameter> parameters) {
        int finalCost = constant.getValue();
        String[] listOfParameters = new String[0];
        for (Parameter p : parameters){
            String composite = "no";
            String newName = p.getName().replace("(", "")
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
                  if (key.indexOf(p.getName()) == 0){
                      if (key.trim().indexOf(parameters.trim()) == 0)
                          finalCost += (p.getWeight() * currentVal);
                      else
                          finalCost += (p.getWeight() * value);
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
                finalCost += (p.getWeight() * temp);
            }
        }
        return finalCost;
    }

    @Override
    public int tuneEquation(String name, String sign, int currentVal, String parameter) {
        int finalCost = constant.getValue();
        String[] listOfParameters = new String[0];
        for (Parameter p : parameters){
            String composite = "no";
            String newName = p.getName().replace("(", "")
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
                    if (key.indexOf(p.getName()) == 0){
                        if (key.trim().indexOf(parameter.trim()) == 0)
                            finalCost += (p.getWeight() * currentVal);
                        else
                            finalCost += (p.getWeight() * value);
                        break;
                    }
                }
            }
            else{
                int temp;
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
                finalCost += (p.getWeight() * temp);
            }
        }
        return finalCost;
    }

}
