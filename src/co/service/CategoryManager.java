package co.service;

import co.model.Category;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CategoryManager {

    private final Set<Category> tree;
    private final Category root = new Category();

    /**
     * In this constructor we instantiate collection of categories
     * and set the default keywords to root category also.
     */
    public CategoryManager() {
        tree = new HashSet<>();
        root.getKeywords().add("defaultKeyword");
        tree.add(root);
    }

    /**
     * This method sets parent to provided category and adds it to collection.
     * @param toAdd
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

    public Set<Category> getTree() {
        return tree;
    }

    public Category getRoot() {
        return root;
    }

    public List<String> keywords(Category providedCategory) {
        Category lookupCategory = providedCategory;
        List<String> ret = null;
        do {
            ret = lookupCategory.getKeywords();
            if (ret.isEmpty()) {
                lookupCategory = lookupCategory.getParent();
                continue;

            } else {
                ret = lookupCategory.getKeywords();
                break;
            }
        } while (lookupCategory.getParent() != null);
        if (ret == null || ret.isEmpty()) {
            ret = root.getKeywords();
        }
        return ret;
    }

    public int level(Category providedCategory) {
        Category lookupCategory = providedCategory;
        int ret = 0;
        while(lookupCategory.getParent() != null) {
            ret++;
            lookupCategory = lookupCategory.getParent();
        }
        return ret;
    }
}
