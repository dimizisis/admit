import java.util.ArrayList;
import java.util.List;

public class ProjectList {

    private final List<Project> projects = new ArrayList<>();

    public boolean deleteProject(String name){
        try {
            projects.remove(findProject(name));
            return true;
        } catch (NullPointerException e) { return false; }
    }

    public boolean deleteModel(String projectName, String decisionName, String modelName){
        try {
            Project tmpProject = findProject(projectName);
            Decision tmpDec = tmpProject.findDecision(decisionName);
            ModelParameter tmpModel = tmpDec.findModel(modelName);
            tmpDec.removeModel(tmpModel);
            return true;
        } catch (Exception e) { return false; }
    }

    public boolean deleteDecision(String projectName, String decisionName) {
        try {
            Project tmpProject = findProject(projectName);
            tmpProject.getDecisions().remove(tmpProject.findDecision(decisionName));
            return true;
        } catch (Exception e) { return false; }
    }

    public void addProject(Project p){
        this.projects.add(p);
    }

    public boolean addModelToDecision(String projectName, String decisionName, String modelName, String type) {
        try {
            Project tmpProject = findProject(projectName);
            Decision tmpDec = tmpProject.findDecision(decisionName);
            tmpDec.addModel(new ModelParameter(modelName, projectName, decisionName, type));
            return true;
        } catch (Exception e) { return false; }
    }

    public boolean addDecision(String projectName, String name, String owner, String date){
        try {
            Project tmpProject = findProject(projectName);
            tmpProject.addDecision(new Decision(name, tmpProject, owner, date));
            return true;
        } catch (Exception e) { return false; }
    }

    public Project findProject(String projectName){
        for (Project pr : projects)
            if (pr.getName().equals(projectName))
                return pr;
        return null;
    }

    public boolean tuneCostBenefitAnalysis(String projectName, String decisionName, int min, int max, String parameter) {
        try {
            Project tmpProject = findProject(projectName);
            tmpProject.tuneCostBenefitAnalysis(tmpProject.findDecision(decisionName), min, max, parameter);
            return true;
        } catch (Exception e) { return false; }
    }

//    public void store(){
//
//    }

//    public void load(){
//
//    }
}
