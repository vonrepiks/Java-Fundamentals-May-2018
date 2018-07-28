package blobs;

import blobs.core.Engine;
import blobs.interfaces.Reader;
import blobs.interfaces.Repository;
import blobs.interfaces.Runnable;
import blobs.interfaces.Writer;
import blobs.io.ConsoleInputReader;
import blobs.io.ConsoleOutputWriter;
import blobs.models.Blob;
import blobs.observers.Subject;
import blobs.repositories.BlobRepository;
import blobs.utility.MutateBoolean;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository();
        Subject subject = new Subject();
        MutateBoolean mutateBoolean = new MutateBoolean(false);

        Runnable engine = new Engine(reader, writer, blobRepository, subject, mutateBoolean);

        engine.run();
    }
}
