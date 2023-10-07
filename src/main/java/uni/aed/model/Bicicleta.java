/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.model;

/**
 *
 * @author mitch
 */
public class Bicicleta {
    
    private String nompropetario;

    public Bicicleta(String nompropetario) {
        this.nompropetario = nompropetario;
    }

    public String getNompropetario() {
        return nompropetario;
    }

    public void setNompropetario(String nompropetario) {
        this.nompropetario = nompropetario;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "nompropetario=" + nompropetario + '}';
    }
    
    
    
    
}
