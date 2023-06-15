package animales.app;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        List<Perro> perros = new ArrayList<>();
        Deque<Perro> perros2 = new LinkedList<>();

        perros2.add(new animalitos.Perro("pablo", 8));

        for (int index = 0; index < perros.size(); index++) {
            perros.get(index).imprimirSonido();
        }
        while (true) {
            if (perros2.isEmpty()) {
                System.out.println("La cola esta vacia");
                break;
            } else {
                Perro miPerroActual = perros2.pop();
                miPerroActual.imprimirSonido();
            }

        }
    }
}