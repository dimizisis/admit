import java.util.ArrayList;
import java.util.List;

public class ProjectList {

    private List<Project> projects = new ArrayList<>();

    public void add(Project p){
        this.projects.add(p);
    }

    public Project findProject(String name){
        for (Project pr : projects)
            if (pr.hasName(name))
                return pr;
        return null;
    }

    public void showDefaultBenefitEquations(String name, Decision dec){
        Project currentProject = findProject(name);
        currentProject.showDefaultBenefitEquations(dec);
    }

    public void showDefaultCostEquations(String name, Decision dec){
        Project currentProject = findProject(name);
        currentProject.showDefaultCostEquations(dec);
    }

    public void showAllEquations(String name, Decision dec){
        Project currentProject = findProject(name);
        currentProject.showAllEquations(dec);
    }

    public void showAllDecisions(String name, Decision dec){
        Project currentProject = findProject(name);
        currentProject.showAllDecisions();
    }

//    public void deleteProject(String name){
//
//    }

//    public void updateParameter(Project pr, Decision dec, ModelParameter model, Parameter param, Parameter newVal){
//
//    }

//    public boolean isCustom(ModelParameter model){
//
//    }

    public void editEquation(Project pr, Decision dec, ModelParameter model){
        Project currentProject = findProject(pr.getName());
        currentProject.editEquation(dec, model);
    }

//    public void deleteModel(Project pr, Decision dec, ModelParameter model){
//
//    }

//    public void deleteCustomModel(Project pr, Decision dec, ModelParameter model){
//
//    }

//    public void addModelToDecision(Project pr, Decision dec, ModelParameter model, String type) {
//
//    }

//    public void deleteDecision(Project pr, String name) {
//
//    }

    public void addDecision(Project pr, String name, String owner, String date){
        Project currentProject = findProject(pr.getName());
        currentProject.addDecision(new Decision(name, pr, owner, date));
    }

    public void showDataEntryTable(Project pr, Decision d){
        Project currentProject = findProject(pr.getName());
        currentProject.showDataEntryTable(d);
    }

    public void tuneCostBenefitAnalysis(Project pr, Decision dec, int min, int max, Parameter parameter) {
        Project currentProject = findProject(pr.getName());
        currentProject.tuneCostBenefitAnalysis(dec, min, max, parameter);
    }

    public void showCostBenefitAnalysis(Project pr, Decision d){
        Project currentProject = findProject(pr.getName());
        currentProject.showCostBenefitAnalysis(d);
    }

//    public void store(){
//
//    }

//    public void addModel(){
//
//    }

//    public void load(){
//
//    }
}
