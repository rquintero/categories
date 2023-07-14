package co.service;

import co.model.Category;

import java.util.List;

public class RecursiveCategoryManager extends AbstractCategoryManager {

    @Override
    public List<String> keywords(Category providedCategory) {
        return providedCategory.getKeywords().isEmpty()
                ? keywords(providedCategory.getParent()) : providedCategory.getKeywords();
    }

    @Override
    public int level(Category providedCategory) {
        if (providedCategory.getParent() == null) {
            return 0;
        }
        return 1 + level(providedCategory.getParent());
    }
}
