import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private double td;
    private double energy;
    private String security;
    private int loc;
    private int marketSize;
    private String marketShare;
    private double price;
    private List<Decision> decisions;

    public Project(String name, double td, double energy, String security,
                   int loc, int marketSize, String marketShare, double price) {
        this.name = name;
        this.td = td;
        this.energy = energy;
        this.security = security;
        this.loc = loc;
        this.marketSize = marketSize;
        this.marketShare = marketShare;
        this.price = price;

        decisions = new ArrayList<>();
    }

    public boolean hasName(String str) {
        return str.indexOf(name) == 0;
    }

    public void addDecision(Decision decision) {
        if (!decisionExists(decision.getName(), decision.getProject()))
            decisions.add(decision);
    }

    public Decision findDecision(Decision decision) {
        for (Decision d : decisions)
            if (d.hasName(decision.getName()))
                return d;
        return null;
    }

    public void insertAllDecisionsToFile() {
        // Todo
    }

    public boolean decisionExists(String name, Project project) {
        for (Decision d : decisions)
            if (d.isEqual(name, project))
                return true;
        return false;
    }

    public void editEquation(Decision dec, ModelParameter model) {
        Decision currentDecision = findDecision(dec);
        currentDecision.editEquation(model);
    }

    public void showDataEntryTable(Decision dec) {
        Decision currentDecision = findDecision(dec);
        currentDecision.showDataEntryTable(this);
    }

    public void tuneCostBenefitAnalysis(Decision dec, int min, int max, Parameter parameter) {
        Decision currentDecision = findDecision(dec);
        currentDecision.tuneCostBenefitAnalysis(min, max, parameter.toString());
    }

    public void showCostBenefitAnalysis(Decision dec){
        Decision currentDecision = findDecision(dec);
        currentDecision.showCostBenefitAnalysis();
    }

    public int getLoC() {
        return this.loc;
    }

    public double getPrice() {
        return this.price;
    }

    public String getMarketShare() {
        return this.marketShare;
    }

    public int getMarketSize() {
        return this.marketSize;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return this.getName();
    }
}
