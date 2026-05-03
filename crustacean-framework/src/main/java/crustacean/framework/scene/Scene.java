package crustacean.framework.scene;

import crustacean.framework.scene.internal.SceneImpl;
import dev.dominion.ecs.api.Entity;

public sealed interface Scene permits SceneImpl {

    Entity addStaticSceneObject(SceneObject object);

    default Entity addStaticSceneObject(String modelId) {
        return addStaticSceneObject(new SceneObject(modelId));
    }

    default Entity[] addStaticSceneObjects(String modelId, int count) {
        Entity[] entities = new Entity[count];
        for (int i = 0; i < count; i++) {
            entities[i] = addStaticSceneObject(modelId);
        }
        return entities;
    }

    default Entity addAnimatedSceneObject(String modelId, SceneObjectAnimation animation) {
        Entity entity = addStaticSceneObject(modelId);
        entity.add(animation);
        return entity;
    }

    default Entity addAnimatedSceneObject(String modelId, int maxFrames) {
        Entity entity = addStaticSceneObject(modelId);
        SceneObjectAnimation animation = new SceneObjectAnimation(false, 0, 0, maxFrames);
        entity.add(animation);
        return entity;
    }

    default Entity[] addAnimatedSceneObjects(String modelId, int maxFrames, int count) {
        Entity[] entities = new Entity[count];
        for (int i = 0; i < count; i++) {
            entities[i] = addStaticSceneObject(modelId);
            SceneObjectAnimation animation = new SceneObjectAnimation(false, 0, 0, maxFrames);
            entities[i].add(animation);
        }
        return entities;
    }
}
