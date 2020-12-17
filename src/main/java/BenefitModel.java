public class BenefitModel extends ModelParameter{

    public BenefitModel(String name, Project project, Decision decision){
        super(name, project, decision);
    }

    @Override
    public String showModel() {
        return null;
    }

    public String showBenefitModel() {
        return null;
    }

    @Override
    public String getType() {
        return "benefit";
    }
}
