-- 1) Identifique e liste quantos valores diferentes estão definidos para a coluna Situacao da tabela Produto 
-- (somente os distintos valores).

SELECT COUNT (distinct situacao) AS [Total Valores Diferentes]
FROM Produto

-- 2) Liste todos os clientes que tenham o LTDA no nome ou razao social.

SELECT IDCliente, Nome, RazaoSocial
FROM Cliente
WHERE UPPER(nome) LIKE '%LTDA%' 
   OR UPPER(razaoSocial) LIKE '%LTDA%'

-- 3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
-- Nome: Galocha Maragato
-- Preço de custo: 35.67
-- Preço de venda: 77.95
-- Situação: A

INSERT INTO Produto (nome, precoCusto, precoVenda, situacao) VALUES ('Galocha Maragato', 35.67, 77.95, 'A')


-- 4) Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de 
-- dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
-- Obs.: o produto criado anteriormente deverá ser listado.

SELECT pr.IDProduto, pr.Nome
FROM Produto pr
LEFT JOIN PedidoItem pe ON pe.IDProduto = pr.IDproduto
WHERE IDPedido IS NULL;

-- Esta opção tem custo menor
SELECT IDProduto, nome
FROM Produto
WHERE NOT EXISTS (SELECT 1
				  FROM PedidoItem
				  WHERE PEdidoItem.IDProduto = Produto.IDProduto);

CREATE INDEX IX_PedidoItem_Produto ON PedidoItem (IDProduto);
DROP INDEX IX_PedidoItem_Produto;

-- 5) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente), 
-- liste também qual o Estado possuí o menor número de clientes.
-- Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION. (Não está pronta)

CREATE VIEW vwEstados AS
	SELECT ci.UF, COUNT (1) AS [Total Clientes]
	FROM Cidade ci 
	JOIN Cliente cl ON cl.IDCidade = ci.IDCidade
	GROUP BY ci.UF


-- 6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
-- Dica: será preciso relacionar Cidade com Cliente, e Cliente com Pedido.

SELECT COUNT (IDCidade) AS [Total Cidades]
FROM Cidade
WHERE EXISTS (Select 1
			  FROM Cliente cl
			  JOIN Pedido pe ON pe.IDcliente = cl.IDCliente
			  WHERE cl.IDCidade = Cidade.IDCidade)
			   
--
SELECT COUNT (DISTINCT ci.Nome) AS [Total Cidades]
FROM Cidade ci
JOIN Cliente cl ON cl.IDcidade = ci.IDCidade
JOIN Pedido pe ON pe.IDCliente = cl.IDCliente;


-- Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais (tabela ProdutoMaterial). Identifique se existe 
-- algum produto sem material relacionado
-- Obs.: o produto criado anteriormente deverá ser listado.

SELECT pro.IDProduto, pro.Nome
FROM Produto pro
WHERE NOT EXISTS (SELECT 1
				  FROM ProdutoMaterial pm
				  WHERE pm.IDProduto = pro.IDProduto);

-- 8) Liste os produtos, com seu preço de custo, e relacione com seus os materiais (ProdutoMaterial), e liste também o somatório 
-- do PrecoCusto de todos seus materiais.

SELECT pro.IDProduto, pro.Nome, pro.PrecoCusto SUM (ma.PrecoCusto * ISNULL (pm.Quantidade, 1)) AS [Preço Custo Material]
FROM Produto pro
JOIN produtoMaterial pm ON pm.IDProduto = pro.IDProduto
JOIN 

-- 9) Após identificar o preço de custo dos produtos e seus materiais será preciso acertar os produtos que estão com o valor de custo 
-- inferior ao custo dos materiais. Pra isso faça uma alteração (update) na tabela de Produtos, definindo o PrecoCusto, para que 
-- fique igual ao custo dos seus materiais.