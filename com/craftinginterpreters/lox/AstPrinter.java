package com.craftinginterpreters.lox;

class AstPrinter implements Expr.Visitor<String>{
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {

    }

    Override
    public String visitGroupingExpr() {
        
    }

    Override
    public String visitLiteralExpr() {
        
    }

    Override
    public String visitUnaryExpr() {
        
    }

    private String parenthesize(String name, Expr... exprs)
}

