package crustacean.framework.engine;

import crustacean.framework.graphics.CrustaceanRenderer;
import crustacean.framework.physics.CrustaceanPhysics;
import dev.dominion.ecs.api.Dominion;

/**
 * Engine of the Crustacean Framework.
 */
public final class CrustaceanEngine {

    private final Dominion dominion;
    private final CrustaceanPhysics physics;
    private final CrustaceanRenderer renderer;

    public CrustaceanEngine(CrustaceanPhysics physics, CrustaceanRenderer renderer) {
        this.dominion = Dominion.create("Engine-Dominion");
        this.physics = physics;
        this.renderer = renderer;
    }
}
