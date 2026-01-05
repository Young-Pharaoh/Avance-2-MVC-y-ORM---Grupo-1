<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Producto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalles del Producto</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            border-bottom: 2px solid #007bff;
            padding-bottom: 10px;
        }
        .product-details {
            display: grid;
            gap: 20px;
            margin: 30px 0;
        }
        .detail-row {
            display: flex;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #eee;
        }
        .label {
            font-weight: bold;
            color: #555;
            min-width: 150px;
        }
        .value {
            color: #333;
            flex: 1;
        }
        .price {
            font-size: 28px;
            font-weight: bold;
            color: #28a745;
            margin: 20px 0;
        }
        .stock {
            padding: 10px;
            background-color: #e9ecef;
            border-radius: 4px;
            margin: 20px 0;
        }
        .stock.available {
            background-color: #d4edda;
            color: #155724;
        }
        .stock.low {
            background-color: #fff3cd;
            color: #856404;
        }
        .category {
            display: inline-block;
            background-color: #007bff;
            color: white;
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 14px;
            margin: 10px 0;
        }
        .button-group {
            margin-top: 30px;
            display: flex;
            gap: 10px;
        }
        .button-group a, .button-group button {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
            font-size: 14px;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        .btn-secondary:hover {
            background-color: #545b62;
        }
        .btn-cart {
            background-color: #28a745;
            color: white;
        }
        .btn-cart:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            Producto producto = (Producto) request.getAttribute("producto");
            
            if (producto != null) {
        %>
            <h1><%= producto.getNombre() %></h1>
            
            <span class="category"><%= producto.getCategoria() %></span>
            
            <div class="product-details">
                <div class="detail-row">
                    <span class="label">ID:</span>
                    <span class="value"><%= producto.getId() %></span>
                </div>
                
                <div class="detail-row">
                    <span class="label">Descripción:</span>
                    <span class="value"><%= producto.getDescripcion() %></span>
                </div>
                
                <div class="detail-row">
                    <span class="label">Precio:</span>
                    <span class="value price">$<%= String.format("%.2f", producto.getPrecio()) %></span>
                </div>
                
                <div class="detail-row">
                    <span class="label">Stock disponible:</span>
                    <span class="value">
                        <% 
                            int cantidad = producto.getCantidad();
                            String stockClass = cantidad > 5 ? "available" : "low";
                        %>
                        <div class="stock <%= stockClass %>">
                            <%= cantidad %> unidades
                            <%
                                if (cantidad == 0) {
                                    out.print(" (Agotado)");
                                } else if (cantidad < 5) {
                                    out.print(" (Stock bajo)");
                                }
                            %>
                        </div>
                    </span>
                </div>
            </div>
            
            <div class="button-group">
                <% if (producto.getCantidad() > 0) { %>
                    <form action="comprar" method="POST" style="display: inline;">
                        <input type="hidden" name="producto_id" value="<%= producto.getId() %>">
                        <button type="submit" class="btn-cart">Agregar al Carrito</button>
                    </form>
                <% } %>
                <a href="explorarCatalogo?action=listar" class="btn-secondary">Volver al Catálogo</a>
            </div>
        <%
            } else {
        %>
            <div class="error-message">
                <p>El producto no fue encontrado.</p>
                <a href="explorarCatalogo?action=listar" class="btn-secondary">Volver al Catálogo</a>
            </div>
        <%
            }
        %>
    </div>
</body>
</html>
