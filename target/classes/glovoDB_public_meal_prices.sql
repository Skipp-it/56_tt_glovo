
DROP TABLE IF EXISTS meal_prices;

create table meal_prices
(
    id    bigint  not null
        constraint meal_prices_pkey
            primary key,
    price integer not null
);


DROP TABLE IF EXISTS user_table;

create table user_table
(
    id    uuid  not null
        primary key,
    first_name text not null,
    last_name text not null,
    email text not null,
    password text not null,
    username text not null

alter table meal_prices
    owner to postgres;

INSERT INTO public.meal_prices (id, price) VALUES (52874, 40);
INSERT INTO public.meal_prices (id, price) VALUES (52878, 76);
INSERT INTO public.meal_prices (id, price) VALUES (52997, 8);
INSERT INTO public.meal_prices (id, price) VALUES (52904, 82);
INSERT INTO public.meal_prices (id, price) VALUES (52812, 59);
INSERT INTO public.meal_prices (id, price) VALUES (52873, 74);
INSERT INTO public.meal_prices (id, price) VALUES (52952, 73);
INSERT INTO public.meal_prices (id, price) VALUES (52834, 17);
INSERT INTO public.meal_prices (id, price) VALUES (52824, 51);
INSERT INTO public.meal_prices (id, price) VALUES (52803, 52);
INSERT INTO public.meal_prices (id, price) VALUES (53013, 31);
INSERT INTO public.meal_prices (id, price) VALUES (52979, 43);
INSERT INTO public.meal_prices (id, price) VALUES (52826, 63);
INSERT INTO public.meal_prices (id, price) VALUES (52998, 9);
INSERT INTO public.meal_prices (id, price) VALUES (53031, 85);
INSERT INTO public.meal_prices (id, price) VALUES (53021, 13);
INSERT INTO public.meal_prices (id, price) VALUES (52781, 90);
INSERT INTO public.meal_prices (id, price) VALUES (52938, 90);
INSERT INTO public.meal_prices (id, price) VALUES (52947, 51);
INSERT INTO public.meal_prices (id, price) VALUES (52827, 10);
INSERT INTO public.meal_prices (id, price) VALUES (52876, 33);
INSERT INTO public.meal_prices (id, price) VALUES (52927, 54);
INSERT INTO public.meal_prices (id, price) VALUES (53006, 9);
INSERT INTO public.meal_prices (id, price) VALUES (53029, 79);
INSERT INTO public.meal_prices (id, price) VALUES (52943, 78);
INSERT INTO public.meal_prices (id, price) VALUES (53017, 62);
INSERT INTO public.meal_prices (id, price) VALUES (52930, 40);
INSERT INTO public.meal_prices (id, price) VALUES (52941, 67);
INSERT INTO public.meal_prices (id, price) VALUES (52992, 58);
INSERT INTO public.meal_prices (id, price) VALUES (52770, 79);
INSERT INTO public.meal_prices (id, price) VALUES (52881, 77);
INSERT INTO public.meal_prices (id, price) VALUES (52935, 77);
INSERT INTO public.meal_prices (id, price) VALUES (52950, 84);
INSERT INTO public.meal_prices (id, price) VALUES (53000, 17);
INSERT INTO public.meal_prices (id, price) VALUES (52940, 60);
INSERT INTO public.meal_prices (id, price) VALUES (53016, 30);
INSERT INTO public.meal_prices (id, price) VALUES (52846, 55);
INSERT INTO public.meal_prices (id, price) VALUES (52796, 56);
INSERT INTO public.meal_prices (id, price) VALUES (52934, 83);
INSERT INTO public.meal_prices (id, price) VALUES (52956, 9);
INSERT INTO public.meal_prices (id, price) VALUES (52850, 70);
INSERT INTO public.meal_prices (id, price) VALUES (52765, 60);
INSERT INTO public.meal_prices (id, price) VALUES (52818, 9);
INSERT INTO public.meal_prices (id, price) VALUES (52875, 86);
INSERT INTO public.meal_prices (id, price) VALUES (52795, 53);
INSERT INTO public.meal_prices (id, price) VALUES (52831, 5);
INSERT INTO public.meal_prices (id, price) VALUES (52920, 71);
INSERT INTO public.meal_prices (id, price) VALUES (52879, 98);
INSERT INTO public.meal_prices (id, price) VALUES (53011, 21);
INSERT INTO public.meal_prices (id, price) VALUES (52832, 26);
INSERT INTO public.meal_prices (id, price) VALUES (52830, 84);
INSERT INTO public.meal_prices (id, price) VALUES (52996, 26);
INSERT INTO public.meal_prices (id, price) VALUES (52951, 73);
INSERT INTO public.meal_prices (id, price) VALUES (52993, 50);
INSERT INTO public.meal_prices (id, price) VALUES (52937, 76);
INSERT INTO public.meal_prices (id, price) VALUES (52820, 50);
INSERT INTO public.meal_prices (id, price) VALUES (52813, 78);
INSERT INTO public.meal_prices (id, price) VALUES (52945, 53);
INSERT INTO public.meal_prices (id, price) VALUES (52851, 3);
INSERT INTO public.meal_prices (id, price) VALUES (52774, 41);
INSERT INTO public.meal_prices (id, price) VALUES (52780, 8);
INSERT INTO public.meal_prices (id, price) VALUES (52933, 29);
INSERT INTO public.meal_prices (id, price) VALUES (53020, 81);
INSERT INTO public.meal_prices (id, price) VALUES (53028, 26);
INSERT INTO public.meal_prices (id, price) VALUES (52806, 17);
INSERT INTO public.meal_prices (id, price) VALUES (52772, 71);
INSERT INTO public.meal_prices (id, price) VALUES (52814, 49);
INSERT INTO public.meal_prices (id, price) VALUES (52893, 44);
INSERT INTO public.meal_prices (id, price) VALUES (52768, 19);
INSERT INTO public.meal_prices (id, price) VALUES (52767, 14);
INSERT INTO public.meal_prices (id, price) VALUES (52855, 34);
INSERT INTO public.meal_prices (id, price) VALUES (52894, 40);
INSERT INTO public.meal_prices (id, price) VALUES (52928, 9);
INSERT INTO public.meal_prices (id, price) VALUES (52891, 59);
INSERT INTO public.meal_prices (id, price) VALUES (52792, 44);
INSERT INTO public.meal_prices (id, price) VALUES (52961, 54);
INSERT INTO public.meal_prices (id, price) VALUES (52923, 30);
INSERT INTO public.meal_prices (id, price) VALUES (52897, 35);
INSERT INTO public.meal_prices (id, price) VALUES (52976, 12);
INSERT INTO public.meal_prices (id, price) VALUES (52898, 50);
INSERT INTO public.meal_prices (id, price) VALUES (52910, 76);
INSERT INTO public.meal_prices (id, price) VALUES (52856, 17);
INSERT INTO public.meal_prices (id, price) VALUES (52853, 70);
INSERT INTO public.meal_prices (id, price) VALUES (52966, 24);
INSERT INTO public.meal_prices (id, price) VALUES (52776, 74);
INSERT INTO public.meal_prices (id, price) VALUES (52860, 25);
INSERT INTO public.meal_prices (id, price) VALUES (52905, 23);
INSERT INTO public.meal_prices (id, price) VALUES (52990, 10);
INSERT INTO public.meal_prices (id, price) VALUES (52788, 98);
INSERT INTO public.meal_prices (id, price) VALUES (52989, 7);
INSERT INTO public.meal_prices (id, price) VALUES (52988, 69);
INSERT INTO public.meal_prices (id, price) VALUES (52899, 45);
INSERT INTO public.meal_prices (id, price) VALUES (52888, 71);
INSERT INTO public.meal_prices (id, price) VALUES (52791, 0);
INSERT INTO public.meal_prices (id, price) VALUES (53007, 88);
INSERT INTO public.meal_prices (id, price) VALUES (52787, 28);
INSERT INTO public.meal_prices (id, price) VALUES (52890, 49);
INSERT INTO public.meal_prices (id, price) VALUES (52859, 7);
INSERT INTO public.meal_prices (id, price) VALUES (53015, 0);
INSERT INTO public.meal_prices (id, price) VALUES (52900, 97);
INSERT INTO public.meal_prices (id, price) VALUES (52991, 82);
INSERT INTO public.meal_prices (id, price) VALUES (52924, 45);
INSERT INTO public.meal_prices (id, price) VALUES (52858, 90);
INSERT INTO public.meal_prices (id, price) VALUES (52854, 9);
INSERT INTO public.meal_prices (id, price) VALUES (52902, 74);
INSERT INTO public.meal_prices (id, price) VALUES (52862, 18);
INSERT INTO public.meal_prices (id, price) VALUES (52861, 2);
INSERT INTO public.meal_prices (id, price) VALUES (52958, 10);
INSERT INTO public.meal_prices (id, price) VALUES (52916, 80);
INSERT INTO public.meal_prices (id, price) VALUES (53022, 37);
INSERT INTO public.meal_prices (id, price) VALUES (52932, 51);
INSERT INTO public.meal_prices (id, price) VALUES (52857, 78);
INSERT INTO public.meal_prices (id, price) VALUES (52901, 94);
INSERT INTO public.meal_prices (id, price) VALUES (52786, 22);
INSERT INTO public.meal_prices (id, price) VALUES (53024, 19);
INSERT INTO public.meal_prices (id, price) VALUES (52833, 95);
INSERT INTO public.meal_prices (id, price) VALUES (52886, 80);
INSERT INTO public.meal_prices (id, price) VALUES (52883, 25);
INSERT INTO public.meal_prices (id, price) VALUES (52793, 26);
INSERT INTO public.meal_prices (id, price) VALUES (53005, 5);
INSERT INTO public.meal_prices (id, price) VALUES (52931, 50);
INSERT INTO public.meal_prices (id, price) VALUES (52889, 11);
INSERT INTO public.meal_prices (id, price) VALUES (52909, 20);
INSERT INTO public.meal_prices (id, price) VALUES (52929, 24);
INSERT INTO public.meal_prices (id, price) VALUES (52892, 83);
INSERT INTO public.meal_prices (id, price) VALUES (52970, 41);
INSERT INTO public.meal_prices (id, price) VALUES (52917, 65);
INSERT INTO public.meal_prices (id, price) VALUES (52769, 9);
INSERT INTO public.meal_prices (id, price) VALUES (52974, 99);
INSERT INTO public.meal_prices (id, price) VALUES (53009, 8);
INSERT INTO public.meal_prices (id, price) VALUES (52877, 71);
INSERT INTO public.meal_prices (id, price) VALUES (52805, 5);
INSERT INTO public.meal_prices (id, price) VALUES (52808, 64);
INSERT INTO public.meal_prices (id, price) VALUES (52843, 27);
INSERT INTO public.meal_prices (id, price) VALUES (52782, 94);
INSERT INTO public.meal_prices (id, price) VALUES (53010, 38);
INSERT INTO public.meal_prices (id, price) VALUES (52884, 17);
INSERT INTO public.meal_prices (id, price) VALUES (52880, 46);
INSERT INTO public.meal_prices (id, price) VALUES (52783, 19);
INSERT INTO public.meal_prices (id, price) VALUES (53008, 86);
INSERT INTO public.meal_prices (id, price) VALUES (52972, 28);
INSERT INTO public.meal_prices (id, price) VALUES (52848, 27);
INSERT INTO public.meal_prices (id, price) VALUES (52939, 23);
INSERT INTO public.meal_prices (id, price) VALUES (52969, 41);
INSERT INTO public.meal_prices (id, price) VALUES (52907, 54);
INSERT INTO public.meal_prices (id, price) VALUES (52815, 88);
INSERT INTO public.meal_prices (id, price) VALUES (52915, 85);
INSERT INTO public.meal_prices (id, price) VALUES (52810, 80);
INSERT INTO public.meal_prices (id, price) VALUES (53014, 68);
INSERT INTO public.meal_prices (id, price) VALUES (52804, 79);
INSERT INTO public.meal_prices (id, price) VALUES (52912, 27);
INSERT INTO public.meal_prices (id, price) VALUES (52845, 42);
INSERT INTO public.meal_prices (id, price) VALUES (52839, 96);
INSERT INTO public.meal_prices (id, price) VALUES (52835, 48);
INSERT INTO public.meal_prices (id, price) VALUES (52829, 26);
INSERT INTO public.meal_prices (id, price) VALUES (52987, 78);
INSERT INTO public.meal_prices (id, price) VALUES (52844, 85);
INSERT INTO public.meal_prices (id, price) VALUES (52837, 72);
INSERT INTO public.meal_prices (id, price) VALUES (52982, 86);
INSERT INTO public.meal_prices (id, price) VALUES (52838, 56);
INSERT INTO public.meal_prices (id, price) VALUES (52885, 48);
INSERT INTO public.meal_prices (id, price) VALUES (52995, 74);
INSERT INTO public.meal_prices (id, price) VALUES (53018, 52);
INSERT INTO public.meal_prices (id, price) VALUES (53036, 48);
INSERT INTO public.meal_prices (id, price) VALUES (53037, 15);
INSERT INTO public.meal_prices (id, price) VALUES (52999, 67);
INSERT INTO public.meal_prices (id, price) VALUES (53035, 71);
INSERT INTO public.meal_prices (id, price) VALUES (52954, 13);
INSERT INTO public.meal_prices (id, price) VALUES (53034, 30);
INSERT INTO public.meal_prices (id, price) VALUES (52847, 94);
INSERT INTO public.meal_prices (id, price) VALUES (52994, 75);
INSERT INTO public.meal_prices (id, price) VALUES (52980, 71);
INSERT INTO public.meal_prices (id, price) VALUES (52949, 26);
INSERT INTO public.meal_prices (id, price) VALUES (52822, 2);
INSERT INTO public.meal_prices (id, price) VALUES (53032, 23);
INSERT INTO public.meal_prices (id, price) VALUES (52926, 90);
INSERT INTO public.meal_prices (id, price) VALUES (52828, 43);
INSERT INTO public.meal_prices (id, price) VALUES (52948, 25);
INSERT INTO public.meal_prices (id, price) VALUES (52959, 90);
INSERT INTO public.meal_prices (id, price) VALUES (52819, 2);
INSERT INTO public.meal_prices (id, price) VALUES (52944, 90);
INSERT INTO public.meal_prices (id, price) VALUES (52802, 62);
INSERT INTO public.meal_prices (id, price) VALUES (52918, 45);
INSERT INTO public.meal_prices (id, price) VALUES (52764, 32);
INSERT INTO public.meal_prices (id, price) VALUES (52773, 96);
INSERT INTO public.meal_prices (id, price) VALUES (52887, 72);
INSERT INTO public.meal_prices (id, price) VALUES (52946, 61);
INSERT INTO public.meal_prices (id, price) VALUES (52821, 17);
INSERT INTO public.meal_prices (id, price) VALUES (52777, 64);
INSERT INTO public.meal_prices (id, price) VALUES (52809, 56);
INSERT INTO public.meal_prices (id, price) VALUES (52960, 88);
INSERT INTO public.meal_prices (id, price) VALUES (52823, 82);
INSERT INTO public.meal_prices (id, price) VALUES (52936, 13);
INSERT INTO public.meal_prices (id, price) VALUES (52836, 78);
INSERT INTO public.meal_prices (id, price) VALUES (52953, 2);
INSERT INTO public.meal_prices (id, price) VALUES (53023, 65);
INSERT INTO public.meal_prices (id, price) VALUES (52882, 28);
INSERT INTO public.meal_prices (id, price) VALUES (52975, 33);
INSERT INTO public.meal_prices (id, price) VALUES (52852, 85);
INSERT INTO public.meal_prices (id, price) VALUES (52914, 80);
INSERT INTO public.meal_prices (id, price) VALUES (52913, 37);
INSERT INTO public.meal_prices (id, price) VALUES (52977, 94);
INSERT INTO public.meal_prices (id, price) VALUES (52919, 38);
INSERT INTO public.meal_prices (id, price) VALUES (53030, 25);
INSERT INTO public.meal_prices (id, price) VALUES (52903, 44);
INSERT INTO public.meal_prices (id, price) VALUES (53033, 77);
INSERT INTO public.meal_prices (id, price) VALUES (52978, 71);
INSERT INTO public.meal_prices (id, price) VALUES (53038, 14);
INSERT INTO public.meal_prices (id, price) VALUES (53019, 4);
INSERT INTO public.meal_prices (id, price) VALUES (52922, 72);
INSERT INTO public.meal_prices (id, price) VALUES (52981, 65);
INSERT INTO public.meal_prices (id, price) VALUES (52925, 47);
INSERT INTO public.meal_prices (id, price) VALUES (52842, 19);
INSERT INTO public.meal_prices (id, price) VALUES (52840, 90);
INSERT INTO public.meal_prices (id, price) VALUES (52779, 93);
INSERT INTO public.meal_prices (id, price) VALUES (52841, 58);
INSERT INTO public.meal_prices (id, price) VALUES (52942, 58);
INSERT INTO public.meal_prices (id, price) VALUES (52794, 83);
INSERT INTO public.meal_prices (id, price) VALUES (52775, 58);
INSERT INTO public.meal_prices (id, price) VALUES (52807, 84);
INSERT INTO public.meal_prices (id, price) VALUES (52870, 29);
INSERT INTO public.meal_prices (id, price) VALUES (52785, 94);
INSERT INTO public.meal_prices (id, price) VALUES (52955, 20);
INSERT INTO public.meal_prices (id, price) VALUES (52906, 20);
INSERT INTO public.meal_prices (id, price) VALUES (53025, 96);
INSERT INTO public.meal_prices (id, price) VALUES (53012, 57);
INSERT INTO public.meal_prices (id, price) VALUES (52971, 18);
INSERT INTO public.meal_prices (id, price) VALUES (52868, 95);
INSERT INTO public.meal_prices (id, price) VALUES (53027, 2);
INSERT INTO public.meal_prices (id, price) VALUES (52973, 44);
INSERT INTO public.meal_prices (id, price) VALUES (52865, 21);
INSERT INTO public.meal_prices (id, price) VALUES (52864, 15);
INSERT INTO public.meal_prices (id, price) VALUES (52921, 98);
INSERT INTO public.meal_prices (id, price) VALUES (52908, 22);
INSERT INTO public.meal_prices (id, price) VALUES (52811, 6);
INSERT INTO public.meal_prices (id, price) VALUES (52816, 74);
INSERT INTO public.meal_prices (id, price) VALUES (52963, 13);
INSERT INTO public.meal_prices (id, price) VALUES (52784, 12);
INSERT INTO public.meal_prices (id, price) VALUES (52872, 3);
INSERT INTO public.meal_prices (id, price) VALUES (52771, 87);
INSERT INTO public.meal_prices (id, price) VALUES (52797, 20);
INSERT INTO public.meal_prices (id, price) VALUES (52849, 14);
INSERT INTO public.meal_prices (id, price) VALUES (52866, 3);
INSERT INTO public.meal_prices (id, price) VALUES (52817, 15);
INSERT INTO public.meal_prices (id, price) VALUES (52911, 61);
INSERT INTO public.meal_prices (id, price) VALUES (52869, 91);
INSERT INTO public.meal_prices (id, price) VALUES (53026, 36);
INSERT INTO public.meal_prices (id, price) VALUES (52863, 30);
INSERT INTO public.meal_prices (id, price) VALUES (52867, 24);
INSERT INTO public.meal_prices (id, price) VALUES (52871, 35);
INSERT INTO public.meal_prices (id, price) VALUES (52965, 21);
INSERT INTO public.meal_prices (id, price) VALUES (52895, 25);
INSERT INTO public.meal_prices (id, price) VALUES (52957, 56);
INSERT INTO public.meal_prices (id, price) VALUES (52896, 18);
INSERT INTO public.meal_prices (id, price) VALUES (52967, 69);
INSERT INTO public.meal_prices (id, price) VALUES (52962, 4);
INSERT INTO public.meal_prices (id, price) VALUES (52964, 70);
INSERT INTO public.meal_prices (id, price) VALUES (52968, 15);

DROP TABLE IF EXISTS user_table;

create table user_table
(
    id    uuid  not null
        primary key,
    first_name text not null,
    last_name text not null,
    email text not null,
    password text not null,
    username text not null
);

alter table meal_prices
    owner to postgres;