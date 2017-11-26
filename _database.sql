-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1
-- 產生時間： 2017-11-24 21:40:32
-- 伺服器版本: 10.1.28-MariaDB
-- PHP 版本： 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `test`
--

-- --------------------------------------------------------

--
-- 資料表結構 `app_users`
--

CREATE TABLE `app_users` (
  `id` int(11) NOT NULL,
  `unique_id` varchar(23) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `encrypted_password` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `salt` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `app_users`
--

INSERT INTO `app_users` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `created_at`, `updated_at`) VALUES
(1, '5a186bd4eff613.60005808', 'test', 'testes1156@1651.cc', 'JvSnQz6Snkx4YEPlSjlN0DvWuq02NTJiMWEyMTli', '652b1a219b', '2017-11-25 02:58:28', NULL),
(15, '5a186d4b4cf803.59469361', 'test', 'testes1156@165dfhds1.cc', 'Po9SAwIuRMB9kFIdAIBEJ9r2VNkyYmE1NWNlNzg3', '2ba55ce787', '2017-11-25 03:04:43', NULL),
(16, '5a186dd3ec37a2.16182497', 'test', 'testes1156@165ddgdsfhds1.cc', 'l8eD2VpQle76215JT16+4cLF/1JlNzk1MDhmMDI1', 'e79508f025', '2017-11-25 03:06:59', NULL),
(17, '5a186e07ce6270.89581446', 'test', 'testes1156@165ddgsdgsfhds1.cc', 'sZVcp7kVWyMJpP5odv7sGHR4Ek0yMWZmZTc4OTU1', '21ffe78955', '2017-11-25 03:07:51', NULL),
(18, '5a186e23f405d0.40178858', 'test', 'testes1156@165ddgsdgsdgfsfhds1.cc', '16iD7w9sQKcvOoeSbWoPaDpLhSQ4YWZmZDRmN2M5', '8affd4f7c9', '2017-11-25 03:08:19', NULL),
(19, '5a186e424ec319.40558314', 'test', 'testes1156@165ddgsgdsdgsdgfsfhds1.cc', 'KykiyhvoHXFkNAkNrj2eYxBkX25hYWU2NmFhMzM1', 'aae66aa335', '2017-11-25 03:08:50', NULL),
(20, '5a186eb2329406.92714912', 'Dhfgsdhfsd', 'fdhdshfsd@dfhdhhfdh.cc', 'EWd/26HQaTS8gdQBKVCgp22QTOY3ODBjNTY1MzQ0', '780c565344', '2017-11-25 03:10:42', NULL),
(21, '5a186fb8cc4071.31823514', 'Test', 'dfhdfhhdf@hddhdf.cc', 'DJqYDs/wyU9I9XNyW9L9a0KhtO9kODViZGY0NWQ1', 'd85bdf45d5', '2017-11-25 03:15:04', NULL),
(22, '5a187d9b1c60f7.35725889', 'Fghjgfdjdf', 'dshsdhfsd@sdfgsdgsd.cc', 'Qg9YcwobwJIK9U+TM/i1+vwTdCM0ZWJiNDg2Mzgz', '4ebb486383', '2017-11-25 04:14:19', NULL),
(23, '5a1882fd92cd46.90145883', 'etys', 'dfhdfhhdf@hddsdgsdhdf.cc', 'uG+0HyT2vxj/W4XtDttHZtbm8G0zNWUzMWFlYjU5', '35e31aeb59', '2017-11-25 04:37:17', NULL),
(24, '5a18831c33aaa6.84039198', 'Test2', '1syh56s156@165fg2h16fs.cc', 'eT1nyd4uU6lOWEUC9DM470uvYgUyZDkwN2FkNWE1', '2d907ad5a5', '2017-11-25 04:37:48', NULL);

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `app_users`
--
ALTER TABLE `app_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_id` (`unique_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `app_users`
--
ALTER TABLE `app_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
