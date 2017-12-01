-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1
-- 產生時間： 2017-12-01 22:19:16
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
-- 資料表結構 `app_movies`
--

CREATE TABLE `app_movies` (
  `movie_id` int(31) NOT NULL,
  `movie_name` varchar(255) NOT NULL,
  `movie_detail` text NOT NULL,
  `movie_class` varchar(255) NOT NULL,
  `youtube` varchar(255) NOT NULL,
  `poster` varchar(255) NOT NULL,
  `price` int(255) NOT NULL DEFAULT '100'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 資料表的匯出資料 `app_movies`
--

INSERT INTO `app_movies` (`movie_id`, `movie_name`, `movie_detail`, `movie_class`, `youtube`, `poster`, `price`) VALUES
(1, 'Deadpool', 'A fast-talking mercenary with a morbid sense of humor is subjected to a rogue experiment that leaves him with accelerated healing powers and a quest for revenge.', 'Action, Adventure, Comedy', 'ONHBaC-pfsk', 'http://10.0.2.2/app/image/1.jpg', 100),
(2, 'Captain America: Civil War', 'Political interference in the Avengers\' activities causes a rift between former allies Captain America and Iron Man.', ' Action, Adventure, Sci-Fi ', 'dKrVegVI0Us', 'http://10.0.2.2/app/image/2.jpg', 100),
(3, 'Captain America: The Winter Soldier', 'As Steve Rogers struggles to embrace his role in the modern world, he teams up with a fellow Avenger and S.H.I.E.L.D agent, Black Widow, to battle a new threat from history: an assassin known as the Winter Soldier.', ' Action, Adventure, Sci-Fi', 'tbayiPxkUMM', 'http://10.0.2.2/app/image/3.jpg', 100),
(4, 'Jigsaw', 'Bodies are turning up around the city, each having met a uniquely gruesome demise. As the investigation proceeds, evidence points to one suspect: John Kramer, the man known as Jigsaw, who has been dead for ten years.', ' Crime, Horror, Mystery', 'vPP6aIw1vgY', 'http://10.0.2.2/app/image/4.jpg', 100),
(5, 'World War Z', 'Former United Nations employee Gerry Lane traverses the world in a race against time to stop the Zombie pandemic that is toppling armies and governments, and threatening to destroy humanity itself.', ' Action, Adventure, Horror ', 'Md6Dvxdr0AQ', 'http://10.0.2.2/app/image/5.jpg', 100),
(6, 'Salt', 'A CIA agent goes on the run after a defector accuses her of being a Russian spy.', ' Action, Crime, Mystery ', 'QZ40WlshNwU', 'http://10.0.2.2/app/image/6.jpg', 100),
(7, 'Les Mis?rables', 'In 19th-century France, Jean Valjean, who for decades has been hunted by the ruthless policeman Javert after breaking parole, agrees to care for a factory worker\'s daughter. The decision changes their lives forever.', ' Drama, History, Musical', 'IuEFm84s4oI', 'http://10.0.2.2/app/image/7.jpg', 100),
(8, 'Happy Death Day', 'A college student must relive the day of her murder over and over again, in a loop that will end only when she discovers her killer\'s identity.', ' Horror, Mystery, Thriller', '1NTaDm3atkc', 'http://10.0.2.2/app/image/8.jpg', 100),
(9, 'It: Chapter One', 'A group of bullied kids band together when a shapeshifting monster, taking the appearance of a clown, begins hunting children.', ' Drama, Horror, Thriller', 'hAUTdjf9rko', 'http://10.0.2.2/app/image/9.jpg', 100),
(10, 'Wonder Woman', 'When a pilot crashes and tells of conflict in the outside world, Diana, an Amazonian warrior in training, leaves home to fight a war, discovering her full powers and true destiny.', ' Action, Adventure, Fantasy', 'VSB4wGIdDwo', 'http://10.0.2.2/app/image/10.jpg', 100),
(11, 'Thor: Ragnarok', 'Imprisoned, the almighty Thor finds himself in a lethal gladiatorial contest against the Hulk, his former ally. Thor must fight for survival and race against time to prevent the all-powerful Hela from destroying his home and the Asgardian civilization.', ' Action, Adventure, Comedy', 'ue80QwXMRHg', 'http://10.0.2.2/app/image/11.jpg', 100),
(12, 'Batman Begins', 'After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the corruption that Scarecrow and the League of Shadows have cast upon it.', ' Action, Adventure, Thriller ', 'neY2xVmOfUM', 'http://10.0.2.2/app/image/12.jpg', 100),
(13, 'The Dark Knight', 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.', ' Action, Crime, Drama', 'EXeTwQWrcwY', 'http://10.0.2.2/app/image/13.jpg', 100),
(14, 'The Dark Knight Rises', 'Eight years after the Joker\'s reign of anarchy, the Dark Knight, with the help of the enigmatic Catwoman, is forced from his exile to save Gotham City, now on the edge of total annihilation, from the brutal guerrilla terrorist Bane.', ' Action, Thriller', 'GokKUqLcvD8', 'http://10.0.2.2/app/image/14.jpg', 100),
(15, 'Suicide Squad', 'A secret government agency recruits some of the most dangerous incarcerated super-villains to form a defensive task force. Their first mission: save the world from the apocalypse.', ' Action, Adventure, Fantasy', 'CmRih_VtVAs', 'http://10.0.2.2/app/image/15.jpg', 100),
(16, 'Justice League', 'Fueled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne enlists the help of his newfound ally, Diana Prince, to face an even greater enemy.', 'Action, Adventure, Fantasy', 'r9-DM9uBtVI', 'http://10.0.2.2/app/image/16.jpg', 100),
(17, 'Kingsman: The Secret Service', 'A spy organization recruits an unrefined, but promising street kid into the agency\'s ultra-competitive training program, just as a global threat emerges from a twisted tech genius.', ' Action, Adventure, Comedy ', 'm4NCribDx4U', 'http://10.0.2.2/app/image/17.jpg', 100),
(18, 'Kingsman: The Golden Circle', 'When their headquarters are destroyed and the world is held hostage, the Kingsman\'s journey leads them to the discovery of an allied spy organization in the US. These two elite secret organizations must band together to defeat a common enemy.', ' Action, Adventure, Comedy', '6Nxc-3WpMbg ', 'http://10.0.2.2/app/image/18.jpg', 100),
(19, 'Doctor Strange', 'While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.', ' Action, Adventure, Fantasy', 'HSzx-zryEgM', 'http://10.0.2.2/app/image/19.jpg', 100),
(20, 'Iron Man', 'After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.', ' Action, Adventure, Sci-Fi ', '8hYlB38asDY', 'http://10.0.2.2/app/image/20.jpg', 100),
(21, 'Iron Man 2', 'With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful mad man with ties to his father\'s legacy.', ' Action, Adventure, Sci-Fi ', 'BoohRoVA9WQ', 'http://10.0.2.2/app/image/21.jpg', 100),
(22, 'Iron Man 3', 'When Tony Stark\'s world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.', ' Action, Adventure, Sci-Fi ', 'Ke1Y3P9D0Bc', 'http://10.0.2.2/app/image/22.jpg', 100),
(23, 'Inception', 'A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.', ' Action, Adventure, Sci-Fi ', 'YoHD9XEInc0', 'http://10.0.2.2/app/image/23.jpg', 100),
(24, 'Fifty Shades of Grey', 'Literature student Anastasia Steele\'s life changes forever when she meets handsome, yet tormented, billionaire Christian Grey.', 'Drama, Romance, Thriller', 'SfZWFDs0LxA', 'http://10.0.2.2/app/image/24.jpg', 100),
(25, 'Fifty Shades Darker', 'While Christian wrestles with his inner demons, Anastasia must confront the anger and envy of the women who came before her.', ' Drama, Romance ', 'TUnylyz5mqQ', 'http://10.0.2.2/app/image/25.jpg', 100),
(26, 'Taken', 'A retired CIA agent travels across Europe and relies on his old skills to save his estranged daughter, who has been kidnapped while on a trip to Paris.', 'Action, Crime, Thriller ', 'uPJVJBm9TPA', 'http://10.0.2.2/app/image/26.jpg', 100),
(27, 'Taken 2', 'In Istanbul, retired CIA operative Bryan Mills and his wife are taken hostage by the father of a kidnapper Mills killed while rescuing his daughter.', 'Action, Crime, Thriller', '9FhdYOZoKcs', 'http://10.0.2.2/app/image/27.jpg', 100),
(28, 'Taken 3', 'Ex-government operative Bryan Mills is accused of a ruthless murder he never committed or witnessed. As he is tracked and pursued, Mills brings out his particular set of skills to find the true killer and clear his name.', 'Action, Crime, Thriller', 'HZaDbUofNgE', 'http://10.0.2.2/app/image/28.jpg', 100),
(29, 'American Sniper', 'Navy S.E.A.L. sniper Chris Kyle\'s pinpoint accuracy saves countless lives on the battlefield and turns him into a legend. Back home to his wife and kids after four tours of duty, however, Chris finds that it is the war he can\'t leave behind.', ' Action, Biography, Drama ', '99k3u9ay1gs', 'http://10.0.2.2/app/image/29.jpg', 100),
(30, 'Ant-Man', 'Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.', ' Action, Adventure, Comedy', 'pWdKf3MneyI', 'http://10.0.2.2/app/image/30.jpg', 100),
(31, 'Avengers: Age of Ultron', 'When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it\'s up to Earth\'s mightiest heroes to stop the villainous Ultron from enacting his terrible plan.', ' Action, Adventure, Sci-Fi?', 'tmeOjFno6Do', 'http://10.0.2.2/app/image/31.jpg', 100),
(32, 'Coco', 'Aspiring musician Miguel, confronted with his family\'s ancestral ban on music, enters the Land of the Dead to work out the mystery.', ' Animation, Adventure, Comedy ', 'Ga6RYejo6Hk', 'http://10.0.2.2/app/image/32.jpg', 100),
(33, 'Olaf\'s Frozen Adventure?', 'A Christmas-themed special featuring characters from Walt Disney Pictures\' 53rd full-length animated motion picture, Frozen (2013).', ' Animation, Short, Adventure ', 'hb8WDATVB6A', 'http://10.0.2.2/app/image/33.jpg', 100),
(34, 'Cinderella', 'When her father unexpectedly passes away, young Ella finds herself at the mercy of her cruel stepmother and her scheming step-sisters. Never one to give up hope, Ella\'s fortunes begin to change after meeting a dashing stranger.', 'Drama, Family, Fantasy', '20DF6U1HcGQ', 'http://10.0.2.2/app/image/34.jpg', 100),
(35, 'Up', 'Seventy-eight year old Carl Fredricksen travels to Paradise Falls in his home equipped with balloons, inadvertently taking a young stowaway.', ' Animation, Adventure, Comedy', 'pkqzFUhGPJg', 'http://10.0.2.2/app/image/35.jpg', 100),
(36, 'The Fast and the Furious', 'Los Angeles police officer Brian O\'Connor must decide where his loyalty really lies when he becomes enamored with the street racing world he has been sent undercover to destroy.', ' Action, Crime, Thriller', 'ZsJz2TJAPjw', 'http://10.0.2.2/app/image/36.jpg', 100),
(37, 'The Fast and the Furious: Tokyo Drift', 'A teenager becomes a major competitor in the world of drift racing after moving in with his father in Tokyo to avoid a jail sentence in America.', ' Action, Crime, Thriller', 'p8HQ2JLlc4E', 'http://10.0.2.2/app/image/37.jpg', 100),
(38, 'Fast & Furious 6', 'Hobbs has Dominic and Brian reassemble their crew to take down a team of mercenaries: Dominic unexpectedly gets convoluted also facing his presumed deceased girlfriend, Letty.', ' Action, Crime, Thriller ', 'dKi5XoeTN0k', 'http://10.0.2.2/app/image/38.jpg', 100),
(39, 'Furious 7', 'Deckard Shaw seeks revenge against Dominic Toretto and his family for his comatose brother.', ' Action, Crime, Thriller ', 'Skpu5HaVkOc', 'http://10.0.2.2/app/image/39.jpg', 100),
(40, 'The Fate of the Furious', 'When a mysterious woman seduces Dom into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.', ' Action, Adventure, Crime ', 'JwMKRevYa_M', 'http://10.0.2.2/app/image/40.jpg', 100);

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
  `money` int(11) NOT NULL DEFAULT '1000',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `app_users`
--

INSERT INTO `app_users` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `money`, `created_at`, `updated_at`) VALUES
(1, '5a186bd4eff613.60005808', 'test', 'mary', 'JvSnQz6Snkx4YEPlSjlN0DvWuq02NTJiMWEyMTli', '652b1a219b', 300, '2017-11-25 02:58:28', NULL),
(15, '5a186d4b4cf803.59469361', 'test', 'testes1156@165dfhds1.cc', 'Po9SAwIuRMB9kFIdAIBEJ9r2VNkyYmE1NWNlNzg3', '2ba55ce787', 1000, '2017-11-25 03:04:43', NULL),
(16, '5a186dd3ec37a2.16182497', 'test', 'testes1156@165ddgdsfhds1.cc', 'l8eD2VpQle76215JT16+4cLF/1JlNzk1MDhmMDI1', 'e79508f025', 1000, '2017-11-25 03:06:59', NULL),
(17, '5a186e07ce6270.89581446', 'test', 'testes1156@165ddgsdgsfhds1.cc', 'sZVcp7kVWyMJpP5odv7sGHR4Ek0yMWZmZTc4OTU1', '21ffe78955', 1000, '2017-11-25 03:07:51', NULL),
(18, '5a186e23f405d0.40178858', 'test', 'testes1156@165ddgsdgsdgfsfhds1.cc', '16iD7w9sQKcvOoeSbWoPaDpLhSQ4YWZmZDRmN2M5', '8affd4f7c9', 1000, '2017-11-25 03:08:19', NULL),
(19, '5a186e424ec319.40558314', 'test', 'testes1156@165ddgsgdsdgsdgfsfhds1.cc', 'KykiyhvoHXFkNAkNrj2eYxBkX25hYWU2NmFhMzM1', 'aae66aa335', 1000, '2017-11-25 03:08:50', NULL),
(20, '5a186eb2329406.92714912', 'Dhfgsdhfsd', 'fdhdshfsd@dfhdhhfdh.cc', 'EWd/26HQaTS8gdQBKVCgp22QTOY3ODBjNTY1MzQ0', '780c565344', 1000, '2017-11-25 03:10:42', NULL),
(21, '5a186fb8cc4071.31823514', 'Test', 'dfhdfhhdf@hddhdf.cc', 'DJqYDs/wyU9I9XNyW9L9a0KhtO9kODViZGY0NWQ1', 'd85bdf45d5', 1000, '2017-11-25 03:15:04', NULL),
(22, '5a187d9b1c60f7.35725889', 'Fghjgfdjdf', 'dshsdhfsd@sdfgsdgsd.cc', 'Qg9YcwobwJIK9U+TM/i1+vwTdCM0ZWJiNDg2Mzgz', '4ebb486383', 1000, '2017-11-25 04:14:19', NULL),
(23, '5a1882fd92cd46.90145883', 'etys', 'dfhdfhhdf@hddsdgsdhdf.cc', 'uG+0HyT2vxj/W4XtDttHZtbm8G0zNWUzMWFlYjU5', '35e31aeb59', 1000, '2017-11-25 04:37:17', NULL),
(24, '5a18831c33aaa6.84039198', 'Test2', '1syh56s156@165fg2h16fs.cc', 'eT1nyd4uU6lOWEUC9DM470uvYgUyZDkwN2FkNWE1', '2d907ad5a5', 1000, '2017-11-25 04:37:48', NULL),
(25, '5a1a73348e4700.56126184', 'Dfndjngjkdsdgasdg', 'gsunisni@iunigs.cc', 'YUXOJ0m6VEr368ziGU7MhC3vGcQ4MDdhNjIxM2Fi', '807a6213ab', 1000, '2017-11-26 15:54:28', NULL),
(26, '5a2054cd14bed0.31639793', 'sgasgsag', 'sadgasgasg', '2ktGMHtcrI1TK6VoAy3doc1oO6c3MThjNjk5Zjc1', '718c699f75', 1000, '2017-12-01 02:58:21', NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `app_user_favs`
--

CREATE TABLE `app_user_favs` (
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 資料表結構 `app_user_pays`
--

CREATE TABLE `app_user_pays` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `cart` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 資料表的匯出資料 `app_user_pays`
--

INSERT INTO `app_user_pays` (`id`, `user_id`, `movie_id`, `cart`) VALUES
(23, 5, 4, 0),
(24, 5, 8, 0),
(25, 5, 11, 0),
(26, 5, 3, 0),
(27, 0, 3, 0),
(35, 26, 4, 0),
(36, 26, 11, 0),
(37, 1, 4, 0);

-- --------------------------------------------------------

--
-- 資料表結構 `app_user_rates`
--

CREATE TABLE `app_user_rates` (
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `rates` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `app_movies`
--
ALTER TABLE `app_movies`
  ADD PRIMARY KEY (`movie_id`);

--
-- 資料表索引 `app_users`
--
ALTER TABLE `app_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_id` (`unique_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- 資料表索引 `app_user_pays`
--
ALTER TABLE `app_user_pays`
  ADD PRIMARY KEY (`id`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `app_movies`
--
ALTER TABLE `app_movies`
  MODIFY `movie_id` int(31) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- 使用資料表 AUTO_INCREMENT `app_users`
--
ALTER TABLE `app_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- 使用資料表 AUTO_INCREMENT `app_user_pays`
--
ALTER TABLE `app_user_pays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
