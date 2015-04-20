-- Table "Emp" ... --
create table Empregado (
 IDEmpregado    int not null
,NomeEmpregado  varchar(30) not null
,Cargo          varchar(15) not null
,IDGerente      int null
,DataAdmissao   datetime not null
,Salario        decimal(7,2) not null
,Comissao       decimal(7,2)
,IDDepartamento int
);

insert into Empregado values (7369 ,'SMITH', 'Atendente', '7902', convert(datetime, '1980/12/17', 111), 800, null, 20);
insert into Empregado values (7499 ,'ALLEN', 'Vendedor', '7698', convert(datetime, '1981/02/20', 111), 1600, 300, 30);
insert into Empregado values (7521 ,'WARD', 'Vendedor', '7698', convert(datetime, '1981/02/22', 111), 1250, 500, 30);
insert into Empregado values (7566 ,'JONES', 'Gerente', '7839', convert(datetime, '1981/04/02', 111), 2975, null, 20);
insert into Empregado values (7654 ,'MARTIN', 'Vendedor', '7698', convert(datetime, '1981/09/28', 111), 1250, 1400, 30);
insert into Empregado values (7698 ,'BLAKE', 'Gerente', '7839', convert(datetime, '1981/05/01', 111), 2850, null, 30);
insert into Empregado values (7782 ,'CLARK', 'Gerente', '7839', convert(datetime, '1981/06/09', 111), 2450, null, 10);
insert into Empregado values (7788 ,'SCOTT', 'Analista', '7566', convert(datetime, '1982/12/09', 111), 3000, null, 20);
insert into Empregado values (7839 ,'KING', 'Presidente', null, convert(datetime, '1981/11/17', 111), 5000, null, null);
insert into Empregado values (7844 ,'TURNER', 'Vendedor', '7698', convert(datetime, '1981/09/08', 111), 1500, 0, 30);
insert into Empregado values (7876 ,'ADAMS', 'Atendente', '7788', convert(datetime, '1983/01/12', 111), 1100, null, 20);
insert into Empregado values (7900 ,'JAMES', 'Atendente', '7698', convert(datetime, '1981/12/03', 111), 950, null, 30);
insert into Empregado values (7902 ,'FORD', 'Analista', '7566', convert(datetime, '1981/12/03', 111), 3000, null, 20);
insert into Empregado values (7934 ,'MILLER', 'Atendente', '7782', convert(datetime, '1982/01/23', 111), 1300, null, 10);
insert into Empregado values (7940 ,'ANDREW', 'Atendente', '7782', convert(datetime, '1988/01/20', 111), 1150, null, null);

create table Departamento (
 IDDepartamento   int not null
,NomeDepartamento varchar(30)
,Localizacao      varchar(25)
);

insert into Departamento values (10,'Contabilidade', 'SAO PAULO');
insert into Departamento values (20,'Pesquisa', 'SAO LEOPOLDO');
insert into Departamento values (30,'Vendas', 'SAO PAULO');
insert into Departamento values (40,'Operações', 'RECIFE');
insert into Departamento values (1, 'Presidência', 'RIBEIRAO PRETO');
insert into Departamento values (60, 'Tecnologia', 'PORTO ALEGRE');

---------
ALTER TABLE Departamento ADD  CONSTRAINT PK_departamento 
  PRIMARY KEY  
  (IDDepartamento);

ALTER TABLE Empregado ADD  CONSTRAINT PK_Empregado
  PRIMARY KEY  
  (IDEmpregado);

ALTER TABLE Empregado ADD CONSTRAINT FK_Empregado_Departamento
  FOREIGN KEY (IDDepartamento) REFERENCES Departamento (IDDepartamento);

CREATE INDEX IX_Empregado_Departamento ON Empregado (IDDepartamento);


SELECT NomeEmpregado as Nome,
	   salario       as Salario,
	   (salario*12)  as SalarioAnual
FROM Empregado;

Select Nome, UF
From Cidade
Order by Nome DESC;

SELECT idcidade, nome, uf
FROM cidade
WHERE nome LIKE '%p%'

SELECT NomeEmpregado as Nome
FROM Empregado
ORDER BY DataAdmissao;

SELECT NomeEmpregado AS Nome, salario AS [Salario Anual]
FROM Empregado 
WHERE Cargo = 'atendente' OR (salario*12) <= 18500;

SELECT idcidade AS [ID Cidade]
FROM Cidade
WHERE nome = 'Uberlândia';

SELECT idcidade AS [ID Cidade], nome
FROM Cidade
WHERE UF = 'RS';

update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 3;


Select COUNT(DISTINCT Cargo) as [Total de Cargos]
From Empregado

SELECT idDepartamento,
	   sum(salario) AS soma,
	   max(salario) AS maximo,
	   min(salario) AS minimo
FROM empregado
GROUP BY idDepartamento;


SELECT NomeEmpregado,
	   (Salario + Comissao) as [Total salario A],
       (Salario + (ISNULL(Comissao,0))) as [Total salario B],
       Comissao
From Empregado;

SELECT IDAssociado,
	   Nome,
CASE WHEN sexo = 'F' THEN 'Feminino'
	 WHEN sexo = 'M' THEN 'Masculino'
	 ELSE 'sei lá'
	END Genero
FROM associado;

SELECT SUBSTRING(nome, 1, CHARINDEX(' ', nome)-1) AS [Primeiro Nome]
FROM Associado

SELECT nome, DATEDIFF (YEAR, dataNascimento, GETDATE())
FROM Associado


SELECT NomeEmpregado, DATEDIFF (MONTH, dataAdmissao, '31/12/2000') AS [Meses Trabalhados]
FROM Empregado 
WHERE dataAdmissao between '01/05/1980' and '20/01/1982' 

SELECT TOP 1 cargo AS [Cargo com mais empregados]
FROM Empregado

SELECT TOP 1 nome AS [Associado com maior nome]
FROM Associado
ORDER BY LEN(nome) DESC;


