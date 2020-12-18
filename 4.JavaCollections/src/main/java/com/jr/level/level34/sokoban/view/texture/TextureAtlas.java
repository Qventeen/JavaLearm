package com.jr.level.level34.sokoban.view.texture;

import com.jr.level.level34.sokoban.utils.RManager;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TextureAtlas")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextureAtlas {
    private static TextureAtlas instance;
    private static String atlasName = RManager.getPropGame("textures.atlas");
    @XmlAttribute
    private String imagePath;
    @XmlElement(name = "SubTexture")
    private List<BaseSubTexture> subTextures;

    public static TextureAtlas getInstance() {
        if (instance == null) {
            try {
                JAXBContext context = JAXBContext.newInstance(TextureAtlas.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                instance = (TextureAtlas) unmarshaller.unmarshal(TextureAtlas.class.getResource(atlasName));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<SubTexture> getSubTextures() {
        return Collections.unmodifiableList(subTextures);
    }
}

