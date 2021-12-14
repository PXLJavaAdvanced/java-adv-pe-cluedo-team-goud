package be.pxl.ja;

import java.util.ArrayList;
import java.util.List;

public class Envelope<T> {
    private final List<T> secrets = new ArrayList<>();

    private void addSecret(T secret) {
        secrets.add(secret);
    }

    private void removeSecret(T secret) {
        secrets.remove(secret);
    }

    private boolean isSecret(T secret) {
        return secrets.contains(secret);
    }
}
