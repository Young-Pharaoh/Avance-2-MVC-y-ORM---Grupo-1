<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Producto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catálogo de Productos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            border-bottom: 2px solid #007bff;
            padding-bottom: 10px;
        }
        .search-section {
            margin: 20px 0;
            display: flex;
            gap: 10px;
        }
        .search-section input {
            flex: 1;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .search-section button {
            padding: 8px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .search-section button:hover {
            background-color: #0056b3;
        }
        .products-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }
        .product-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            background-color: #fafafa;
            transition: box-shadow 0.3s;
        }
        .product-card:hover {
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }
        .product-card h3 {
            margin: 0 0 10px 0;
            color: #007bff;
        }
        .product-card .description {
            color: #666;
            font-size: 14px;
            margin: 10px 0;
        }
        .product-card .price {
            font-size: 18px;
            font-weight: bold;
            color: #28a745;
            margin: 10px 0;
        }
        .product-card .stock {
            color: #666;
            font-size: 14px;
        }
        .product-card .category {
            display: inline-block;
            background-color: #e9ecef;
            padding: 4px 8px;
            border-radius: 4px;
            font-size: 12px;
            margin-top: 10px;
        }
        .no-products {
            text-align: center;
            color: #666;
            padding: 40px 20px;
        }
        .info-message {
            background-color: #d1ecf1;
            border: 1px solid #bee5eb;
            color: #0c5460;
            padding: 12px;
            border-radius: 4px;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Catálogo de Productos</h1>
        
        <!-- Sección de búsqueda -->
        <div class="search-section">
            <form action="explorarCatalogo" method="GET" style="display: flex; width: 100%; gap: 10px;">
                <input type="hidden" name="action" value="buscar">
                <input type="text" name="busqueda" placeholder="Buscar producto por nombre..." required>
                <button type="submit">Buscar</button>
                <a href="explorarCatalogo?action=listar" style="padding: 8px 20px; background-color: #6c757d; color: white; border-radius: 4px; text-decoration: none;">Ver Todo</a>
            </form>
        </div>
        
        <%
            // Obtiene la lista de productos del controlador
            List<Producto> productos = (List<Producto>) request.getAttribute("productos");
            String mensaje = (String) request.getAttribute("mensaje");
            
            if (mensaje != null && !mensaje.isEmpty()) {
        %>
            <div class="info-message">
                <%= mensaje %>
            </div>
        <%
            }
            
            if (productos != null && !productos.isEmpty()) {
        %>
            <div class="products-grid">
                <%
                    for (Producto producto : productos) {
                %>
                <div class="product-card">
                    <h3><%= producto.getNombre() %></h3>
                    <p class="description"><%= producto.getDescripcion() %></p>
                    <div class="price">$<%= String.format("%.2f", producto.getPrecio()) %></div>
                    <div class="stock">Stock disponible: <%= producto.getCantidad() %> unidades</div>
                    <span class="category"><%= producto.getCategoria() %></span>
                </div>
                <%
                    }
                %>
            </div>
        <%
            } else {
        %>
            <div class="no-products">
                <p>No se encontraron productos.</p>
            </div>
        <%
            }
        %>
    </div>
</body>
</html>
