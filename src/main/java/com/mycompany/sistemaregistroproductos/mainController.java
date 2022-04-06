/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.sistemaregistroproductos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luis
 */
@WebServlet(name = "mainController", urlPatterns = {"/mainController"})
public class mainController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        if (ses.getAttribute("listaProd") == null) {
            ArrayList<Productos> listaux = new ArrayList<Productos>();
            ses.setAttribute("listaProd", listaux);
        }

        ArrayList<Productos> lista = (ArrayList<Productos>) ses.getAttribute("listaProd");

        String op = request.getParameter("op");
        String opcion = (op != null) ? request.getParameter("op") : "otro";

        Productos prod = new Productos();
        int cod, pos;

        if (opcion.equalsIgnoreCase("nuevo")) {
            request.setAttribute("miProducto", prod);
            request.getRequestDispatcher("agregarYeditar.jsp").forward(request, response);
        } else if (opcion.equalsIgnoreCase("editar")) {
            cod = Integer.parseInt(request.getParameter("cod"));
            pos = buscarIndice(request, cod);
            prod = lista.get(pos);
            request.setAttribute("miProducto", prod);
            request.getRequestDispatcher("agregarYeditar.jsp").forward(request, response);
        } else if (opcion.equalsIgnoreCase("eliminar")) {
            pos = buscarIndice(request, Integer.parseInt(request.getParameter("cod")));
            lista.remove(pos);
            ses.setAttribute("listaProd", lista);
            response.sendRedirect("index.jsp");
        } else if (opcion.equalsIgnoreCase("otro")) {
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<Productos> lista = (ArrayList<Productos>) ses.getAttribute("listaProd");

        Productos prod = new Productos();
        prod.setId(Integer.parseInt(request.getParameter("Id")));
        prod.setDescripcion(request.getParameter("Descripcion"));
        prod.setCantidad(Integer.parseInt(request.getParameter("Cantidad")));
        prod.setPrecio(Double.parseDouble(request.getParameter("Precio")));
        prod.setCategoria(request.getParameter("Categoria"));

        int idaux = prod.getId();
        if (idaux == 0) {
            int ultimoId = ultimoId(request);
            prod.setId(ultimoId);
            lista.add(prod);
        } else {
            lista.set(buscarIndice(request, idaux), prod);
        }
        ses.setAttribute("listaProd", lista);
        response.sendRedirect("index.jsp");
    }

    private int ultimoId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Productos> lista = (ArrayList<Productos>) ses.getAttribute("listaProd");

        int idaux1 = 0;
        for (Productos item : lista) {
            idaux1 = item.getId();
        }
        return idaux1 + 1;
    }

    private int buscarIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Productos> lista = (ArrayList<Productos>) ses.getAttribute("listaProd");

        int valor = 0;
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    valor = i;
                }
            }
        }
        return valor;
    }
}
