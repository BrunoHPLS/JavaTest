CREATE SEQUENCE public.tb_frete_pk_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

create table public."tb_frete" (
	"id_frete" int8 not null DEFAULT nextval('tb_frete_pk_seq'::regclass),
	"peso" float4 not null,
	"cep_origem" varchar(9) not null,
	"cep_destino" varchar(9) not null,
	"nome_destinatario" varchar(255) not null,
	"vl_total_frete" float4 not null,
	"data_prevista_entrega" date not null,
	"data_consulta" timestamp not null,
	constraint tb_frete_pk primary key ("id_frete")
);