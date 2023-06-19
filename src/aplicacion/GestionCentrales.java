package aplicacion;

import java.util.ArrayList;

public class GestionCentrales {

    private ArrayList<Central> centrales;

    /**
     * Constructor de la clase GestionCentrales.
     * Inicializa la lista de centrales.
     */
    public GestionCentrales() {
        centrales = new ArrayList<>();
    }

    /**
     * Agrega una nueva central a la lista de centrales.
     * 
     * @param nombre     El nombre de la central.
     * @param produccion La producción de energía de la central.
     * @throws Exception Si la producción es negativa o si ya existe una central con el mismo nombre.
     */
    public void addCentral(String nombre, double produccion) throws Exception {

        if (produccion < 0) {
            throw new Exception("La producción no puede ser negativa");
        } else if (!existeCentral(nombre)) {
            centrales.add(new Central(nombre, produccion));
        } else {
            throw new Exception("Ya existe la central");
        }
    }

    /**
     * Verifica si existe una central con el nombre dado.
     * 
     * @param nombre El nombre de la central a buscar.
     * @return true si existe una central con el nombre dado, false en caso contrario.
     */
    private boolean existeCentral(String nombre) {
        for (Central c : centrales) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la producción máxima entre todas las centrales.
     * 
     * @return La producción máxima.
     * @throws Exception Si no hay ninguna central registrada.
     */
    public double getMaximoProduccion() throws Exception {

        if (centrales.isEmpty()) {
            throw new Exception("No hay centrales");
        } else {
            double maximo = 0;
            for (Central c : centrales) {
                if (c.getProduccion() > maximo) {
                    maximo = c.getProduccion();
                }
            }
            return maximo;
        }
    }
}


