package be.pxl.ja;

import java.util.ArrayList;
import java.util.List;

public class Envelope<T> {
    private final List<T> secrets = new ArrayList<>();

    public void addSecret(T secret) {
        secrets.add(secret);
    }

    public void removeSecret(T secret) {
        secrets.remove(secret);
    }

    public boolean isSecret(T secret) {
        return secrets.contains(secret);
    }
}
