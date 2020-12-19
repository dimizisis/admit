import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Equation {
    protected Map<String, Double> parameters;
    protected String id;
    protected String equationStr;

    public Equation(String id, String eq){
        this.id = id;
        this.equationStr = eq;
        this.parameters = new HashMap<>();
        initializeParameters(parseParameterNames());
    }

    public void putParameterWeight(String name, double weight) { parameters.put(name, weight); }

    private void initializeParameters(Set<String> paramNames){ paramNames.forEach(name -> this.parameters.put(name, 0.0)); }

    private Set<String> parseParameterNames(){
        Set<String> names = new HashSet<>();
        Matcher m = Pattern.compile("\\b([A-Za-z]\\w*)\\b").matcher(this.equationStr);
        while (m.find())
            names.add(m.group());
        return names;
    }

    public double computeEquation() {
        double finalCost = 0.0;
        Expression e = new ExpressionBuilder(this.equationStr)
                .variables(this.parameters.keySet())
                .build()
                .setVariables(this.parameters);
        try { finalCost = e.evaluate(); } catch (Exception ignored){}
        return finalCost;
    }

    public double computeEquation(Map.Entry<String, Double> param) {
        double finalCost = 0.0;
        Map<String, Double> tmpParams = new HashMap<>(this.parameters);
        tmpParams.put(param.getKey(), param.getValue());
        Expression e = new ExpressionBuilder(this.equationStr)
                .variables(tmpParams.keySet())
                .build()
                .setVariables(tmpParams);
        try { finalCost = e.evaluate(); } catch (Exception ignored){}
        return finalCost;
    }

    public Map<String, Double> getParameters() { return parameters; }
}
