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

    protected static final float IMAGE_SIZE = 100;

    private Texture image;
    private Sprite sprite;
    private String name, imageName;
    protected long initPrice, price, amount;
    protected int score;
    private float imageX, imageY, textX, textY;

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

    //TODO ok I know that this is really wonky and should be changed but this is what I managed to make by myself
    // I really need to fix this

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
        sprite.setSize(IMAGE_SIZE, IMAGE_SIZE);
        textX = imageX + IMAGE_SIZE / 8;
        textY = imageY - 10;
    }

    @Override
    public void dispose() {
        image.dispose();
    }

    @Override
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

    public boolean isTouched(float x, float y) {
        return sprite.getBoundingRectangle().contains(x, y);
    }

    @Override
    public String toString() {
        return name + ": " + amount + "\nCena: " + price;
    }

}
