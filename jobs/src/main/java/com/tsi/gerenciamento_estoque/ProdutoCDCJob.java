package com.tsi.gerenciamento_estoque.jobs;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.springframework.boot.loader.net.protocol.Handlers;

public class ProdutoCDCJob {
    public static void main(String[] argumentos) throws Exception {

        Handlers.register();
        // Ambiente de execução
        StreamExecutionEnvironment ambienteDeExecucao = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment ambienteDeTabela = StreamTableEnvironment.create(ambienteDeExecucao);

        // Fonte: tabela produto via CDC
        ambienteDeTabela.executeSql(
                "CREATE TABLE ProdutosCDC (" +
                        " id INT," +
                        " nome STRING," +
                        " quantidade INT," +
                        " preco DOUBLE," +
                        " categoria STRING," +
                        " PRIMARY KEY (id) NOT ENFORCED" +
                        ") WITH (" +
                        " 'connector' = 'postgres-cdc'," +
                        " 'hostname' = 'localhost'," +
                        " 'port' = '5432'," +
                        " 'username' = 'postgres'," +
                        " 'password' = '12345'," +
                        " 'database-name' = 'gerenciador_estoque'," +
                        " 'schema-name' = 'public'," +
                        " 'table-name' = 'Produto'" +
                        ")"
        );

        // Destino: tabela de métricas
        ambienteDeTabela.executeSql(
                "CREATE TABLE MetricasCategoria (" +
                        " categoria STRING," +
                        " valor_total DOUBLE," +
                        " PRIMARY KEY (categoria) NOT ENFORCED" +
                        ") WITH (" +
                        " 'connector' = 'jdbc'," +
                        " 'url' = 'jdbc:postgresql://localhost:5432/gerenciador_estoque'," +
                        " 'table-name' = 'metricas_categoria'," +
                        " 'username' = 'postgres'," +
                        " 'password' = '12345'," +
                        " 'driver' = 'org.postgresql.Driver'" +
                        ")"
        );

        // Consulta contínua: calcula valor total por categoria
        ambienteDeTabela.executeSql(
                "INSERT INTO MetricasCategoria " +
                        "SELECT categoria, SUM(quantidade * preco) AS valor_total " +
                        "FROM ProdutosCDC " +
                        "GROUP BY categoria"
        );

        ambienteDeExecucao.execute("Calcular métricas de produtos por categoria (CDC)");
    }
}