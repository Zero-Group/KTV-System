create table tb_food
(
  id    int auto_increment,
  fname varchar(20)    not null,
  price decimal(10, 2) not null,
  stock int            not null,
  primary key (id, fname)
)
  engine = InnoDB;

create table tb_manager
(
  username varchar(255) not null
    primary key,
  password varchar(255) not null
)
  engine = InnoDB;

create table tb_room
(
  id         int             not null,
  type       varchar(10)     not null,
  price      double          null,
  status     int default '0' not null,
  start_time datetime        null,
  end_time   datetime        null,
  primary key (type, id)
)
  engine = InnoDB;

create index `index`
  on tb_room (type);

create table tb_vip
(
  id    int auto_increment,
  cname varchar(20) not null,
  phone varchar(20) not null,
  primary key (id, cname)
)
  engine = InnoDB
  charset = utf8;

create table tb_order
(
  id        int auto_increment
    primary key,
  ordertime datetime        null,
  room      varchar(32)     not null,
  cname     varchar(30)     not null,
  phone     varchar(30)     not null,
  price     int             null,
  pay       int default '0' null,
  detail    varchar(500)    null,
  constraint fk_1
  foreign key (cname) references tb_vip (cname)
    on update cascade
    on delete cascade,
  constraint fk_2
  foreign key (phone) references tb_vip (phone)
    on update cascade
    on delete cascade
)
  engine = InnoDB
  charset = utf8;

create index fk_1
  on tb_order (cname);

create index fk_2
  on tb_order (phone);

create index cname
  on tb_vip (cname);

create index phone
  on tb_vip (phone);

