<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle del Producto - Tienda de Vinilos</title>
<style>
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	
	body {
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
		background:  linear-gradient(135deg, #667eea 0%, #764ba2 100%);
		min-height: 100vh;
		padding: 20px;
	}
	
	.container {
		max-width: 900px;
		margin: 0 auto;
		background-color: white;
		padding: 30px;
		border-radius: 15px;
		box-shadow:  0 10px 30px rgba(0,0,0,0.3);
	}
	
	h1 {
		color: #333;
		text-align: center;
		margin-bottom: 30px;
		font-size: 2.5em;
		text-shadow: 2px 2px 4px rgba(0,0,0,0.1);
	}
	
	.nav-buttons {
		text-align: center;
		margin-bottom: 20px;
	}
	
	. btn {
		display: inline-block;
		padding: 10px 20px;
		background-color: #667eea;
		color: white;
		text-decoration: none;
		border-radius: 5px;
		transition: all 0.3s;
		margin: 0 5px;
	}
	
	.btn:hover {
		background-color: #764ba2;
		transform: translateY(-2px);
		box-shadow: 0 5px 15px rgba(0,0,0,0.2);
	}
	
	table {
		width: 100%;
		border-collapse: collapse;
		margin-top: 20px;
		box-shadow: 0 2px 10px rgba(0,0,0,0.1);
	}
	
	th {
		background:  linear-gradient(135deg, #667eea 0%, #764ba2 100%);
		color: white;
		padding: 15px;
		text-align: left;
		font-weight: bold;
		font-size: 1.1em;
	}
	
	td {
		padding: 15px;
		border-bottom: 1px solid #e0e0e0;
	}
	
	tr:last-child td {
		border-bottom: none;
	}
	
	tr:hover {
		background-color: #f8f9ff;
		transition: background-color 0.3s;
	}
	
	.producto-imagen {
		max-width: 300px;
		height: auto;
		border-radius: 10px;
		box-shadow: 0 5px 15px rgba(0,0,0,0.2);
		transition: transform 0.3s;
	}
	
	. producto-imagen:hover {
		transform: scale(1.05);
	}
	
	. disponible {
		color: #4CAF50;
		font-weight: bold;
		font-size: 1.1em;
	}
	
	.no-disponible {
		color: #f44336;
		font-weight: bold;
		font-size: 1.1em;
	}
	
	.precio {
		font-size: 24px;
		color: #667eea;
		font-weight: bold;
	}
	
	.condicion-nuevo {
		color: #4CAF50;
		font-weight: bold;
		font-size: 1.1em;
	}
	
	. condicion-usado {
		color: #FF9800;
		font-weight: bold;
		font-size: 1.1em;
	}
	
	.label {
		font-weight: bold;
		color: #555;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>🎵 Detalle del Vinilo 🎵</h1>
		
		<div class="nav-buttons">
			<a href="producto?action=lista" class="btn">← Volver al Catálogo</a>
		</div>
		
		<c:if test="${not empty producto}">
			<c:set var="detalle" value="${producto.obtenerDetalles()}" />
			
			<table>
				<tr>
					<th colspan="2" style="text-align: center;">Información del Producto</th>
				</tr>
				<tr>
					<td class="label">Imagen</td>
					<td style="text-align: center;">
						<img src="${pageContext.request.contextPath}/${detalle.imagen}" 
						     alt="Vinilo" 
						     class="producto-imagen"
						     onerror="this.src='${pageContext.request.contextPath}/images/vinilos/default.jpg'">
					</td>
				</tr>
				<tr>
					<td class="label">Descripción</td>
					<td>${detalle.descripcion}</td>
				</tr>
				<tr>
					<td class="label">Precio</td>
					<td class="precio">
						<fmt:formatNumber value="${detalle.precio}" type="currency" currencySymbol="$" />
					</td>
				</tr>
				<tr>
					<td class="label">Condición</td>
					<td>
						<c:choose>
							<c:when test="${detalle.condicion == 'nuevo'}">
								<span class="condicion-nuevo">🆕 Nuevo</span>
							</c:when>
							<c:otherwise>
								<span class="condicion-usado">♻️ Usado</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td class="label">Disponibilidad</td>
					<td>
						<c:choose>
							<c:when test="${detalle.disponibilidad}">
								<span class="disponible">✓ Disponible en Stock</span>
							</c: when>
							<c:otherwise>
								<span class="no-disponible">✗ Agotado</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</c: if>
		
		<c:if test="${empty producto}">
			<p style="text-align: center; color: #f44336; font-size: 1.2em; padding: 20px;">
				⚠️ Producto no encontrado
			</p>
		</c:if>
	</div>
</body>
</html>