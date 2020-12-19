
import java.util.HashSet;
import java.util.Set;

public class Project {
    private String name;
    private double td;
    private double energy;
    private String security;
    private int loc;
    private int marketSize;
    private String marketShare;
    private double price;
    private Set<Decision> decisions;

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
        decisions = new HashSet<>();
    }

    public void addDecision(Decision decision) { decisions.add(decision); }

    public Decision findDecision(String decisionName) {
        for (Decision d : decisions)
            if (d.getName().equals(decisionName))
                return d;
        return null;
    }

    public void insertAllDecisionsToFile() {
        // Todo
    }

    public void tuneCostBenefitAnalysis(Decision dec, int min, int max, String parameter) {
        Decision currentDecision = findDecision(dec.getName());
        currentDecision.tuneCostBenefitAnalysis(min, max, parameter);
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

    public Set<Decision> getDecisions() { return decisions; }

    public String toString(){
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Project)) return false;

        Project other = (Project)o;
        return other.getName().equals(this.getName());
    }
}
