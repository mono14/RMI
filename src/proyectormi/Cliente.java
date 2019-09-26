/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectormi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author Tatiana
 */
public class Cliente {

    private static Interfaz interfaz;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        try {
            Registry registro = LocateRegistry.getRegistry(2320);
            interfaz = (Interfaz) registro.lookup("//localhost/Servidor");
            int opciones = 0;
            do {
                String texto = JOptionPane.showInputDialog("ingrese una Opcion.\n"
                        + "1. Seno.\n"
                        + "2. Coseno.\n"
                        + "3. Tangente.\n"
                        + "4. Potencia.\n"
                        + "5. Logaritmo.\n"
                        + "6. Random.\n"
                        + "7. Raiz cuadrada.\n"
                        + "8. Redondeo.\n"
                        + "9. Valor absoluto.\n"
                        + "10. Exponenciacion.\n"
                );
                String Respuesta = interfaz.Opcion(texto);
                JOptionPane.showMessageDialog(null, Respuesta);
            } while (opciones != 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
