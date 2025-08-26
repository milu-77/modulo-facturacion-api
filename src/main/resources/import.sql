--INGRESO DE CLIENTES
INSERT INTO cliente (condicion_de_venta, condicioniva, cuit, domicilio, mail, razon_social, telefono) VALUES
('CONTADO', 'RESPONSABLE_INSCRIPTO', '20-12345678-9', 'Av. Corrientes 1234', 'abc@empresa.com', 'Empresa ABC S.A.', '011-4321-5678'),
 ('CONTADO', 'RESPONSABLE_INSCRIPTO', '27-87654321-0', 'Calle Florida 567', 'ventas@xyz.com', 'Comercial XYZ Ltda.', '011-4789-1234'),
('CONTADO', 'RESPONSABLE_INSCRIPTO', '30-11223344-5', 'Rivadavia 789', 'info@distribuidoranorte.com', 'Distribuidora Norte S.R.L.', '0341-456-7890'),
 ('CONTADO', 'RESPONSABLE_INSCRIPTO', '23-44556677-8', 'Belgrano 234', 'servicios@rojas.com', 'Servicios Técnicos Rojas', '011-4000-1234'),
 ('CONTADO', 'RESPONSABLE_INSCRIPTO', '24-99887766-5', 'Lavalle 876', 'importadora@sur.com.ar', 'Importadora Sur S.A.', '011-5222-3333'),
('CONTADO', 'RESPONSABLE_INSCRIPTO', '20-55443322-1', 'Av. Santa Fe 3456', 'produccion@fabricanacional.com', 'Fábrica Nacional S.A.', '011-4777-8888'),
 ('CONTADO', 'RESPONSABLE_INSCRIPTO', '27-66778899-2', 'Mitre 123', 'lopez@comercio.com', 'Comercio López e Hijos', '0343-423-4567'),
('CONTADO', 'RESPONSABLE_INSCRIPTO', '30-22334455-6', 'San Martín 654', 'logistica@transporteseste.com', 'Transportes del Este S.R.L.', '0379-444-5555'),
 ('CONTADO', 'RESPONSABLE_INSCRIPTO', '23-77889900-3', 'Sarmiento 321', 'donjose@almacen.com', 'Almacén Don José', '011-4333-2222'),
('CONTADO', 'RESPONSABLE_INSCRIPTO', '20-33445566-7', 'Av. 9 de Julio 1200', 'obras@constructoracentral.com', 'Constructora Central S.A.', '011-6000-1000');

--INGRESO DE FACTURAS
--	FECHA_EMISION  	IMPORTE_TOTAL  	NUMERO_COMPROBANTE  	PUNTO_VENTA  	TIPO  	CLIENTE_ID
INSERT INTO factura (fecha_emision, importe_total, numero_comprobante, punto_venta, tipo, cliente_id) VALUES
('2024-01-15', 12500.50, 'FAC-0001', '001', 'FACTURA_A', 1),
('2024-01-15', 8450.75, 'FAC-0002', '001', 'FACTURA_B', 2),
('2024-01-16', 3200.00, 'FAC-0003', '001', 'FACTURA_A', 3),
('2024-01-16', 15600.25, 'FAC-0004', '002', 'FACTURA_B', 1),
('2024-01-17', 9800.00, 'FAC-0005', '002', 'FACTURA_A', 4),
('2024-01-17', 4500.30, 'FAC-0006', '001', 'FACTURA_B', 5),
('2024-01-18', 12750.90, 'FAC-0007', '002', 'FACTURA_A', 2),
('2024-01-18', 6800.45, 'FAC-0008', '001', 'FACTURA_B', 3),
('2024-01-19', 9200.00, 'FAC-0009', '002', 'FACTURA_A', 4),
('2024-01-19', 11500.60, 'FAC-0010', '001', 'FACTURA_B', 5);
--INGRESO DE notas
--   	FECHA_EMISION  	IMPORTE_TOTAL  	MOTIVO  	NUMERO_NOTA  	TIPO  	FACTURA_ID
INSERT INTO nota (fecha_emision, importe_total, motivo, numero_nota, tipo, factura_id) VALUES
('2024-01-15', 12500.50, 'Devolucion producto defectuoso', 'NOT-0001', 'CREDITO', 1),
('2024-01-18', 8500.75, 'Descuento por pronto pago', 'NOT-0002', 'CREDITO', 3),
('2024-01-22', 15600.00, 'Ajuste por error en facturación', 'NOT-0003', 'DEBITO', 2),
('2024-01-25', 9200.25, 'Bonificación por fidelidad', 'NOT-0004', 'CREDITO', 5),
('2024-01-28', 13450.80, 'Cargo adicional por servicio', 'NOT-0005', 'DEBITO', 4),
('2024-02-01', 7800.00, 'Devolución parcial', 'NOT-0006', 'CREDITO', 7),
('2024-02-05', 21000.90, 'Recargo por mora', 'NOT-0007', 'DEBITO', 6),
('2024-02-10', 11500.30, 'Descuento promocional', 'NOT-0008', 'CREDITO', 8),
('2024-02-15', 16800.45, 'Ajuste de impuestos', 'NOT-0009', 'DEBITO', 9),
('2024-02-20', 9500.60, 'Compensación por demora', 'NOT-0010', 'CREDITO', 10);