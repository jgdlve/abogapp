package com.usal.abogadosapp.negocio.dto;

public enum Ventanas {
	
	VentanaPrincipal("/com/usal/abogadosapp/view/panels/VentanaPrincipal.fxml", "Gestion de Expedientes y empleados"),
    Login("/com/usal/abogadosapp/view/panels/Login.fxml", "Login"), 
    PanelAbogados("/com/usal/abogadosapp/view/panels/PanelAbogados.fxml", "Gestion de Empleados"),
	PanelExpedientes("/com/usal/abogadosapp/view/panels/PanelExpedientes.fxml", "Gestion de Expedientes"),
	PanelEstadoExpediente("/com/usal/abogadosapp/view/panels/PanelEstadoExpediente.fxml", "Expediente");
	
    private String path;
    private String title;
    private Boolean isopen;

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getIsopen() {
        return isopen;
    }

    public void setIsopen(Boolean isopen) {
        this.isopen = isopen;
    }

    
    private Ventanas(String path, String title) {
        this.path = path;
        this.title = title;
        isopen = false;
    }

}
