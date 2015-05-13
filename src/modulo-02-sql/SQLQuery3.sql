BEGIN
	DECLARE @Nome VARCHAR(30)
	SET @Nome = 'CWI Software'
	
	PRINT @Nome
	PRINT getdate()
END

BEGIN
	DECLARE @vIDCliente int
	
	SELECT @vIDCliente = IDCliente
	FROM Cliente
	WHERE Nome = 'Mariana Ventura Che'

	PRINT 'Mariana possui o código ' + CAST(@vIDCliente AS VARCHAR(30))
END

BEGIN
	DECLARE @vCount int

	Select @vCount = COUNT(1)
	From Cliente

	IF (@vCount=0)
		Print 'Nenhum cliente cadastrado.'
	ELSE IF (@vCount=1)
		Print 'Um registro encontrado.'
	ELSE
		Print 'Muitos registros encontrados.'
END

BEGIN
	BEGIN TRY
		Begin Transaction

	Set Identity_Insert Cidade ON;

	Insert into Cidade (IDCidade, Nome, UF)
	Values (1, 'Morro da Pedra', 'RS');

	Set Identity_Insert Cidade OFF;

		Commit
	END TRY

	BEGIN CATCH
		If @@TRANCOUNT > 0 Rollback; --Se existir alguma transacao
		Print ERROR_MESSAGE()
	END CATCH
END

BEGIN
	DECLARE ListaCidade CURSOR
		Local
		Fast_Forward
		FOR Select Nome, Uf
			From Cidade
			Group by Nome, Uf
			Having COUNT(1) > 1;
	DECLARE @vNome varchar(50),
			@vUF varchar(2)

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

-- @@ são variaveis do sistema
		WHILE (@@FETCH_STATUS=0) BEGIN
			Print @vNome + '/'+ @vUF;
			FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
		END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END

-- 1) Imprima qual produto é o mais vendido, considerea quantidade(PedidoItem).

SELECT IDProduto, SUM(quantidade) [Total Itens]
FROM PedidoItem
GROUP BY IDProduto
ORDER BY [Total Itens]

BEGIN
	
	DECLARE @IDProduto   INTEGER,
			@vanome VARCHAR(100),
			@Total_Itens INTEGER

	SELECT TOP 1 WITH TIE
	@IDProduto = PedidoItem.IDProduto, 
	@vanome = Produto.nome
	@Total_Itens = SUM(quantidade) [Total de Itens], COUNT (DISTINCT pedI.IDPedido) [Total PEd]
	FROM PedidoItem
	JOIN Produto ON produto.IDProduto = pedidoItens.IDProduto
	GROUP BY pedI.IDProduto, pro.nome
	ORDER BY [Total Pedido] DESC

END

-- 2) Liste as cidades com nome e UF duplicados que tenham clientes relacionados.


SELECT nome, UF, COUNT (1) [Total Cidades] 
FROM cidade
GROUP BY nome, UF
HAVING COUNT (1) > 1
 
BEGIN
	DECLARE ListaCidade CURSOR
	LOCAL
	FAST_FORWARD
	FOR SELECT	Cidade.Nome,
				Cidade.UF
		FROM	Cidade
		GROUP BY Cidade.Nome,
				 Cidade.UF
		HAVING COUNT(1) > 1;

	DECLARE @varNome	VARCHAR(50),
			@varUF	VARCHAR(2),
			@total integer;

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @varNome, @varUF

	WHILE (@@FETCH_STATUS = 0) BEGIN
		SELECT @total = COUNT(1)
		FROM Cliente
		WHERE EXISTS (SELECT 1
						FROM Cidade
						WHERE  Cidade.IDCidade = Cliente.IDCidade
						AND Cidade.Nome = @varNome
						AND Cidade.UF = @varUF);
		
		if @total > 0
			PRINT @varNome + '/' + @varUF + ' total de clientes: ' + CAST(@total AS VARCHAR(10));

		FETCH NEXT FROM ListaCidade INTO @varNome, @varUF
	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END
-- 3) Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados, 
-- com produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.

SELECT COUNT(1) (DISTINCT ped_IDPedido)
FROM   Pedido ped
 INNER JOIN PedidoItem
WHERE  EXISTS (SELECT 1
			   FROM ProdutoMaterial pm
			   WHERE pm.IDProduto = pro.IDProduto
			   AND pm.IDMaterial IN (SELECT IDMaterial 
									 FROM vwMateriais_Mais_Utilizados)

CREATE VIEW vwMateriais_Mais_Utilizados AS
SELECT TOP 1 WITH TIES 
	   ma.IDMaterial,
	   ma.Descricao, 
	   COUNT(DISTINCT pm.quantidade) Total_Produto_Distintos
FROM material ma
	INNER JOIN ProdutoMaterial pm ON pm.IDMaterial = ma.IDMaterial
	INNER JOIN Produto		   pr ON pr.IDProduto  = pm.IDProduto
GROUP BY ma.IDMaterial, ma.descricao
ORDER BY Total_Produto_Distintos DESC

 
SELECT ped.IDPedido, PeI.IDPedidoItem, pro.IDProduto, pro.Nome, PeI.Quantidade
FROM Pedido ped
	INNER JOIN PedidoItem PeI ON PeI.IDPedido = PeI.IDPedido
	INNER JOIN Produto    pro ON pro.IdProduto = PeI.IDProduto
	--INNER JOIN ProdutoMaterial pm ON pm.IDProduto = pro.IDProduto 
WHERE ped.DataPedido BETWEEN DATEADD(DAY, -60, GETDATE()) AND GETDATE();
   
CREATE INDEX IX_Pedido_DataPedido ON Pedido(DataPedido);