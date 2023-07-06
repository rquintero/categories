package test;

import co.model.Category;
import co.service.CategoryManager;

import static org.junit.jupiter.api.Assertions.*;

class CategoryManagerTest {

    @org.junit.jupiter.api.Test
    void keywords() {
        CategoryManager categoryManager = new CategoryManager();
        Category furniture = new Category();
        furniture.setName("Furniture");
        furniture.getKeywords().add("Furniture");
        assertTrue(categoryManager.addCategory(furniture, null));

        Category smallFurniture = new Category();
        smallFurniture.setName("smallFurniture");
        assertTrue(categoryManager.addCategory(smallFurniture, furniture));
        assertEquals(smallFurniture.getParent(), furniture);
        assertTrue(categoryManager.keywords(smallFurniture).contains("Furniture"));
        assertEquals(2, categoryManager.level(smallFurniture));
    }

    @org.junit.jupiter.api.Test
    void gettingDefaultKeywords() {
        CategoryManager categoryManager = new CategoryManager();
        Category homeApp = new Category();
        homeApp.setName("Home appliances");
        //homeApp.getKeywords().add("homeApp");
        assertTrue(categoryManager.addCategory(homeApp, null));

        Category majorApp = new Category();
        majorApp.setName("Major Appliances");
        assertTrue(categoryManager.addCategory(majorApp, homeApp));
        assertEquals(majorApp.getParent(), homeApp);
        assertFalse(categoryManager.keywords(majorApp).contains("Major Appliances"));
        assertTrue(categoryManager.keywords(majorApp).contains("defaultKeyword"));
        assertEquals(2, categoryManager.level(majorApp));
    }
}