package animales.app.animalitos;

public class Perro implements IAnimal {

    Integer edad;

    String nombre;

    public Perro(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public void imprimirSonido() {
        System.out.println("Guau Guau de parte de" + nombre);
    }

    @Override
    public int obtenerEdad() {
        return 0;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
