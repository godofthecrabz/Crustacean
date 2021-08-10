package main.engine.items;

import main.engine.graphics.Material;
import main.engine.graphics.opengl.Mesh;
import main.engine.graphics.opengl.Texture;
import main.engine.loaders.obj.OBJLoader;

public class SkyBox extends GameItem {

    public SkyBox(String objModel, String textureFile) throws Exception {
        super();
        Mesh skyBoxMesh = OBJLoader.loadMesh(objModel);
        Texture skyBoxtexture = new Texture(textureFile);
        skyBoxMesh.setMaterial(new Material(skyBoxtexture, 0.0f));
        setMesh(skyBoxMesh);
        setPosition(0, 0, 0);
    }
}