package crustacean.framework.scene.internal;

import crustacean.framework.scene.Scene;
import crustacean.framework.scene.SceneObject;
import dev.dominion.ecs.api.Dominion;
import dev.dominion.ecs.api.Entity;

public final class SceneImpl implements Scene {

    public final Dominion dominion;
    public final String title;

    public SceneImpl(Dominion dominion, String title) {
        this.dominion = dominion;
        this.title = title;
    }

    public Entity addStaticSceneObject(SceneObject object) {
        return dominion.createEntity(object);
    }
}
