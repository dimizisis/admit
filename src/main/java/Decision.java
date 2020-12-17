import java.util.ArrayList;
import java.util.List;

public class Decision {
    private String name;
    private Project project;
    private String owner;
    private String dDate;
    private List<ModelParameter> models;
    private List<ModelParameter> defaultModels;

    public Decision(String name, Project project, String owner, String dDate){
        this.name = name;
        this.project = project;
        this.owner = owner;
        this.dDate = dDate;

        this.models = new ArrayList<>();
        this.defaultModels = new ArrayList<>();
    }

    public boolean modelExistsInDecision(ModelParameter model){
        for (ModelParameter m : models)
            if(m.hasName(model.getName()))
                return true;
        return false;
    }

    public boolean hasName(String str){
        return str.indexOf(name) == 0;
    }

    public ModelParameter findModel(ModelParameter model){
        for (ModelParameter m : models)
            if (m.hasName(model.getName()))
                return m;
        return null;
    }

    public void addModelParameter(ModelParameter cm){
        if (!modelExists(project, this, cm.getName()))
            models.add(cm);
    }

    public boolean isEqual(String name, Project project){
        return name.indexOf(this.name) == 0 && project.toString().indexOf(this.project.toString()) == 0;
    }

    public boolean modelExists(Project project, Decision decision, String name){
        for (ModelParameter m : models)
            if (m.isEqual(project, decision, name))
                return true;
        return false;
    }

    public void tuneCostBenefitAnalysis(int min, int max, String parameter){
        List<Integer> intervals = new ArrayList<>();
        List<Integer> costs = new ArrayList<>();
        List<Integer> benefits = new ArrayList<>();

        List<String> costModelsNames = new ArrayList<>();
        List<Integer> costModels0 = new ArrayList<>();
        List<Integer> costModels10 = new ArrayList<>();

        List<String> benefitModelsNames = new ArrayList<>();
        List<Integer> benefitModels0 = new ArrayList<>();
        List<Integer> benefitModels10 = new ArrayList<>();

        int range = max - min;
        int interval = range / 10;

        for (int i=0; i<=10; ++i)
            intervals.add(i, min + interval*i);

        String[] p = parameter.split("_");
        parameter = p[0];

        for (int i=0; i<=10; ++i){
            costs.add(0, i);
            for (ModelParameter m : models){
                int cost = m.tuneCosts(intervals.get(i), parameter);
                costs.add(i, costs.get(i) + cost);
                if (m.getType().indexOf("cost") == 0){
                    if (i == 0){
                        costModelsNames.add(m.getName());
                        costModels0.add(cost);
                    }
                    else if (i == 10)
                        costModels10.add(cost);
                }
            }
            benefits.add(i, 0);
            for (ModelParameter m : models){
                int ben = m.tuneBenefits(intervals.get(i), parameter);
                benefits.add(i, benefits.get(i) + ben);
                if (m.getType().indexOf("benefit") == 0){
                    if (i == 0){
                        costModelsNames.add(m.getName());
                        benefitModels0.add(ben);
                    }
                    else if (i == 10)
                        benefitModels10.add(ben);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public Project getProject() {
        return project;
    }

    public List<ModelParameter> getModels() {
        return models;
    }

    public String toString(){
        return this.getName();
    }
}
