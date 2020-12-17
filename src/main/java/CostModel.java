public class CostModel extends ModelParameter{

    public CostModel(String name, Project project, Decision decision){
        super(name, project, decision);
    }

    @Override
    public String showModel() {
        return null;
    }

    public String showCostModel() {
        return null;
    }

    @Override
    public String getType() {
        return "cost";
    }
}
