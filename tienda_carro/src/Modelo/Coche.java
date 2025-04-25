
package Modelo;

public class Coche extends Vehiculo {
    private int numeroPuertas;
    private String marca;
    private String tipoCombustible;
    private String caracteristicasAdicionales;

    // Constructor
    public Coche() {
        super();
        this.numeroPuertas = 4;
        this.marca = "";
        this.tipoCombustible = "";
        this.caracteristicasAdicionales = "";
    }

    // Getter y Setter para numeroPuertas
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    // Getter y Setter para marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter y Setter para tipoCombustible
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    // Getter y Setter para caracteristicasAdicionales
    public String getCaracteristicasAdicionales() {
        return caracteristicasAdicionales;
    }

    public void setCaracteristicasAdicionales(String caracteristicasAdicionales) {
        this.caracteristicasAdicionales = caracteristicasAdicionales;
    }

    // Método para mostrar información del coche
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numeroPuertas);
        System.out.println("Marca: " + marca);
        System.out.println("Tipo de combustible: " + tipoCombustible);
        System.out.println("Características adicionales: " + caracteristicasAdicionales);
    }
}


