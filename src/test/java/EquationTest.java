import java.util.AbstractMap;

public class EquationTest {
    public static void main(String[] args) {
        String eq = "(Meeting_Duration_in_Minutes-Meetings_Per_Month) / 60 * (Meetings_Per_Month * 12) * Hourly_Rate * Number_of_Participants";
        Equation equation = new Equation("eq", eq);
        System.out.println(equation.getParameters());
        equation.putParameterWeight("Meetings_Per_Month", 2);
        equation.putParameterWeight("Meeting_Duration_in_Minutes", 4);
        equation.putParameterWeight("Hourly_Rate", 3);
        equation.putParameterWeight("Number_of_Participants", 12);
        System.out.println(equation.computeEquation());
        System.out.println(equation.computeEquation(new AbstractMap.SimpleEntry<>("Hourly_Rate", 100.0)));
    }
}
