-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: webstore
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

# --
# -- Table structure for table `cart`
# --
#
# DROP TABLE IF EXISTS CART;
# /*!40101 SET @saved_cs_client     = @@character_set_client */;
# /*!40101 SET character_set_client = utf8 */;
# CREATE TABLE CART (
#   `ID` varchar(255) NOT NULL,
#   `GRAND_TOTAL` decimal(19,2) DEFAULT NULL,
#   PRIMARY KEY (`ID`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# /*!40101 SET character_set_client = @saved_cs_client */;
#
# --
# -- Dumping data for table `cart`
# --
#
# LOCK TABLES CART WRITE;
# /*!40000 ALTER TABLE CART DISABLE KEYS */;
# INSERT INTO CART VALUES ('9D4D910087C54ADF67C43D5C65B3D70E',1190.00);
# /*!40000 ALTER TABLE CART ENABLE KEYS */;
# UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

# DROP TABLE IF EXISTS CART_ITEM;
# /*!40101 SET @saved_cs_client     = @@character_set_client */;
# /*!40101 SET character_set_client = utf8 */;
# CREATE TABLE CART_ITEM (
#   `ID` int(11) NOT NULL AUTO_INCREMENT,
#   `QUANTITY` int(11) DEFAULT NULL,
#   `TOTAL_PRICE` decimal(19,2) DEFAULT NULL,
#   `cart_ID` varchar(255) DEFAULT NULL,
#   `product_ID` int(11) DEFAULT NULL,
#   PRIMARY KEY (`ID`),
#   KEY `FKB488ACD244789D83` (`cart_ID`),
#   KEY `FKB488ACD2BC2316F1` (`product_ID`),
#   CONSTRAINT `FKB488ACD244789D83` FOREIGN KEY (`cart_ID`) REFERENCES CART (`ID`),
#   CONSTRAINT `FKB488ACD2BC2316F1` FOREIGN KEY (`product_ID`) REFERENCES PRODUCT (`ID`)
# ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
# /*!40101 SET character_set_client = @saved_cs_client */;
#
# --
# -- Dumping data for table `cart_item`
# --
#
# LOCK TABLES CART_ITEM WRITE;
# /*!40000 ALTER TABLE CART_ITEM DISABLE KEYS */;
# INSERT INTO CART_ITEM VALUES (1,1,1190.00,'9D4D910087C54ADF67C43D5C65B3D70E',7);
# /*!40000 ALTER TABLE CART_ITEM ENABLE KEYS */;
# UNLOCK TABLES;
#
# --
# -- Table structure for table `category`
# --

