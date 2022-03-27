package br.com.cobli.optimus.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
