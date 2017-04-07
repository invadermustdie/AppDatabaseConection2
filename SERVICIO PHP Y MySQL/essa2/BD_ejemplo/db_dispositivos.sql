-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2017 a las 00:56:36
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_dispositivos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivo`
--

CREATE TABLE `dispositivo` (
  `id` int(11) NOT NULL,
  `imei` varchar(100) NOT NULL,
  `macbt` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(200) NOT NULL,
  `dep_registro` varchar(100) NOT NULL,
  `codigo_ecom` varchar(100) NOT NULL,
  `fecha_reg` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivos2`
--

CREATE TABLE `dispositivos2` (
  `id` tinyint(10) NOT NULL,
  `imei` varchar(255) NOT NULL,
  `macbt` varchar(255) NOT NULL,
  `ecom` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `dispositivos2`
--

INSERT INTO `dispositivos2` (`id`, `imei`, `macbt`, `ecom`) VALUES
(1, '864394130922497', '50:68:0A:FE:23:8D', 1212121),
(2, '864394130922497', '50:71:0A:FE:23:8D', 21212121),
(3, '864394130922497', '50:75:0A:FE:23:8D', 2147483647),
(4, '864394130922497', '50:33:0A:FE:23:8D', 2147483647);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivo_prueba`
--

CREATE TABLE `dispositivo_prueba` (
  `id` int(30) NOT NULL,
  `imei` varchar(100) NOT NULL,
  `macbt` varchar(100) NOT NULL,
  `estado` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_ecom`
--

CREATE TABLE `lista_ecom` (
  `id` int(11) NOT NULL,
  `codigo_ecom` varchar(100) NOT NULL,
  `estado` int(11) NOT NULL,
  `cod_dispositivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `dispositivos2`
--
ALTER TABLE `dispositivos2`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `dispositivo_prueba`
--
ALTER TABLE `dispositivo_prueba`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lista_ecom`
--
ALTER TABLE `lista_ecom`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dispositivo`
--
ALTER TABLE `dispositivo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `dispositivos2`
--
ALTER TABLE `dispositivos2`
  MODIFY `id` tinyint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `dispositivo_prueba`
--
ALTER TABLE `dispositivo_prueba`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `lista_ecom`
--
ALTER TABLE `lista_ecom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
