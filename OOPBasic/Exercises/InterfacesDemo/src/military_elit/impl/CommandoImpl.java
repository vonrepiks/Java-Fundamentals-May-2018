package military_elit.impl;

import military_elit.contracts.Commando;
import military_elit.contracts.Mission;

import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Set<Mission> missions;

    public CommandoImpl(String id, String firstName, String lastName, double salary, String corps, Set<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder commando = new StringBuilder(super.toString()).append(System.lineSeparator());

        commando
                .append("Missions:");

        for (Mission mission : this.missions) {
            commando
                    .append(System.lineSeparator())
                    .append("  " + mission);
        }

        return commando.toString();
    }
}
