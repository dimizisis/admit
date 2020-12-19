import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProjectList {

    private final List<Project> projects = new ArrayList<>();

    /**
     * Removes a project from the aggregated project list
     * Returns true if removal was successful, false otherwise
     *
     * @param  projectName  the project's name to be removed from the aggregated project list
     *
     * @return  true if removal was successful, false otherwise
     */
    public boolean removeProject(String projectName){
        try {
            projects.remove(findProject(projectName));
            return true;
        } catch (NullPointerException e) { return false; }
    }

    /**
     * Removes a model (Cost or Benefit) from decision's models list
     * Returns true if removal was successful, false otherwise
     *
     * @param  projectName  the project's name that contains the decision of model
     * @param  decisionName  the decision's name that contains the model
     * @param  modelName  the model to be removed from decision's model list
     *
     * @return  true if removal was successful, false otherwise
     */
    public boolean removeModel(String projectName, String decisionName, String modelName){
        try {
            Project tmpProject = findProject(projectName);
            Decision tmpDec = tmpProject.findDecision(decisionName);
            ModelParameter tmpModel = tmpDec.findModel(modelName);
            tmpDec.removeModel(tmpModel);
            return true;
        } catch (Exception e) { return false; }
    }

    /**
     * Removes a decision from project's decision list
     * Returns true if removal was successful, false otherwise
     *
     * @param  projectName   the project's name that contains the decision
     * @param  decisionName  the decision's name to be removed from project's decision list
     *
     * @return  true if removal was successful, false otherwise
     */
    public boolean removeDecision(String projectName, String decisionName) {
        try {
            Project tmpProject = findProject(projectName);
            tmpProject.removeDecision(tmpProject.findDecision(decisionName));
            return true;
        } catch (Exception e) { return false; }
    }

    /**
     * Adds a project to the aggregated project list
     * Returns true if addition was successful, false otherwise
     *
     * @param  projectName  the project's name to be added to the aggregated project list
     * @param  td  the project's technical debt principal
     * @param  energy  the project's energy consumption
     * @param  security  the project's security type
     * @param  loc  the project's loc
     * @param  marketSize  the project's marketSize
     * @param  marketShare  the project's marketShare type
     * @param  price  the project's price
     *
     * @return  true if addition was successful, false otherwise
     */
    public boolean addProject(String projectName, double td, double energy, String security,
                              int loc, int marketSize, String marketShare, double price){
        try {
            this.projects.add(new Project(projectName, td, energy, security, loc, marketSize, marketShare, price));
            return true;
        } catch (Exception e){ return false; }
    }

    /**
     * Adds a model (Cost or Benefit) to a decision's models list
     * Returns true if addition was successful, false otherwise
     *
     * @param  projectName  the project's name that contains the decision
     * @param  decisionName  the decision's name that contains the model
     * @param  modelName  model's name to be added
     * @param  type  model's type to be added
     *
     * @return  true if addition was successful, false otherwise
     */
    public boolean addModelToDecision(String projectName, String decisionName, String modelName, String type) {
        try {
            Project tmpProject = findProject(projectName);
            Decision tmpDec = tmpProject.findDecision(decisionName);
            tmpDec.addModel(new ModelParameter(modelName, projectName, decisionName, type));
            return true;
        } catch (Exception e) { return false; }
    }

    /**
     * Adds a decision to a project's decision list
     * Returns true if addition was successful, false otherwise
     *
     * @param  projectName  the project's name that will contain the decision
     * @param  decisionName  the decision to be added to project's model list
     * @param  owner  the decision to be added to project's model list
     * @param  date  the decision to be added to project's model list
     *
     * @return  true if addition was successful, false otherwise
     */
    public boolean addDecision(String projectName, String decisionName, String owner, String date){
        try {
            Project tmpProject = findProject(projectName);
            tmpProject.addDecision(new Decision(decisionName, tmpProject, owner, date));
            return true;
        } catch (Exception e) { return false; }
    }

    /**
     * Finds a specific project and returns its instance.
     * If no project exists with the name given, returns null
     *
     * @param  projectName  the project's name that is being searched
     *
     * @return  the project's instance (Project) if exists, null otherwise
     */
    public Project findProject(String projectName){
        try {
            return projects.stream().filter(pr -> pr.getName().equals(projectName)).findFirst().get();
        } catch (NoSuchElementException e){ return null; }
    }

    /**
     * Tunes cost & benefit analysis, given a project name, a decision name,
     * a min & a max value for a specific parameter.
     *
     * @param  projectName  the project's name that contains the decision
     * @param  decisionName  the decision's name that contains the parameter given
     * @param  min  the parameter's value minimum threshold
     * @param  max  the parameter's value maximum threshold
     * @param  parameter  the parameter's name
     */
    public boolean tuneCostBenefitAnalysis(String projectName, String decisionName, int min, int max, String parameter) {
        try {
            Project tmpProject = findProject(projectName);
            tmpProject.tuneCostBenefitAnalysis(tmpProject.findDecision(decisionName), min, max, parameter);
            return true;
        } catch (Exception e) { return false; }
    }

//    public boolean store(){
//
//    }

//    public void load(){
//
//    }
}
