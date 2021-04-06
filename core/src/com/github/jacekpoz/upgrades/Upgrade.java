package com.github.jacekpoz.upgrades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import static com.github.jacekpoz.GlobalVars.TEXTURES_LOCATION;
import static com.github.jacekpoz.GlobalVars.UPGRADES_LOCATION;

public abstract class Upgrade implements Disposable, Buyable, Json.Serializable {

    private static final float IMAGE_SIZE = 100;

    private Texture image;
    private Sprite sprite;
    private String name;
    private String imageName;
    private long initPrice;
    protected long price;
    protected long amount;
    protected int score;

    private float imageX;
    private float imageY;
    private float textX;
    private float textY;

    public Upgrade(String fileName, String upgradeName, long initialPrice, int upgradeScore, int x, int y) {
        imageName = fileName;
        image = new Texture(Gdx.files.internal(TEXTURES_LOCATION + UPGRADES_LOCATION + fileName));

        sprite = new Sprite(image);

        imageX = x;
        imageY = y;

        sprite.setPosition(imageX, imageY);
        sprite.setSize(IMAGE_SIZE, IMAGE_SIZE);

        textX = imageX + IMAGE_SIZE / 8;
        textY = imageY - 10;
        name = upgradeName;
        initPrice = initialPrice;
        price = initialPrice;
        amount = 0;
        score = upgradeScore;
    }

    public Upgrade() {
        this("null.png", null, 0, 0, 0, 0);
    }

    public void set(Upgrade u) {
        imageName = u.imageName;
        image = new Texture(Gdx.files.internal(TEXTURES_LOCATION + UPGRADES_LOCATION + imageName));
        sprite = new Sprite(image);
        name = u.name;
        initPrice = u.initPrice;
        price = u.price;
        amount = u.amount;
        score = u.score;
        imageX = u.imageX;
        imageY = u.imageY;
        sprite.setPosition(imageX, imageY);
        sprite.setSize(IMAGE_SIZE, IMAGE_SIZE);
        textX = u.textX;
        textY = u.textY;
    }

    public abstract void buy();

    @Override
    public void write(Json json) {
        json.writeValue("texture", imageName);
        json.writeValue("name", name);
        json.writeValue("initPrice", initPrice);
        json.writeValue("price", price);
        json.writeValue("amount", amount);
        json.writeValue("score", score);
        json.writeValue("x", imageX);
        json.writeValue("y", imageY);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        imageName = jsonData.get("texture").asString();
        image = new Texture(Gdx.files.internal(TEXTURES_LOCATION + UPGRADES_LOCATION + imageName));
        sprite = new Sprite(image);
        name = jsonData.get("name").asString();
        initPrice = jsonData.get("initPrice").asLong();
        price = jsonData.get("price").asLong();
        amount = jsonData.get("amount").asLong();
        score = jsonData.get("score").asInt();
        imageX = jsonData.get("x").asFloat();
        imageY = jsonData.get("y").asFloat();
        sprite.setPosition(imageX, imageY);
        textX = imageX + IMAGE_SIZE / 8;
        textY = imageY - 10;
    }

    public void dispose() {
        image.dispose();
    }

    public long getPrice() {
        return price;
    }

    public float getTextX() {
        return textX;
    }

    public float getTextY() {
        return textY;
    }

    public String getName() {
        return name;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public String toString() {
        return name + ": " + amount + "\nCena: " + price;
    }

}
