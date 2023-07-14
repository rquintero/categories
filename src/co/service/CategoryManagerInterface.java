package co.service;

import co.model.Category;

import java.util.List;

public interface CategoryManagerInterface {
    List<String> keywords(Category providedCategory);

    int level(Category providedCategory);

    boolean addCategory(Category toAdd, Category parent);
}
