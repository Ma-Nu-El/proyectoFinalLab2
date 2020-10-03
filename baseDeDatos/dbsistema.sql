-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-10-2020 a las 05:04:52
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbsistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio_venta` int(20) NOT NULL,
  `stock` int(11) NOT NULL,
  `descripcion` varchar(225) DEFAULT NULL,
  `imagen` varchar(50) DEFAULT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id`, `categoria_id`, `codigo`, `nombre`, `precio_venta`, `stock`, `descripcion`, `imagen`, `activo`) VALUES
(1, 1, '1111', 'Bolso Babolat Pure Aero x12', 89990, 8, 'Tamaño: 76 cm x 42 cm x 36 cm\nTres compartimentos principales\nBolsillo exterior ventilado\nSaco para zapatillas extraíble incluido.', 'Bolso Babolat Pure Aero x12.png', b'1'),
(2, 1, '1112', 'Bolso Babolat Pure Drive x12', 89990, 12, 'Tamaño: 76 cm x 42 cm x 36 cm\nBolsillo exterior ventilado\nAmplio bolsillo lateral.\nBolsillo lateral moldeado para accesorios de menor tamaño.\nSaco para zapatillas extraíble incluido.', 'Bolso Babolat Pure Drive x12.jpg', b'0'),
(3, 1, '1211', 'Bolso Head Djokovic x12 Raquetas Monstercombi', 89990, 15, 'El bolso de tenis está equipado para un compartimiento de raqueta, un bolsillo para zapatos y dos compartimentos adicionales para el almacenamiento.\nDimensiones: 56 x 29 x 38.\nCompartimiento para raqueta', 'Bolso Head Djokovic x12 Raquetas Monstercombi.jpg', b'1'),
(4, 1, '1333', 'Bolso Wilson Roger Federer 12R', 99990, 5, '2 compartimentos principales para el equipo\nPequeño bolsillo para accesorios oculto\nCorreas de mochila y asas de transporte acolchadas y ergonómicas con correa de esternón y acolchado para la espalda\n', 'BOLSO WILSON ROGER FEDERER 12R.jpg', b'1'),
(5, 1, '1222', 'Mochila Wilson Roland Garros Tour Blanca', 69990, 20, 'Contiene un compartimento con funda acolchada para portátil\n2 bolsillos laterales para botellas de agua\nCompartimento de 2 raquetas con cremalleras de cierre', 'Mochila Wilson Roland Garros Tour Blanca.jpg', b'1'),
(6, 2, '2233', 'Babolat Pure Aero', 189990, 10, 'Tamiz: 100 in² / 645 cm².\nPeso no encordada: 300 g / 10,6 oz.\nRigidez: 67.\nPatrón de encordado: 16x19', 'Babolat Pure Aero.jpg', b'1'),
(7, 2, '2244', 'Babolat Pure Drive', 189990, 9, 'Tamaño Cabeza: 100in²/645cm²\nPeso: 10.6oz/300g\nRigidez: 70\nPatrón encordado: 16x19', 'Babolat Pure Drive.jpg', b'1'),
(8, 2, '2255', 'Babolat Pure Strike', 189990, 10, 'Tamiz: 98 in² / 632 cm²\nPeso sin encordar: 305 g\nRigidez: 66\nPatrón de encordado: 18x20', 'Babolat Pure Strike.jpg', b'1'),
(9, 2, '3300', 'Head Graphene 360 Radical Pro', 189990, 8, 'Tamiz: 98 in² / 632 cm²\nPeso sin encordar: 310 g\nRigidez: 68\nPatrón de encordado:16x19', 'Head Graphene 360 Radical Pro.jpg', b'1'),
(10, 2, '3311', 'Raqueta Head Graphene 360 Instinct MP', 189990, 19, 'Tamiz: 100 in² / 645 cm²\nPeso sin encordar: 300g / 10,6oz\nRigidez: 65\nPatrón de encordado: 16x19', 'Raqueta Head Graphene 360 Instinct MP.jpg', b'1'),
(11, 2, '3322', 'Raqueta Head Graphene 360 Speed Pro', 189990, 4, 'Tamiz: 100 in² / 645 cm²\nPeso: 310 g\nRigidez: 62\nPatrón de encordado: 18x20', 'Raqueta Head Graphene 360 Speed Pro.jpg', b'1'),
(12, 2, '3355', 'Wilson Blade', 189990, 3, 'Tamiz: 98 in² / 632 cm²\nPeso sin encordar: 305 g\nPatrón de encordado: 18 x 20 \nRigidez: 62', 'Wilson Blade.jpg', b'1'),
(13, 2, '3366', 'Wilson Pro Staff Autograph', 189990, 4, 'Peso: 340 gr\nPatrón de encordado: 16×19\nTamaño Cabeza: 97 in²', 'Wilson Pro Staff Autograph.jpg', b'1'),
(14, 2, '3377', 'Wilson Ultra Tour', 189990, 2, 'Tamiz:626 cm²\nPeso sin encordar:305 g\nPatrón de encordado: 18 x 20 \nRigidez: 63', 'Wilson Ultra Tour.jpg', b'1'),
(15, 2, '4400', 'Raqueta Yonex EZONE 98 2020', 189990, 10, 'Tamiz: 98 in² / 632 cm²\nPeso sin encordar: 305 g/10,8oz\nRigidez: 64\nPatrón de encordado: 16x19', 'Raqueta Yonex EZONE 98 2020 (305g).jpg', b'1'),
(16, 2, '4411', 'Raqueta Yonex Vcore 98 Flame', 189990, 2, 'Tamiz: 98 in² / 632 cm².\nPeso sin encordar: 305 g\nRigidez: 65.\nPatrón de encordado: 16x19\n', 'Raqueta Yonex Vcore 98 Flame.jpg', b'1'),
(17, 2, '4422', 'Yonex VCORE Galaxy Black 100', 189990, 7, 'Tamiz: 100 in² / 645 cm².\nPeso sin encordar: 300 g.\nRigidez: 69.\nPatrón de encordado: 16x19', 'Yonex VCORE Galaxy Black 100.jpg', b'1'),
(18, 3, '5500', 'Rollo de Cuerdas Solinco Hyper G', 99990, 28, 'Un co-polyester de gran calidad.\nColor: Verde\nGrosor: 1.23 - 1.25 mm\nLongitud 200 metros', 'Rollo de Cuerdas Solinco Hyper G.jpg', b'1'),
(19, 3, '5511', 'Rollo Yonex Poly Tour Pro', 99990, 20, 'Color: Amarillo\nEspesor: 1.25mm\nLongitud: 200 metros\nCordaje de poliéster maleable ', 'Rollo Yonex Poly Tour Pro.jpg', b'1'),
(20, 3, '5522', 'Rollo Yonex Poly Tour Tough', 99990, 30, 'Color: Negro\nEspesor: 1.20 - 1.30\nLongitud: 200 mts', 'Rollo Yonex Poly Tour Tough.jpg', b'1'),
(21, 3, '5533', 'Polymo Hexplosion', 46990, 31, 'Polymo Hexplosion es una cuerda ultradurable de monofilamento de co-poliéster \nColor: Negro\nGrosor: 1.25 mm\nLongitud: 200 metros', 'Polymo Hexplosion.png', b'1'),
(22, 4, '6600', 'Calcetin Joma Blanco', 5990, 30, 'Calcetin Pro con un 75% Algodón 20% Poliéster 5% Elastano.\nColor: Blanco\nTalla: 38-46 EU\n\n', 'Calcetin Joma Blanco.jpg', b'1'),
(23, 4, '6611', 'Calcetin Joma Negro', 5990, 40, 'Calcetin Pro con un 75% Algodón 20% Poliéster 5% Elastano.\nColor: Negro\nTalla: 38-46 EU\n', 'Calcetin Joma Negro.jpg', b'1'),
(24, 4, '6622', 'Muñequera Joma Jumbo Blanca', 6990, 40, 'Muñequera Jumbo, contiene un 85% algodón y 15% elastano.', 'Muñequera Joma Jumbo Blanca.jpg', b'1'),
(25, 4, '6633', 'Muñequera Joma Jumbo Negra', 6990, 45, 'Muñequera Jumbo, contiene un 85% algodón y 15% elastano.\nColor: Negra', 'Muñequera Joma Jumbo Negra.png', b'1'),
(26, 4, '6655', 'Polera Joma Olimpia Azul-Blanco', 22990, 30, 'Camiseta diseñada con cuello pico en tejido base.\nTallas: S-M-L-XL\nIncluye una pieza de mesh en la parte inferior de la manga y en la axila que facilita la transpiración del sudor.\n\n', 'Polera Joma Olimpia Azul-Blanco.jpg', b'1'),
(27, 4, '6666', 'Polera Olimpia Negro Naranja', 22990, 40, 'Camiseta diseñada con cuello pico en tejido base.\nTallas: S-M-L-XL\nIncluye una pieza de mesh en la parte inferior de la manga y en la axila que facilita la transpiración del sudor.', 'Polera Olimpia Negro Naranja.jpg', b'1'),
(28, 4, '6688', 'Short Master Joma Blanco', 20990, 25, 'Tallas: S-M-L-XL.\nColor: Blanco', 'Short Master Joma Blanco.jpg', b'1'),
(29, 4, '6699', 'Short Master Joma Negro', 20990, 35, 'Tallas: S-M-L_XL.\nColor: Negro', 'Short Master Joma Negro.jpg', b'1'),
(30, 5, '7711', 'Zapatilla Asics Resolution 8 Clay', 109990, 10, 'Talla US: 10-11\nSuperficie: Arcilla\nColor: PEACOAT/WHITE\nLas zapatillas de tenis GEL-RESOLUTION™ 8 CLAY facilitan una pisada reactiva y genera una agradable sensación de proximidad a la pista. \n', 'Zapatilla Asics Resolution 8 Clay.jpg', b'1'),
(31, 5, '7722', 'Zapatilla Asics Solution Speed FF Clay', 89990, 6, 'Talla Us: 8-11.5\nSuperficie: Arcilla\nColor: Flash Coral/Black.\nLas zapatillas de tenis para hombre Solution Speed FF Clay LE son excepcionalmente reactivas, súper cómodas y ligeras. ', 'Zapatilla Asics Solution Speed FF Clay.jpg', b'1'),
(32, 5, '7733', 'Zapatilla Gel Resolution 8 Mako', 109990, 8, 'Talla US: 9.5-12\nSuperficie: Cemento\nColor: Blue-White\nLos jugadores encontrarán comodidad al pisar con la amortiguación FlyteFoam en la entresuela.', 'Zapatilla Gel Resolution 8 Mako.jpg', b'1'),
(33, 5, '7755', 'Zapatillas Hombre Wilson Kaos', 69990, 10, 'Peso: 357 gramos aprox.\nTalla Us: 7.5-11.5\nSuperficie: Arcilla\nColor: Azul / negro', 'Zapatillas Hombre Wilson Kaos.jpg', b'1'),
(34, 5, '7766', 'Zapatillas Hombre Wilson Rush Pro', 89990, 3, 'Peso: 375 gramos aprox. \nTalla US: 8-11\nSuperficie: Arcilla.\nColor: Verde Olivo', 'Zapatillas Hombre Wilson Rush Pro.jpg', b'1'),
(35, 6, '0203', 'Pantalon modelo 2', 20990, 14, 'pantalon que parece muñequera', 'Muñequera Joma Jumbo Negra.png', b'1'),
(36, 6, '22', '22', 22, 22, 's', 'Raqueta Head Graphene 360 Instinct MP.jpg', b'1'),
(37, 1, '22', 'aaaaaa', 22, 22, '22', 'azul_img.png', b'1'),
(38, 1, '22', 'aaabbb', 22, 22, '22', 'azul_img.png', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(22) NOT NULL,
  `funcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id`, `nombre`, `funcion`) VALUES
(1, 'Administrador General', 'Encargado de la planeacion y direccion de tienda'),
(2, 'Jefe de Tienda', 'Encargado del funcionamiento del personal de ventas'),
(3, 'Vendedor', 'Encargado de ventas de productos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(225) DEFAULT NULL,
  `activo` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `descripcion`, `activo`) VALUES
(1, 'Bolsos y Mochilas', 'Modelos disponibles de bolsos y mochilas por sus respectivas marcas y modelo', b'1'),
(2, 'Raquetas', 'Modelos disponibles de raquetas por sus respectivas marcas y modelo', b'1'),
(3, 'Cuerdas', 'Modelos disponibles de cuerdas por sus respectivas marcas y modelo', b'1'),
(4, 'Vestuario', 'Modelos disponibles de vestuario por sus respectivas marcas y modelo', b'1'),
(5, 'Zapatillas', 'Modelos disponibles de zapatillas por sus respectivas marcas y modelo', b'1'),
(6, 'Pantalones tenis', 'pantalones para uso en el tenis', b'1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  ADD KEY `fk_articulo_categoria_idx` (`categoria_id`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `fk_articulo_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
