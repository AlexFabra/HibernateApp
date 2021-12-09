package entity;

import javax.persistence.*;

@Entity
@Table(name = "familia", schema = "hibernate")
public class FamiliaEntity {
    private int id;
    private String nombre;

    public FamiliaEntity(String nombre) {
        this.nombre = nombre;
    }

    public FamiliaEntity() { }

    @Override
    public String toString() {
        return "FamiliaEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public FamiliaEntity(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamiliaEntity that = (FamiliaEntity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

}
