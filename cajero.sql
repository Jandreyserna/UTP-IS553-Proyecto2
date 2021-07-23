-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-07-2021 a las 23:02:20
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cajero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajero`
--

CREATE TABLE `cajero` (
  `IdCajero` int(9) NOT NULL,
  `Numero` int(9) NOT NULL,
  `Sucursal` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `Cash` int(11) DEFAULT NULL,
  `D1` int(9) DEFAULT NULL,
  `D2` int(9) DEFAULT NULL,
  `D3` int(9) DEFAULT NULL,
  `D4` int(9) DEFAULT NULL,
  `D5` int(9) DEFAULT NULL,
  `State` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cajero`
--

INSERT INTO `cajero` (`IdCajero`, `Numero`, `Sucursal`, `Cash`, `D1`, `D2`, `D3`, `D4`, `D5`, `State`) VALUES
(1, 100, 'La Julita', 0, 5, 20, 100, 10, 60, 1),
(2, 101, 'Bellas Artes', 0, 10, 10, 10, 10, 10, 1),
(3, 102, 'Jorge Roa Martinez', 0, 12, 12, 12, 12, 12, 1),
(9, 103, 'Juan Camilo Ordo�ez', 498000, 20, 20, 20, 20, 20, 1),
(10, 104, 'Juan Camilo Ordo�ez', 2001000, 23, 23, 23, 23, 23, 1),
(11, 105, 'Juan Camilo Ordo�ez', 2339000, 28, 26, 24, 27, 22, 1),
(12, 106, 'Juan Camilo Buitrago', 2158000, 24, 25, 28, 26, 24, 1),
(13, 108, 'chespirito', 3534000, 50, 28, 26, 34, 22, 0),
(14, 109, 'Aeropuerto', 1653000, 19, 19, 19, 19, 19, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficinas`
--

CREATE TABLE `oficinas` (
  `IdOficina` int(9) NOT NULL,
  `Name` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `Doc` int(11) NOT NULL,
  `Pass` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `State` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `oficinas`
--

INSERT INTO `oficinas` (`IdOficina`, `Name`, `Doc`, `Pass`, `State`) VALUES
(1, 'Jandre Steven Serna Restrepo', 1088036722, 'jandreyserna', 1),
(2, 'Carlos Osorio', 10880367, '123', 1),
(3, '', 12, '2', 1),
(4, 'pablito', 108, '124', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `students`
--

CREATE TABLE `students` (
  `IdStudent` int(9) NOT NULL,
  `Name` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `Doc` int(11) NOT NULL,
  `Cash` int(9) DEFAULT NULL,
  `Pass` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `State` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `students`
--

INSERT INTO `students` (`IdStudent`, `Name`, `Doc`, `Cash`, `Pass`, `State`) VALUES
(1, 'juan diaz', 1035687, 220000, 'juandavid', 0),
(2, 'edy Serna', 1099036054, 0, '', 1),
(3, 'Sandra Milena Restrepo', 1088036721, 498000, '', 1),
(4, '', 103709812, 4000000, '6587', 1),
(5, 'Fabian Grizales', 1088098478, 1000000, '1234', 1),
(6, 'Juan Camilo Ordo�ez', 1055069, 298000, '5698', 1),
(7, 'Juan Camilo Buitrago', 108706905, 2000000, '159753', 1),
(8, 'Cesar Augusto Diaz', 1314, 11000000, '123', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valores`
--

CREATE TABLE `valores` (
  `IdCarro` int(9) NOT NULL,
  `Doc` int(11) NOT NULL,
  `Pass` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `Name` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cajero`
--
ALTER TABLE `cajero`
  ADD PRIMARY KEY (`IdCajero`);

--
-- Indices de la tabla `oficinas`
--
ALTER TABLE `oficinas`
  ADD PRIMARY KEY (`IdOficina`);

--
-- Indices de la tabla `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`IdStudent`);

--
-- Indices de la tabla `valores`
--
ALTER TABLE `valores`
  ADD PRIMARY KEY (`IdCarro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cajero`
--
ALTER TABLE `cajero`
  MODIFY `IdCajero` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `oficinas`
--
ALTER TABLE `oficinas`
  MODIFY `IdOficina` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `students`
--
ALTER TABLE `students`
  MODIFY `IdStudent` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `valores`
--
ALTER TABLE `valores`
  MODIFY `IdCarro` int(9) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
