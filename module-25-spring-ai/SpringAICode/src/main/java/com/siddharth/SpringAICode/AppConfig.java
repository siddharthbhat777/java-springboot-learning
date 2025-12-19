package com.siddharth.SpringAICode;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.ai.vectorstore.redis.RedisVectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.JedisPooled;

@Configuration
public class AppConfig {

    // using PgVectorStore
    /*@Bean
    public VectorStore vectorStore(JdbcTemplate jdbcTemplate, @Qualifier("openAiEmbeddingModel") EmbeddingModel embeddingModel) {
        return PgVectorStore.builder(jdbcTemplate, embeddingModel)
                .dimensions(1536)
                .distanceType(PgVectorStore.PgDistanceType.COSINE_DISTANCE)
                .indexType(PgVectorStore.PgIndexType.HNSW)
                .build();
    }*/

    // using RedisVectorStore
    @Bean
    public JedisPooled jedisPooled() {
        return new JedisPooled("localhost", 6379);
    }

    @Bean
    public VectorStore vectorStore(JedisPooled jedisPooled, @Qualifier("openAiEmbeddingModel") EmbeddingModel embeddingModel) {
        return RedisVectorStore.builder(jedisPooled, embeddingModel)
                .indexName("product-index")
                .initializeSchema(true)
                .build();
    }
}
