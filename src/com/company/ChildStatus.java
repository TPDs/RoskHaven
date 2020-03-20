package com.company;

public enum ChildStatus {
    PASSIVE, //Tidligere køsatte børn eller tidligere betalende (evt. børn, der ikke har betalt deres sidste regninger)
    ACTIVE, //Betalende
    QUEUE //I kø til at komme ind
}
