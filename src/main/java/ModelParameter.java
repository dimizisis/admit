
public class ModelParameter {
    private String name;
    private Equation equation;
    private String project;
    private String decision;
    private String type;

    public ModelParameter(String name, String project, String decision, String type){
        this.name = name;
        this.project = project;
        this.decision = decision;
        this.type = type;
    }

    public String getName() { return this.name; }

    public String getType() { return this.type; }

    public Equation getEquation() { return equation; }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ModelParameter)) return false;

        ModelParameter other = (ModelParameter)o;
        return other.getName().equals(this.getName());
    }

}
