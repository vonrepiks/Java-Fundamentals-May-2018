package blobs.core.commands;

import blobs.annotations.Inject;
import blobs.interfaces.Executable;
import blobs.interfaces.Repository;
import blobs.models.Blob;

public class AttackCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Override
    public void execute() {
        String sourceName = this.data[0];
        String targetName = this.data[1];

        Blob source = this.blobRepository.getByName(sourceName);
        Blob target = this.blobRepository.getByName(targetName);

        source.attack(target);
    }
}
