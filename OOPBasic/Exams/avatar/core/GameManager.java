package avatar.core;

import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;
import avatar.factories.BenderFactory;
import avatar.factories.MonumentFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static avatar.utilities.Constants.*;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class GameManager {
    private Map<String, List<Bender>> benders;
    private Map<String, List<Monument>> monuments;
    private List<String> issuedWars;

    public GameManager() {
        this.setBenders();
        this.setMonuments();
        this.issuedWars = new ArrayList<>();
    }

    public void createBender(String type, String name, long power, double secondParameter) {
        Bender bender = BenderFactory.makeBender(type, name, power, secondParameter);
        List<Bender> benderList = this.benders.get(type);
        benderList.add(bender);
        this.benders.put(type, benderList);
    }

    public void createMonument(String type, String name, long affinity) {
        Monument monument = MonumentFactory.makeMonument(type, name, affinity);
        List<Monument> monumentList = this.monuments.get(type);
        monumentList.add(monument);
        this.monuments.put(type, monumentList);
    }

    public String status(String nation) {
        StringBuilder sb = new StringBuilder();
        sb.append(nation).append(" Nation").append(System.lineSeparator()).append("Benders:");
        if (this.benders.get(nation).isEmpty()) {
            sb.append(" None").append(System.lineSeparator());
        } else {
            sb.append(System.lineSeparator());
            for (Bender bender : this.benders.get(nation)) {
                sb.append(bender).append(System.lineSeparator());
            }
        }
        sb.append("Monuments:");
        if (this.monuments.get(nation).isEmpty()) {
            sb.append(" None");
        } else {
            sb.append(System.lineSeparator());
            for (Monument monument : this.monuments.get(nation)) {
                sb.append(monument).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    public void war(String nation) {
        this.issuedWars.add(nation);
        double winnerPower = Double.MIN_VALUE;
        String winnerNation = "";
        for (Map.Entry<String, List<Bender>> benderEntry : this.benders.entrySet()) {
            double currentPower = benderEntry.getValue().stream().mapToDouble(Bender::getTotalPower).sum() + (((benderEntry.getValue().stream().mapToDouble(Bender::getTotalPower).sum()) / DIVIDER) * this.monuments.get(benderEntry.getKey()).stream().mapToLong(Monument::getAffinity).sum());

            if (currentPower > winnerPower) {
                winnerPower = currentPower;
                winnerNation = benderEntry.getKey();
            }
        }
        String finalWinnerNation = winnerNation;
        this.benders.entrySet().stream().filter(x -> !x.getKey().equals(finalWinnerNation)).forEach(x -> x.getValue().clear());
        this.monuments.entrySet().stream().filter(x -> !x.getKey().equals(finalWinnerNation)).forEach(x -> x.getValue().clear());
    }

    public String quit() {
        long counter = 1;
        StringBuilder sb = new StringBuilder();
        for (String issuedWar : issuedWars) {
            sb.append(String.format(STRING_FORMAT_ISSUED_WAR, counter, issuedWar)).append(System.lineSeparator());
            counter++;
        }
        return sb.toString().trim();
    }

    private void setMonuments() {
        this.monuments = new LinkedHashMap<>();
        this.monuments.put(AIR, new ArrayList<>());
        this.monuments.put(WATER, new ArrayList<>());
        this.monuments.put(FIRE, new ArrayList<>());
        this.monuments.put(EARTH, new ArrayList<>());
    }

    private void setBenders() {
        this.benders = new LinkedHashMap<>();
        this.benders.put(AIR, new ArrayList<>());
        this.benders.put(WATER, new ArrayList<>());
        this.benders.put(FIRE, new ArrayList<>());
        this.benders.put(EARTH, new ArrayList<>());
    }
}
