import lotterysystem.Candidate;
import lotterysystem.LotterySystem;

import javax.naming.directory.InvalidAttributesException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InvalidAttributesException {
        LotterySystem system = new LotterySystem();

        system.addCandidate("Alice", 15);   // 15% chance approx
        system.addCandidate("Bob", 20);     // 20%
        system.addCandidate("Charlie", 60); // 60%
        system.addCandidate("Lada", 2);  // 5%

        int iterations = 100000;
        Map<String, Integer> winStats = new HashMap<>();

        for (Candidate c : system.getCandidates()) {
            winStats.put(c.name, 0);
        }

        for (int i = 0; i < iterations; i++) {
            system.makeWinner();
            Candidate winner = system.getWinner();
            winStats.put(winner.name, winStats.get(winner.name) + 1);
        }

        System.out.println("Lottery Results after " + iterations + " runs:");
        for (Map.Entry<String, Integer> entry : winStats.entrySet()) {
            double percentage = (entry.getValue() * 100.0) / iterations;
            System.out.printf("%s won %d times (%.2f%%)\n", entry.getKey(), entry.getValue(), percentage);
        }
    }
}