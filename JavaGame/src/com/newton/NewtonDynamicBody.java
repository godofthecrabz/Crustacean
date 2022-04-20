package com.newton;

import org.joml.Matrix4f;

import com.newton.generated.Constants$root;
import com.newton.generated.Newton_h;

import jdk.incubator.foreign.*;

public class NewtonDynamicBody extends NewtonBody {
	
	protected NewtonDynamicBody(MemoryAddress address) {
		super(address, ResourceScope.newConfinedScope());
	}
	
	protected NewtonDynamicBody(MemoryAddress address, ResourceScope scope) {
		super(address, scope);
	}
	
	public static NewtonBody create(NewtonWorld world, NewtonCollision collision, Addressable matrix) {
		return new NewtonDynamicBody(Newton_h.NewtonCreateDynamicBody(world.address, collision.address, matrix));
	}
	
	public static NewtonBody create(NewtonWorld world, NewtonCollision collision, Addressable matrix, ResourceScope scope) {
		return new NewtonDynamicBody(Newton_h.NewtonCreateDynamicBody(world.address, collision.address, matrix), scope);
	}
	
	public static NewtonBody create(NewtonWorld world, NewtonCollision collision, Matrix4f matrix) {
		ResourceScope scope = ResourceScope.newConfinedScope();
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		float[] matArr = new float[16];
		matrix.get(matArr);
		MemorySegment matrixSegment = allocator.allocateArray(Newton_h.C_FLOAT, matArr);
		return create(world, collision, matrixSegment, scope);
	}
	
	public static NewtonBody create(NewtonWorld world, NewtonCollision collision, Matrix4f matrix, ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		float[] matArr = new float[16];
		matrix.get(matArr);
		MemorySegment matrixSegment = allocator.allocateArray(Newton_h.C_FLOAT, matArr);
		return create(world, collision, matrixSegment, scope);
	}
	
	protected static NewtonBody wrapImpl(MemoryAddress address) {
		return new NewtonDynamicBody(address);
	}
}
