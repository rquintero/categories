package co.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private Category parent = null;
    private final List<String> keywords = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
