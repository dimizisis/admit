import java.util.List;

public abstract class Equation {
    protected Constant constant;
    protected List<Parameter> parameters;
    protected List<Operand> operands;
    protected String id;

    public Equation(String id){
        this.id = id;
    }

//    public void printParametersInSelect(){
//        for (Parameter p : parameters)
//            p.printParametersInSelect();
//
//        for (Operand o : operands)
//            o.printParametersInSelect();
//    }

//    public void editEquation(){
//        if (getType().indexOf("linear") == 0){
//            System.out.println("Parameter Name");
//            System.out.println("Weight");
//        }
//        else
//            System.out.println("Parameter Name");
//
//        int i = 0;
//
//        for (Parameter p : parameters) {
//            p.editInTR(i);
//            i += 2;
//        }
//
//        for (Operand o : operands) {
//            o.editInTR(i);
//            ++i;
//        }
//
//        if (constant != null)
//            constant.editInTR(i);
//    }

//    public void showDataEntryTable(String pr){
//        for (Parameter p : parameters)
//            p.printInTR(pr);
//
//        for (Operand o : operands)
//            o.printInTR(pr);
//
//        if (constant != null)
//            constant.printIntR();
//    }

    public boolean parameterExists(String id, String n){
        for (Parameter p : parameters)
            if (id.indexOf(this.id) == 0)
                if (p.isEqual(n))
                    return true;
        return false;
    }

    public boolean operandExists(String id, Operand n){
        for (Operand o : operands)
            if (id.indexOf(this.id) == 0)
                if (o.isEqual(n.getName()))
                    return true;
        return false;
    }

    public void setConstant(String name, int value){
        this.constant = new Constant(name, value);
    }

    public void addParameter(String name, int weight) {
        if (!parameterExists(this.id, name))
            parameters.add(new Parameter(name, weight));
    }

    public void addOperand(String name) {
        if (!parameterExists(this.id, name))
            operands.add(new Operand(name));
    }

    public abstract String showEquation();

    public abstract String getType();
    public abstract int computeEquation(String name, String sign);
    public abstract int tuneEquation(String name, String sign, int currentVal, List<Parameter> parameters);
    public abstract int tuneEquation(String name, String sign, int currentVal, String parameter);

}
