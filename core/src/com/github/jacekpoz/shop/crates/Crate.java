package com.github.jacekpoz.shop.crates;

import com.github.jacekpoz.shop.skins.Skin;
import com.github.jacekpoz.upgrades.Buyable;

public abstract class Crate<T extends Skin> implements Buyable {

    private T drop;
    private int price;

    public Crate() {

    }

    @Override
    public abstract void buy();

}

