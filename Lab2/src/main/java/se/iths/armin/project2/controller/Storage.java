package se.iths.armin.project2.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.iths.armin.project2.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    ObjectMapper mapper = new ObjectMapper();
    Path file = Path.of("products.json");

    public void save(List<Product> products) {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            Path tmp = file.resolveSibling(file.getFileName() + ".tmp");

            mapper.writerFor(new TypeReference<java.util.List<se.iths.armin.project2.model.Product>>() {
                    }).withDefaultPrettyPrinter()
                    .writeValue(tmp.toFile(), products);

            try {
                Files.move(tmp, file, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (java.nio.file.AtomicMoveNotSupportedException e) {
                Files.move(tmp, file, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            try {
                Files.deleteIfExists(file.resolveSibling(file.getFileName() + ".tmp"));
            } catch (IOException ignored) {
            }
            throw new RuntimeException("Failed to save products", e);
        }
    }

    public List<Product> load() {
        try {
            if (Files.notExists(file)) {
                return new ArrayList<>();
            }
            return mapper.readValue(
                    file.toFile(),
                    new TypeReference<java.util.List<se.iths.armin.project2.model.Product>>() {
                    }
            );
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
