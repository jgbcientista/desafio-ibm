--BASE DE DADOS POSTGRESS

CREATE TABLE tb_cliente (
	id_cliente bigserial NOT NULL,
	email_cliente varchar(255) NULL,
	idade_cliente int8 NULL,
	nome_cliente varchar(255) NULL,
	numero_cliente varchar(255) NULL,
	saldo_cliente numeric(38, 2) NULL,
	CONSTRAINT tb_cliente_pkey PRIMARY KEY (id_cliente)
);

CREATE TABLE tb_extrato (
	id_extrato bigserial NOT NULL,
	data_operacao timestamp(6) NULL,
	id_cliente int8 NULL,
	operacao_extrato varchar(255) NULL,
	valor_extrato numeric(38, 2) NULL,
	CONSTRAINT tb_extrato_pkey PRIMARY KEY (id_extrato)
);