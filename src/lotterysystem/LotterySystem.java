package lotterysystem;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Collections;

public class LotterySystem {
    private static final int MAX_AMOUNT = 10000;

    private ArrayList<Candidate> candidates;
    private int total;
    Candidate winner;

    public LotterySystem () {
        candidates = new ArrayList<>();
        total = 0;
        winner = null;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void addCandidate(String name, int amount) throws InvalidAttributesException {
        if (amount <= 0 || amount > MAX_AMOUNT) {
            throw new InvalidAttributesException("amount is invalid");
        }
        candidates.add(new Candidate(name, amount));
        total += amount;
    }

    public void makeWinner() throws InvalidAttributesException {
        if (candidates.isEmpty()) {
            throw new InvalidAttributesException("no candidates available");
        }
        int value = (int) (Math.random() * total);
        int cur = 0;
        winner = null;
        Collections.shuffle(candidates);
        for (Candidate c : candidates) {
            cur += c.amount;
            if (cur > value) {
                winner = c;
                break;
            }
        }
    }

    public Candidate getWinner() throws InvalidAttributesException {
        if (winner == null) {
            makeWinner();
        }
        return winner;
    }
}
