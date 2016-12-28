package com.packt.webstore.exception;


public class EmailExistsException extends RuntimeException {

    private static final long serialVersionUID = -694354953032299587L;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
