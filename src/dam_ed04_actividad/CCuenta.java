/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dam_ed04_actividad;


public class CCuenta {
    
    
    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInterés;

    /**
     * Constructor sin parámetros
     */
    public CCuenta()
    {
    }
    
    /**
    * Constructor al que se le pasan los parámetros siguientes: 
    * @param nom Nombre del Cliente
    * @param cue Número de Cuenta
    * @param sal Saldo de la cuenta
    * @param tipo Tipo de Interes
    * @author Pruebas
    */
    public CCuenta(String nom, String cue, double sal, double tipo)
    {
        nombre =nom;
        cuenta=cue;
        saldo=sal;
    }
    
    /**
     * Método para asignar un nombre de cliente al objeto CCCuenta
     * @param nom String: Nombre del Cliente
     */
    public void asignarNombre(String nom)
    {
        setNombre(nom);
    }
    
    /**
     * Método que devuelve el nombre del cliente
     * @return String: Nombre del cliente
     */
    public String obtenerNombre()
    {
        return getNombre();
    }

    /**
     * Método que devuelve el saldo de la cuenta
     * @return double: cantidad de saldo
     */
    public double estado()
    {
        return getSaldo();
    }
    
    /**
     * Método para ingresar saldo en la cuenta
     * @param cantidad double: cantidad a ingresar
     * @throws Exception No se puede ingresra cantidades negativas
     */
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        setSaldo(getSaldo() + cantidad);
    }
    
    /**
     * Método para retirar saldo en la cuenta
     * @param cantidad double: cantidad a retirar
     * @throws Exception No se puede retirar cantidades negativas
     */
    public void retirar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (estado()< cantidad)
            throw new Exception ("No se hay suficiente saldo");
        setSaldo(getSaldo() - cantidad);
    }

    /**
     * Método que nos devuelve el número de cuenta
     * @return String: Número de cuenta
     */
    public String obtenerCuenta()
    {
        return getCuenta();
    }

    /**
     * Método que nos devuelve el nombre del cliente
     * @return String: Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getTipoInterés() {
        return tipoInterés;
    }


    public void setTipoInterés(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
