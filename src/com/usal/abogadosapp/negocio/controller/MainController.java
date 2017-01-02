package com.usal.abogadosapp.negocio.controller;

import com.usal.abogadosapp.application.Main;

public abstract class MainController {

    protected Main mainApp;

    public void setMainApp(Main runner) {
        this.mainApp = runner;
    }
}
