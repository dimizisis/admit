import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Decision {
    private String name;
    private Project project;
    private String owner;
    private String dDate;
    private List<ModelParameter> models;

    public Decision(String name, Project project, String owner, String dDate){
        this.name = name;
        this.project = project;
        this.owner = owner;
        this.dDate = dDate;
        this.models = new ArrayList<>();
    }

    public void tuneCostBenefitAnalysis(int min, int max, String parameter){
        List<Double> intervals = new ArrayList<>();

        int range = max - min;
        double interval = range / 10;

        for (int i=0; i<=10; ++i)
            intervals.add(min + interval*i);

        for (Double i : intervals)
            for (ModelParameter m : models)
                if (m.getEquation().getParameters().containsKey(parameter))
                    m.getEquation().computeEquation(new AbstractMap.SimpleEntry<>(parameter, i));

    }

    public ModelParameter findModel(String modelName){
        for (ModelParameter m : models)
            if (m.getName().equals(modelName))
                return m;
        return null;
    }

    public boolean addModel(ModelParameter model){
        models.add(model);
        return true;
    }

    public boolean removeModel(ModelParameter model){
        try { models.remove(model); } catch (Exception e){ return false; }
        return true;
    }

    public String getName() { return name; }

    public Project getProject() { return project; }

    public List<ModelParameter> getModels() { return models; }

    public String toString(){ return this.getName(); }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Decision)) return false;

        Decision other = (Decision)o;
        return other.getName().equals(this.getName());
    }
}
