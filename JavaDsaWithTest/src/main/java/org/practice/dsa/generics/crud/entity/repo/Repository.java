package org.practice.dsa.generics.crud.entity.repo;

import org.practice.dsa.generics.crud.entity.Product;
import org.practice.dsa.generics.crud.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository<T> {
    private final List<T> entities = new ArrayList<>();

    public void add(T entity) {
        entities.add(entity);
    }

    public List<T> getAll() {
        return entities;
    }

    public Optional<T> getById(int id) {
        for (T entity : entities) {
            if (entity instanceof User && ((User) entity).getId() == id) {
                return Optional.of(entity);
            } else if (entity instanceof Product && ((Product) entity).getProductId() == id) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    public void update(int id, T newEntity) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof User && ((User) entities.get(i)).getId() == id) {
                entities.set(i, newEntity);
                return;
            } else if (entities.get(i) instanceof Product && ((Product) entities.get(i)).getProductId() == id) {
                entities.set(i, newEntity);
                return;
            }
        }
    }

    public void delete(int id) {
        entities.removeIf(entity -> (entity instanceof User && ((User) entity).getId() == id) ||
                (entity instanceof Product && ((Product) entity).getProductId() == id));
    }
}
