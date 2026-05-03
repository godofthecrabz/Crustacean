package crustacean.framework.engine;

import dev.dominion.ecs.api.Dominion;
import dev.dominion.ecs.api.Entity;
import dev.dominion.ecs.api.Results;

import java.util.HashMap;
import java.util.Map;

public class DominionManager {

    private final Map<String, Dominion> dominions;

    public DominionManager() {
        this.dominions = new HashMap<>();
    }

    public boolean createDominion(String dominionName) {
        if (dominions.containsKey(dominionName)) {
            return false;
        }
        Dominion dominion = Dominion.create(dominionName);
        dominions.put(dominionName, dominion);
        return true;
    }

    public boolean destroyDominion(String dominionName) {
        if (!dominions.containsKey(dominionName)) {
            return false;
        }
        Dominion dominion = dominions.get(dominionName);
        dominions.remove(dominionName);
        dominion.close();
        return true;
    }

    public Results<Entity> findAllEntities(String dominionName) {
        if (!dominions.containsKey(dominionName)) {
            return null;
        }
        Dominion dominion = dominions.get(dominionName);
        return dominion.findAllEntities();
    }

    public <T> Results<Results.With1<T>> findEntitiesWith(String dominionName, Class<T> component) {
        if (!dominions.containsKey(dominionName)) {
            return null;
        }
        Dominion dominion = dominions.get(dominionName);
        return dominion.findEntitiesWith(component);
    }
}
