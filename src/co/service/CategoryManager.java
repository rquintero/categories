package co.service;

import co.model.Category;

import java.util.List;

public class CategoryManager extends AbstractCategoryManager {

    @Override
    public List<String> keywords(Category providedCategory) {
        Category lookupCategory = providedCategory;
        List<String> ret;
        do {
            ret = lookupCategory.getKeywords();
            if (ret.isEmpty()) {
                lookupCategory = lookupCategory.getParent();
            } else {
                ret = lookupCategory.getKeywords();
                break;
            }
        } while (lookupCategory.getParent() != null);
        if (ret == null || ret.isEmpty()) {
            ret = getRoot().getKeywords();
        }
        return ret;
    }

    @Override
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
