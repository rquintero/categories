package co.service;

import co.model.Category;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractCategoryManager implements CategoryManagerInterface {
    private final Set<Category> tree;
    private final Category root = new Category();

    public AbstractCategoryManager() {
        tree = new HashSet<>();
        root.getKeywords().add("defaultKeyword");
        tree.add(root);
    }

    /**
     * This method sets parent to provided category and adds it to collection.
     *
     * @param toAdd Category to be added
     * @param parent if parent is null we set root parent
     * @return if element was added or not.
     */
    public boolean addCategory(Category toAdd, Category parent) {
        if (parent == null) {
            parent = root;
        }
        toAdd.setParent(parent);
        return tree.add(toAdd);
    }

    public Category getRoot() {
        return root;
    }

    public abstract List<String> keywords(Category providedCategory);

    public abstract int level(Category providedCategory);
}
