public class PositiveIntegerHW {
    private int num;
    public PositiveIntegerHW(int number) {
        num = number;
    }
    public boolean isPerfect() {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == num) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isAbundant() {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum = sum + i;
            }
        }
        if (sum > num) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isNarcissistic() {
      if (num < 0) {
          return false;
      }
      String numStringValue = Integer.toString(num);
      String[] numStringCharacters = numStringValue.split("");

      double[] numIntCharacters = new double[numStringCharacters.length];

      for (int i = 0; i < numIntCharacters.length; i++) {
          numIntCharacters[i] = (double) Integer.parseInt(numStringCharacters[i]);
      }

      double numPower = (double) numIntCharacters.length;
      double count = 0;
      for (int i = 0; i < numIntCharacters.length; i++) {
          count = count + Math.pow(numIntCharacters[i], numPower);
      }
      return count == num;
    }
    public static void main(String[] args) {
        PositiveIntegerHW simulator = new PositiveIntegerHW(6);
        boolean perfect = simulator.isPerfect();
        System.out.println("Is this number perfect: " + perfect);
        boolean abundant = simulator.isAbundant();
        System.out.println("Is this number abundant: " + abundant);
        boolean narcissistic = simulator.isNarcissistic();
        System.out.println("Is this number narcissistic: " + narcissistic);
    }
}

