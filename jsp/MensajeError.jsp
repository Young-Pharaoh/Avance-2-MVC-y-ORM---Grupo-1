<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mensaje de Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .error-box {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
            padding: 15px;
            color: #721c24;
        }
        .error-box h2 {
            margin-top: 0;
            color: #721c24;
        }
        .error-box p {
            margin-bottom: 0;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }
        .back-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-box">
            <h2>Error en la Operación</h2>
            <p>
                <%
                    String mensaje = (String) request.getAttribute("mensaje");
                    if (mensaje != null && !mensaje.isEmpty()) {
                        out.print(mensaje);
                    } else {
                        out.print("Se ha producido un error al procesar su solicitud. Por favor, intente nuevamente.");
                    }
                %>
            </p>
        </div>
        
        <a href="explorarCatalogo?action=listar" class="back-link">Volver al Catálogo</a>
    </div>
</body>
</html>
