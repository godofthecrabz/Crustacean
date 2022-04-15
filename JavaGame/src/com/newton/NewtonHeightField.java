package com.newton;

import com.newton.generated.Newton_h;

import jdk.incubator.foreign.*;

public class NewtonHeightField extends NewtonCollision {
	
	private NewtonHeightField(MemoryAddress address) {
		super(address, ResourceScope.newConfinedScope());
	}
	
	private NewtonHeightField(MemoryAddress address, ResourceScope scope) {
		super(address, scope);
	}
	
	public static NewtonCollision create(NewtonWorld world, int width,  int height,  int gridsDiagonals,  int elevationdatType,  Addressable elevationMap,  Addressable attributeMap,  float verticalScale,  float horizontalScale_x,  float horizontalScale_z,  int shapeID) {
		return new NewtonHeightField(Newton_h.NewtonCreateHeightFieldCollision(world.address, width, height, gridsDiagonals, elevationdatType, elevationMap, attributeMap, verticalScale, horizontalScale_x, horizontalScale_z, shapeID));
	}
	
	public static NewtonCollision create(NewtonWorld world, int width,  int height,  int gridsDiagonals,  int elevationdatType,  Addressable elevationMap,  Addressable attributeMap,  float verticalScale,  float horizontalScale_x,  float horizontalScale_z,  int shapeID, ResourceScope scope) {
		return new NewtonHeightField(Newton_h.NewtonCreateHeightFieldCollision(world.address, width, height, gridsDiagonals, elevationdatType, elevationMap, attributeMap, verticalScale, horizontalScale_x, horizontalScale_z, shapeID), scope);
	}
}
