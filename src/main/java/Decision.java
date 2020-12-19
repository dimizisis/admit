import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Decision {
    private String name;
    private Project project;
    private String owner;
    private String dDate;
    private List<ModelParameter> models;

    private final int INTERVAL_LEN = 10;

    public Decision(String name, Project project, String owner, String dDate){
        this.name = name;
        this.project = project;
        this.owner = owner;
        this.dDate = dDate;
        this.models = new ArrayList<>();
    }

    /**
     * Tunes cost & benefit analysis, given a min & a max value for a specific parameter.
     *
     * @param  min  the parameter's value minimum threshold
     * @param  max  the parameter's value maximum threshold
     */
    public void tuneCostBenefitAnalysis(int min, int max, String parameter){
        List<Double> intervals = new ArrayList<>();

        int range = max - min;
        double interval = range / INTERVAL_LEN;

        for (int i=0; i<=INTERVAL_LEN; ++i)
            intervals.add(min + interval*i);

        intervals.forEach(i ->
            models.stream().filter(m -> m.getEquation().getParameters().containsKey(parameter)).forEach(m -> m.getEquation().computeEquation(new AbstractMap.SimpleEntry<>(parameter, i))));
    }

    /**
     * Finds a specific model (Cost or Benefit) and returns its instance.
     * If no model exists with the name given, returns null
     *
     * @param  modelName  the model's name that is being searched
     *
     * @return  the model's instance (ModelParameter) if exists, null otherwise
     */
    public ModelParameter findModel(String modelName){
        try {
            return models.stream().filter(m -> m.getName().equals(modelName)).findFirst().get();
        } catch (NoSuchElementException e){ return null; }
    }

    /**
     * Adds a model (Cost or Benefit) to decision's models list
     * Returns true if addition was successful, false otherwise
     *
     * @param  model  the model to be added to decision's model list
     *
     * @return  true if addition was successful, false otherwise
     */
    public boolean addModel(ModelParameter model){
        try {
            models.add(model);
            return true;
        } catch (Exception e){ return false; }
    }

    /**
     * Removes a model (Cost or Benefit) from decision's models list
     * Returns true if removal was successful, false otherwise
     *
     * @param  model  the model to be removed from decision's model list
     *
     * @return  true if removal was successful, false otherwise
     */
    public boolean removeModel(ModelParameter model){
        try {
            models.remove(model);
            return true;
        } catch (Exception e){ return false; }
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
