package vistas;

public class arranque {

    public static void main(String[] args) {
        /* Se instancia el objeto Frame que sera la pantalla de arranque
        al ainiciar el programa, ademas se coloca en el centro. */
        Guardar abrir = new Guardar();
        abrir.setVisible(true);
        abrir.setLocationRelativeTo(null);
    }   
}
