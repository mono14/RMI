/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectormi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 *
 * @author Tatiana
 */
public class Servidor extends UnicastRemoteObject implements Interfaz {

    private static final long serialVersionUID = 1L;

    protected Servidor() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException {
        try {
            Registry registro = LocateRegistry.createRegistry(2320);
            registro.rebind("//localhost/Servidor", new Servidor());
            System.err.println("El servidor esta listo");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String Opcion(String Opcion) throws RemoteException {
        System.err.println(Opcion + "is trying to contact!");
        Servidor s = new Servidor();
        return s.metodos(Opcion);
    }

    public String metodos(String numero) {
        String retorno = "";
        int base, angulo;
        switch (numero) {
            case "1"://Seno
                angulo = Integer.parseInt(JOptionPane.showInputDialog("ingrese el angulo"));
                double seno = Math.sin(angulo);
                retorno = "La solucion es: " + Math.toRadians(seno);
                break;
            case "2"://Coseno
                angulo = Integer.parseInt(JOptionPane.showInputDialog("ingrese el angulo"));
                double coseno = Math.cos(angulo);
                retorno = "La Solucion es: " + Math.toRadians(coseno);
                break;
            case "3"://Tangente
                angulo = Integer.parseInt(JOptionPane.showInputDialog("ingrese el angulo"));
                double tangente = Math.tan(angulo);
                retorno = "La Solucion es: " + Math.toRadians(tangente);
                break;
            case "4"://Potencia
                base = Integer.parseInt(JOptionPane.showInputDialog("ingrese la base"));
                int exponente = Integer.parseInt(JOptionPane.showInputDialog("ingrese el exponente"));
                retorno = "La Solucion es: " + Math.pow(base, exponente);
                break;
            case "5"://Logaritmo
                base = Integer.parseInt(JOptionPane.showInputDialog("ingrese la base"));
                retorno = "La solucion es: " + Math.log(base);
                break;
            case "6"://Random
                base = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Limite de numeros"));
                retorno = "La solucion es: " + Math.random() * base;
                break;
            case "7"://Raiz Cuadrada
                base = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero "));
                retorno = "La raiz cuadrada del numero es: " + Math.sqrt(base);
                break;
            case "8"://Redondeo
                double numeros = Double.parseDouble(JOptionPane.showInputDialog("ingrese el numero para redondear con ."));
                retorno = "el numero redondeado es: " + Math.round(numeros);
                break;
            case "9"://Valor Absoluto
                base = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor"));
                retorno = "el valor absoluto es: " + Math.abs(base);
                break;
            case "10"://Exponenciacion
                base = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero"));
                retorno = "el numero a la exponencia neperiana es: " + Math.exp(base);
                break;
            default:
                break;
        }
        return retorno;
    }
}
