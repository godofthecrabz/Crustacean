package crustacean.framework.graphics;

import crustacean.framework.engine.CrustaceanWindow;
import dev.dominion.ecs.api.Dominion;

import java.util.Collection;

/**
 *
 */
public interface CrustaceanRenderer {

    void registerModel(ModelData model);
    void registerModels(ModelData... models);
    void registerModels(Collection<ModelData> models);
    ModelData removeModel(ModelData model);
    ModelData[] removeModels(ModelData... models);
    ModelData[] removeModels(Collection<ModelData> models);
    void load();
    void unload();
    void reload();
    void render(Dominion dominion, CrustaceanWindow window);
    void cleanup();
}
