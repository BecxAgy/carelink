-- Create tables
CREATE TABLE IF NOT EXISTS cl_role (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS cl_user (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cl_user_role (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES cl_user(id),
    FOREIGN KEY (role_id) REFERENCES cl_role(id)
);

-- Insert initial roles
INSERT INTO cl_role (nome, value) VALUES ('Administrador', 'ADMIN');
INSERT INTO cl_role (nome, value) VALUES ('Usuário', 'USER');