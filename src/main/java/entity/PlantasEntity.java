package entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "plantas", schema = "hibernate")

public class PlantasEntity {
    private int id;
    private String nombre;
    private String especie;
    private String localizacion;


    private FamiliaEntity familia_id;


    @ManyToOne(targetEntity = FamiliaEntity.class, cascade=CascadeType.ALL)
    @JoinColumn(name="familia_id", referencedColumnName = "id")
    public FamiliaEntity getFamilia_id() {
        return familia_id;
    }

    public void setFamilia_id(FamiliaEntity familia_id) {
        this.familia_id = familia_id;
    }

    public PlantasEntity(String nombre, String especie, String localizacion) {
        this.nombre = nombre;
        this.especie = especie;
        this.localizacion = localizacion;
    }

    public PlantasEntity() {

    }

    @Override
    public String toString() {
        return "PlantasEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", localizacion='" + localizacion + '\'' +
                '}';
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "especie")
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Basic
    @Column(name = "localizacion")
    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantasEntity that = (PlantasEntity) o;
        return id == that.id && nombre.equals(that.nombre) && especie.equals(that.especie) && localizacion.equals(that.localizacion) && Objects.equals(familia_id, that.familia_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, especie, localizacion, familia_id);
    }

}
