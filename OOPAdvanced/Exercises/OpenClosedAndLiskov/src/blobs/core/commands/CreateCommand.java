package blobs.core.commands;

import blobs.annotations.Inject;
import blobs.factories.AttackFactory;
import blobs.factories.BehaviorFactory;
import blobs.factories.BlobFactory;
import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.interfaces.Executable;
import blobs.interfaces.Repository;
import blobs.models.Blob;
import blobs.observers.Subject;
import blobs.utility.MutateBoolean;

public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Subject subject;

    @Inject
    private Boolean hasReportEvent;

    @Inject
    private MutateBoolean mutateBoolean;

    @Override
    public void execute() {
        String name = this.data[0];
        int health = Integer.parseInt(this.data[1]);
        int damage = Integer.parseInt(this.data[2]);
        String behaviorType = this.data[3];
        String attackType = this.data[4];

        Behavior behavior = BehaviorFactory.create(behaviorType);
        Attack attack = AttackFactory.create(attackType);

        Blob blob = BlobFactory.create(
                name,
                health,
                damage,
                behavior,
                attack,
                this.subject,
                this.mutateBoolean.getFlag());

        this.blobRepository.add(blob);
    }
}
