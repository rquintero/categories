package test;

import co.model.Category;
import co.service.CategoryManagerInterface;
import co.service.RecursiveCategoryManager;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecursiveCategoryManagerTest {

    private CategoryManagerInterface categoryManager;
    static Logger logger = Logger.getLogger(RecursiveCategoryManagerTest.class.getName());

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        logger.info("setUp called.");
        categoryManager = new RecursiveCategoryManager();
    }

    @org.junit.jupiter.api.Test
    void keywords() {
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
        Category homeApp = new Category();
        homeApp.setName("Home appliances");
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
