package main.engine.physics.collision.narrowphase;

import org.joml.Vector3f;

/**
 * ManifoldPoint collects and maintains persistent contactpoints. Used to improve
 * stability and performance of rigidbody dynamics response.
 * 
 * @author jezek2
 */
public class ManifoldPoint {

	public final Vector3f localPointA = new Vector3f();
	public final Vector3f localPointB = new Vector3f();
	public final Vector3f positionWorldOnB = new Vector3f();
	///m_positionWorldOnA is redundant information, see getPositionWorldOnA(), but for clarity
	public final Vector3f positionWorldOnA = new Vector3f();
	public final Vector3f normalWorldOnB = new Vector3f();
	
	public float distance1;
	public float combinedFriction;
	public float combinedRestitution;
	
	// BP mod, store contact triangles.
	public int partId0;
	public int partId1;
	public int index0;
	public int index1;
	
	public Object userPersistentData;
	public float appliedImpulse;
	
	public boolean lateralFrictionInitialized;
	public float appliedImpulseLateral1;
	public float appliedImpulseLateral2;
	public int lifeTime; //lifetime of the contactpoint in frames

	public final Vector3f lateralFrictionDir1 = new Vector3f();
	public final Vector3f lateralFrictionDir2 = new Vector3f();
	
	public ManifoldPoint() {
		this.userPersistentData = null;
		this.appliedImpulse = 0f;
		this.lateralFrictionInitialized = false;
		this.lifeTime = 0;
	}
	
	public ManifoldPoint(Vector3f pointA, Vector3f pointB, Vector3f normal, float distance) {
		init(pointA, pointB, normal, distance);
	}

	public void init(Vector3f pointA, Vector3f pointB, Vector3f normal, float distance) {
		this.localPointA.set(pointA);
		this.localPointB.set(pointB);
		this.normalWorldOnB.set(normal);
		this.distance1 = distance;
		this.combinedFriction = 0f;
		this.combinedRestitution = 0f;
		this.userPersistentData = null;
		this.appliedImpulse = 0f;
		this.lateralFrictionInitialized = false;
		this.appliedImpulseLateral1 = 0f;
		this.appliedImpulseLateral2 = 0f;
		this.lifeTime = 0;
	}

	public float getDistance() {
		return distance1;
	}

	public int getLifeTime() {
		return lifeTime;
	}
	
	public void set(ManifoldPoint p) {
		localPointA.set(p.localPointA);
		localPointB.set(p.localPointB);
		positionWorldOnA.set(p.positionWorldOnA);
		positionWorldOnB.set(p.positionWorldOnB);
		normalWorldOnB.set(p.normalWorldOnB);
		distance1 = p.distance1;
		combinedFriction = p.combinedFriction;
		combinedRestitution = p.combinedRestitution;
		partId0 = p.partId0;
		partId1 = p.partId1;
		index0 = p.index0;
		index1 = p.index1;
		userPersistentData = p.userPersistentData;
		appliedImpulse = p.appliedImpulse;
		lateralFrictionInitialized = p.lateralFrictionInitialized;
		appliedImpulseLateral1 = p.appliedImpulseLateral1;
		appliedImpulseLateral2 = p.appliedImpulseLateral2;
		lifeTime = p.lifeTime;
		lateralFrictionDir1.set(p.lateralFrictionDir1);
		lateralFrictionDir2.set(p.lateralFrictionDir2);
	}
	
	public Vector3f getPositionWorldOnA(Vector3f out) {
		out.set(positionWorldOnA);
		return out;
		//return m_positionWorldOnB + m_normalWorldOnB * m_distance1;
	}

	public Vector3f getPositionWorldOnB(Vector3f out) {
		out.set(positionWorldOnB);
		return out;
	}

	public void setDistance(float dist) {
		distance1 = dist;
	}
	
}