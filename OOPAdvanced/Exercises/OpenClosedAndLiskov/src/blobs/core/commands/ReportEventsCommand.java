package blobs.core.commands;

import blobs.annotations.Inject;
import blobs.interfaces.Executable;
import blobs.utility.MutateBoolean;

public class ReportEventsCommand implements Executable {

    @Inject
    private MutateBoolean mutateBoolean;

    @Override
    public void execute() {
        this.mutateBoolean.setFlag(true);
    }
}
