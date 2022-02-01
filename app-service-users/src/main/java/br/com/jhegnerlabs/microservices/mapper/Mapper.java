package br.com.jhegnerlabs.microservices.mapper;

public interface Mapper<T, R> {

    public R map(T source);

}
