import java.util.List;

public abstract class ModelParameter {
    protected String name;
    protected Equation equation;
    protected Project project;
    protected Decision decision;

    public ModelParameter(String name, Project project, Decision decision){
        this.name = name;
        this.project = project;
        this.decision = decision;
    }

//    public void printParametersInSelect(){
//        equation.prineParametersInSelect();
//    }

//    public void editEquation(){
//        System.out.println(name);
//        equation.editEquation();
//    }

    public boolean hasName(String str){
        return str.indexOf(name) == 0;
    }

    public boolean isEqual(Project p, Decision d, String n){
        if (n.indexOf(name) == 0)
            if (p.toString().indexOf(project.toString()) == 0)
                return d.toString().indexOf(decision.toString()) == 0;

        return false;
    }

    public int tuneCosts(int currentVal, List<Parameter> parameters){
        return (this.getType().indexOf("cost") == 0) ?
                equation.tuneEquation(name, "-", currentVal, parameters) : 0;
    }

    public int tuneCosts(int currentVal, String parameter){
        return (this.getType().indexOf("cost") == 0) ?
                equation.tuneEquation(name, "-", currentVal, parameter) : 0;
    }

    public int tuneBenefits(int currentVal, List<Parameter> parameters){
        return (this.getType().indexOf("benefit") == 0) ?
                equation.tuneEquation(name, "-", currentVal, parameters) : 0;
    }

    public int tuneBenefits(int currentVal, String parameter){
        return (this.getType().indexOf("benefit") == 0) ?
                equation.tuneEquation(name, "-", currentVal, parameter) : 0;
    }

    public int calcCosts(){
        return (this.getType().indexOf("cost") == 0) ?
                equation.computeEquation(name, "-") : 0;
    }

    public int calcBenefits(){
        return (this.getType().indexOf("benefit") == 0) ?
                equation.computeEquation(name, "") : 0;
    }

//    public void showDataEntryTable(String pr) {
//        System.out.println(name);
//        equation.showDataEntryTable(pr);
//    }

    public void setEquationType(Equation eq){
        this.equation = eq;
    }

    public String getName(){
        return this.name;
    }

    public abstract String showModel();
    public abstract String getType();

}
