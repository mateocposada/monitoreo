package co.com.telematica.monitoreo.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Trafico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String trafico;

    public int getId() {
        return id;
    }

    public String getTrafico() {
        return trafico;
    }

    public void setTrafico(String trafico) {
        this.trafico = trafico;
    }
}
