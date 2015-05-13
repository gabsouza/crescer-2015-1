-- 1) Identifique e liste quantos valores diferentes est�o definidos para a coluna Situacao da tabela Produto 
-- (somente os distintos valores).

SELECT COUNT (distinct situacao) AS [Total Valores Diferentes]
FROM Produto

-- 2) Liste todos os clientes que tenham o LTDA no nome ou razao social.

SELECT IDCliente, Nome, RazaoSocial
FROM Cliente
WHERE UPPER(nome) LIKE '%LTDA%' 
   OR UPPER(razaoSocial) LIKE '%LTDA%'

-- 3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
-- Nome: Galocha Maragato
-- Pre�o de custo: 35.67
-- Pre�o de venda: 77.95
-- Situa��o: A

INSERT INTO Produto (nome, precoCusto, precoVenda, situacao) VALUES ('Galocha Maragato', 35.67, 77.95, 'A')


-- 4) Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de 
-- dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
-- Obs.: o produto criado anteriormente dever� ser listado.

SELECT pr.IDProduto, pr.Nome
FROM Produto pr
LEFT JOIN PedidoItem pe ON pe.IDProduto = pr.IDproduto
WHERE IDPedido IS NULL;

-- Esta op��o tem custo menor
SELECT IDProduto, nome
FROM Produto
WHERE NOT EXISTS (SELECT 1
				  FROM PedidoItem
				  WHERE PEdidoItem.IDProduto = Produto.IDProduto);

CREATE INDEX IX_PedidoItem_Produto ON PedidoItem (IDProduto);
DROP INDEX IX_PedidoItem_Produto;

-- 5) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), 
-- liste tamb�m qual o Estado possu� o menor n�mero de clientes.
-- Dica: pode (n�o � obrigat�rio) ser utilizado subquery, e tamb�m UNION. (N�o est� pronta)

CREATE VIEW vwEstados AS
	SELECT ci.UF, COUNT (1) AS [Total Clientes]
	FROM Cidade ci 
	JOIN Cliente cl ON cl.IDCidade = ci.IDCidade
	GROUP BY ci.UF


-- 6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
-- Dica: ser� preciso relacionar Cidade com Cliente, e Cliente com Pedido.

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


-- Dentro da atual estrutura, cada produto � composto por 1 ou v�rios materiais (tabela ProdutoMaterial). Identifique se existe 
-- algum produto sem material relacionado
-- Obs.: o produto criado anteriormente dever� ser listado.

SELECT pro.IDProduto, pro.Nome
FROM Produto pro
WHERE NOT EXISTS (SELECT 1
				  FROM ProdutoMaterial pm
				  WHERE pm.IDProduto = pro.IDProduto);

-- 8) Liste os produtos, com seu pre�o de custo, e relacione com seus os materiais (ProdutoMaterial), e liste tamb�m o somat�rio 
-- do PrecoCusto de todos seus materiais.

SELECT pro.IDProduto, pro.Nome, pro.PrecoCusto SUM (ma.PrecoCusto * ISNULL (pm.Quantidade, 1)) AS [Pre�o Custo Material]
FROM Produto pro
JOIN produtoMaterial pm ON pm.IDProduto = pro.IDProduto
JOIN 

-- 9) Ap�s identificar o pre�o de custo dos produtos e seus materiais ser� preciso acertar os produtos que est�o com o valor de custo 
-- inferior ao custo dos materiais. Pra isso fa�a uma altera��o (update) na tabela de Produtos, definindo o PrecoCusto, para que 
-- fique igual ao custo dos seus materiais.