package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.core.annotations.Inject;

public class ReportCommand implements Executable {

    @Inject
    private Repository repository;

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