DROP TABLE IF EXISTS CATEGORY;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE CATEGORY (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `REST_KEY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES CATEGORY WRITE;
/*!40000 ALTER TABLE CATEGORY DISABLE KEYS */;
INSERT INTO CATEGORY VALUES (1,'Acoustic guitars','acoustics'),(2,'Electric guitars','electrics'),(3,'Keyboards and MIDI','keys'),(4,'Drums and percussion','drums'),(5,'Amplifiers and effects','amplifiers_effects'),(6,'Accesoires','accesoires');
/*!40000 ALTER TABLE CATEGORY ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_info`
--

# DROP TABLE IF EXISTS DELIVERY_IFO;
# /*!40101 SET @saved_cs_client     = @@character_set_client */;
# /*!40101 SET character_set_client = utf8 */;
# CREATE TABLE DELIVERY_IFO (
#   `id` bigint(20) NOT NULL AUTO_INCREMENT,
#   `COUNTRY` varchar(255) DEFAULT NULL,
#   `DOOR_NUMBER` varchar(255) DEFAULT NULL,
#   `REGION_NAME` varchar(255) DEFAULT NULL,
#   `STATE` varchar(255) DEFAULT NULL,
#   `STREET_NAME` varchar(255) DEFAULT NULL,
#   `ZIP_CODE` varchar(255) DEFAULT NULL,
#   `DELIVERY_DATE` date DEFAULT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# /*!40101 SET character_set_client = @saved_cs_client */;
#
# --
# -- Dumping data for table `delivery_info`
# --
#
# LOCK TABLES DELIVERY_IFO WRITE;
# /*!40000 ALTER TABLE DELIVERY_IFO DISABLE KEYS */;
# /*!40000 ALTER TABLE DELIVERY_IFO ENABLE KEYS */;
# UNLOCK TABLES;
#
# --
# -- Table structure for table `product`
# --

DROP TABLE IF EXISTS PRODUCT;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE PRODUCT (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(1500) DEFAULT NULL,
  `MANUFACTURER` varchar(255) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `PRICE` decimal(10,2) NOT NULL,
  `UNITS_IN_STOCK` bigint(20) DEFAULT NULL,
  `CATEGORY_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK185958CFBBA2DC43` (`CATEGORY_ID`),
  CONSTRAINT `FK185958CFBBA2DC43` FOREIGN KEY (`CATEGORY_ID`) REFERENCES CATEGORY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES PRODUCT WRITE;
/*!40000 ALTER TABLE PRODUCT DISABLE KEYS */;
INSERT INTO PRODUCT VALUES (1,'From its inaugural appearance in 1937, Gibson’s SJ-200 set a standard others have been trying to match ever since. Today’s reigning “King of the Flat-tops” is the SJ-200 Standard. This super jumbo delivers a balanced, powerful sound with rich bass. It is simply the world’s most famous, and most popular, acoustic guitar.','Gibson','J-200',3799.00,50,1),(2,'The Yamaha LL16 Handcrafted acoustic guitar has a solid Engelmann Spruce top and solid Rosewood back and sides. It also features a new non-scalloped bracing design that delivers a beautiful and well-balanced tone. Choice materials and Yamaha\'s unique ability to blend traditional skills with advanced manufacturing make the Yamaha LL16 an exceptional guitar at a price that\'s hard to beat.','Yamaha','LL16',1190.00,200,1),(3,'This is no doubt where some of this guitar\'s woody \"snap\" in the highs and lows comes from. At 24.9\", the scale length on this acoustic is a touch shorter than standard. It lets the strings bend a little easier and makes for a hassle-free ride with your playing hand. The hand-fit dovetail neck joint is crucial to this guitar\'s sound and stability as well. This acoustic is perfect for anyone on the hunt for a lifelong musical companion.','Martin','000-42',5599.00,10,1),(4,'Building world class instruments with unique and exotic tonewoods is our specialty. Coupling a Redwood top with Ziricote back and sides, the Phoenix produces a smoky tone to match its silky playability. Inlayed in gold pearl, abalone and bloodwood, the mythical Phoenix rises from the ebony fingerboard, perfectly complimenting the Bloodwood binding and herringbone top purfling','Breedlove','Phoenix',5430.00,28,1),(5,'The acoustic NV360 dreadnought features a solid, hand-selected \"bear claw\" spruce which creates a rare, naturally occurring pattern. Each soundboard is individually voiced to maximize its power and dynamic range. The back and sides are solid bookmatched Indian Rosewood, chosen for both its appearance and acoustic integrity. The ebony fingerboard is fitted with nickel silver frets, leveled and finished by hand for perfect playability and intonation. The soundhole and perimeter of the top are inlaid with hundreds of pieces of beautiful abalone shell.','Takamine','NV360S',2135.00,15,1),(6,'U.S.-designed Paramount series Deluxe acoustic instruments are finely crafted and specially voiced to bring your personal artistic vision to life. Each all-solid body serves up many legacy design elements of classic ’60s models, but alongside this art deco look, Paramount instruments retain a foothold in thoroughly modern design. Long, lean and loud, Triple 0 acoustic guitars excel in any performance, with balanced tone that\'s particularly suited to classical style and soloing.','Fender','PM-3',999.00,320,1),(7,'Celestial, sparkling highs and punchy mid-register allow the Avante Gryphon to shine in a wide range of applications. Guitarists can immediately play mandolin-style parts in a new high register without learning a new tuning. As a songwriting tool, for doubling or layering in studio, and even as a compact traveling companion, the Avante Gryphon is guaranteed to inspire.','Veillette','Avante',1190.00,28,1),(8,'Everybody knows that rare, Adirondack spruce was the favored top wood on the majority of the classic, prewar guitars that are so collectible and valuable today. The luthiers at Blueridge have found a supply of this precious wood, and, when combined with the solid Indian rosewood and lavish pearl inlay of our model BR-180A, the result is the finest tone and the most elegant look that money can buy. Compare the BR-180A to any prewar OR modern guitar costing thousands more - you\'ll be amazed!','Blueridge','BR-180A',1249.00,36,1),(9,'Gibson’s J-45 True Vintage captures the original spirit of Gibson’s most popular acoustic. Nicknamed “The Workhorse” for its reliable, rock-solid construction, the J-45 True Vintage offers the build, materials, looks, and tone of this legendary guitar as it was the day it was first introduced in 1942.','Gibson','J-45',1291.00,97,1),(10,'For guitarists everywhere who appreciate great style, rich and versatile tone, and excellent value, the Standard Stratocaster is an elegant and affordable classic with a great combination of traditional design and contemporary features. Time-honored Fender style and performance-minded modern upgrades don’t have to break the bank, and this model delivers the best of both in an instrument ideal for Stratocaster players everywhere at every level.','Fender','Stratocaster',599.99,250,2),(11,'For guitarists everywhere who appreciate great style, rich and versatile tone, and excellent value, the Standard Telecaster is an elegant and affordable classic with a great combination of traditional design and contemporary features. Time-honored Fender style and performance-minded modern upgrades don’t have to break the bank, and this model delivers the best of both in an instrument ideal for Telecaster players everywhere at every level.','Fender','Telecaster',599.99,248,2),(12,'Classic looks, coil splitting and built–in Turbo Boost, in a full–bore Les Paul at an incredible price. Cream binding and pickguard, pearl trapezoid inlays, and four finish options in high-gloss nitrocellulose keep it delivering in the looks department, while a pair of Gibson’s ’61 Zebra Coil humbuckers with coil-split switching and a built-in 15 dB Turbo Boost on mini-toggle switch kick it all into the stratosphere.','Gibson','Les Paul',1999.00,120,2),(13,'The ES-355 Limited Run electric guitar makes one of the great Gibson classics of the late \'50s available again as a beautifully crafted and finished Custom Shop masterpiece. This one sports the classic Bigsby vibrato. Includes black levant hardshell case.\r\nThe Gibson ES-335 brought hollowbody tradition and solidbody performance together in 1958, and it is still one of the all-time classic guitar designs. It\'s among the most versatile guitars you can own. Classic semi-hollowbody design and dual \'57 Classic Gibson humbuckers combine to produce everything from full-bodied growls to singing sustain. ','Gibson','ES-335',2799.00,110,2),(14,'Unveiled alongside the Explorer in 1958, the Flying V was-by a long margin-the most revolutionary electric guitar of its day, and its potential was not fully appreciate until the heavy rock and metal era of the late \'60s. The Gibson Flying V 2016 T is true to the original icon with traditional features and upgraded performance.\r\n\r\n','Gibson','Flying V',1299.00,88,2),(15,'The Jackson PDX-2 Demmelition King V solidbody electric guitar is built to Machine Head axe man Phil Demmel\'s exacting specs. You get the dangerous-looking King V body shape, a 3-piece through-body maple neck topped with a bound compound-radius rosewood fingerboard with 24 jumbo frets and Jackson\'s cool shark fin inlays. Also onboard, are a pair of EMG HZ humbucking pups, two volume controls, and a 3-way blade switch. A Floyd Rose Special vibrato keeps your tuning stable, even under intense whammy action. Shred like you mean it, with the Jackson PDX-2 Demmelition King V.','Jackson','PDX-2 Demmelition King V',699.99,53,2),(16,'The Dean Cadillac 1980 is a sweet reproduction of the original Cadillac, which has appeared on stages for decades as the trusted axe of many rock legends. With a mahogany body and set-in mahogany neck, it\'s no surprise players chose the great tone and sustain the original Cadillac offered. Block pearloid inlays grace the rosewood fingerboard, and the gold hardware and multi-ply binding provide the class you\'d expect from a guitar labeled Cadillac. Uses Grover Rotomatic tuners for spot-on intonation. Three covered high-output humbuckers provide singing tone that make this guitar just as awesome now as it was when Carter was handing the White House over to Reagan.','Dean Guitars','CADI1980 CBK 3PU',452.00,15,2),(17,'The Eclipse is a solid body, single cutaway, 24.75 inch scale guitar similar in shape to a Gibson Les Paul although the body of the Eclipse is significantly thinner and lighter. Common features are Mahogany body, set neck, 24.75\" scale, EMG pickups (typically the EMG 81/60 combo), 3-way toggle, TonePros locking bridge and tailpiece, and locking tuners. ','ESP','Eclipse S-1 Python',3266.00,25,2),(18,'The Les Paul Classic-T with Min-ETune is the world\"s most affordable self-tuning electric guitar! Fast, accurate and dependable.','Epiphone','Les Paul CLASSIC-T',599.00,80,2),(19,'The Nord Piano 2 HA88 lets you play, split, and layer sounds from both the Nord Piano Library and the Nord Sample Library and features a versatile effect section, all in a portable package sporting a premium 88-note Hammer Action keybed. The Nord Piano 2 comes loaded with a selection of amazing sounds from the Nord Piano Library, our specialized library for Grand, Upright and Electrical Pianos, Clavinet and Harpsichords. ','Nord','Piano 2',4890.00,25,3),(20,'PureCF Sound Engine starts with a meticulous recording of Yamaha\'s acclaimed concert grand piano. This recording contains a number of dynamic levels from pianissimo to fortissimo, so you can experience the delicate touch of a soft passage or the pure power of two-handed chords.\r\n\r\nAt 33 inches, the YDP162 is taller than previous ARIUS models. Not only does this greater cabinet size give a more substantial upright piano look to the YDP-162, but it also helps deliver deeper piano sound acoustically.','Yamaha','Arius YDP162R',1299.00,35,3),(21,'Premium-quality effects suite – use up to 16 effects simultaneously Kronos X provides 16 internal effects to add impact to your sonic creations. Each of the 12 Insert effects can be applied to individual or multiple timbres in a combination, or to individual or multiple tracks of the sequencer. In addition, two Master effects can be applied to sends 1/2, and two Total effects can be applied to all tracks at the final stage of the sound.','Korg','Kronos X',3699.00,15,3),(22,'The Arius series digital pianos feature Yamaha\'s sophisticated AWM (Advanced Wave Memory) with Dynamic Stereo Sampling for the ultimate in instrument realism. Taken at different 3 levels of soft, medium and loud each key is comprised of multiple stereo recordings of an actual grand piano. This provides subtle differences in volume and timbre depending on how you play the keys, and gives you full expressive control over the sound. Enjoy exceptionally natural, grand piano-like touch, with realistic weight gradations-heavy in the lower end, and light in the upper.','Yamaha','YDP-160 Arius',1049.00,25,3),(23,'Given Kawai\'s deep experience in producing acoustic pianos, it is no surprise that the Kawai action is among the most highly prized in the digital piano marketplace. The feel, sound and features of the Kawai ES8 make it one of the most desirable digital pianos in its price range today.Kawai ES8 - Wherever the venue... Whatever the occasionRegardless of whether you\'e playing on stage, practicing for a recital, accompanying the church choir or studying in the classroom, the new Kawai ES8 is portable piano perfection. ','Kawai','ES8',1999.00,32,3),(24,'The new MPK Mini MKII is an ultra-compact keyboard controller designed to easily fit in the laptop-toting musician\'s backpack and still earn its spot on the desktop producer\'s crowded table space.\r\n\r\nThe MKII packs 25 slender, velocity-sensitive keys, a brand new four-way thumbstick for dynamic pitch and modulation manipulation, eight backlit velocity-sensitive MPC-style pads plus two banks, and eight assignable control knobs.','Akai Professional','MPK-mini',129.00,30,3),(25,'Enhanced with RGB LED feedback, and velocity and pressure-sensitive pads, Launchpad Pro brings limitless expression and creativity to your music. Launchpad Pro is an instrument designed for live performance. The new RGB pads light up to match the color of your clips in Ableton Live\'s session view, so you can see at a glance which clips are playing. In Scale Mode, Launchpad Pro’s pads are automatically assigned to the notes of one of 32 preset scales or modes, making it impossible to play out of key','Novation','Launchpad Pro',299.00,50,3),(26,'The MPD2 Series is a result of over six years of detailed customer research and user feedback. We asked what you wanted and took what you told us to create the most capable and user-friendly line of pad controllers Akai Professional has developed to date.\r\n\r\nIts intuitive blend of MPC controls and technologies mesh with easy USB connectivity to bring the feel of classic beat making into the world of computer music production.','Akai Professional','MPD226',199.00,2,3),(27,'In 2006, Vestax introduced the VCI-100, the world’s first professional USB MIDI controller, which fit perfectly into the upcoming demand of the computer DJ scene. The concept of flexibly controlling any DJ software and being built with Japanese parts and mechatronics technology enabled the VCI-100 to make its mark in the DJ world. Over the years, as the entire DJ scene made its shift to computer-based DJing, Vestax has been collecting suggestions and requests. The result is the VCI-100MKII.','Vestax','VCI100 Mk II',1366.70,3,3),(28,'DW\'s flagship line, the Collector\'s Series, are the original US-made custom drums. For years, drum makers have preferred maple for its resonant tonal qualities. Maple is a traditional shell material that provides low-end punch, warmth and attack. This DW Shell Pack features North American maple shells with 3-ply reinforcement hoops. Toms 8-13\" are 6-ply, while 14\" and bigger (including bass drums) are 7-ply.This shell pack features rack toms with Vertical Low Timbre (VLT) - a DW special feature which involves arranging grain patterns of shell plies so the outermost and innermost plies run vertically versus the traditional horizontal. This provides less tension on the shell for greater resonance.','DW','5-Piece Shell Pack Broken Glass',4277.00,2,4),(29,'The Yamaha DTX760K electronic drum set offers drummers the benefits and luxury of all 3-zone DTX-PADs in a more affordable kit. Utilizing the same real hi-hat controller, and large 3-zone choke-able cymbals as the 900 series, this configuration provides a realistic and comfortable feel around the entire instrument. The hi-hat and snare stand are included, so you can ideally position them as you please, and the kit can be expanded with up to two additional pads.','Yamaha','DTX 760K',3699.00,2,4),(30,'Featuring the best preselected custom options from the Masterworks realm for the best in sound and playability from each drum, Pearl Reference Series drums produce optimum pro performance for high-volume, high-capacity playing presence. Featuring the finest cuts of premium Maple, Birch, and Mahogany, each Reference drum shell features a wood, bearing edge, and hardware combination to best fit the drum\'s performance by size and application. ','Pearl ','4-PC shell pack RF924XEDP/C103',2999.00,1,4),(31,'The Sonor Player 4-Piece Shell Set incorporates 9-ply poplar shells for a warm, musical, tone that is sure to please players of all styles and skill levels. Sizes are 12 x20 Bass Drum8 x10 Tom12 x14 Floor Tom5 x14 SnareThe 12 x20 Bass Drum is extremely unique in the sense that it is the only one of its kind. The shallow depth helps give this drum a more pronounced, punchy tone while still being warm, open, and booming. ','Sonor','Player 4-Piece Shell Set',429.00,3,4),(32,'Sonor\'s Martini SE Shell Pack is a diminutive kit that enables a player to fit their acoustic jazz bossa grooves into the tightest of venues. Cross-laminated, 9-ply poplar shells output punchy tone with ample resonance. A steel snare drum provides those crisp, round tones with the ring you\'ve come to love.Triple-flange hoops will endure all the rimshots you can dish out, while Tune-Safe lugs ensure that the tuning stays in place.','Sonor','Martini 4-Piece Shell Pack ',399.00,2,4),(33,'Masters Maple Complete\'s EvenPly 6-layer premium Maple shell delivers the road-proven combination of warmth, power, and tonal purity the touring pro has come to expect from the Masters legacy. This 3-pc. shell pack includes a 22x16 bass drum, 16x16 floor tom, and 12x8 suspended tom in (#346) Vermillion Sparkle lacquer finish.','Pearl','Masters Maple Complete MCT923XSP/C346',1155.50,3,4),(34,'This dholak is made from dried shesham wood and is dark wood in color. It also comes with tuning spanner and is very easy to tune. This is a special quality dried, natural shesham color, shesham wood.','Maharaja Musicals','Dholak PDI-BBC',175.00,5,4),(35,'Tone Chime 2 Octave Chromatic Set with Case:This 25 note, chromatic Tone Chime set is perfect for classroom instruction or performance. Includes foam cutout for each bell, note name labeling and durable heavy duty travel case. Range G4 to G6.Most Innovative-Precision crafted from fine lightweight aluminum, Suzuki Tone Chimes have adjustable clapper heads for variable expression and overtone tuning for perfect harmonics.','Suzuki Music','HB-25 Tone Chime',839.00,10,4),(36,'This amazing Professional level drum is deep-carved with a rich brown and black-colored geometric pattern. It\'s headed with premium goat skins from the back of the goat, lathe-turned for uniform thickness, then followed up with lateral groove rough-surfaced carvings on interior bowl to reduce overtones. ','Mother Rhythm Drums','Geometric Professional Djembe- 19\"-20\"',139.00,50,4),(37,'Whatever your preferred instrument (guitar, bass, electric double bass), Stagg offers precise, reliable and sharp-looking amplifiers. Gain, reverb, equalization... every single function will respectfully enhance your sound.','Stagg','15 AA DR',99.99,20,5),(38,'All MG4 Carbon Series solid-state amps are innovative, highly functional and produce great tone combining years of experience in analogue amplification with cutting edge digital technology. These amps are ideal for the beginner and gigging pro alike. The carbon series offers modern looks and new features which set these amps apart from copycat brands. The MG50CFX offers 50 watts in a 1x12 combo with 4 programmable channels, effects, MP3 input and two-way footswitch included.\r\n\r\n','Marshall','MG50CFX',359.99,24,5),(39,'Limited edition MS-2J micro amp in silver. Limited edition MS-2W micro amp in white. Marshall mini amps, though small, pack a punch, are very cool, portable and no guitarist should be without one. The MS-2 looks great and sounds great for practice on the go. A fun gift and great practice amp, Marshall\'s MS-2 is the ultimate in portable battery/mains operated micro amps, packing full Marshall tone into a tiny case measuring just 14 x 11 x 6 centimeters. This mighty micro Marshall has switchable Clean and Overdrive channels, delivered with one little Marshall Watt. A single tone control lets you dial it in. Features a headphone output for rocking out in private, or even driving an external power amp.','Marshall','M-MS-2J-U',34.99,15,5),(40,'Our Frontman amps deliver quality tone at a great price, with custom-voiced built-in overdrive for great tone and the unmistakable Fender Blackface look. The 10-watt Frontman 10G features a 6-inch Special Design speaker and a selectable gain control that can rock guitar tones from tube-emulated overdrive to full-strength ultra-saturated distortion; perfect for blues, metal and the famous Fender clean tone. Closed-back design gives a heavier bass response; the 1/8-inch input lets you play along with your media player of choice; and the 1/8-inch headphone output is great for silent practicing.','Fender','Frontman 10G',59.99,30,5),(41,'The new Loud box Mini delivers the tonal quality that has made the Fishman name the standard for great acoustic sound. Never before has Fishman offered our award-winning tone in a compact, lightweight, portable and inexpensive package. You\'ll finally be able to capitalize on the profit and goodwill generated by the Fishman brand at affordable price! ','Fishman','Loudbox Mini Acoustic ',352.00,35,5),(42,'Fender, a leader in instrument manufacturing, started designing, manufacturing and evolving musical instruments in 1946. Since, Fender amplifiers have and continue to be an integral part of modern music. The Fender Acoustasonic 90 is perfect for the acoustic guitarist who needs compact, lightweight, powerful and affordable amplification, packing pure tone, great features and stage-worthy performance into a versatile and lightweight combo amp. ','Fender','Acoustasonic 90- ',299.00,25,5),(43,'The Dunlop Crybaby is the original - the one that created some of the most timeless sounds in rock. When people talk about wah pedals, they\'re talking about the Crybaby. Relied on by Jimi Hendrix, Eric Clapton, Buddy Guy, David Gilmour, and many other greats. Features: Heavy die cast construction for years of reliability, 100k ohm Hot Potz potentiometer that allows for that quick, abrupt wah sound. Powered by the Dunlop ECB-03 AC Adapter and/or 9 volt battery. The Crybaby has been a standard in the world of music since its introduction in the late 1960\'s. Its rugged construction and efficient design will give years of outstanding performance.','Dunlop','GCB95 Cry Baby',79.99,15,5),(44,'The Essential all-in-one pedal board experience, Line 6 M13 Stompbox Modeler! Featuring a comprehensive collection of the most sought-after stompbox sounds, a full-featured looper and super-heavy-duty all-metal construction, without complicated menus or presets. Line 6 M13 Stompbox Modeler channels the soul and ease of a stompbox. ','Line 6','M13 Stompbox Modeler',330.00,10,5),(45,'Here it is. The 1 stompbox for legions of crunch-craving guitarists all over the planet. This DS-1 distortion pedal is a time-proven mainstay of rock and metal tone, no doubt about it. Three knobs make way for practically every rock sound you\'ve ever heard. If you dig it loud and distorted, you\'ve simply got to have a DS-1 in your rig. And that\'s that.','BOSS Audio','DS1',49.00,100,5),(46,' On-Stage\'s best seller combines a special formula velveteen rubber with extra thick tubing. It features a removable lower stepped yoke, security strap on the upper yoke, and adjustable height. Perfect for any guitar.','OnStage','XCG4',21.95,150,6),(47,'The M-Series ATH-M40x professional monitor headphones are tuned flat for incredibly accurate audio monitoring across an extended frequency range. Your studio experience is enhanced with superior sound isolation and swiveling earcups for convenient one-ear monitoring. Engineered with pro-grade materials and robust construction, the M40x excels in professional studio tracking and mixing, as well as DJ monitoring.','Audio-Technica','ATH-M40x ',78.75,140,6),(48,'Wireless Bluetooth Headphones In-ear Design Sweatproof with Mic for iPhone Smart Phone Bluetooth Devices Come with Intelligent Charging Box (Black)','Syllable','D900MINI',25.00,110,6),(49,'For over 50 years, Ernie Ball Slinky electric guitar strings have been the favorite of musicians across the globe. Legendary artists from Eric Clapton, The Rolling Stones, Jimmy Page, AC/DC, John Petrucci, Slash, Green Day and more.','Ernie Ball','Regular Slinky Nickel Wound Sets',12.99,300,6),(50,'The American Classic Series combines tradition and Vic Firth style. With bold designs for fuller sound, the Classics are turned from select hickory, a dense wood with little flex for a more pronounced sound. Hickory is also capable of withstanding a great deal of shock, making it highly durable. Length: 16 Diameter: .570','Vic Firth','5A Drum Sticks',6.98,250,6),(51,'Guitar, Bass and Violin Tuner','Snark','SN-5',9.95,100,6),(52,'The String Swing Guitar Hanger features exclusive tubing that will not mark the finish on your instrument - Guaranteed! Its hardwood construction looks fantastic and is built to last. The yoke pivots to hold any type of headstock and is is adjustable to any width. This hanger will display wide or narrow body instruments. ','String Swing','CC01KOAK',10.99,90,6),(53,'The ergonomic design of the D\'Addario Pro-Winder makes string changes easier than ever before with it\'s built-in clippers, bridge pin puller, and peg winder all rolled into one product. The peg winder is also designed to fit on virtually all guitars, banjos, and mandolins, truly making it a must have for every instrument case','Planet Waves','Pro Winder',7.22,80,6),(54,' Nickel Wound Slinky strings consist of nickel plated steel wrapped around a tin plated high carbon steel core for a balanced tone that compliments all guitar types and playing styles.','Ernie Ball','Super Slinky Nickel Wound Set',4.40,100,6);
/*!40000 ALTER TABLE PRODUCT ENABLE KEYS */;
UNLOCK TABLES;

# --
# -- Table structure for table `shopping_order`
# --
#
# DROP TABLE IF EXISTS SHOPPING_ORDER;
# /*!40101 SET @saved_cs_client     = @@character_set_client */;
# /*!40101 SET character_set_client = utf8 */;
# CREATE TABLE SHOPPING_ORDER (
#   `ID` bigint(20) NOT NULL AUTO_INCREMENT,
#   `DELIVERY_DATE` date DEFAULT NULL,
#   `cart_ID` varchar(255) DEFAULT NULL,
#   `customer_ID` int(11) DEFAULT NULL,
#   `deliveryInfo_id` bigint(20) DEFAULT NULL,
#   PRIMARY KEY (`ID`),
#   KEY `FKCE95259744789D83` (`cart_ID`),
#   KEY `FKCE9525971E457163` (`deliveryInfo_id`),
#   KEY `FKCE95259717797043` (`customer_ID`),
#   CONSTRAINT `FKCE95259717797043` FOREIGN KEY (`customer_ID`) REFERENCES USER (`ID`),
#   CONSTRAINT `FKCE9525971E457163` FOREIGN KEY (`deliveryInfo_id`) REFERENCES DELIVERY_IFO (`id`),
#   CONSTRAINT `FKCE95259744789D83` FOREIGN KEY (`cart_ID`) REFERENCES CART (`ID`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# /*!40101 SET character_set_client = @saved_cs_client */;
#
# --
# -- Dumping data for table `shopping_order`
# --
#
# LOCK TABLES SHOPPING_ORDER WRITE;
# /*!40000 ALTER TABLE SHOPPING_ORDER DISABLE KEYS */;
# /*!40000 ALTER TABLE SHOPPING_ORDER ENABLE KEYS */;
# UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS USER;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE USER (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `DOOR_NUMBER` varchar(255) DEFAULT NULL,
  `REGION_NAME` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `STREET_NAME` varchar(255) DEFAULT NULL,
  `ZIP_CODE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `ENABLED` bit(1) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES USER WRITE;
/*!40000 ALTER TABLE USER DISABLE KEYS */;
INSERT INTO USER VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'Admin','',NULL,'Admin123',NULL,'ROLE_ADMIN'),(2,'UK','25','Che','Che','Pushok','15000','123@123.com','','Petro','123','123456','ROLE_USER');
/*!40000 ALTER TABLE USER ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-15 16:30:52
