-- auto-generated definition
create schema bank collate utf8mb4_general_ci;

-- auto-generated definition
create table market_quote
(
    id              bigint auto_increment
        primary key,
    curve_name      varchar(255)                       not null,
    instrument_type varchar(255)                       not null,
    instrument_name varchar(255)                       not null,
    tenor           varchar(255)                       not null,
    quote           varchar(255)                       not null,
    maturity_date   varchar(63)                        not null,
    m_h_per_date    varchar(63)                        null,
    is_deleted      tinyint  default 0                 null comment '逻辑删除 1-已删除 0-未删除',
    gmt_created     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    gmt_modified    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);
