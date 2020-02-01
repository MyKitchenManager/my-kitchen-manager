ALTER TABLE inventory MODIFY expiration_date timestamp NULL NOT NULL;
ALTER TABLE recipe_details MODIFY ingredient_volume float;
ALTER TABLE inventory MODIFY inventory_volume float;

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




