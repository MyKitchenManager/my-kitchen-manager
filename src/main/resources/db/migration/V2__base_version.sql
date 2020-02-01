ALTER TABLE inventory MODIFY expiration_date timestamp NULL NOT NULL;
ALTER TABLE recipe_details MODIFY ingredient_volume float;
ALTER TABLE inventory MODIFY inventory_volume float;

DELETE FROM recipe;
INSERT INTO `recipe` (`recipe_id`, `recipe_category`, `is_vegetarian`,`is_vegan`,`contains_diary`,`is_gluten_free`,`contributor_id`,`recipe_image_url`,`instructions`,`prep_time`,`times_cooked`)
VALUES
    ('1',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/a23/a2300a1c6b33bee0963f380782d48e27.jpg','Placeholder for now. No good data from API','0','0'),
    ('2',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/a8e/a8e6b4cd3856e78ad8f84f2a4d4ad8c3.jpg','Placeholder for now. No good data from API','150','0'),
    ('3',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/909/9092610dcd088cf92a3361a6921337ed.jpg','Placeholder for now. No good data from API','0','0'),
    ('4',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/940/940467deb43702947644245a7d9a7eed.jpg','Placeholder for now. No good data from API','0','0'),
    ('5',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/f8c/f8c0228f90eaf3225363126b1264aeb1.jpg','Placeholder for now. No good data from API','75','0'),
    ('6',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/ebd/ebdc48cd66cc9ecaa6d5e66a79a254f0.jpg','Placeholder for now. No good data from API','171','0'),
    ('7',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/b80/b8059c9d12be9f0c37e322ea2f954f3d.jpg','Placeholder for now. No good data from API','10','0'),
    ('8',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/ecc/ecc9e6ae4c16211d5c726fdafb255327.jpg','Placeholder for now. No good data from API','70','0'),
    ('9',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/072/07235b307cdb22c232119b92cdf0a37a.jpg','Placeholder for now. No good data from API','30','0'),
    ('10',NULL,'0','0','1','0',NULL,'https://www.edamam.com/web-img/692/69230ed3a6836f8d6b2671fe1d7b5cf1.jpg','Placeholder for now. No good data from API','0','0');

DELETE FROM ingredient;

INSERT INTO `ingredient` (`ingredient_id`,`ingredient_category`, `ingredient_name`, `ingredient_image_url`)
VALUES
  (1,1,'Bok Choy','https://i.ndtvimg.com/mt/cooks/2014-11/1382352986_bokchoy.jpg'),
  (2,1,'Snake Beans','https://i.ndtvimg.com/i/2014-11/snake-beans_625x300_71416569505.jpg'),
  (3,1,'Sorrel Leaves','https://i.ndtvimg.com/i/2014-11/sorrel-leaves_625x300_81416569353.jpg'),
  (4,1,'Rocket Leaves','https://i.ndtvimg.com/i/2014-11/rocket-leaves_625x300_61416560403.jpg'),
  (5,1,'Drumstick','https://i.ndtvimg.com/mt/cooks/2014-11/1377864763_drumsticks.jpg'),
  (6,1,'Cherry Tomatoes','https://i.ndtvimg.com/i/2014-11/cherry-tomatoes_625x300_61416570122.jpg'),
  (7,1,'Kaffir Lime','https://i.ndtvimg.com/i/2014-11/kaffir-lime_625x300_61416569741.jpg'),
  (8,1,'Plantain','https://i.ndtvimg.com/mt/cooks/2014-11/1372152620_plantain.jpg'),
  (9,1,'Turnip','https://i.ndtvimg.com/mt/cooks/2014-11/turnip-shalgam.jpg'),
  (10,1,'Sweet Potatoes','https://i.ndtvimg.com/mt/cooks/2014-11/sweet-potato-shakarkandi.jpg'),
  (11,1,'Round Gourd','https://i.ndtvimg.com/mt/cooks/2014-11/tinda.jpg'),
  (12,1,'Ridge Gourd','https://i.ndtvimg.com/mt/cooks/2014-11/ridge-gourd-torai.jpg'),
  (13,1,'Pimiento','https://i.ndtvimg.com/mt/cooks/2014-11/pimento.jpg'),
  (14,1,'Spinach','https://i.ndtvimg.com/mt/cooks/2014-11/spinach-palak.jpg'),
  (15,1,'Onion','https://i.ndtvimg.com/mt/cooks/2014-11/1378802129_onions_med.jpg'),
  (16,1,'Mustard Leaves','https://i.ndtvimg.com/mt/cooks/2014-11/mustard-leaves.jpg'),
  (17,1,'Mushroom','https://i.ndtvimg.com/mt/cooks/2014-11/mushrooms.jpg'),
  (18,1,'Radish','https://i.ndtvimg.com/mt/cooks/2014-11/radish.jpg'),
  (19,1,'Shallots','https://i.ndtvimg.com/mt/cooks/2014-11/madrasi-onions.jpg'),
  (20,1,'Lettuce','https://i.ndtvimg.com/mt/cooks/2014-11/lettuce.jpg'),
  (21,1,'Leek','https://i.ndtvimg.com/mt/cooks/2014-11/leek.jpg'),
  (22,1,'Pumpkin','https://i.ndtvimg.com/mt/cooks/2014-11/pumpkin-kaddu.jpg'),
  (23,1,'Yam','https://i.ndtvimg.com/mt/cooks/2014-11/yam-zimikand.jpg'),
  (24,1,'Jalapeno','https://i.ndtvimg.com/mt/cooks/2014-11/jalapeno.jpg'),
  (25,1,'Jackfruit','https://i.ndtvimg.com/mt/cooks/2014-11/1372323351_kathal.jpg'),
  (26,1,'Horseradish','https://i.ndtvimg.com/mt/cooks/2014-11/horseradish.jpg'),
  (27,1,'Spring Onion','https://i.ndtvimg.com/mt/cooks/2014-11/spring-onions.jpg'),
  (28,1,'Green Peas','https://i.ndtvimg.com/mt/cooks/2014-11/peas-matar.jpg'),
  (29,1,'Green Chillies','https://i.ndtvimg.com/mt/cooks/2014-11/green-chillies.jpg'),
  (30,1,'Cluster Beans','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (31,1,'Gherkins','https://i.ndtvimg.com/mt/cooks/2014-11/gherkins.jpg'),
  (32,1,'Garlic','https://i.ndtvimg.com/mt/cooks/2014-11/garlic.jpg'),
  (33,1,'French Beans','https://i.ndtvimg.com/mt/cooks/2014-11/frans-beans.jpg'),
  (34,1,'Fenugreek','https://i.ndtvimg.com/mt/cooks/2014-11/fenugreek.jpg'),
  (35,1,'Cucumber','https://i.ndtvimg.com/mt/cooks/2014-11/cucumber.jpg'),
  (36,1,'Zucchini','https://i.ndtvimg.com/mt/cooks/2014-11/courgettes-zucchini.jpg'),
  (37,1,'Corn','https://i.ndtvimg.com/i/2015-04/corn_240x180_81428306138.jpg'),
  (38,1,'Shiitake Mushroom','https://i.ndtvimg.com/mt/cooks/2014-11/1375095515_shiitake.jpg'),
  (39,1,'Celery','https://i.ndtvimg.com/mt/cooks/2014-11/celery.jpg'),
  (40,1,'Cauliflower','https://i.ndtvimg.com/mt/cooks/2014-11/cauliflower.jpg'),
  (41,1,'Carrot','https://i.ndtvimg.com/mt/cooks/2014-11/carrots.jpg'),
  (42,1,'Capsicum','https://i.ndtvimg.com/mt/cooks/2014-11/capsicum.jpg'),
  (43,1,'Capers','https://i.ndtvimg.com/mt/cooks/2014-11/capers.jpg'),
  (44,1,'Broccoli','https://i.ndtvimg.com/mt/cooks/2014-11/broccoli.jpg'),
  (45,1,'Broad Beans','https://i.ndtvimg.com/mt/cooks/2014-11/broad-beans-sem.jpg'),
  (46,1,'Bottle Gourd','https://i.ndtvimg.com/mt/cooks/2014-11/bottle-gourd.jpg'),
  (47,1,'Bitter Gourd','https://i.ndtvimg.com/mt/cooks/2014-11/bitter-gourd.jpg'),
  (48,1,'Lady Finger','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (49,1,'Lotus Stem','https://i.ndtvimg.com/mt/cooks/2014-11/lotus-root.jpg'),
  (50,1,'Bell Pepper','https://i.ndtvimg.com/mt/cooks/2014-11/bell-pepper.jpg'),
  (51,1,'Beetroot','https://i.ndtvimg.com/mt/cooks/2014-11/beetroot.jpg'),
  (52,1,'Pigweed','https://i.ndtvimg.com/mt/cooks/2014-11/bathua.jpg'),
  (53,1,'Cabbage','https://i.ndtvimg.com/mt/cooks/2014-11/cabbage.jpg'),
  (54,1,'Bamboo Shoot','https://i.ndtvimg.com/mt/cooks/2014-11/bamboo-shoot.jpg'),
  (55,1,'Baby Corn','https://i.ndtvimg.com/i/2014-11/baby-corn-corn_625x300_51416555719.jpg'),
  (56,1,'Avocado','https://i.ndtvimg.com/mt/cooks/2014-11/avocado.jpg'),
  (57,1,'Eggplant','https://i.ndtvimg.com/mt/cooks/2014-11/aubergine.jpg'),
  (58,1,'Asparagus','https://i.ndtvimg.com/mt/cooks/2014-11/asparagus.jpg'),
  (59,1,'Ash Gourd','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (60,1,'Artichoke','https://i.ndtvimg.com/mt/cooks/2014-11/artichoke.jpg'),
  (61,1,'Colocasia','https://i.ndtvimg.com/mt/cooks/2014-11/Colocasia.jpg'),
  (62,1,'Potatoes','https://i.ndtvimg.com/mt/cooks/2014-11/potatoes-aloo.jpg'),
  (63,1,'Ginger','https://i.ndtvimg.com/mt/cooks/2014-11/ginger.jpg'),
  (64,2,'Coriander Powder','https://i.ndtvimg.com/i/2014-11/coriander-powder_625x300_61416570200.jpg'),
  (65,2,'Chives','https://i.ndtvimg.com/mt/cooks/2014-11/1377755809_chives.jpg'),
  (66,2,'Galangal','https://i.ndtvimg.com/mt/cooks/2014-11/1368690905_galangal_ing.jpg'),
  (67,2,'Tulsi','https://i.ndtvimg.com/mt/cooks/2014-11/tulsi-holy-basil.jpg'),
  (68,2,'Sage','https://i.ndtvimg.com/mt/cooks/2014-11/1381121563_sage.jpg'),
  (69,2,'Rosemary','https://i.ndtvimg.com/mt/cooks/2014-11/rosemary.jpg'),
  (70,2,'Yellow Chillies','https://i.ndtvimg.com/mt/cooks/2014-11/yellow-chillies-peeli-mirch.jpg'),
  (71,2,'Oregano','https://i.ndtvimg.com/mt/cooks/2014-11/1375705468_oregano.jpg'),
  (72,2,'Nasturtium','https://i.ndtvimg.com/mt/cooks/2014-11/1374488421_Nasturtium.jpg'),
  (73,2,'Salt','https://i.ndtvimg.com/mt/cooks/2014-11/salt-namak.jpg'),
  (74,2,'Mustard Powder','https://i.ndtvimg.com/mt/cooks/2014-11/mustard-powder.jpg'),
  (75,2,'Paprika','https://i.ndtvimg.com/mt/cooks/2014-11/paprika.jpg'),
  (76,2,'Mint Leaves','https://i.ndtvimg.com/mt/cooks/2014-11/mint.jpg'),
  (77,2,'Marjoram','https://i.ndtvimg.com/mt/cooks/2014-11/marjoram.jpg'),
  (78,2,'Lemongrass','https://i.ndtvimg.com/mt/cooks/2014-11/lemon-grass.jpg'),
  (79,2,'Red Chilli','https://i.ndtvimg.com/mt/cooks/2014-11/red-chilli.jpg'),
  (80,2,'Saffron','https://i.ndtvimg.com/mt/cooks/2014-11/saffron.jpg'),
  (81,2,'Dried Fenugreek Leaves','https://i.ndtvimg.com/mt/cooks/2014-11/kasoori-methi.jpg'),
  (82,2,'Kashmiri Mirch','https://i.ndtvimg.com/mt/cooks/2014-11/kashmiri-mirch.jpg'),
  (83,2,'Onion Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/nigella-kalonji.jpg'),
  (84,2,'Mace','https://i.ndtvimg.com/mt/cooks/2014-11/mace.jpg'),
  (85,2,'Nutmeg','https://i.ndtvimg.com/mt/cooks/2014-11/nutmeg-jaiphal.jpg'),
  (86,2,'Herbs','https://i.ndtvimg.com/mt/cooks/2014-11/herbs.jpg'),
  (87,2,'Thyme','https://i.ndtvimg.com/mt/cooks/2014-11/thyme.jpg'),
  (88,2,'Turmeric','https://i.ndtvimg.com/mt/cooks/2014-11/turmeric.jpg'),
  (89,2,'Garam Masala','https://i.ndtvimg.com/i/2017-09/garam-masala_240x180_61505480427.jpg'),
  (90,2,'Five Spice Powder','https://i.ndtvimg.com/mt/cooks/2014-11/five-spice-powder.jpg'),
  (91,2,'Fenugreek Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/fenugreek-seeds.jpg'),
  (92,2,'Fennel','https://i.ndtvimg.com/mt/cooks/2014-11/fennel.jpg'),
  (93,2,'Green Cardamom','https://i.ndtvimg.com/mt/cooks/2014-11/green-cardamom.jpg'),
  (94,2,'Dry Ginger Powder','https://i.ndtvimg.com/mt/cooks/2014-11/dry-ginger-powder-sonth.jpg'),
  (95,2,'Dill','https://i.ndtvimg.com/mt/cooks/2014-11/dill.jpg'),
  (96,2,'Curry Leaves','https://i.ndtvimg.com/mt/cooks/2014-11/curry-leaves.jpg'),
  (97,2,'Cumin Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/cumin-seeds.jpg'),
  (98,2,'Coriander Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/coriander-seeds.jpg'),
  (99,2,'Coriander Leaves','https://i.ndtvimg.com/mt/cooks/2014-11/coriander.jpg'),
  (100,2,'Cloves','https://i.ndtvimg.com/mt/cooks/2014-11/cloves.jpg'),
  (101,2,'Cinnamon','https://i.ndtvimg.com/mt/cooks/2014-11/cinnamon.jpg'),
  (102,2,'Star Anise','https://i.ndtvimg.com/mt/cooks/2014-11/star-anise.jpg'),
  (103,2,'Cayenne','https://i.ndtvimg.com/mt/cooks/2014-11/cayenne.jpg'),
  (104,2,'Caraway Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/caraway-seeds.jpg'),
  (105,2,'Cajun Spices','https://i.ndtvimg.com/mt/cooks/2014-11/cajun-spice.jpg'),
  (106,2,'Rock Salt','https://i.ndtvimg.com/mt/cooks/2014-11/black-salt-kala-namak.jpg'),
  (107,2,'Black Pepper','https://i.ndtvimg.com/mt/cooks/2014-11/black-peppercorns.jpg'),
  (108,2,'Black Cumin','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (109,2,'Bay Leaf','https://i.ndtvimg.com/mt/cooks/2014-11/bay-leaf.jpg'),
  (110,2,'Basil','https://i.ndtvimg.com/mt/cooks/2014-11/basil.jpg'),
  (111,2,'Black Cardamom','https://i.ndtvimg.com/mt/cooks/2014-11/black-cardamom.jpg'),
  (112,2,'Asafoetida','https://i.ndtvimg.com/mt/cooks/2014-11/1376648756_asafoetida.jpg'),
  (113,2,'Aniseed','https://i.ndtvimg.com/mt/cooks/2014-11/1372765704_aniseeds.jpg'),
  (114,2,'Raw Mango Powder','https://i.ndtvimg.com/mt/cooks/2014-11/mango-powder.jpg'),
  (115,2,'Allspice','https://i.ndtvimg.com/mt/cooks/2014-11/all-spice.jpg'),
  (116,2,'Carom Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/carom-seeds.jpg'),
  (117,2,'Parsley','https://i.ndtvimg.com/mt/cooks/2014-11/parsley.jpg'),
  (118,2,'Acacia','https://i.ndtvimg.com/mt/cooks/2014-11/acacia-leaves.jpg'),
  (119,2,'Carom Seeds','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (120,2,'Parsley','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (121,2,'Acacia','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (122,3,'Amaranth','https://i.ndtvimg.com/i/2015-02/amaranth_240x180_61424866932.jpg'),
  (123,3,'Flour','https://i.ndtvimg.com/mt/cooks/2014-11/1409660769_flour.jpg'),
  (124,3,'Muesli','https://i.ndtvimg.com/mt/cooks/2014-11/1394710457_muesli.jpg'),
  (125,3,'Oats','https://i.ndtvimg.com/mt/cooks/2014-11/1394709702_oats.jpg'),
  (126,3,'Jowar','https://i.ndtvimg.com/i/2014-11/jowar_625x300_71416561674.jpg'),
  (127,3,'Brown Rice','https://i.ndtvimg.com/i/2014-11/brown-rice_625x300_61416569888.jpg'),
  (128,3,'Arborio Rice','https://i.ndtvimg.com/i/2014-11/arborio-rice_625x300_81416569812.jpg'),
  (129,3,'Water Chestnut flour','https://i.ndtvimg.com/mt/cooks/2014-11/singhare-ka-atta.jpg'),
  (130,3,'Barnyard Millet','https://i.ndtvimg.com/mt/cooks/2014-11/samvat-ke-chaawal.jpg'),
  (131,3,'Tapioca','https://i.ndtvimg.com/mt/cooks/2014-11/sabudana.jpg'),
  (132,3,'Semolina','https://i.ndtvimg.com/mt/cooks/2014-11/semolina-suji.jpg'),
  (133,3,'Finger Millet','https://i.ndtvimg.com/mt/cooks/2014-11/ragi-finger-millet.jpg'),
  (134,3,'Puffed Rice','https://i.ndtvimg.com/mt/cooks/2014-11/puffed-rice-murmura.jpg'),
  (135,3,'Buckwheat','https://i.ndtvimg.com/mt/cooks/2014-11/kootoo-ka-atta.jpg'),
  (136,3,'Kidney Beans','https://i.ndtvimg.com/mt/cooks/2014-11/kidney-beans.jpg'),
  (137,3,'Whole Bengal Gram','https://i.ndtvimg.com/mt/cooks/2014-11/whole-bengal-gram-kala-chana.jpg'),
  (138,3,'Green Gram','https://i.ndtvimg.com/mt/cooks/2014-11/green-gram.jpg'),
  (139,3,'All Purpose Flour','https://i.ndtvimg.com/mt/cooks/2014-11/flour.jpg'),
  (140,3,'Whole Brown Lentils','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (141,3,'Husked Black Gram','https://i.ndtvimg.com/mt/cooks/2014-11/dhuli-urad-husked-black-gram.jpg'),
  (142,3,'Husked Green Gram','https://i.ndtvimg.com/mt/cooks/2014-11/husked-green-gram.jpg'),
  (143,3,'Couscous','https://i.ndtvimg.com/mt/cooks/2014-11/cous-cous.jpg'),
  (144,3,'Cornmeal','https://i.ndtvimg.com/mt/cooks/2014-11/corn-meal.jpg'),
  (145,3,'Pressed Rice','https://i.ndtvimg.com/mt/cooks/2014-11/chiwa.jpg'),
  (146,3,'Rice','https://i.ndtvimg.com/mt/cooks/2014-11/rice.jpg'),
  (147,3,'Breadcrumbs','https://i.ndtvimg.com/mt/cooks/2014-11/bread-crumbs.jpg'),
  (148,3,'Bread','https://i.ndtvimg.com/mt/cooks/2014-11/bread.jpg'),
  (149,3,'Black-eyed Beans','https://i.ndtvimg.com/mt/cooks/2014-11/black-eyed-beans-lobhia.jpg'),
  (150,3,'Black Gram','https://i.ndtvimg.com/mt/cooks/2014-11/Black-Gram-Sabut-Urad-Dal.jpg'),
  (151,3,'Black Beans','https://i.ndtvimg.com/mt/cooks/2014-11/black-beans.jpg'),
  (152,3,'Gram flour','https://i.ndtvimg.com/mt/cooks/2014-11/1377848239_besan-final.jpg'),
  (153,3,'Bengal Gram (Split)','https://i.ndtvimg.com/mt/cooks/2014-11/bengal-gram-split.jpg'),
  (154,3,'Chickpeas','https://i.ndtvimg.com/mt/cooks/2014-11/chickpeas.jpg'),
  (155,3,'Basmati Rice','https://i.ndtvimg.com/mt/cooks/2014-11/basmati-rice.jpg'),
  (156,3,'Barley','https://i.ndtvimg.com/mt/cooks/2014-11/barley.jpg'),
  (157,3,'Pearl Millet','https://i.ndtvimg.com/mt/cooks/2014-11/millet.jpg'),
  (158,3,'Whole Wheat Flour','https://i.ndtvimg.com/mt/cooks/2014-11/wholemeal-flour-atta.jpg'),
  (159,3,'Pigeon Pea','https://i.ndtvimg.com/mt/cooks/2014-11/yellow-lentils-arhar-dal.jpg'),
  (160,3,'Bean Sprouts','https://i.ndtvimg.com/mt/cooks/2014-11/ankurwali-dal-bean-sprouts.jpg'),
  (161,4,'Beef','https://i.ndtvimg.com/mt/cooks/2014-11/1406204578_beef.jpg'),
  (162,4,'Grass Fed Chicken','https://i.ndtvimg.com/mt/cooks/2014-11/1368613628_chicken.jpg'),
  (163,4,'Free Range Chicken','https://i.ndtvimg.com/mt/cooks/2014-11/1368613571_chicken.jpg'),
  (164,4,'Organic Chicken','https://i.ndtvimg.com/mt/cooks/2014-11/1368613542_chicken.jpg'),
  (165,4,'Turkey','https://i.ndtvimg.com/mt/cooks/2014-11/turkey.jpg'),
  (166,4,'Skinned Chicken','https://i.ndtvimg.com/mt/cooks/2014-11/skinned-chicken.jpg'),
  (167,4,'Pork','https://i.ndtvimg.com/mt/cooks/2014-11/pork.jpg'),
  (168,4,'Partridge','https://i.ndtvimg.com/mt/cooks/2014-11/partridge-teetar.jpg'),
  (169,4,'Meat Stock','https://i.ndtvimg.com/mt/cooks/2014-11/meat-stock.jpg'),
  (170,4,'Keema','https://i.ndtvimg.com/mt/cooks/2014-11/keema.jpg'),
  (171,4,'Mutton Liver','https://i.ndtvimg.com/mt/cooks/2014-11/liver.jpg'),
  (172,4,'Ham','https://i.ndtvimg.com/mt/cooks/2014-11/ham.jpg'),
  (173,4,'Kidney Meat','https://i.ndtvimg.com/mt/cooks/2014-11/kidney.jpg'),
  (174,4,'Crab','https://i.ndtvimg.com/mt/cooks/2014-11/crab.jpg'),
  (175,4,'Chicken Stock','https://i.ndtvimg.com/mt/cooks/2014-11/chicken-stock.jpg'),
  (176,4,'Chicken Liver','https://i.ndtvimg.com/mt/cooks/2014-11/chicken-liver.jpg'),
  (177,4,'Chicken','https://i.ndtvimg.com/mt/cooks/2014-11/chicken.jpg'),
  (178,4,'Chops','https://i.ndtvimg.com/mt/cooks/2014-11/chops.jpg'),
  (179,4,'Lamb Meat','https://i.ndtvimg.com/mt/cooks/2014-11/bhed-ka-gosht-lamb-meat.jpg'),
  (180,4,'Quail','https://i.ndtvimg.com/mt/cooks/2014-11/quail.jpg'),
  (181,4,'Mutton','https://i.ndtvimg.com/mt/cooks/2014-11/mutton.jpg'),
  (182,4,'Bacon','https://i.ndtvimg.com/mt/cooks/2014-11/bacon.jpg'),
  (183,5,'Gruyere Cheese','https://i.ndtvimg.com/i/2014-11/gruyere-cheese_625x300_71416558331.jpg'),
  (184,5,'Gouda Cheese','https://i.ndtvimg.com/i/2014-11/gouda-cheese_625x300_81416558191.jpg'),
  (185,5,'Feta Cheese','https://i.ndtvimg.com/i/2014-11/feta-cheese_625x300_61416559749.jpg'),
  (186,5,'Milk','https://i.ndtvimg.com/i/2014-11/milk_625x300_41416559876.jpg'),
  (187,5,'Brie Cheese','https://i.ndtvimg.com/i/2014-11/brie-cheese_625x300_71416557507.jpg'),
  (188,5,'Cream Cheese','https://i.ndtvimg.com/i/2014-11/cream-cheese_625x300_61416562101.jpg'),
  (189,5,'Ricotta Cheese','https://i.ndtvimg.com/i/2014-11/ricotta-cheese_625x300_61416561366.jpg'),
  (190,5,'Parmesan Cheese','https://i.ndtvimg.com/i/2014-11/parmesan-cheese_625x300_71416560204.jpg'),
  (191,5,'Blue Cheese','https://i.ndtvimg.com/i/2014-11/blue-cheese_625x300_51416570383.jpg'),
  (192,5,'Cheddar Cheese','https://i.ndtvimg.com/i/2014-11/cheddar-cheese_625x300_51416570018.jpg'),
  (193,5,'Mascarpone Cheese','https://i.ndtvimg.com/i/2014-11/mascarpone-cheese_625x300_61416569958.jpg'),
  (194,5,'Cream','https://i.ndtvimg.com/mt/cooks/2014-11/1370597513_cream.jpg'),
  (195,5,'Provolone Cheese','https://i.ndtvimg.com/mt/cooks/2014-11/provolone-cheese.jpg'),
  (196,5,'Mozzarella Cheese','https://i.ndtvimg.com/mt/cooks/2014-11/mozzarella-cheese.jpg'),
  (197,5,'Khoya','https://i.ndtvimg.com/mt/cooks/2014-11/khoya.jpg'),
  (198,5,'Hung Curd','https://i.ndtvimg.com/mt/cooks/2014-11/hung-curd.jpg'),
  (199,5,'Yogurt','https://i.ndtvimg.com/mt/cooks/2014-11/yogurt-dahi.jpg'),
  (200,5,'Cottage Cheese','https://i.ndtvimg.com/mt/cooks/2014-11/cottage-cheese-paneer.jpg'),
  (201,5,'Condensed Milk','https://i.ndtvimg.com/mt/cooks/2014-11/condensed-milk.jpg'),
  (202,5,'Clarified Butter','https://i.ndtvimg.com/mt/cooks/2014-11/1378114339_clarified-butter.jpg'),
  (203,5,'Buttermilk','https://i.ndtvimg.com/mt/cooks/2014-11/buttermilk.jpg'),
  (204,5,'Butter','https://i.ndtvimg.com/mt/cooks/2014-11/butter.jpg'),
  (205,6,'Cranberry','https://i.ndtvimg.com/mt/cooks/2014-11/1393499279_cranberries.jpg'),
  (206,6,'Kiwi','https://i.ndtvimg.com/mt/cooks/2014-11/1378362519_kiwi.jpg'),
  (207,6,'Blueberries','https://i.ndtvimg.com/mt/cooks/2014-11/1378191969_blueberries.jpg'),
  (208,6,'Mango','https://i.ndtvimg.com/mt/cooks/2014-11/1369305503_mango.jpg'),
  (209,6,'Watermelon','https://i.ndtvimg.com/mt/cooks/2014-11/1369289404_watermelon.jpg'),
  (210,6,'Tomato','https://i.ndtvimg.com/mt/cooks/2014-11/tomatoes.jpg'),
  (211,6,'Strawberry','https://i.ndtvimg.com/mt/cooks/2014-11/strawberry.jpg'),
  (212,6,'Water Chestnut','https://i.ndtvimg.com/mt/cooks/2014-11/water-chestnut-singhada.jpg'),
  (213,6,'Papaya','https://i.ndtvimg.com/mt/cooks/2014-11/papaya-papita.jpg'),
  (214,6,'Orange Rind','https://i.ndtvimg.com/mt/cooks/2014-11/orange-rind.jpg'),
  (215,6,'Orange','https://i.ndtvimg.com/mt/cooks/2014-11/orange-santra.jpg'),
  (216,6,'Olives','https://i.ndtvimg.com/mt/cooks/2014-11/olives-zaitun.jpg'),
  (217,6,'Pear','https://i.ndtvimg.com/mt/cooks/2014-11/pear-naashpati.jpg'),
  (218,6,'Sultana','https://i.ndtvimg.com/mt/cooks/2014-11/sultana.jpg'),
  (219,6,'Mulberry','https://i.ndtvimg.com/mt/cooks/2014-11/shehtoot-mulberry.jpg'),
  (220,6,'Lychee','https://i.ndtvimg.com/mt/cooks/2014-11/lychee.jpg'),
  (221,6,'Lemon Juice','https://i.ndtvimg.com/mt/cooks/2014-11/lemon-juice.jpg'),
  (222,6,'Lemon Rind','https://i.ndtvimg.com/mt/cooks/2014-11/lemon-rind.jpg'),
  (223,6,'Lemon','https://i.ndtvimg.com/mt/cooks/2014-11/lemon.jpg'),
  (224,6,'Raisins','https://i.ndtvimg.com/mt/cooks/2014-11/raisins.jpg'),
  (225,6,'Jamun','https://i.ndtvimg.com/mt/cooks/2014-11/jamun.jpg'),
  (226,6,'Tamarind','https://i.ndtvimg.com/mt/cooks/2014-11/tamarind.jpg'),
  (227,6,'Grapefruit','https://i.ndtvimg.com/mt/cooks/2014-11/grapefruit.jpg'),
  (228,6,'Indian Gooseberry','https://i.ndtvimg.com/mt/cooks/2014-11/gooseberry.jpg'),
  (229,6,'Dried Fruit','https://i.ndtvimg.com/mt/cooks/2014-11/dried-fruits.jpg'),
  (230,6,'Dates','https://i.ndtvimg.com/mt/cooks/2014-11/dates.jpg'),
  (231,6,'Custard Apple','https://i.ndtvimg.com/mt/cooks/2014-11/custard-apple.jpg'),
  (232,6,'Currant','https://i.ndtvimg.com/mt/cooks/2014-11/currant.jpg'),
  (233,6,'Cooking Apples','https://i.ndtvimg.com/mt/cooks/2014-11/cooking-apples.jpg'),
  (234,6,'Coconut','https://i.ndtvimg.com/mt/cooks/2014-11/coconut.jpg'),
  (235,6,'Cherry','https://i.ndtvimg.com/mt/cooks/2014-11/cherries.jpg'),
  (236,6,'Cape Gooseberry','https://i.ndtvimg.com/mt/cooks/2014-11/cape-gooseberry-rasbhari.jpg'),
  (237,6,'Banana','https://i.ndtvimg.com/mt/cooks/2014-11/banana.jpg'),
  (238,6,'Peach','https://i.ndtvimg.com/mt/cooks/2014-11/peach.jpg'),
  (239,6,'Apricots','https://i.ndtvimg.com/mt/cooks/2014-11/apricot.jpg'),
  (240,6,'Apples','https://i.ndtvimg.com/mt/cooks/2014-11/apple.jpg'),
  (241,6,'Figs','https://i.ndtvimg.com/mt/cooks/2014-11/figs.jpg'),
  (242,6,'Grapes','https://i.ndtvimg.com/mt/cooks/2014-11/grapes.jpg'),
  (243,6,'Pomegranate','https://i.ndtvimg.com/mt/cooks/2014-11/pomegranate-anaar.jpg'),
  (244,6,'Pineapple','https://i.ndtvimg.com/mt/cooks/2014-11/pineapple-annanas.jpg'),
  (245,6,'Guava','https://i.ndtvimg.com/mt/cooks/2014-11/guava.jpg'),
  (246,6,'Plum','https://i.ndtvimg.com/mt/cooks/2014-11/plums.jpg'),
  (247,7,'Shrimp','https://i.ndtvimg.com/mt/cooks/2014-11/1380798049_shrimp.jpg'),
  (248,7,'Tuna Fish','https://i.ndtvimg.com/mt/cooks/2014-11/tuna.jpg'),
  (249,7,'Shellfish','https://i.ndtvimg.com/mt/cooks/2014-11/shellfish.jpg'),
  (250,7,'Shark','https://i.ndtvimg.com/mt/cooks/2014-11/shark.jpg'),
  (251,7,'Hilsa','https://i.ndtvimg.com/mt/cooks/2014-11/shad-hilsa.jpg'),
  (252,7,'Sardines','https://i.ndtvimg.com/mt/cooks/2014-11/sardines.jpg'),
  (253,7,'Salmon','https://i.ndtvimg.com/mt/cooks/2014-11/salmon.jpg'),
  (254,7,'Prawns','https://i.ndtvimg.com/mt/cooks/2014-11/prawns.jpg'),
  (255,7,'Pomfret','https://i.ndtvimg.com/mt/cooks/2014-11/pomfret.jpg'),
  (256,7,'Perch','https://i.ndtvimg.com/mt/cooks/2014-11/perch-fish.jpg'),
  (257,7,'Pearl spot','https://i.ndtvimg.com/mt/cooks/2014-11/pearl-spot-fish.jpg'),
  (258,7,'Mussels','https://i.ndtvimg.com/mt/cooks/2014-11/mussels.jpg'),
  (259,7,'Mullet','https://i.ndtvimg.com/mt/cooks/2014-11/mullet.jpg'),
  (260,7,'Squids','https://i.ndtvimg.com/mt/cooks/2014-11/squids.jpg'),
  (261,7,'Haddock','https://i.ndtvimg.com/mt/cooks/2014-11/haddock.jpg'),
  (262,7,'Flounder','https://i.ndtvimg.com/mt/cooks/2014-11/flounder-sole.jpg'),
  (263,7,'Fish Stock','https://i.ndtvimg.com/mt/cooks/2014-11/fish-stock.jpg'),
  (264,7,'Fish','https://i.ndtvimg.com/mt/cooks/2014-11/fish.jpg'),
  (265,7,'Fish Fillet','https://i.ndtvimg.com/mt/cooks/2014-11/fillet.jpg'),
  (266,7,'Cuttle fish','https://i.ndtvimg.com/mt/cooks/2014-11/cuttle-fish.jpg'),
  (267,7,'Cod','https://i.ndtvimg.com/mt/cooks/2014-11/cod.jpg'),
  (268,7,'Clams','https://i.ndtvimg.com/mt/cooks/2014-11/clams.jpg'),
  (269,7,'Cat fish','https://i.ndtvimg.com/mt/cooks/2014-11/cat-fish.jpg'),
  (270,7,'Mackerel','https://i.ndtvimg.com/mt/cooks/2014-11/mackerel.jpg'),
  (271,7,'Anchovies','https://i.ndtvimg.com/mt/cooks/2014-11/anchovies.jpg'),
  (272,8,'Brown Sugar','https://i.ndtvimg.com/i/2014-11/brown-sugar_625x300_41416557136.jpg'),
  (273,8,'Sugar Candy','https://i.ndtvimg.com/mt/cooks/2014-11/sugar-candy-mishri.jpg'),
  (274,8,'Icing Sugar','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (275,8,'Honey','https://i.ndtvimg.com/mt/cooks/2014-11/honey.jpg'),
  (276,8,'Jaggery','https://i.ndtvimg.com/mt/cooks/2014-11/jaggery.jpg'),
  (277,8,'Golden Syrup','https://i.ndtvimg.com/mt/cooks/2014-11/golden-syrup.jpg'),
  (278,8,'Sugar','https://i.ndtvimg.com/mt/cooks/2014-11/cheeni-sugar.jpg'),
  (279,8,'Castor Sugar','https://i.ndtvimg.com/mt/cooks/2014-11/castor-sugar.jpg'),
  (280,8,'Caramel','https://i.ndtvimg.com/mt/cooks/2014-11/caramel.jpg'),
  (281,8,'Cane Sugar','https://i.ndtvimg.com/mt/cooks/2014-11/cane-sugar.jpg'),
  (282,9,'Canola Oil','https://i.ndtvimg.com/i/2015-03/canola-oil_240x180_81425281969.jpg'),
  (283,9,'Chia Seeds','https://i.ndtvimg.com/i/2014-11/chia-seeds_625x300_81416559553.jpg'),
  (284,9,'Hazelnut','https://i.ndtvimg.com/i/2014-11/hazelnut_625x300_71416569423.jpg'),
  (285,9,'Pine Nuts','https://i.ndtvimg.com/i/2014-11/pine-nuts_625x300_61416561439.jpg'),
  (286,9,'Mustard Oil','https://i.ndtvimg.com/mt/cooks/2014-11/1368689586_mustard-oil.jpg'),
  (287,9,'Sunflower Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/sunflower-seeds.jpg'),
  (288,9,'Sesame Oil','https://i.ndtvimg.com/mt/cooks/2014-11/sesame-oil-til-ka-tel.jpg'),
  (289,9,'Pistachio','https://i.ndtvimg.com/mt/cooks/2014-11/pistachio.jpg'),
  (290,9,'Olive Oil','https://i.ndtvimg.com/mt/cooks/2014-11/olive-oil.jpg'),
  (291,9,'Mustard Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/mustard-seeds.jpg'),
  (292,9,'Poppy Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/poppy-seeds.jpg'),
  (293,9,'Sesame Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/sesame-seeds.jpg'),
  (294,9,'Peanuts','https://i.ndtvimg.com/mt/cooks/2014-11/groundnut.jpg'),
  (295,9,'Chironji','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (296,9,'Cashew Nuts','https://i.ndtvimg.com/mt/cooks/2014-11/cashew-nuts.jpg'),
  (297,9,'Blanched Almonds','https://i.ndtvimg.com/mt/cooks/2014-11/blanched-almonds.jpg'),
  (298,9,'Almonds','https://i.ndtvimg.com/mt/cooks/2014-11/almonds.jpg'),
  (299,9,'Walnuts','https://i.ndtvimg.com/mt/cooks/2014-11/walnuts-akhrot.jpg'),
  (300,9,'Walnuts','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (301,10,'Almond Milk','https://i.ndtvimg.com/i/2014-11/almond-milk_625x300_41416557931.jpg'),
  (302,10,'Red Wine Vinegar','https://i.ndtvimg.com/i/2014-11/red-wine-vinegar_625x300_41416557810.jpg'),
  (303,10,'Red Wine','https://i.ndtvimg.com/i/2014-11/red-wine_625x300_81416557655.jpg'),
  (304,10,'Margarine','https://i.ndtvimg.com/mt/cooks/2014-11/1391601946_margarine.jpg'),
  (305,10,'Soy Milk','https://i.ndtvimg.com/i/2014-11/soy-milk_625x300_81416557368.jpg'),
  (306,10,'White Wine','https://i.ndtvimg.com/i/2014-11/white-wine_625x300_41416557240.jpg'),
  (307,10,'Yeast','https://i.ndtvimg.com/mt/cooks/2014-11/1381490887_yeast.jpg'),
  (308,10,'White Pepper','https://i.ndtvimg.com/i/2014-11/white-pepper_625x300_71416557004.jpg'),
  (309,10,'Rice Vinegar','https://i.ndtvimg.com/i/2014-11/rice-vinegar_625x300_71416556797.jpg'),
  (310,10,'Sea Salt','https://i.ndtvimg.com/i/2014-11/sea-salt_625x300_61416556664.jpg'),
  (311,10,'Hoisin Sauce','https://i.ndtvimg.com/i/2014-11/hoisin-sauce_625x300_81416568995.jpg'),
  (312,10,'Malt Vinegar','https://i.ndtvimg.com/i/2014-11/malt-vinegar_625x300_41416562197.jpg'),
  (313,10,'Chocolate Chips','https://i.ndtvimg.com/i/2014-11/chocolate-chips_625x300_61416561516.jpg'),
  (314,10,'Quinoa','https://i.ndtvimg.com/mt/cooks/2014-11/1378985209_quinoa.jpg'),
  (315,10,'Rice Flour','https://i.ndtvimg.com/i/2014-11/rice-flour_625x300_51416560305.jpg'),
  (316,10,'Polenta','https://i.ndtvimg.com/mt/cooks/2014-11/1378728858_polenta.jpg'),
  (317,10,'Oyster Sauce','https://i.ndtvimg.com/i/2014-11/oyster-sauce_625x300_81416570732.jpg'),
  (318,10,'Guchchi','https://i.ndtvimg.com/mt/cooks/2014-11/1378123690_gucchi.jpg'),
  (319,10,'Flat Noodles','https://i.ndtvimg.com/i/2014-11/flat-noodles_625x300_81416570572.jpg'),
  (320,10,'Balsamic Vinegar','https://i.ndtvimg.com/i/2014-11/balsamic-vinegar_625x300_41416570490.jpg'),
  (321,10,'Coconut Oil','https://i.ndtvimg.com/i/2014-11/coconut-oil_625x300_81416570303.jpg'),
  (322,10,'Barfi','https://i.ndtvimg.com/mt/cooks/2014-11/1372839411_barfi.jpg'),
  (323,10,'Rice Noodles','https://i.ndtvimg.com/i/2014-11/rice-noodles_625x300_51416571274.jpg'),
  (324,10,'Coffee','https://i.ndtvimg.com/mt/cooks/2014-11/1370425624_coffee.jpg'),
  (325,10,'Beer','https://i.ndtvimg.com/i/2014-11/beer_625x300_41416571111.jpg'),
  (326,10,'Chocolate','https://i.ndtvimg.com/i/2014-11/chocolate_625x300_71416571015.jpg'),
  (327,10,'Sake','https://i.ndtvimg.com/mt/cooks/2014-11/1368690449_sake_ing.jpg'),
  (328,10,'Vinaigrette','https://i.ndtvimg.com/mt/cooks/2014-11/vinegarette.jpg'),
  (329,10,'Vanilla Essence','https://i.ndtvimg.com/mt/cooks/2014-11/vanilla-essence.jpg'),
  (330,10,'Tortilla','https://i.ndtvimg.com/mt/cooks/2014-11/tortillas.jpg'),
  (331,10,'Tomato Puree','https://i.ndtvimg.com/mt/cooks/2014-11/tomato-puree.jpg'),
  (332,10,'Vegetable Oil','https://i.ndtvimg.com/mt/cooks/2014-11/vegetable-oil.jpg'),
  (333,10,'Tartaric Acid','https://i.ndtvimg.com/mt/cooks/2014-11/tartaric-acid.jpg'),
  (334,10,'Soya Sauce','https://i.ndtvimg.com/mt/cooks/2014-11/soya-sauce.jpg'),
  (335,10,'Vinegar','https://i.ndtvimg.com/mt/cooks/2014-11/vinegar-sirka.jpg'),
  (336,10,'Sharbat','https://i.ndtvimg.com/mt/cooks/2014-11/sherbet.jpg'),
  (337,10,'Vermicelli','https://i.ndtvimg.com/mt/cooks/2014-11/vermicilli.jpg'),
  (338,10,'Sev','https://i.ndtvimg.com/mt/cooks/2014-11/sev.jpg'),
  (339,10,'Rum','https://i.ndtvimg.com/mt/cooks/2014-11/rum.jpg'),
  (340,10,'Roux','https://i.ndtvimg.com/mt/cooks/2014-11/roux.jpg'),
  (341,10,'Petha','https://i.ndtvimg.com/mt/cooks/2014-11/1372848331_petha.jpg'),
  (342,10,'Pasta','https://i.ndtvimg.com/mt/cooks/2014-11/pasta.jpg'),
  (343,10,'Papad','https://i.ndtvimg.com/mt/cooks/2014-11/papad.jpg'),
  (344,10,'Paan','https://i.ndtvimg.com/mt/cooks/2014-11/paan-beetle-leaf.jpg'),
  (345,10,'Meringue','https://i.ndtvimg.com/mt/cooks/2014-11/meringue.jpg'),
  (346,10,'Mayonnaise','https://i.ndtvimg.com/mt/cooks/2014-11/mayonnaise.jpg'),
  (347,10,'Melon Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/melon-seeds.jpg'),
  (348,10,'Lotus Seeds','https://i.ndtvimg.com/mt/cooks/2014-11/lotus-seeds.jpg'),
  (349,10,'Vetiver','https://i.ndtvimg.com/mt/cooks/2014-11/vetivier-khus.jpg'),
  (350,10,'Screw Pine','https://i.ndtvimg.com/mt/cooks/2014-11/screw-pine.jpg'),
  (351,10,'Jus','https://i.ndtvimg.com/mt/cooks/2014-11/jus.jpg'),
  (352,10,'Jelly','https://i.ndtvimg.com/mt/cooks/2014-11/jelly.jpg'),
  (353,10,'Rose Water','https://i.ndtvimg.com/mt/cooks/2014-11/gulab-jal.jpg'),
  (354,10,'Gold Leaves','https://i.ndtvimg.com/mt/cooks/2014-11/gold-leaves.jpg'),
  (355,10,'Glycerine','https://i.ndtvimg.com/mt/cooks/2014-11/glycerine.jpg'),
  (356,10,'Gelatin','https://i.ndtvimg.com/mt/cooks/2014-11/gelatine.jpg'),
  (357,10,'Fish Sauce','https://i.ndtvimg.com/mt/cooks/2014-11/fish-sauce.jpg'),
  (358,10,'Desiccated Coconut','https://i.ndtvimg.com/mt/cooks/2014-11/dessicated-coconut.jpg'),
  (359,10,'Cranberry Sauce','https://i.ndtvimg.com/mt/cooks/2014-11/cranberry-sauce.jpg'),
  (360,10,'Cornflour','https://i.ndtvimg.com/mt/cooks/2014-11/1367236121_corn-flour-new.jpg'),
  (361,10,'Cognac','https://i.ndtvimg.com/mt/cooks/2014-11/cognac.jpg'),
  (362,10,'Coconut Water','https://i.ndtvimg.com/mt/cooks/2014-11/coconut-water.jpg'),
  (363,10,'Coconut Milk','https://i.ndtvimg.com/mt/cooks/2014-11/coconut-milk.jpg'),
  (364,10,'Cocoa','https://i.ndtvimg.com/mt/cooks/2014-11/cocoa.jpg'),
  (365,10,'Tea','https://i.ndtvimg.com/mt/cooks/2014-11/tea.jpg'),
  (366,10,'Brown Sauce','https://i.ndtvimg.com/mt/cooks/2014-11/brown-sauce.jpg'),
  (367,10,'Baking Soda','https://i.ndtvimg.com/mt/cooks/2014-11/bi-carbonate-of-soda.jpg'),
  (368,10,'Tofu','https://i.ndtvimg.com/mt/cooks/2014-11/bean-curd-tofu.jpg'),
  (369,10,'Baking Powder','https://i.ndtvimg.com/mt/cooks/2014-11/baking-powder.jpg'),
  (370,10,'Arrowroot','https://i.ndtvimg.com/mt/cooks/2014-11/arrowroot.jpg'),
  (371,10,'Egg','https://i.ndtvimg.com/mt/cooks/2014-11/egg.jpg'),
  (372,10,'Alum','https://i.ndtvimg.com/mt/cooks/2014-11/alum.jpg'),
  (373,10,'Marzipan','https://i.ndtvimg.com/mt/cooks/2014-11/marzipan.jpg'),
  (374,10,'Ajinomoto','https://i.ndtvimg.com/mt/cooks/2014-11/ajinomoto.jpg'),
  (375,10,'Agar','https://i.ndtvimg.com/mt/cooks/2014-11/agar-agar.jpg'),
  (376,10,'Agar','https://food.ndtv.com/static/web/images/food-default-205x205.png'),
  (377,10,'Ajinomoto','https://food.ndtv.com/static/web/images/food-default-205x205.png');


INSERT INTO `recipe_details` (`recipe_id`, `ingredient_id`,`ingredient_volume`,`units_of_measure`)
  VALUES
    ('1','6','90','12'),
    ('1','15','150','12'),
    ('2','15','125','12'),
    ('3','15','12','12'),
    ('4','15','250','12'),
    ('6','15','60','12'),
    ('8','15','230','12'),
    ('9','15','110','12'),
    ('9','17','140','12'),
    ('2','32','7.5','12'),
    ('3','32','9','12'),
    ('4','32','212.747812920029','12'),
    ('6','32','3','12'),
    ('8','32','8.49999999985629','12'),
    ('9','41','144','12'),
    ('1','43','4.73333333357341','12'),
    ('4','63','6.6','12'),
    ('10','68','0.0875','12'),
    ('8','69','30','12'),
    ('1','71','1.5','12'),
    ('10','71','0.25','12'),
    ('1','73','5.57315000000619','12'),
    ('1','73','2.78657500000309','12'),
    ('2','73','16.5351640936207','12'),
    ('3','73','10.161','12'),
    ('4','73','14.5624999997537','12'),
    ('7','73','4.85416666691287','12'),
    ('8','73','6','12'),
    ('8','73','42.5999999999999','12'),
    ('9','73','1.42499999999999','12'),
    ('2','75','6.8','12'),
    ('2','75','6.8','12'),
    ('3','75','9.2','12'),
    ('10','87','0.125','12'),
    ('4','92','21.2747812920029','12'),
    ('3','103','1.8','12'),
    ('3','107','5.0805','12'),
    ('7','107','1.45','12'),
    ('8','107','0.575','12'),
    ('10','107','0.575','12'),
    ('1','110','0.50000000002536','12'),
    ('4','110','0.25','12'),
    ('2','117','11.3999999999999','12'),
    ('3','117','7.6','12'),
    ('8','117','15','12'),
    ('9','117','7.6','12'),
    ('2','123','7.81249999986791','12'),
    ('8','123','62.5','12'),
    ('8','123','7.8','12'),
    ('9','123','31.25','12'),
    ('10','123','375','12'),
    ('4','146','25','12'),
    ('6','146','390','12'),
    ('3','148','58','12'),
    ('4','160','453.59237','12'),
    ('2','175','289.109894100757','12'),
    ('3','175','960','12'),
    ('6','175','183.877499999908','12'),
    ('8','175','720','12'),
    ('9','175','360','12'),
    ('1','177','348','12'),
    ('1','177','12.6324733333473','12'),
    ('2','177','1150','12'),
    ('3','177','348','12'),
    ('4','177','1360.77711','12'),
    ('4','177','920','12'),
    ('5','177','1587.573295','12'),
    ('6','177','348','12'),
    ('7','177','1700.9713875','12'),
    ('8','177','907.18474','12'),
    ('9','177','840','12'),
    ('10','177','2880','12'),
    ('10','177','920','12'),
    ('9','186','366','12'),
    ('10','186','244','12'),
    ('2','194','243.038288169496','12'),
    ('2','204','28.4','12'),
    ('9','204','28.4','12'),
    ('1','210','15.1250000007671','12'),
    ('1','210','190','12'),
    ('1','210','10','12'),
    ('2','210','615','12'),
    ('3','223','58','12'),
    ('4','264','72.0000000012172','12'),
    ('6','272','27.1874999995403','12'),
    ('4','278','8.4','12'),
    ('6','288','27.2','12'),
    ('2','290','27','12'),
    ('8','290','9','12'),
    ('9','290','27','12'),
    ('3','299','175.5','12'),
    ('4','311','0','12'),
    ('9','365','1.45','12');


