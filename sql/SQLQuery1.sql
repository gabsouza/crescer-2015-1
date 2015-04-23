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

--1
SELECT SUBSTRING(nome, 1, CHARINDEX(' ', nome)-1) AS [Primeiro Nome]
FROM Associado

--2
SELECT nome, DATEDIFF (YEAR, dataNascimento, GETDATE()) idade --arredondamento
FROM Associado

--3
SELECT NomeEmpregado, DATEDIFF (MONTH, dataAdmissao, CONVERT (DateTime, '31/12/2000', 103)) AS [Meses Trabalhados]
FROM Empregado 
WHERE dataAdmissao between CONVERT (DateTime, '01/05/1980', 103) and CONVERT(DateTime, '20/01/1982', 103)

--4
SELECT TOP 1 WITH TIES cargo, COUNT(1) AS [Cargo com mais empregados]
FROM Empregado
GROUP BY Cargo
ORDER BY [Cargo com mais empregados] desc;

--5
SELECT TOP 1 nome AS [Associado com maior nome]
FROM Associado
ORDER BY LEN(nome) DESC;

-- SET LENGUAGE Portuguese
--6
SELECT nome, 
	  CONVERT (varchar(30), DATEADD (YEAR, 50, dataNascimento), 103) AS [50 anos em],
	  DATENAME(weekday, DATEADD (YEAR, 50, dataNascimento)) AS [Dia da semana] 
FROM Associado

-- 7
SELECT UF, COUNT(1) AS [Quantidade de Cidade]
FROM Cidade
GROUP BY UF
ORDER BY UF ASC

--8
SELECT UF, nome, COUNT(1) AS Total
FROM Cidade
GROUP BY nome, UF
HAVING COUNT(1) > 1
ORDER BY UF

--9
SELECT ISNULL (MAX(IDAssociado), 0)+1 AS [Proximo ID]
From Associado;

--10
DELETE FROM CopiaCidade;

INSERT INTO CopiaCidade (IDCidade, nome, UF)

SELECT UF, nome, MIN(IDCidade) AS [Menor IDCidade]
FROM Cidade
GROUP BY nome, UF


-- Executando exemplos

SELECT a.Nome AS Associado, 
	   c.Nome AS NomeCidade
From Associado a
INNER JOIN Cidade c ON c.IDCidade = a.IDCidade

SELECT e.IDEmpregado, 
	   e.NomeEmpregado,
	   d.NomeDepartamento
FROM Empregado e
INNER JOIN Departamento d on d.IDDepartamento = e.IDDepartamento

SELECT e.IDEmpregado, e.NomeEmpregado AS [Nome Empregado], e.IDGerente, g.NomeEmpregado AS nomeGerente
FROM Empregado e
INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado

Select a.IDAssociado,
a.Nome,
a.IDCidade IDCidadeEmp,
c.IDCidade,
c.Nome
From Associado a, Cidade c
go

-- Exercícios 

update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 3;

-- 1 Selecione o nome do empregado e nome do departamento que cada um está associado.

SELECT e.nomeEmpregado, d.nomeDepartamento
FROM Empregado e
JOIN Departamento d ON d.IDDepartamento = e.IDDepartamento

-- 2 Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.

SELECT a.nome, c.nome
FROM Associado a
LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade

-- 3 Lista os estados (UF) e total de cidades que não possuem associados relacionados 
-- (dica: pode ser utilizado count + group by + exists).

SELECT c.UF, COUNT (1) AS Cidade
FROM Cidade c
WHERE NOT EXISTS(Select 1
FROM Associado a
WHERE a.IDCidade = c.IDCidade)
GROUP BY UF

-- 4 Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade 
-- é da região SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), senão imprimir nulo.

SELECT a.Nome, c.Nome AS [Nome Cidade]
FROM Associado a, cidade c
INNER JOIN (SELECT IDCidade, ('***') AS Nome
FROM Cidade
WHERE UF IN ('SC', 'PR', 'RS'))as cidade
ON c.IDCidade = a.IDCidade);