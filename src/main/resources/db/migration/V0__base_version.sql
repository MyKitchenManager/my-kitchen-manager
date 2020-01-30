drop table if exists list_entry;
create table list_entry (
    list_entry_id integer NOT NULL,
    source varchar(100),
    entry varchar(100),
    PRIMARY KEY (list_entry_id)
)
;
drop table if exists ingredient;
create table ingredient (
    ingredient_id integer NOT NULL AUTO_INCREMENT,
    ingredient_category integer,
    ingredient_name varchar(100),
    ingredient_image_url varchar(100),
    PRIMARY KEY (ingredient_id)
)
;
drop table if exists members;
create table members (
     member_id integer NOT NULL AUTO_INCREMENT,
     singup_date timestamp,
     password varchar(100),
     gender char(1),
     is_vegetarian boolean,
     is_vegan boolean,
     is_lactose_intolerant boolean,
     is_gluten_free boolean,
     email_address varchar(100),
     nationality integer,
     first_name varchar(100),
     last_name varchar(100),
     user_name varchar(100),
     PRIMARY KEY (member_id),
     UNIQUE KEY (user_name)
)
;

drop table if exists recipe;
create table recipe (
    recipe_id integer NOT NULL AUTO_INCREMENT,
    recipe_category integer,
    is_vegetarian boolean,
    is_vegan boolean,
    contains_diary boolean,
    is_gluten_free boolean,
    contributor_id integer,
    recipe_image_url varchar(100),
    instructions varchar(10000) NOT NULL,
    prep_time integer,
    times_cooked integer,
    PRIMARY KEY (recipe_id),
    FOREIGN KEY (contributor_id) REFERENCES members(member_id)
)
;

drop table if exists meal_plan;
create table meal_plan (
   meal_plan_id integer NOT NULL AUTO_INCREMENT,
   member_id integer ,
   recipe_id integer ,
   when_added timestamp,
   meal_date date,
   status varchar(10),
   PRIMARY KEY (meal_plan_id),
   FOREIGN KEY (member_id) REFERENCES members(member_id),
   FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id)
)
;
drop table if exists recipe_details;
create table recipe_details (
    recipe_details_id integer NOT NULL AUTO_INCREMENT,
    recipe_id integer ,
    ingredient_id integer ,
    ingredient_volume integer,
    units_of_measure integer ,
    PRIMARY KEY (recipe_details_id),
    FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id),
    FOREIGN KEY (units_of_measure) REFERENCES list_entry(list_entry_id)
)
;
drop table if exists inventory;
create table inventory (
   inventory_id integer NOT NULL AUTO_INCREMENT,
   ingredient_id integer ,
   purchase_date timestamp,
   expiration_date timestamp,
   inventory_volume integer,
   units_of_measure integer ,
   member_id integer ,
   PRIMARY KEY (inventory_id),
   FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id),
   FOREIGN KEY (units_of_measure) REFERENCES list_entry(list_entry_id),
   FOREIGN KEY (member_id) REFERENCES members(member_id)
)
