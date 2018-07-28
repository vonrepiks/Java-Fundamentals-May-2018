package blobs.repositories;

import blobs.interfaces.Repository;
import blobs.models.Blob;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepository implements Repository<Blob> {

    private Map<String, Blob> blobs;

    public BlobRepository() {
        this.blobs = new LinkedHashMap<>();
    }

    @Override
    public void add(Blob blob) {
        this.blobs.putIfAbsent(blob.getName(), blob);
    }

    @Override
    public Blob getByName(String name) {
        return this.blobs.get(name);
    }

    @Override
    public Collection<Blob> findAll() {
        return this.blobs.values();
    }
}
