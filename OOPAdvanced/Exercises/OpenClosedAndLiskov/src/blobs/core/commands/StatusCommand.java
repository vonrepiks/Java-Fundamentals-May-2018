package blobs.core.commands;

import blobs.annotations.Inject;
import blobs.interfaces.Executable;
import blobs.interfaces.Repository;
import blobs.interfaces.Writer;
import blobs.models.Blob;

public class StatusCommand implements Executable {

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Writer writer;

    @Override
    public void execute() {
        this.blobRepository
                .findAll()
                .forEach(blob -> this.writer.writeLine(blob.toString()));
    }
}
