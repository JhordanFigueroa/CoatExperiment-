//need an array to solve for this problem
public class CoatExperimentSimulator {
    int numberOfPeople;

    CoatExperimentSimulator(int numPpl) {
        numberOfPeople = numPpl;
    }
    public int numPplWhoGotTheirCoat(int[] permutations) {
        int count = 0;
        for (int i = 0; i < permutations.length -1; i++) {
            int personIndex = i + 1;
            if (personIndex == permutations[i]) {
                count++;
            }
        }
        return count;
    }
    public int[] simulateCoatExperiment(int iterations) {
        int[] simulations = new int[iterations];
        for (int i = 0; i < iterations; i++) {
            int[] sampleSize = RandomOrderGenerator.getRandomOrder(numberOfPeople);
            int numberOfPeopleWhoGotGoat = numPplWhoGotTheirCoat(sampleSize);
            simulations[i] = numberOfPeopleWhoGotGoat;
        }
        return simulations;
    }
    public double answerToQuestionA(int[] results) {
        double totalNumberOfSimulations = (double) results.length;
        double count = 0;
        for (int i = 0; i < totalNumberOfSimulations - 1; i++) {
            if (results[i] == 0) {
                count++;
            }
        }
        return count/totalNumberOfSimulations;
    }
    public double answerToQuestionB(int[] results) {
        double totalNumberOfSimulations = (double) results.length;
        double numberOfPeopleWhoDidNotGetCoat = answerToQuestionA(results);
        return (results.length - numberOfPeopleWhoDidNotGetCoat)/totalNumberOfSimulations;
    }

    public static void main(String[] args) {
        CoatExperimentSimulator simulator = new CoatExperimentSimulator(25);
        int[] results = simulator.simulateCoatExperiment(100000);
        double probability = simulator.answerToQuestionA(results);
        System.out.println(probability);
        double average = simulator.answerToQuestionB(results);
        System.out.println(average);
        double estimate = 1 / probability; //since answerToQuestionA = 1/e, e = 1/answerToQuestionA
        System.out.println(estimate);
    }
}
