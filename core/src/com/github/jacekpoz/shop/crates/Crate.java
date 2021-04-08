package com.github.jacekpoz.shop.crates;

import com.github.jacekpoz.shop.skins.Skin;
import com.github.jacekpoz.upgrades.Buyable;

//TODO actually make this class with generics hopefully

public class Crate<S extends Skin> implements Buyable {

    private int price;

    public Crate(int p) {

        price = p;
    }

    @Override
    public void buy() {

    }

    @Override
    public long getPrice() {
        return price;
    }

}

