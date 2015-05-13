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
insert into Departamento values (40,'Opera��es', 'RECIFE');
insert into Departamento values (1, 'Presid�ncia', 'RIBEIRAO PRETO');
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
WHERE nome = 'Uberl�ndia';

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
	 ELSE 'sei l�'
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

-- 11

UPDATE Cidade
SET nome = '*' + nome
WHERE nome IN (SELECT nome 
				FROM Cidade
				GROUP BY nome, uf
				HAVING COUNT(1) > 1
				) 

SELECT * FROM Cidade ORDER BY nome;

-- Convers�o para concatenar, exemplo
SELECT '123' + CAST(23 AS VARCHAR(10))

-- 12
SELECT nome,
	   CASE sexo
		WHEN 'M' THEN 'Masculino'
		WHEN 'F' THEN 'Feminino'
		ELSE 'Outro'
	   END Genero
FROM Associado;

-- 13 
SELECT nomeEmpregado, salario,
		CASE WHEN salario BETWEEN 1164.01 AND 2326 THEN (Salario*0.15)
			 WHEN salario > 2326 THEN (Salario*0.275)
			 ELSE 0
		END [Desconto IR]
FROM Empregado

-- 14
Begin transaction;

DELETE FROM Cidade
WHERE IDCidade IN (SELECT MAX(IDCidade)
				   FROM Cidade
				   GROUP BY nome, uf
				   HAVING COUNT(1) > 1)

SELECT MAX (IDCidade) [Maior IDCidade Duplicada]
FROM Cidade
GROUP BY Nome, uf
HAVING COUNT(1) > 1

SELECT nome, uf
FROM Cidade
GROUP BY nome, uf
HAVING COUNT(1) > 1

COMMIT

-- 15 

-- Regra de restri��o
ALTER TABLE Cidade
	ADD CONSTRAINT UK_Cidade_Nome_UF 
	UNIQUE (Nome, UF)

INSERT INTO Cidade (IDCidade, Nome, UF) VALUES (1000, 'Sapucaia', 'RJ')

SELECT * FROM Cidade
 
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

-- Exerc�cios 

update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 3;

-- 1 Selecione o nome do empregado e nome do departamento que cada um est� associado.

SELECT e.nomeEmpregado, d.nomeDepartamento
FROM Empregado e
JOIN Departamento d ON d.IDDepartamento = e.IDDepartamento

-- 2 Exibir o nome do associado e sua cidade, exibir tamb�m associados sem Cidade relacionada.

SELECT a.nome AS [Nome do Associado], c.nome AS Cidade
FROM Associado a
LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade

-- Tirar o *
BEGIN TRANSACTION
GO

UPDATE Cidade
SET Nome = REPLACE(Nome, '*', ' ')
WHERE Nome LIKE '*%'

SELECT IDCidade, nome, REPLACE(Nome, '*', '') Novo_Nome
FROM Cidade



-- 3 Lista os estados (UF) e total de cidades que n�o possuem associados relacionados 
-- (dica: pode ser utilizado count + group by + exists).

SELECT c.UF, COUNT (1) AS [Total de Cidade]
FROM Cidade c
WHERE NOT EXISTS(SELECT 1
				FROM Associado a
				WHERE a.IDCidade = c.IDCidade)
GROUP BY c.UF

-- 4 Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade 
-- � da regi�o SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), sen�o imprimir nulo.

--- Criando com veiw (view � apenas uma forma de salvar um comando sql para reutilizar ele.
CREATE VIEW vw_Cidade_Regi�o AS
SELECT a.Nome, c.Nome AS [Nome Cidade],
		CASE WHEN c.UF IN ('RS', 'SC', 'PR') THEN '***'
		  ELSE null
		END [Regi�o Sul]
FROM Associado a
LEFT JOIN Cidade c ON c.IDCidade = a.IDCidade

-- utilizando a view
SELECT * FROM vw_Cidade_Regi�o

COMMIT

-- 5 Liste o nome do empregado, o nome do gerente, e o departamento de cada um.

SELECT e.nomeEmpregado, e.IDDepartamento, g.nomeEmpregado, g.IDDepartamento
FROM Empregado e
INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado;

-- 6 Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados que o departamento fique na 
-- localidade de SAO PAULO, fa�a um reajuste de 14,5%
Begin transaction;

SELECT * INTO CopiaEmpregado
FROM Empregado

UPDATE Empregado
SET salario += (salario*0.145)
WHERE IDDepartamento in (10)

SELECT nomeEmpregado, salario, IDDepartamento
FROM Empregado

SELECT nomeEmpregado, salario, IDDepartamento
FROM CopiaEmpregado

COMMIT
ROLLBACK

-- 7 Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio dos sal�rios de 
-- todos os empregados.


-- 8 Liste o departamento que possui o empregado de maior sal�rio. (Nao esta pronto)

SELECT TOP 1 WITH TIES d.IDDepartamento, e.nomeEmpregado, e.salario
FROM Empregado e
JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento
ORDER BY Salario DESC

SELECT e.salario, d.IDDepartamento
FROM Empregado e
JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento

-- Tem mais exerc�cios para serem feitos!!!