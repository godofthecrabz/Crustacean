package main.engine.graphics.animation;

import main.engine.items.GameItem;
import java.util.Map;
import java.util.Optional;

public class AnimGameItem {

	private Map<String, Animation> animations;

    private Animation currentAnimation;
    
    public AnimGameItem(String id, String modelId, Map<String, Animation> animations) {
    	this.animations = animations;
        Optional<Map.Entry<String, Animation>> entry = animations.entrySet().stream().findFirst();
        currentAnimation = entry.isPresent() ? entry.get().getValue() : null;
    }

    public Animation getAnimation(String name) {
        return animations.get(name);
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    public void setCurrentAnimation(Animation currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
}