package se.itg.app.controller;

import se.itg.app.data.Data;

public interface Controller<D extends Data>  {

    void show();
    void hide();

    void setData(D data);
    D getData();

}