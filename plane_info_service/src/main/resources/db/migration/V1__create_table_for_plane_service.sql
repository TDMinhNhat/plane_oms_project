-- v1: Create some tables for plane service

-- Create "countries" table
CREATE TABLE IF NOT EXISTS countries
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    country_id   VARCHAR(10)  NOT NULL UNIQUE,
    country_name VARCHAR(200) NOT NULL UNIQUE,
    delete_flag  BIT          NOT NULL DEFAULT 0,
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP    NOT NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    created_by   VARCHAR(50)  NOT NULL DEFAULT 'anonymous',
    updated_by   VARCHAR(50)  NOT NULL DEFAULT NULL,
    version      INTEGER      NOT NULL DEFAULT 0
);

-- Create "services" table
CREATE TABLE IF NOT EXISTS services
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    service_name        VARCHAR(200) NOT NULL UNIQUE,
    service_description VARCHAR(300),
    service_icon_url    VARCHAR(300),
    delete_flag         BIT          NOT NULL DEFAULT 0,
    created_at          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP    NOT NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    created_by          VARCHAR(50)  NOT NULL DEFAULT 'anonymous',
    updated_by          VARCHAR(50)  NOT NULL DEFAULT NULL,
    version             INTEGER      NOT NULL DEFAULT 0
);

-- Create "facilities" table
CREATE TABLE IF NOT EXISTS facilities
(
    id                   BIGINT PRIMARY KEY AUTO_INCREMENT,
    facility_name        VARCHAR(200) NOT NULL UNIQUE,
    facility_description VARCHAR(300),
    facility_icon_url    VARCHAR(300),
    delete_flag          BIT          NOT NULL DEFAULT 0,
    created_at           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at           TIMESTAMP    NOT NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    created_by           VARCHAR(50)  NOT NULL DEFAULT 'anonymous',
    updated_by           VARCHAR(50)  NOT NULL DEFAULT NULL,
    version              INTEGER      NOT NULL DEFAULT 0
);

-- Create "planes" table
CREATE TABLE IF NOT EXISTS planes
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    plane_id       VARCHAR(50)   NOT NULL UNIQUE,
    plane_name     VARCHAR(200)  NOT NULL UNIQUE,
    plane_logo_url VARCHAR(300),
    country_id     BIGINT        NOT NULL,
    width_meter    NUMERIC(4, 2) NOT NULL,
    height_meter   NUMERIC(4, 2) NOT NULL,
    capacity       INTEGER       NOT NULL,
    description    VARCHAR(300),
    deleteFlag     BIT           NOT NULL DEFAULT 0,
    created_at     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP     NOT NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    created_by     VARCHAR(50)   NOT NULL DEFAULT 'anonymous',
    updated_by     VARCHAR(50)   NOT NULL DEFAULT NULL,
    version        INTEGER       NOT NULL DEFAULT 0,
    CONSTRAINT fk__planes__country_id FOREIGN KEY (country_id) REFERENCES countries (id)
);

-- Create "plane_images" table
CREATE TABLE IF NOT EXISTS plane_images
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    plane_id    BIGINT       NOT NULL,
    image_url   VARCHAR(300) NOT NULL,
    delete_flag BIT          NOT NULL DEFAULT 0,
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    created_by  VARCHAR(50)  NOT NULL DEFAULT 'anonymous',
    updated_by  VARCHAR(50)  NOT NULL DEFAULT NULL,
    version     INTEGER      NOT NULL DEFAULT 0,
    CONSTRAINT fk__plane_images__plane_id FOREIGN KEY (plane_id) REFERENCES planes (id)
);

-- Create "plane_services" table
CREATE TABLE IF NOT EXISTS plane_services
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    plane_id    BIGINT      NOT NULL,
    service_id  BIGINT      NOT NULL,
    delete_flag BIT         NOT NULL DEFAULT 0,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP   NOT NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    created_by  VARCHAR(50) NOT NULL DEFAULT 'anonymous',
    updated_by  VARCHAR(50) NOT NULL DEFAULT NULL,
    version     INTEGER     NOT NULL DEFAULT 0,
    CONSTRAINT fk__plane_services__plane_id FOREIGN KEY (plane_id) REFERENCES planes (id),
    CONSTRAINT fk__plane_services__service_id FOREIGN KEY (service_id) REFERENCES services (id),
    UNIQUE (plane_id, service_id)
);

-- Create "plane_facilities" table
CREATE TABLE IF NOT EXISTS plane_facilities
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    plane_id    BIGINT       NOT NULL,
    facility_id BIGINT       NOT NULL,
    description VARCHAR(300) NOT NULL,
    delete_flag BIT          NOT NULL DEFAULT 0,
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    created_by  VARCHAR(50)  NOT NULL DEFAULT 'anonymous',
    updated_by  VARCHAR(50)  NOT NULL DEFAULT NULL,
    version     INTEGER      NOT NULL DEFAULT 0,
    CONSTRAINT fk__plane_facilities__plane_id FOREIGN KEY (plane_id) REFERENCES planes (id),
    CONSTRAINT fk__plane_facilities__facility_id FOREIGN KEY (facility_id) REFERENCES facilities (id),
    UNIQUE (plane_id, facility_id)
);