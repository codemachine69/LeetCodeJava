package leetcode;

import java.util.*;

public class FindAllPossibleRecipesfromGivenSupplies2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> available = new HashSet<>();
        for (String supply : supplies) available.add(supply);

        Queue<Integer> recipeQueue = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeQueue.add(i);
        }

        List<String> createdRecipes = new ArrayList<>();
        int lastSize = -1;

        while (available.size() > lastSize) {
            lastSize = available.size();
            int queueSize = recipeQueue.size();

            while (queueSize-- > 0) {
                int recipeIdx = recipeQueue.poll();
                boolean canCreate = true;

                for (String ingredient : ingredients.get(recipeIdx)) {
                    if (!available.contains(ingredient)) {
                        canCreate = false;
                        break;
                    }
                }

                if (!canCreate) {
                    recipeQueue.add(recipeIdx);
                } else {
                    available.add(recipes[recipeIdx]);
                    createdRecipes.add(recipes[recipeIdx]);
                }
            }
        }
        return createdRecipes;
    }
}
